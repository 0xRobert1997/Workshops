--8. Wprowadzamy promocję w naszym sklepie i chcemy aby wszystkie produkty od producenta Bruen
--Group, które kosztują więcej niż 50 pieniędzy zostały przecenione na 40 pieniędzy.

UPDATE product
SET product_price = 40
FROM product as produc
JOIN producer as produce
ON produc.producer_id = produce.id
WHERE produce.producer_name = 'Bruen Group';

