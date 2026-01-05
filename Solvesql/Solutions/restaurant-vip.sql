-- @ss.idx: 10
-- @ss.level: 2
-- @ss.title: 레스토랑의 요일별 VIP
-- @ss.slug: restaurant-vip
-- @ss.category: Aggregate
-- @ss.note:

SELECT *
FROM tips
WHERE (day, total_bill) IN (
    SELECT day
         , MAX(total_bill) OVER (PARTITION BY day)
    FROM tips
);


SELECT t.total_bill
     , t.tip
     , t.sex
     , t.smoker
     , t.day
     , t.time
     , t.size
FROM (
    SELECT *
          , ROW_NUMBER() OVER (PARTITION BY day ORDER BY total_bill DESC) AS rn
    FROM tips
) AS t
WHERE t.rn = 1;