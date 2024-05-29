-- Question
-- Table: Members

-- +--------------------------+---------------+
-- | Column Name              | Type          |
-- +--------------------------+---------------+
-- | member_id                | int           |
-- | Updated_Outreach_Id      | varchar(50)   |
-- | updated_date             | date          |
-- +--------------------------+---------------+
-- (member_id, updated_date) is the primary key (combination of columns with unique values) of this table.
-- Each row of this table indicates that the Outreach_Id of some member_id was changed to a Updated_Outreach_Id at some date.
 

-- Write a solution to find the Outreach_Id of all members on 2019-08-16. Assume the Outreach_Id of all members before any change is "N/A"

-- Return the result table in any order.

-- Input: 
-- Members table:
-- +------------+---------------------+--------------+
-- | member_id  | Updated_Outreach_Id | updated_date |
-- +------------+---------------------+--------------+
-- | 1          | MNX_20225           | 2019-08-14   |
-- | 2          | TRX_25850           | 2019-08-14   |
-- | 1          | LRI_89730           | 2019-08-15   |
-- | 1          | BQI_34535           | 2019-08-16   |
-- | 2          | HTX_35665           | 2019-08-17   |
-- | 3          | ZXV_48750           | 2019-08-18   |
-- +------------+---------------------+--------------+
-- Output: 
-- +------------+-------------+
-- | member_id  | Outreach_Id |
-- +------------+-------------+
-- | 2          | TRX_25850   |
-- | 1          | BQI_34535   |
-- | 3          | N/A         |
-- +------------+-------------+

-- Query

-- Create Table
CREATE TABLE Members (
  member_id int,
  Updated_Outreach_Id varchar(50),
  updated_date date
);

-- Insert Data
INSERT INTO Members (member_id, Updated_Outreach_Id, updated_date) VALUES
(1, 'MNX_20225', '2019-08-14'),
(2, 'TRX_25850', '2019-08-14'),
(1, 'LRI_89730', '2019-08-15'),
(1, 'BQI_34535', '2019-08-16'),
(2, 'HTX_35665', '2019-08-17'),
(3, 'ZXV_48750', '2019-08-18');

-- Query
-- Return the result where the Outreach_Id of all members on 2019-08-16
-- Ex: if the Outreach_Id didn't change on 2019-08-16, then return the previous Outreach_Id of that member else return "N/A"
SELECT member_id, 
       COALESCE(
           (SELECT Updated_Outreach_Id 
            FROM Members 
            WHERE updated_date <= '2019-08-16' 
            AND member_id = m.member_id 
            ORDER BY updated_date DESC 
            LIMIT 1), 
           'N/A') AS Outreach_Id
FROM Members m
GROUP BY member_id;


-- Write a function that outputs all times in which sum of all digits of a digital clock (hh:mm) equals 13, in ascending order, using the 12-hour U.S. style
-- Ex: 00:00, 00:49, 01:38, 02:37, 03:36, 04:35, 05:34, 06:29, 07:28, 08:27, 09:26, 10:19, 11:18, 12:09

-- Query
-- Create a function that outputs all times in which sum of all digits of a digital clock (hh:mm) equals 13, in ascending order, using the 12-hour U.S. style in MySQL
CREATE FUNCTION timeSum13()
RETURNS VARCHAR(5)
BEGIN
    DECLARE h INT;
    DECLARE m INT;
    DECLARE result VARCHAR(5);
    SET result = '';
    SET h = 0;
    WHILE h < 24 DO
        SET m = 0;
        WHILE m < 60 DO
            IF (FLOOR(h / 10) + h % 10 + FLOOR(m / 10) + m % 10) = 13 THEN
                SET result = CONCAT(result, LPAD(h, 2, '0'), ':', LPAD(m, 2, '0'), ',');
            END IF;
            SET m = m + 1;
        END WHILE;
        SET h = h + 1;
    END WHILE;
    RETURN LEFT(result, LENGTH(result) - 1);
END;


