SELECT d.name AS Department
     , e.name AS Employee
     , e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE e.salary = (
    SELECT MAX(salary)
    FROM Employee
    WHERE departmentId = e.departmentId
    GROUP BY departmentId
);



WITH TempTable AS (
    SELECT e.name
         , e.salary
         , e.departmentId
         , RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS "rank"
    FROM Employee e
)
SELECT d.name AS Department
     , t.name AS Employee
     , t.salary AS Salary
FROM TempTable t
         JOIN Department d ON t.departmentId = d.id
WHERE t.rank = 1