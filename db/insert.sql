INSERT INTO roles (name) VALUES ('boss');
INSERT INTO roles (name) VALUES ('manager');
INSERT INTO roles (name) VALUES ('driver');
INSERT INTO rules (name) VALUES ('approve payments');
INSERT INTO rules (name) VALUES ('receive applications');
INSERT INTO rules (name) VALUES ('deliver');
INSERT INTO categories (name) VALUES ('urgent');
INSERT INTO categories (name) VALUES ('regular');
INSERT INTO states (name) VALUES ('waiting');
INSERT INTO states (name) VALUES ('at work');
INSERT INTO states (name) VALUES ('done');

INSERT INTO users (name, roles_id) VALUES ('Alex', 1);
INSERT INTO users (name, roles_id) VALUES ('Bob', 2);
INSERT INTO users (name, roles_id) VALUES ('Mike', 2);
INSERT INTO users (name, roles_id) VALUES ('Shon', 3);
INSERT INTO users (name, roles_id) VALUES ('Bil', 3);

INSERT INTO items (name, users_id, categories_id, states_id) VALUES ('oil', 2, 2, 1);
INSERT INTO items (name, users_id, categories_id, states_id) VALUES ('sugar', 2, 2, 1);
INSERT INTO items (name, users_id, categories_id, states_id) VALUES ('butter', 2, 2, 1);

INSERT INTO items (name, users_id, categories_id, states_id) VALUES ('fish', 2, 1, 2);

INSERT INTO items (name, users_id, categories_id, states_id) VALUES ('oil', 3, 2, 2);
INSERT INTO items (name, users_id, categories_id, states_id) VALUES ('sugar', 3, 2, 2);
INSERT INTO items (name, users_id, categories_id, states_id) VALUES ('flour', 3, 2, 2);

INSERT INTO comments (comment, items_id) VALUES ('before lunch', 4);
INSERT INTO comments (comment, items_id) VALUES ('not frozen', 4);

INSERT INTO attachs (path, items_id) VALUES ('C:\Users\Public\Documents', 4);

CREATE TABLE roles_rules(
	id SERIAL PRIMARY KEY,
	roles_id INT REFERENCES roles(id),
	rules_id INT REFERENCES rules(id)
);

INSERT INTO roles_rules (roles_id, rules_id) VALUES (1, 1);
INSERT INTO roles_rules (roles_id, rules_id) VALUES (1, 2);
INSERT INTO roles_rules (roles_id, rules_id) VALUES (1, 3);
INSERT INTO roles_rules (roles_id, rules_id) VALUES (2, 2);
INSERT INTO roles_rules (roles_id, rules_id) VALUES (2, 3);
INSERT INTO roles_rules (roles_id, rules_id) VALUES (3, 3);

