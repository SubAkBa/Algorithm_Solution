-- @ss.idx: 4
-- @ss.level: 2
-- @ss.title: 우리 플랫폼에 정착한 판매자 2
-- @ss.slug: settled-sellers-2
-- @ss.category: Aggregate
-- @ss.note:

SELECT temp.seller_id
     , COUNT(*) AS orders
FROM (
    SELECT DISTINCT order_id
                  , seller_id
    FROM olist_order_items_dataset
    WHERE price >= 50
) AS temp
GROUP BY temp.seller_id
HAVING orders >= 100
ORDER BY orders DESC;