-- Table: Outreach
-- +--------------------------+---------------+
-- | Column Name              | Type          |
-- +--------------------------+---------------+
-- | member_id                | varchar(50)   |
-- | Outreach_Id              | varchar(50)   |
-- | Outreach_date            | varchar(50)   |
-- | Outreach_Type            | varchar(50)   |
-- | Phone_Numbers            | varchar(50)   |
-- | Email                    | date          |
-- | InValid                  | bit           |
-- | Notes                    | varchar(Max)  |
-- +--------------------------+---------------+

-- Table: Outreach is a staging table with all column type NULLS ( no required columns ) and has the following data.
-- Outreach table:
-- +------------+---------------------+---------------+---------------+---------------------+------------------+------------+----------------------------------+
-- | member_id  |      Outreach_Id    | Outreach_date | Outreach_Type |    Phone_Numbers    |       Email      |   InValid  |               Notes              |
-- +------------+---------------------+-------------- +---------------+---------------------+------------------+------------+----------------------------------+
-- | 1          | MNX_20225           | 2023-12-14    |1              |+1-999-666-9999      |search123@yah.com |            |  Null                            |
-- | 2          | TR_X25850           | 2023-12-05    |1              |9324446789_          |abc_hyk@gmail     |            |  Null                            |
-- |            | LRI8_9730           | 2023-12-15    |1              |892-654323           |WORK.abc@abc.com  |            |  Null                            |
-- | 4          | BQI_345359          | 2023-12-16    |A              |789065483-           |abc_hki.com       |            |  Null                            |
-- | 5          | HTX_35665           |               |2              |9752345676           |def@yah.com.uk    |            |  Null                            |
-- | 6          | ZXV_48750           | 2023.12.18    |1              |5123427986           |def@gmail.com     |            |  Null                            |
-- +------------+---------------------+---------------+---------------+---------------------+------------------+------------+----------------------------------+

-- The date needs to be validated during each load and below are some validation rules to be applied,

-- 1. When a value of member_id is missing then mark InValid  1 and Notes to 'Invalid member_id;'
-- 2. Outreach_Id should always be present and should always be 9 character length with '_' being in its 4th place else update InValid  1 and Notes to 'Invalid Outreach_Id;'
-- 3. Outreach_date, if present, should always be a date else update InValid  1 and Notes to 'Outreach_date;'
-- 4. Outreach_Type should either be 1 or 2 else update InValid  1 and Notes to 'Outreach_Type;'
-- 5. Phone_Numbers should be a number and should always be 10 character length and should not start with 0 else update InValid  1 and Notes to 'Invalid Phone_Number;'
-- 6. Email, if present, should always follow the pattern __@__.__ else update InValid  1 and Notes to 'Invalid Email;'

-- If the data in the table passes all the validation rules then set Invalid to 0 else it should be set to 1 and Notes should reflex all the errors.


-- Question: Write a SP to validate the data in Outreach Table , should update IsValid, Notes with the Errors provided and display the table.

-- Output:
-- +------------+---------------------+---------------+---------------+---------------------+------------------+------------+-----------------------------------------------------------------+
-- | member_id  |      Outreach_Id    | Outreach_date | Outreach_Type |    Phone_Numbers    |       Email      |   InValid  |               Notes                                             |
-- +------------+---------------------+-------------- +---------------+---------------------+------------------+------------+-----------------------------------------------------------------+
-- | 1          | MNX_20225           | 2023-12-14    |1              |+1-999-666-9999      |search123@yah.com | 1          |InValid Phone_Numbers;                                           |
-- | 2          | TR_X25850           | 2023-12-05    |1              |9324446789_          |abc_hyk@gmail     | 1          |InValid Outreach_Id; InValid Phone_Numbers; InValid Email;       |
-- |            | LRI8_9730           | 2023-12-15    |1              |892-654323           |WORK.abc@abc.com  | 1          |InValid member_id; InValid Outreach_Id; InValid Phone_Numbers;   |
-- | 4          | BQI_345359          | 2023.12.16    |A              |789065483-           |abc_hki.com       | 1          |InValid Outreach_Type; InValid Email;                            |
-- | 5          | HTX_35665           |               |2              |9752345676           |def@yah.com.uk    | 0          |NULL                                                             |
-- | 6          | ZXV_48750           | 2023-18-12    |1              |5123427986           |def@gmail.com     | 1          |InValid Outreach_date;                                           |
-- +------------+---------------------+---------------+---------------+---------------------+------------------+------------+-----------------------------------------------------------------+

