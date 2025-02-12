SELECT name, expired_date, price
FROM product
WHERE type_id = 1;

SELECT name, expired_date, price
FROM product
WHERE name LIKE '%мороженое%';

SELECT name, expired_date, price
FROM product
WHERE expired_date < '2025-02-12';

SELECT name, expired_date, price
FROM product
WHERE price = (SELECT MAX(price)
					FROM product
					);

SELECT t.name, COUNT(p.name)
FROM type AS t, product AS p
WHERE p.type_id = t.id
GROUP BY t.name;

SELECT name, expired_date, price
FROM product
WHERE type_id IN (1, 2);

SELECT t.name
FROM type AS t, product AS p
WHERE p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.name) < 10;

SELECT p.name, p.expired_date, p.price, t.name				
FROM type AS t, product AS p
WHERE p.type_id = t.id
					