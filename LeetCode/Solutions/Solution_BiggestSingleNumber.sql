SELECT (
   SELECT num
   FROM MyNumbers
   GROUP BY num
   HAVING COUNT(*) = 1
   ORDER BY num DESC
   LIMIT 1
) AS num
FROM DUAL;

WITH TEMP_TABLE AS (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
)
SELECT MAX(num) AS num
FROM TEMP_TABLE;