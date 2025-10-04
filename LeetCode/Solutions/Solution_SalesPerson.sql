SELECT name
FROM SalesPerson s
WHERE NOT EXISTS (
    SELECT 1
    FROM Company c
    JOIN Orders o ON c.com_id = o.com_id
    WHERE o.sales_id = s.sales_id
    AND c.name = 'RED'
);