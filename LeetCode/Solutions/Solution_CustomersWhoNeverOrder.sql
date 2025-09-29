SELECT c.name AS Customers
FROM Customers c
WHERE NOT EXISTS (SELECT 1 FROM Orders o WHERE c.id = o.customerId)


SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o ON c.id = o.customerId
WHERE o.id IS NULL;


SELECT c.name AS Customers
FROM Customers c
WHERE c.id NOT IN (SELECT o.customerId FROM Orders o);