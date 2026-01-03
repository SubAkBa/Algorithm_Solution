-- @ss.idx: 8
-- @ss.level: 2
-- @ss.title: 점검이 필요한 자전거 찾기
-- @ss.slug: inspection-needed-bike
-- @ss.category: Aggregate
-- @ss.note:

SELECT bike_id
FROM rental_history
WHERE DATE_FORMAT(rent_at, '%Y-%m') = '2021-01'
AND DATE_FORMAT(return_at, '%Y-%m') = '2021-01'
GROUP BY bike_id
HAVING SUM(distance) >= 50000;