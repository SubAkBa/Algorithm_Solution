-- @ss.idx: 1
-- @ss.level: 3
-- @ss.title: 복수 국적 메달 수상한 선수 찾기
-- @ss.slug: multiple-medalist
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT a.name
FROM athletes a
JOIN records r ON r.athlete_id = a.id
JOIN games g   ON g.id = r.game_id
WHERE r.medal != ""
AND g.year >= 2000
GROUP BY a.id
HAVING COUNT(DISTINCT r.team_id) >= 2
ORDER BY a.name;