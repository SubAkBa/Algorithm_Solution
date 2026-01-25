-- @ss.idx: 8
-- @ss.level: 3
-- @ss.title: 온라인 쇼핑몰의 월 별 매출액 집계
-- @ss.slug: shoppingmall-monthly-summary
-- @ss.category: JOIN/UNION
-- @ss.note: union all

SELECT order_month
     , SUM(IF(temp.is_canceled = 0, amount, 0)) AS ordered_amount
     , SUM(IF(temp.is_canceled = 1, amount, 0)) AS canceled_amount
     , SUM(IF(temp.is_canceled = 0, amount, 0)) + SUM(IF(temp.is_canceled = 1, amount, 0)) AS total_amount
FROM (
    SELECT DATE_FORMAT(o.order_date, '%Y-%m') AS order_month
         , IF(o.order_id LIKE 'C%', 1, 0) is_canceled
         , oi.price * oi.quantity AS amount
      FROM orders o
      JOIN order_items oi ON o.order_id = oi.order_id
) AS temp
GROUP BY temp.order_month
ORDER BY temp.order_month;