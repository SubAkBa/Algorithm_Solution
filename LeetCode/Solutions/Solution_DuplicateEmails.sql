SELECT p.email AS Email
FROM Person p
GROUP BY p.email
HAVING COUNT(*) > 1;