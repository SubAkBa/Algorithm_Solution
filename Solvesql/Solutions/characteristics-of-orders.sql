-- @ss.idx: 3
-- @ss.level: 3
-- @ss.title: 지역별 주문의 특징
-- @ss.slug: characteristics-of-orders
-- @ss.category: CASE/IF
-- @ss.note:

SELECT region AS `Region`
     , COUNT(DISTINCT CASE WHEN category = 'Furniture' THEN order_id END) AS `Furniture`
     , COUNT(DISTINCT CASE WHEN category = 'Office Supplies' THEN order_id END) AS `Office Supplies`
     , COUNT(DISTINCT CASE WHEN category = 'Technology' THEN order_id END) AS `Technology`
FROM records
GROUP BY region
ORDER BY region;