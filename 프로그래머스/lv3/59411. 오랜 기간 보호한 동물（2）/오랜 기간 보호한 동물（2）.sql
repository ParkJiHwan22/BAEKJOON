-- 코드를 입력하세요
SELECT ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_OUTS
INNER JOIN ANIMAL_INS USING (ANIMAL_ID)
ORDER BY DATEDIFF(ANIMAL_OUTS.DATETIME, ANIMAL_INS.DATETIME) DESC
LIMIT 2;