-- @ss.idx: 7
-- @ss.level: 3
-- @ss.title: 쇼핑몰의 일일 매출액과 ARPPU
-- @ss.slug: daily-arppu
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT DATE_FORMAT(o.order_purchase_timestamp, '%Y-%m-%d') AS dt
     , COUNT(DISTINCT customer_id) AS pu
     , ROUND(SUM(p.payment_value), 2) AS revenue_daily
     , ROUND(SUM(p.payment_value) / COUNT(DISTINCT customer_id), 2) AS arppu
FROM olist_orders_dataset o
JOIN olist_order_payments_dataset p ON o.order_id = p.order_id
WHERE DATE_FORMAT(o.order_purchase_timestamp, '%Y-%m-%d') >= '2018-01-01'
GROUP BY dt
ORDER BY dt;