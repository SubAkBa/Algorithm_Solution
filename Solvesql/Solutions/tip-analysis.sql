-- @ss.idx: 2
-- @ss.level: 2
-- @ss.title: 레스토랑 웨이터의 팁 분석
-- @ss.slug: tip-analysis
-- @ss.category: Aggregate
-- @ss.note:

SELECT day
     , time
     , ROUND(AVG(tip), 2) as avg_tip
     , ROUND(AVG(size), 2) as avg_size
FROM tips
GROUP BY day, time
ORDER BY day, time;