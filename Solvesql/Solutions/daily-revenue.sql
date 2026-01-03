-- @ss.idx: 5
-- @ss.level: 2
-- @ss.title: 레스토랑의 일일 매출
-- @ss.slug: daily-revenue
-- @ss.category: Aggregate
-- @ss.note:

SELECT day
     , SUM(total_bill) AS revenue_daily
FROM tips
GROUP BY day
HAVING revenue_daily >= 1000
ORDER BY revenue_daily DESC;