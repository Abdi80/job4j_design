create table passport(
	id serial primary key,
	seria int,
	number int
);

insert into passport(seria, number) values (300, 123456789);
insert into passport(seria, number) values (300, 987654321);

create table owners(
	id serial primary key,
	name varchar(255),
	passport_id int references passport(id) unique
);

insert into owners (name, passport_id) values ('Alex', 1); 
insert into owners (name, passport_id) values ('Bob', 2);

select * from owners