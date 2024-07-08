-- 코드를 작성해주세요

SELECT E1.ID,
    CASE
        WHEN (NUM/(SELECT COUNT(*) FROM ECOLI_DATA))*100 <= 25
        THEN 'CRITICAL'
        WHEN (NUM/(SELECT COUNT(*) FROM ECOLI_DATA))*100 <= 50
        THEN 'HIGH'
        WHEN (NUM/(SELECT COUNT(*) FROM ECOLI_DATA))*100 <= 75
        THEN 'MEDIUM'
        ELSE 'LOW'
    END AS 'COLONY_NAME'
FROM ECOLI_DATA E1
JOIN (SELECT ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS NUM,
      ID, SIZE_OF_COLONY
      FROM ECOLI_DATA) AS E2
ON E1.ID = E2.ID
ORDER BY E1.ID;