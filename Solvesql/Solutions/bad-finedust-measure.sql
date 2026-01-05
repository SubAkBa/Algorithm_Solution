-- @ss.idx: 11
-- @ss.level: 2
-- @ss.title: 다음날도 서울숲의 미세먼지 농도는 나쁨 😢
-- @ss.slug: bad-finedust-measure
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT m1.measured_at AS today
     , m2.measured_at AS next_day
     , m1.pm10 AS pm10
     , m2.pm10 AS next_pm10
FROM measurements m1
JOIN measurements m2 ON m1.measured_at = DATE_SUB(m2.measured_at, INTERVAL 1 DAY)
WHERE m1.pm10 < m2.pm10;


SELECT t.*
FROM (
         SELECT measured_at AS today
              , LEAD(measured_at) OVER (ORDER BY measured_at) AS next_day
       , pm10
              , LEAD(pm10) OVER (ORDER BY measured_at) AS next_pm10
         FROM measurements
     ) AS t
WHERE t.today = DATE_SUB(t.next_day, INTERVAL 1 DAY)
  AND t.pm10 < t.next_pm10;