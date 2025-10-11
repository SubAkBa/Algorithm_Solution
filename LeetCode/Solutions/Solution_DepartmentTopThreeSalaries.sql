WITH Temptable AS (
    SELECT DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rk
         , name
         , salary
         , departmentId
    FROM Employee
)
SELECT d.name AS Department
     , t.name AS Employee
     , t.salary
FROM Temptable t
JOIN Department d ON t.departmentId = d.id
WHERE t.rk <= 3
