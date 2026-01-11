-- @ss.idx: 22
-- @ss.level: 2
-- @ss.title: 한국 감독의 영화 찾기
-- @ss.slug: find-movies-by-korean-artists
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT at.name as artist
     , a.title
FROM artworks a
JOIN artworks_artists aa ON a.artwork_id = aa.artwork_id
JOIN artists at ON aa.artist_id = at.artist_id
WHERE at.nationality = 'Korean'
AND a.classification LIKE 'Film%';