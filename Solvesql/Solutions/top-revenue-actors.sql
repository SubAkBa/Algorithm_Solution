-- @ss.idx: 21
-- @ss.level: 2
-- @ss.title: 매출이 높은 배우 찾기
-- @ss.slug: top-revenue-actors
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT a.first_name
     , a.last_name
     , temp.total_revenue
FROM actor a
JOIN (
    SELECT fa.actor_id
         , SUM(p.amount) as total_revenue
    FROM film_actor fa
    JOIN inventory i ON i.film_id = fa.film_id
    JOIN rental r ON r.inventory_id = i.inventory_id
    JOIN payment p ON p.rental_id = r.rental_id
    GROUP BY fa.actor_id
) AS temp ON a.actor_id = temp.actor_id
ORDER BY temp.total_revenue DESC
LIMIT 5;