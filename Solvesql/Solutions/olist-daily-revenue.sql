-- @ss.idx: 7
-- @ss.level: 2
-- @ss.title: 쇼핑몰의 일일 매출액
-- @ss.slug: olist-daily-revenue
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT DATE_FORMAT(o1.order_purchase_timestamp, '%Y-%m-%d') AS dt
     , ROUND(SUM(o2.payment_value), 2) AS revenue_daily
FROM olist_orders_dataset o1
JOIN olist_order_payments_dataset o2 ON o1.order_id = o2.order_id
WHERE o1.order_purchase_timestamp >= '2018-01-01 00:00:00'
GROUP BY dt
ORDER BY dt;