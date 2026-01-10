-- @ss.idx: 18
-- @ss.level: 2
-- @ss.title: 스탬프를 찍어드려요
-- @ss.slug: count-stamps
-- @ss.category: CASE/IF
-- @ss.note:

SELECT CASE WHEN total_bill >= 25 THEN 2
            WHEN total_bill >= 15 THEN 1
            ELSE 0
       END AS stamp
     , COUNT(*) AS count_bill
FROM tips
GROUP BY stamp
ORDER BY stamp;