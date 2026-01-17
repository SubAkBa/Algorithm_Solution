-- @ss.idx: 5
-- @ss.level: 3
-- @ss.title: 작품이 없는 작가 찾기
-- @ss.slug: artists-without-artworks
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT ar.artist_id
     , ar.name
FROM artists ar
WHERE ar.death_year IS NOT NULL
AND NOT EXISTS (
    SELECT 1
    FROM artworks a
    JOIN artworks_artists aa ON a.artwork_id = aa.artwork_id
    WHERE aa.artist_id = ar.artist_id
);