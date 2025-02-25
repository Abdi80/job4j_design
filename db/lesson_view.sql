CREATE TABLE student(
	student_id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE author(
	author_id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE book(
	book_id SERIAL PRIMARY KEY,
	name VARCHAR(200),
	author_id INT REFERENCES author(author_id)
);

CREATE TABLE orders(
	id SERIAL PRIMARY KEY,
	active BOOLEAN DEFAULT TRUE,
	book_id INT REFERENCES book(book_id),
	student_id INT REFERENCES student(student_id)
);

INSERT INTO student(name)
VALUES('Petr'),
		('Masha'),
		('Ivan'),
		('Varya');

INSERT INTO author(name)
VALUES('Александр Пушкин'),
		('Николай Гоголь'),
		('Михаил Шолохов'),
		('Исаак Бабель');

INSERT INTO book(name, author_id)
VALUES('Евгений Онегин', 1),
		('Капитанская дочка', 1),
		('Дубровский', 1),
		('Мертвые души', 2),
		('Вий', 2),
		('Тихий Дон', 3),
		('Судьба человека', 3),
		('Поднятая целина', 3),
		('Конармия', 4),
		('Беня Крик', 4),
		('Одесские рассказы', 4);

INSERT INTO orders(book_id, student_id)
VALUES(1, 1),
		(3, 1),
		(5, 2),
		(4, 1),
		(2, 2),
		(10, 3),
		(9, 4),
		(8, 4),
		(2, 4);

CREATE VIEW show_students_with_3_or_more_authors
AS
SELECT s.name AS student, a.name AS author
FROM author AS a
JOIN book AS b USING(author_id)
JOIN orders AS o USING(book_id)
JOIN student AS s USING(student_id)
WHERE student_id IN (SELECT student_id
						FROM orders
						JOIN book USING(book_id)
						GROUP BY student_id
						HAVING COUNT (DISTINCT author_id) >= 3);

SELECT * FROM show_students_with_3_or_more_authors 						
		