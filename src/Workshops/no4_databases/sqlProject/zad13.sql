--13. Oblicz ile zarobiliśmy w naszym sklepie w każdym miesiącu od uruchomienia sklepu. Zagadnienie
--wybiega poza zakres materiału pokazany w części teoretycznej, pełne wyjaśnienie w nagraniu z
--rozwiązaniem. Podpowiedź: możesz wykorzystać zapytanie zagnieżdżone i funkcję bazodanową
--DATE_TRUNC('month', date_time), aby wyciągnąć sam miesiąc z daty.

WITH TMP AS (
	SELECT
	DATE_TRUNC('month', pur.date_time) as Date_time,
	pur.quantity,
	pr.product_price,
	PUR.QUANTITY * PR.PRODUCT_PRICE as INCOME_PER_PRODUCT
	FROM PURCHASE as PUR
	INNER JOIN PRODUCT as PR
	ON PR.ID = PUR.PRODUCT_ID
	ORDER BY DATE_TIME, INCOME_PER_PRODUCT
)
SELECT TMP.DATE_TIME, SUM(TMP.INCOME_PER_PRODUCT)
FROM TMP
GROUP BY TMP.DATE_TIME
ORDER BY TMP.DATE_TIME