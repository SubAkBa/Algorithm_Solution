-- @ss.idx: 12
-- @ss.level: 2
-- @ss.title: 제목이 모음으로 끝나지 않는 영화
-- @ss.slug: film-ending-with-consonant
-- @ss.category: String/Date
-- @ss.note: 정규표현식 REGEXP 또는 RIGHT 사용

SELECT title
FROM film
WHERE rating IN ('R', 'NC-17')
AND title NOT REGEXP '[AEIOU]$';
-- AND RIGHT(title, 1) NOT IN ('A','E','I','O','U');
-- AND title NOT LIKE '%A'
-- AND title NOT LIKE '%E'
-- AND title NOT LIKE '%I'
-- AND title NOT LIKE '%O'
-- AND title NOT LIKE '%U';