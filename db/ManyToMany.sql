create table owners(
	id serial primary key,
	name varchar(255),
	passport_id int references passport(id) unique
);

insert into owners (name, passport_id) values ('Alex', 1); 
insert into owners (name, passport_id) values ('Bob', 2);

create table owners_apartments(
	id serial primary key,
	owners_id int references owners(id),
	apartments_id int references apartments(id)
);

insert into owners_apartments (owners_id, apartments_id) values (1, 1);
insert into owners_apartments (owners_id, apartments_id) values (1, 2);
insert into owners_apartments (owners_id, apartments_id) values (1, 3);
insert into owners_apartments (owners_id, apartments_id) values (2, 2);
insert into owners_apartments (owners_id, apartments_id) values (2, 3);

select * from owners_apartments