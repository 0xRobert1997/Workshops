-- 4. Nie podobają nam się opinie o ocenie niższej niż 4, więc usuń je wszystkie ὠ.

DELETE FROM OPINION
WHERE STARS < 4