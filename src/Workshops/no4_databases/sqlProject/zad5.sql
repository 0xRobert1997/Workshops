-- 5. Wyświetl unikalne kody produktów, które zostały zakupione przed datą '2020-02-01'.
-- dane były wygenerowane od 2021-01-01 dlatego zmieniłem date

SELECT DISTINCT PROD.PRODUCT_CODE
FROM PURCHASE as PUR
INNER JOIN PRODUCT as PROD
ON PROD.ID = PUR.PRODUCT_ID
WHERE DATE_TIME < '2021-06-01'