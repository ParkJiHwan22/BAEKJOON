-- 코드를 입력하세요
SELECT ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_OUTS
INNER JOIN ANIMAL_INS USING (ANIMAL_ID)
WHERE TIMEDIFF(ANIMAL_OUTS.DATETIME, ANIMAL_INS.DATETIME) < 0
ORDER BY ANIMAL_INS.DATETIME;