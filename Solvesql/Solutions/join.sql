-- @ss.idx: 1
-- @ss.level: 2
-- @ss.title: 두 테이블 결합하기
-- @ss.slug: join
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT DISTINCT athlete_id
FROM records
WHERE EXISTS (
    SELECT 1
    FROM events
    WHERE sport = 'Golf'
    AND events.id = records.event_id
);