-- create table
CREATE TABLE Outreach (
  member_id varchar(50),
  Outreach_Id varchar(50),
  Outreach_date varchar(50),
  Outreach_Type varchar(50),
  Phone_Numbers varchar(50),
  Email varchar(50),
  InValid bit,
  Notes varchar(50)
);

-- insert data
INSERT INTO Outreach (member_id, Outreach_Id, Outreach_date, Outreach_Type, Phone_Numbers, Email, InValid, Notes) VALUES
('1', 'MNX_20225', '2023-12-14', '1', '+1-999-666-9999', 'search123@yah.com', '1', 'InValid Phone_Numbers;'),
('2', 'TR_X25850', '2023-12-05', '1', '9324446789_', 'abc_hyk@gmail', '1', 'InValid Outreach_Id; InValid Phone_Numbers; InValid Email;'),
('', 'LRI8_9730', '2023-12-15', '1', '892-654323', 'WORK.abc@abc.com', '1', 'InValid member_id; InValid Outreach_Id; InValid Phone_Numbers;'),
('4', 'BQI_345359', '2023.12.16', 'A', '789065483-', 'abc_hki.com', '1', 'InValid Outreach_Type; InValid Email;'),
('5', 'HTX_35665', '', '2', '9752345676', 'def@yah.com.uk', '0', 'NULL'),
('6', 'ZXV_48750', '2023-18-12', '1', '5123427986', 'def@gmail.com', '1', 'InValid Outreach_date;');

-- Query
-- Write a SP to validate the data in Outreach Table , should update IsValid, Notes with the Errors provided and display the table.
DELIMITER //
CREATE PROCEDURE validateOutreach()
BEGIN
    UPDATE Outreach
    SET InValid = 0, Notes = NULL;
    UPDATE Outreach
    SET InValid = 1, Notes = 'Invalid member_id;'
    WHERE member_id = '';
    UPDATE Outreach
    SET InValid = 1, Notes = 'Invalid Outreach_Id;'
    WHERE LENGTH(Outreach_Id) != 9 OR SUBSTRING(Outreach_Id, 4, 1) != '_';
    UPDATE Outreach
    SET InValid = 1, Notes = 'Outreach_date;'
    WHERE Outreach_date IS NOT NULL AND STR_TO_DATE(Outreach_date, '%Y-%m-%d') IS NULL;
    UPDATE Outreach
    SET InValid = 1, Notes = 'Outreach_Type;'
    WHERE Outreach_Type NOT IN ('1', '2');
    UPDATE Outreach
    SET InValid = 1, Notes = 'Invalid Phone_Number;'
    WHERE LENGTH(Phone_Numbers) != 10 OR LEFT(Phone_Numbers, 1) = '0' OR Phone_Numbers REGEXP '[^0-9]';
    UPDATE Outreach
    SET InValid = 1, Notes = 'Invalid Email;'
    WHERE Email IS NOT NULL AND Email NOT REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$';
END//
DELIMITER ;


-- Call the SP
CALL validateOutreach();

-- Display the table
SELECT * FROM Outreach;


DECLARE @JSON nvarchar(MAX)							
													
