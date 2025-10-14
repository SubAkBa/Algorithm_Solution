WITH Temp AS (
    SELECT buyer_id
         , COUNT(buyer_id) AS order_count
    FROM Orders
    WHERE DATE_FORMAT(order_date, '%Y') = '2019'
    GROUP BY buyer_id
)
SELECT u.user_id AS buyer_id
     , u.join_date
     , IFNULL(t.order_count, 0) AS orders_in_2019
FROM Users u
LEFT JOIN Temp t ON u.user_id = t.buyer_id;