SELECT e.name
     , b.bonus
FROM Employee e
LEFT JOIN Bonus b ON e.empId = b.empId
WHERE IFNULL(b.bonus, 0) < 1000;