SET @JSON = '										
{  													
  "ConfirmationID": 12345,							
  "PlanName": "Wellcare Dual Access (HMO D-SNP)",	
  "ClientLocationIdentifier": "3467900",			
  "BlueButtonPatientId": null,						
  "ProductId": 120,									
  "PlanId": 2830,									
  "AgentId": "3690250",								
  "SubmitDate": "2024-02-08T10:27:59",				
  "Premium": "0.00",								
  "ApplicationType": "5",  							
  "Persons": [										
    {												
      "Prefix": null,								
      "FirstName": "Brenda",						
      "LastName": "Wilson",							
      "MiddleName": null,							
      "Gender": "Female",							
      "Ssn": null,									
      "Dob": "1945-04-17T00:00:00",					
      "Age": 78,									
      "Retirement": null,							
      "Relationship": null,							
      "PersonType": 1,								
      "ContactInfoList": [							
        {											
          "Street1": "123 4th Avenue",				
          "Street2": null,							
          "City": "Chattanooga",					
          "County": "Hamilton",						
          "State": "TN",							
          "ZipCode": "37407",						
          "Country": null,							
          "Phone": "9879879870",					
          "SecondaryPhone": null,					
          "Fax": null,								
          "Email": "BrendasEmail@gmail.com",		
          "Type": 1,								
          "Code": 0									
        }											
      ],											
      "ContactInfoTypeList": [						
        1											
      ],											
      "PCPID": null,								
      "GroupName": null,							
      "CurrentPatient": null,						
      "InNetwork": null,							
      "isNull": false,								
      "Code": 0										
    },												
    {												
      "Prefix": null,								
      "FirstName": "Olisha ",						
      "LastName": "Wilson",							
      "MiddleName": null,							
      "Gender": null,								
      "Ssn": null,									
      "Dob": null,									
      "Age": null,									
      "Retirement": null,							
      "Relationship": "Daughter",					
      "PersonType": 5,								
      "ContactInfoList": [							
        {											
          "Street1": null,							
          "Street2": null,							
          "City": null,								
          "County": null,							
          "State": null,							
          "ZipCode": null,							
          "Country": null,							
          "Phone": "5555551234",					
          "SecondaryPhone": null,					
          "Fax": null,								
          "Email": null,							
          "Type": 1,								
          "Code": 0									
        }											
      ],											
      "ContactInfoTypeList": [						
        1											
      ],											
      "PCPID": null,								
      "GroupName": null,							
      "CurrentPatient": null,						
      "InNetwork": null,							
      "isNull": false,								
      "Code": 0										
    },												
    {												
      "Prefix": null,								
      "FirstName": "CHRISTINE",						
      "LastName": "SHOAF",							
      "MiddleName": null,							
      "Gender": null,								
      "Ssn": null,									
      "Dob": null,									
      "Age": null,									
      "Retirement": null,							
      "Relationship": "Primary Doctor",				
      "PersonType": 4,								
      "ContactInfoList": [							
        {											
          "Street1": "3800 TENNESSEE AVE",			
          "Street2": "STE 124",						
          "City": "CHATTANOOGA",					
          "County": null,							
          "State": "TN",							
          "ZipCode": "37409",						
          "Country": null,							
          "Phone": "423-778-2700",					
          "SecondaryPhone": null,					
          "Fax": "423-778-2772",					
          "Email": null,							
          "Type": 0,								
          "Code": 0									
        }											
      ],											
      "ContactInfoTypeList": [],					
      "PCPID": "1912456344",						
      "GroupName": null,							
      "CurrentPatient": null,						
      "InNetwork": true,							
      "isNull": false,								
      "Code": 0										
    }												
  ],												
													
  "MultipleSelectEnrollmentProviderMapInfo": [		
    {												
      "ClientLocationIdentifier": "848491",			
      "NPI": "1124021340",							
      "IsApplicantPCP": false,						
      "PCPSelectedByBeneficiary": false,			
      "FirstName": "JAMES",							
      "LastName": "SIZEMORE",						
      "Street1": "1000 E 3RD ST",					
      "Street2": "STE 302",							
      "City": "CHATTANOOGA",						
      "State": "TN",								
      "Zip": "37403",								
      "PhoneNumber": "423-664-5165",				
      "InNetwork": true,							
      "ZelisProviderEnrollmentID": null				
    },												
    {												
      "ClientLocationIdentifier": "476686",			
      "NPI": "1568484871",							
      "IsApplicantPCP": false,						
      "PCPSelectedByBeneficiary": false,			
      "FirstName": "NAINA",							
      "LastName": "SHARMA",							
      "Street1": "251 NORTH LYERLY ST",				
      "Street2": "STE 300",							
      "City": "CHATTANOOGA",						
      "State": "TN",								
      "Zip": "37404",								
      "PhoneNumber": "423-778-8950",				
      "InNetwork": true,							
      "ZelisProviderEnrollmentID": null				
    },												
    {												
      "ClientLocationIdentifier": "3467900",		
      "NPI": "1912456344",							
      "IsApplicantPCP": true,						
      "PCPSelectedByBeneficiary": true,				
      "FirstName": "CHRISTINE",						
      "LastName": "SHOAF",							
      "Street1": "3800 TENNESSEE AVE",				
      "Street2": "STE 124",							
      "City": "CHATTANOOGA",						
      "State": "TN",								
      "Zip": "37409",								
      "PhoneNumber": "423-778-2700",				
      "InNetwork": true,							
      "ZelisProviderEnrollmentID": null				
    }												
  ],												
  "SelectedDoctor": null,							
  "SelectedDoctorEnrollmentProviderMapInfo": {		
    "ClientLocationIdentifier": "3467900",			
    "NPI": "1912456344",							
    "IsApplicantPCP": true,							
    "PCPSelectedByBeneficiary": true,				
    "FirstName": "CHRISTINE",						
    "LastName": "SHOAF",							
    "Street1": "3800 TENNESSEE AVE",				
    "Street2": "STE 124",							
    "City": "CHATTANOOGA",							
    "State": "TN",									
    "Zip": "37409",									
    "PhoneNumber": "423-778-2700",					
    "InNetwork": true,								
    "ZelisProviderEnrollmentID": null				
  }													
													
}													
'													
													
