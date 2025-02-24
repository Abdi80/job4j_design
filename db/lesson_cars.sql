CREATE TABLE car_bodies(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE car_engines(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE car_transmissions(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE cars(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	body_id INT REFERENCES car_bodies(id),
	engine_id INT REFERENCES car_engines(id),
	transmission_id INT REFERENCES car_transmissions(id)
);

INSERT INTO car_bodies(name)
VALUES('Седан'),
		('Хэтчбек'),
		('Кроссовер'),
		('Купе'),
		('Универсал'),
		('Пикап'),
		('Внедорожник'),
		('Фастбэк'), 
		('Кабриолет'),
		('Лифтбэк'); 

INSERT INTO car_engines(name)
VALUES('2.5 л, бензиновый'),
        ('3.0 л, дизельный'),
        ('5.0 л, бензиновый V8'),
        ('1.6 л, бензиновый'),
        ('2.0 л, дизельный'),
        ('4.0 л, бензиновый V8 битурбо'),
        ('2.0 л, бензиновый'),
        ('6.2 л, бензиновый V8'),
        ('2.9 л, бензиновый V6 (гибрид)'),
        ('Электрический');		
		
INSERT INTO car_transmissions(name)
VALUES('Механика'),
		('Автомат'),
		('Робот'),
		('Вариатор');

INSERT INTO cars(name, body_id, engine_id, transmission_id)
VALUES('Toyota Camry', 1, 1, 2),
		('BMW X5', 3, 2, 2),
		('Hyundai Tucson', 3, 4, 3),
		('Volkswagen Passat', 5, 5, 2),
		('Mazda MX-5', 9, 7, 1),
		('Tesla Model S', 10, 10, 2),
		('Porsche Panamera', 8, NULL, 3);

SELECT c.id AS id, c.name AS car_name, cb.name AS body_name, ce.name AS engine_name,
ct.name AS transmission_name
FROM cars AS c
LEFT JOIN car_bodies AS cb ON c.body_id = cb.id 
LEFT JOIN car_engines AS ce ON c.engine_id = ce.id
LEFT JOIN car_transmissions AS ct ON c.transmission_id = ct.id;

SELECT cb.name
FROM car_bodies AS cb
LEFT JOIN cars AS c ON cb.id = c.body_id 
WHERE c.name IS NULL;

SELECT ce.name
FROM car_engines AS ce
LEFT JOIN cars AS c ON ce.id = c.engine_id 
WHERE c.name IS NULL;

SELECT ct.name
FROM car_transmissions AS ct
LEFT JOIN cars AS c ON ct.id = c.transmission_id 
WHERE c.name IS NULL