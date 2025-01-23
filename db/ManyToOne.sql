create table homes(
	id serial primary key,
	name varchar(255),
	adress text
);

create table apartments(
	id serial primary key,
	number int,
	floor int,
	area float8,
	rooms int,
	homes_id int references homes(id)
);

insert into homes (name, adress) values ('West river 5', 'West river street, building 5');
insert into apartments (number, floor, area, rooms, homes_id) values (1, 2, 80.00, 2, 1);
insert into apartments (number, floor, area, rooms, homes_id) values (2, 2, 100.00, 3, 1);
insert into apartments (number, floor, area, rooms, homes_id) values (3, 2, 105.00, 3, 1);

select * from apartments






