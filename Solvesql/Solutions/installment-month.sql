-- @ss.idx: 2
-- @ss.level: 3
-- @ss.title: 할부는 몇 개월로 해드릴까요
-- @ss.slug: installment-month
-- @ss.category: Aggregate
-- @ss.note:

SELECT payment_installments
     , COUNT(DISTINCT order_id) AS order_count
     , MIN(payment_value) AS min_value
     , MAX(payment_value) AS max_value
     , AVG(payment_value) AS avg_value
FROM olist_order_payments_dataset
WHERE payment_type = 'credit_card'
GROUP BY payment_installments;