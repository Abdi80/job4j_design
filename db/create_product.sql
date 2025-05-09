CREATE TABLE type(
	id 	SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE product(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	type_id INT REFERENCES type(id),
	expired_date DATE,
	price DECIMAL(8, 2)
);

INSERT INTO type(name) VALUES('СЫР'), ('МОЛОКО'), ('МОРОЖЕНОЕ'), ('СОК'), ('ШОКОЛАД');

INSERT INTO product(name, type_id, expired_date, price) 
VALUES('Сыр плавленный', 1, '2025-03-15', 900.00),
('Сыр моцарелла', 1, '2025-02-15', 1500.00),
('Голандский', 1, '2025-05-01', 3000.00),
('Деревенское', 2, '2025-02-17', 600.00),
('Хорошее', 2, '2025-03-17', 650.00),
('Бабушкино', 2, '2025-06-01', 700.00),
('Родина', 2, '2025-02-15', 660.00),
('Луг', 2, '2025-01-15', 665.00),
('Умка', 3, '2025-04-01', 290.00),
('Мягкое мороженое', 3, '2025-02-01', 500.00),
('Мороженое север', 3, '2025-02-01', 360.00),
('Снежок', 3, '2025-03-01', 250.00),
('Вкусный сок', 4, '2025-03-01', 800.00),
('Наш сад', 4, '2025-04-01', 700.00),
('Сок южный', 4, '2025-02-01', 600.00),
('Лучший', 4, '2025-06-01', 1200.00),
('Экзотик', 5, '2025-03-01', 3000.00),
('Шоколад 50%', 5, '2025-07-02', 800.00),
('Шоколад 70%', 5, '2025-06-09', 900.00),
('Шоколад 90%', 5, '2025-07-20', 1200.00),
('Шоколад №5', 5, '2025-07-15', 1205.00),
('Шоколад №6', 5, '2025-07-16', 1210.00),
('Шоколад №7', 5, '2025-07-17', 1215.00),
('Шоколад №8', 5, '2025-07-18', 1220.00),
('Шоколад №9', 5, '2025-07-19', 1225.00),
('Шоколад №10', 5, '2025-07-20', 1230.00),
('Шоколад №11', 5, '2025-07-20', 1235.00)


