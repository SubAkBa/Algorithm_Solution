SELECT *
FROM (
         SELECT C.CAR_ID
              , C.CAR_TYPE
              , ROUND(C.DAILY_FEE * (1 - (
                                             SELECT DISCOUNT_RATE
                                             FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                             WHERE CAR_TYPE = C.CAR_TYPE
                                             AND DURATION_TYPE = '30일 이상') / 100)) * 30 AS FEE
         FROM CAR_RENTAL_COMPANY_CAR C
         WHERE NOT EXISTS (
             SELECT 1
             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
             WHERE C.CAR_ID = H.CAR_ID
             AND H.START_DATE <= '2022-11-30'
             AND H.END_DATE >= '2022-11-01'
         )
         AND C.CAR_TYPE IN ('세단', 'SUV')
     ) T
WHERE T.FEE >= 500000
AND T.FEE < 2000000
ORDER BY T.FEE DESC, T.CAR_TYPE, T.CAR_ID DESC;