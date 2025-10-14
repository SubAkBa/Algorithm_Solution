WITH Temp AS (
    SELECT product_id
         , new_price
         , ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY change_date DESC) AS rn
    FROM Products
    WHERE change_date <= '2019-08-16'
)
SELECT p.product_id
     , IFNULL(t.new_price, 10) AS price
FROM Temp t
RIGHT JOIN (
    SELECT DISTINCT product_id
    FROM Products
) AS p ON p.product_id = t.product_id AND t.rn = 1;