-- 코드를 입력하세요

SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_CAR 
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY USING (CAR_ID)
WHERE DATE_FORMAT(START_DATE, '%Y-%m') = '2022-10' AND CAR_TYPE = '세단'
ORDER BY CAR_ID DESC;