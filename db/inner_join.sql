CREATE TABLE father(
	id SERIAL PRIMARY KEY,
	name VARCHAR(100)
);

CREATE TABLE childe(
	id SERIAL PRIMARY KEY,
	name VARCHAR(100),
	age INT,
	father_id INT REFERENCES father(id)
);

INSERT INTO father(name) VALUES('Petr');
INSERT INTO father(name) VALUES('Bob');

INSERT INTO childe(name, age, father_id) VALUES('Fil', 5, 1); 
INSERT INTO childe(name, age, father_id) VALUES('Mary', 8, 1);
INSERT INTO childe(name, age, father_id) VALUES('Ann', 9, 1);
INSERT INTO childe(name, age, father_id) VALUES('Phil', 2, 2);
INSERT INTO childe(name, age, father_id) VALUES('Mike', 5, 2);

SELECT f.name, c.name FROM childe AS c INNER
JOIN father AS f ON c.father_id = f.id;

SELECT f.name AS отец, c.name AS ребенок, c.age AS возраст FROM childe AS c
JOIN father AS f ON c.father_id = f.id; 

SELECT f.name "Отец", c.name "Ребенок", c.age "Возраст" FROM childe c
JOIN father f ON c.father_id = f.id
