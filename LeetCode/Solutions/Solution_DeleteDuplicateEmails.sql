DELETE p1 FROM Person p1
JOIN Person p2 ON p1.email = p2.email AND p1.id > p2.id;


DELETE p1 FROM Person p1
WHERE p1.id NOT IN (
   SELECT temp.id
   FROM (
      SELECT MIN(p2.id) AS ID
      FROM Person p2
      GROUP BY p2.email
   ) AS temp
);