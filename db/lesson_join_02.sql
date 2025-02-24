CREATE TABLE teens(
	teens_id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	gender VARCHAR(10)
);

INSERT INTO teens(name, gender)
VALUES('Boris', 'male'),
		('Fedr', 'male'),
		('Petr', 'male'),
		('Ann', 'female'),
		('Katy', 'female'),
		('Oleg', 'male'),
		('Inna', 'female');

SELECT t1.name AS male, t2.name AS female
FROM teens AS t1
CROSS JOIN teens AS t2
WHERE t1.gender = 'male' AND t2.gender = 'female'