WITH Temptable AS (
    SELECT RANK() OVER (PARTITION BY product_id ORDER BY year) AS rk
         , product_id
         , year
         , quantity
         , price
    FROM Sales
)
SELECT product_id
     , year AS first_year
     , quantity
     , price
FROM Temptable
WHERE rk = 1;



WITH Temptable AS (
    SELECT product_id
         , MIN(year) AS first_year
    FROM Sales
    GROUP BY product_id
)
SELECT t.product_id
     , t.first_year
     , s.quantity
     , s.price
FROM Temptable t
         JOIN Sales s ON t.product_id = s.product_id
    AND t.first_year = s.year;