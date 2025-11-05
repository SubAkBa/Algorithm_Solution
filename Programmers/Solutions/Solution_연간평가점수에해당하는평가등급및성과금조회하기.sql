SELECT E.EMP_NO
     , E.EMP_NAME
     , ELT(G.BAND, 'S', 'A', 'B', 'C') AS GRADE
     , E.SAL * ELT(G.BAND, 0.2, 0.15, 0.1, 0.0) AS BONUS
FROM HR_EMPLOYEES E
JOIN (
    SELECT EMP_NO
         , AVG(SCORE) AS AVG_SCORE
         , CASE WHEN AVG(SCORE) >= 96 THEN 1
                WHEN AVG(SCORE) >= 90 THEN 2
                WHEN AVG(SCORE) >= 80 THEN 3
                ELSE 4
           END AS 'BAND'
    FROM HR_GRADE
    GROUP BY EMP_NO
) G ON E.EMP_NO = G.EMP_NO
ORDER BY E.EMP_NO;