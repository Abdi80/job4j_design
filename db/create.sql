CREATE TABLE roles(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE rules(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE categories(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE states(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE users(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	roles_id INT REFERENCES roles(id)
);

CREATE TABLE items(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	users_id INT REFERENCES users(id),
	categories_id INT REFERENCES categories(id),
	states_id INT REFERENCES states(id)
);

CREATE TABLE comments(
	id SERIAL PRIMARY KEY,
	comment TEXT,
	items_id INT REFERENCES items(id)
);

CREATE TABLE attachs(
	id SERIAL PRIMARY KEY,
	path VARCHAR(255),
	items_id INT REFERENCES items(id)
);

CREATE TABLE roles_rules(
	id SERIAL PRIMARY KEY,
	roles_id INT REFERENCES roles(id),
	rules_id INT REFERENCES rules(id)
)