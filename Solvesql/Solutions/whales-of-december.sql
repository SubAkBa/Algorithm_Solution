-- @ss.idx: 17
-- @ss.level: 2
-- @ss.title: 12월 우수 고객 찾기
-- @ss.slug: whales-of-december
-- @ss.category: Aggregate
-- @ss.note:

SELECT customer_id
FROM records
WHERE DATE_FORMAT(order_date, '%Y-%m') = '2020-12'
GROUP BY customer_id
HAVING SUM(sales) >= 1000;