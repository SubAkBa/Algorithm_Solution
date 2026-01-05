-- @ss.idx: 9
-- @ss.level: 2
-- @ss.title: 레스토랑의 대목
-- @ss.slug: high-season-of-restaurant
-- @ss.category: Aggregate
-- @ss.note:

SELECT *
FROM tips
WHERE day IN (
    SELECT day
    FROM tips
    GROUP BY day
    HAVING SUM(total_bill) >= 1500
);