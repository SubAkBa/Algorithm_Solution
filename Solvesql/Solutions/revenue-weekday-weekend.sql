-- @ss.idx: 20
-- @ss.level: 2
-- @ss.title: 레스토랑의 주중, 주말 매출액 비교하기
-- @ss.slug: revenue-weekday-weekend
-- @ss.category: CASE/IF
-- @ss.note:

SELECT IF(day IN ('Sat', 'Sun'), 'weekend', 'weekday') AS 'week'
     , SUM(total_bill) AS 'sales'
FROM tips
GROUP BY week
ORDER BY sales DESC;