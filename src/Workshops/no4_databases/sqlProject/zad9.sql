--9. Znajdź osoby, które wystawiły co najmniej jedną opinię o wartości 5 gwiazdek.


SELECT DISTINCT CUS.ID, CUS.NAME, CUS.SURNAME
FROM CUSTOMER as CUS
INNER JOIN OPINION as OP
ON CUS.ID = OP.CUSTOMER_ID
WHERE OP.STARS = 5