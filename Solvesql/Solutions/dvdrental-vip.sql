-- @ss.idx: 19
-- @ss.level: 2
-- @ss.title: DVD 대여점 우수 고객 찾기
-- @ss.slug: dvdrental-vip
-- @ss.category: Subquery/CTE
-- @ss.note:

SELECT c.customer_id
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
WHERE c.active = 1
GROUP BY c.customer_id
HAVING COUNT(c.customer_id) >= 35;