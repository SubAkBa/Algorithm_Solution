-- @ss.idx: 15
-- @ss.level: 2
-- @ss.title: 최대값을 가진 행 찾기
-- @ss.slug: max-row
-- @ss.category: Subquery/CTE
-- @ss.note:

SELECT id
FROM points
WHERE x = (SELECT MAX(x) FROM points)
UNION
SELECT id
FROM points
WHERE y = (SELECT MAX(y) FROM points)
ORDER BY id;