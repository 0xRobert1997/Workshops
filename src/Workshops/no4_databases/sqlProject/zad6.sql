--6. Wyświetl na ekranie kody oraz ilość dokonanych transakcji zakupowych dla 5 produktów, które
--pojawiają się w największej ilości transakcji. Wynik posortuj malejąco na podstawie ilości
--dokonanych transakcji zakupowych. Ilość dokonanych transakcji zakupowych nie oznacza, że
--produkt jest kupowany najczęściej w obrębie jednej transakcji zakupowej, tylko oznacza, że produkt
--pojawia się w największej ilości dokonanych transakcji zakupowych.


SELECT PROD.PRODUCT_CODE, COUNT(*)
FROM PURCHASE as PUR
INNER JOIN PRODUCT AS PROD
ON PROD.ID = PUR.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY COUNT(*) DESC
LIMIT(5)

