-- @ss.idx: 14
-- @ss.level: 2
-- @ss.title: 게임을 10개 이상 발매한 게임 배급사 찾기
-- @ss.slug: publisher-with-many-games
-- @ss.category: Aggregate
-- @ss.note:

SELECT c.name
FROM games g
JOIN companies c ON g.publisher_id = c.company_id
GROUP BY c.company_id
HAVING COUNT(c.company_id) >= 10;