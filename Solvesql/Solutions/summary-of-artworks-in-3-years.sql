-- @ss.idx: 16
-- @ss.level: 2
-- @ss.title: 3년간 들어온 소장품 집계하기
-- @ss.slug: summary-of-artworks-in-3-years
-- @ss.category: CASE/IF
-- @ss.note: IF, CASE WHEN

SELECT classification
     , SUM(IF(YEAR(acquisition_date) = 2014, 1, 0)) AS '2014'
     , SUM(IF(YEAR(acquisition_date) = 2015, 1, 0)) AS '2015'
     , SUM(IF(YEAR(acquisition_date) = 2016, 1, 0)) AS '2016'
--      , COUNT(CASE WHEN YEAR(acquisition_date) = 2014 THEN 1 END) AS '2014'
--      , COUNT(CASE WHEN YEAR(acquisition_date) = 2015 THEN 1 END) AS '2015'
--      , COUNT(CASE WHEN YEAR(acquisition_date) = 2016 THEN 1 END) AS '2016'
FROM artworks
GROUP BY classification
ORDER BY classification;