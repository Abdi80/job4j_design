CREATE TABLE devices(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	price FLOAT
);

CREATE TABLE people(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE devices_people(
	id SERIAL PRIMARY KEY,
	device_id INT REFERENCES devices(id),
	people_id INT REFERENCES people(id)
);

INSERT INTO devices(name, price) VALUES('phone', 2000.00);
INSERT INTO devices(name, price) VALUES('PC', 10000.00);
INSERT INTO devices(name, price) VALUES('laptop', 4000.00);

INSERT INTO people(name) VALUES('Petr');
INSERT INTO people(name) VALUES('Ann');
INSERT INTO people(name) VALUES('Mike');

INSERT INTO devices_people(device_id, people_id) VALUES(1, 1);
INSERT INTO devices_people(device_id, people_id) VALUES(1, 2);
INSERT INTO devices_people(device_id, people_id) VALUES(1, 3);
INSERT INTO devices_people(device_id, people_id) VALUES(2, 1);
INSERT INTO devices_people(device_id, people_id) VALUES(3, 2);
INSERT INTO devices_people(device_id, people_id) VALUES(3, 3);
INSERT INTO devices_people(device_id, people_id) VALUES(3, 1);

SELECT AVG(price) AS average_price
FROM devices;

SELECT p.name, AVG(d.price) AS average_price
FROM devices_people AS dp
JOIN people AS p ON dp.people_id = p.id
JOIN devices AS d ON dp.device_id = d.id 
GROUP BY p.name;

SELECT p.name, AVG(d.price) AS average_price
FROM devices_people AS dp
JOIN people AS p ON dp.people_id = p.id
JOIN devices AS d ON dp.device_id = d.id 
GROUP BY p.name
HAVING AVG(d.price) > 5000

