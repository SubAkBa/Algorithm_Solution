-- @ss.idx: 23
-- @ss.level: 2
-- @ss.title: 연도별 배송 업체 이용 내역 분석하기
-- @ss.slug: yearly-shipping-usage
-- @ss.category: CASE/IF
-- @ss.note:

SELECT YEAR(purchased_at) AS 'year'
     , SUM(shipping_method = 'Standard') + SUM(is_returned) AS 'standard'
     , SUM(shipping_method = 'Express') AS 'express'
     , SUM(shipping_method = 'Overnight') AS 'overnight'
FROM transactions
WHERE is_online_order = 1
GROUP BY YEAR(purchased_at)
ORDER BY year;