package codechef;

/*
 * Abhi is a salesman. He was given two types of candies, which he is selling in 
𝑁
N different cities.

For the prices of the candies to be valid, Abhi's boss laid down the following condition:

A given type of candy must have distinct prices in all 
𝑁
N cities.
In his excitement, Abhi wrote down the prices of both the candies on the same page and in random order instead of writing them on different pages. Now he is asking for your help to find out if the prices he wrote are valid or not.

You are given an array 
𝐴
A of size 
2
𝑁
2N. Find out whether it is possible to split 
𝐴
A into two arrays, each of length 
𝑁
N, such that both arrays consist of distinct elements.

Both arrays can have distinct elements only if no element in the original array is repeated more than twice.

Input Format
The first line of input will contain a single integer 
𝑇
T, denoting the number of test cases.
Each test case consists of two lines of input.
The first line of each test case contains one integer 
𝑁
N, denoting the number of cities
The second line contains 
2
𝑁
2N space-separated integers 
𝐴
1
,
𝐴
2
,
…
,
𝐴
2
𝑁
A 
1
​
 ,A 
2
​
 ,…,A 
2N
​
  — the elements of the array 
𝐴
A.
Output Format
For each test case output the answer on a new line — Yes if the given array represents a valid list of prices, and No otherwise.

Each letter of the output may be printed in either uppercase or lowercase, i.e, Yes, YES, and yEs will all be treated as equivalent.

Constraints
1
≤
𝑇
≤
1
0
3
1≤T≤10 
3
 
1
≤
𝑁
≤
1
0
3
1≤N≤10 
3
 
1
≤
𝐴
𝑖
≤
1
0
9
1≤A 
i
​
 ≤10 
9
 
The sum of 
𝑁
N over all testcases does not exceed 
2
⋅
1
0
3
2⋅10 
3
 */


 import java.util.*;

 
 class Codechef
 {
     public static void main(String[] args) throws java.lang.Exception
     {
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();
         while (t-- > 0) {
             solve(sc);
         }
         sc.close();
     }
 
     public static void solve(Scanner sc) {
         long n = sc.nextLong();
         HashMap <Long, Long> map = new HashMap <> ();
         long key;
         for (int i = 0; i < n * 2; i++) {
             key = sc.nextLong();
             map.put(key, map.getOrDefault(key, 0L) + 1);
         }
         for(long i: map.values()){
             if(i > 2){
                 System.out.println("NO");
                    return;
             }
         }
         System.out.println("YES");
     }
 }