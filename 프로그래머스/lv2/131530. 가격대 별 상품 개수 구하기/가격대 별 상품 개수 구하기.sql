SELECT (PRICE - PRICE % 10000) PRICE_GROUP, COUNT(*) PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP