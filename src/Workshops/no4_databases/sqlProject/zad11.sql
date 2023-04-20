--11. Wyświetl na ekranie drugi najdroższy produkt (minimum nazwa i cena). Możesz wykorzystać
--klauzulę OFFSET.

SELECT PRODUCT_NAME, PRODUCT_PRICE
FROM PRODUCT
ORDER BY PRODUCT_PRICE DESC
LIMIT 1
OFFSET 1