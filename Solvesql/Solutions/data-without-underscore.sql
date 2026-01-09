-- @ss.idx: 13
-- @ss.level: 2
-- @ss.title: 언더스코어(_)가 포함되지 않은 데이터 찾기
-- @ss.slug: data-without-underscore
-- @ss.category: String/Date
-- @ss.note: 정규표현식 REGEXP 또는 INSTR 사용

SELECT DISTINCT page_location
FROM ga
WHERE 1 = 1
AND page_location NOT LIKE '%\_%'
-- AND page_location NOT REGEXP '_'
-- INSTR(page_location, '_') = 0
ORDER BY page_location;