-- +-------------------------------------------------------+



-- ===========================
-- Question 1 of 2
-- ===========================

-- ===========================
/*

Part #1 - Write a solution to return the values for fields for all the Providers selected in the MultipleSelectEnrollmentProviderMapInfo array. 
	Return the VALUES FOR :
		NPI,
		FirstName,
		LastName,
		IsApplicantPCP,
		PCPSelectedByBeneficiary 
		

Part #2 - Take the results from Part #1 and the PCPSelectedByBeneficiary = true selected from these list of Providers and return the same fields as in Part #1


*/
-- ===========================





-- ===========================
-- Question 2 of 2
-- ===========================

-- ===========================
/*

Write a solution to select the Person object where the PersonType = 4. 
Return the VALUES FOR :
	FirstName
	LastName
	Relationship
	PersonType

*/
-- ===========================

-- Solution 1 of 2
-- Part #1
-- Write a solution to return the values for fields for all the Providers selected in the MultipleSelectEnrollmentProviderMapInfo array.
-- Return the VALUES FOR :
-- NPI,
-- FirstName,
-- LastName,
-- IsApplicantPCP,
-- PCPSelectedByBeneficiary

-- Query
SELECT 
    NPI,
    FirstName,
    LastName,
    IsApplicantPCP,
    PCPSelectedByBeneficiary
FROM OPENJSON(@JSON, '$.MultipleSelectEnrollmentProviderMapInfo')
WITH (
    NPI varchar(50),
    FirstName varchar(50),
    LastName varchar(50),
    IsApplicantPCP bit,
    PCPSelectedByBeneficiary bit
);

-- Part #2
-- Take the results from Part #1 and the PCPSelectedByBeneficiary = true selected from these list of Providers and return the same fields as in Part #1

-- Query
SELECT 
    NPI,
    FirstName,
    LastName,
    IsApplicantPCP,
    PCPSelectedByBeneficiary
FROM OPENJSON(@JSON, '$.MultipleSelectEnrollmentProviderMapInfo')
WITH (
    NPI varchar(50),
    FirstName varchar(50),
    LastName varchar(50),
    IsApplicantPCP bit,
    PCPSelectedByBeneficiary bit
)
WHERE PCPSelectedByBeneficiary = 1;

-- Solution 2 of 2
-- Write a solution to select the Person object where the PersonType = 4.
-- Return the VALUES FOR :
-- FirstName
-- LastName
-- Relationship
-- PersonType

-- Query
SELECT 
    FirstName,
    LastName,
    Relationship,
    PersonType
FROM OPENJSON(@JSON, '$.Persons')
WITH (
    FirstName varchar(50),
    LastName varchar(50),
    Relationship varchar(50),
    PersonType int
)
WHERE PersonType = 4;

-- Table: Members