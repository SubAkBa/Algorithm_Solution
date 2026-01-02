SELECT day
     , time
     , ROUND(AVG(tip), 2) as avg_tip
     , ROUND(AVG(size), 2) as avg_size
FROM tips
GROUP BY day, time
ORDER BY day, time;