WITH Temp AS (
    SELECT IF(order_date = customer_pref_delivery_date, 1, 0) AS is_equal
         , ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY order_date) AS rn
    FROM Delivery
)
SELECT ROUND(SUM(is_equal) / COUNT(*) * 100, 2) AS immediate_percentage
FROM Temp
WHERE rn = 1;