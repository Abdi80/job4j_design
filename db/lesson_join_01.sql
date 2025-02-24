CREATE TABLE departments(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE employees(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	departments_id INT REFERENCES departments(id)
);

INSERT INTO departments(name)
VALUES('Производственный отдел'),
		('Отдел продаж'),
		('Бухгалтерия'),
		('Юридический отдел');

INSERT INTO departments(name)
VALUES('Отдел кадров');		

		
INSERT INTO employees(name, departments_id)
VALUES('Boris' , 1),
		('Petr', 1),
		('Vlad', 1),
		('Masha', 2),
		('Stas', 2),
		('Inna', 3),
		('Katy', 3),
		('Oksana', NULL);

SELECT d.name 
FROM departments AS d
LEFT JOIN employees AS e ON d.id = e.departments_id
WHERE departments_id IS NULL;

SELECT d.name, e.name
FROM departments AS d
LEFT JOIN employees AS e ON d.id = e.departments_id
ORDER BY 1, 2;

SELECT d.name, e.name
FROM employees AS e 
RIGHT JOIN departments AS d ON d.id = e.departments_id
ORDER BY 1, 2;

SELECT d.name, e.name
FROM departments AS d
FULL JOIN employees AS e ON d.id = e.departments_id;

SELECT d.name, e.name
FROM departments AS d
CROSS JOIN employees AS e;