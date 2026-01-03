-- @ss.idx: 6
-- @ss.level: 2
-- @ss.title: 버뮤다 삼각지대에 들어가버린 택배
-- @ss.slug: shipment-in-bermuda
-- @ss.category: Aggregate
-- @ss.note:

SELECT DATE_FORMAT(order_delivered_carrier_date, '%Y-%m-%d') AS delivered_carrier_date
     , COUNT(*) AS orders
FROM olist_orders_dataset
WHERE DATE_FORMAT(order_delivered_carrier_date, '%Y-%m') = '2017-01'
AND order_delivered_customer_date IS NULL
GROUP BY delivered_carrier_date
ORDER BY delivered_carrier_date;