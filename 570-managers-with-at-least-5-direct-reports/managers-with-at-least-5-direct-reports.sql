SELECT m.name as name
FROM Employee m
JOIN (
    SELECT managerId
    FROM Employee
    WHERE  managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(*) >= 5
) AS mgr
on m.id = mgr.managerId;
