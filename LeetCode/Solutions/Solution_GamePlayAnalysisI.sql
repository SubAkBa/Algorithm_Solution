WITH Temptable AS (
    SELECT RANK() OVER (PARTITION BY player_id ORDER BY event_date) AS rk
         , player_id
         , event_date
    FROM Activity
)
SELECT t.player_id AS player_id
     , t.event_date AS first_login
FROM Temptable t
WHERE rk = 1;



SELECT player_id
     , MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;