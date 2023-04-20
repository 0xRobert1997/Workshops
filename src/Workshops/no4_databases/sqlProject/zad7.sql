--7. Wyświetl na ekranie wszystkich klientów którzy zakupili produkty przeznaczone dla dorosłych
--(flaga ADULTS_ONLY ustawiona na true).

SELECT CUS.ID, CUS.USER_NAME, CUS.NAME, CUS.SURNAME
FROM CUSTOMER as CUS
INNER JOIN PURCHASE as PUR on CUS.ID = PUR.CUSTOMER_ID
INNER JOIN PRODUCT as PROD on PROD.ID = PUR.PRODUCT_ID
WHERE PROD.ADULTS_ONLY = true