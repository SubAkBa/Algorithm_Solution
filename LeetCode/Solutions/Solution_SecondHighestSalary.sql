WITH CTE_TEMP AS (
    SELECT ROW_NUMBER() OVER (ORDER BY salary DESC) AS seq
         , salary
    FROM Employee
    GROUP BY salary
)
SELECT CASE WHEN COUNT(*) < 2 THEN NULL
            ELSE MAX(CASE WHEN seq = 2 THEN salary END)
            END AS SecondHighestSalary
FROM CTE_TEMP;



SELECT MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);




SELECT IFNULL(
   (
       SELECT DISTINCT salary
       FROM Employee
       ORDER BY salary DESC
       LIMIT 1
       OFFSET 1
   ), NULL
) AS SecondHighestSalary;