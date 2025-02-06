insert into fauna(name, avg_age, discovery_date) values('aqq', 5, '1910-01-30');
insert into fauna(name, avg_age, discovery_date) values('skk', 30, '1679-01-25');
insert into fauna(name, avg_age, discovery_date) values('dii', 7, '1950-07-19');
insert into fauna(name, avg_age, discovery_date) values('fishfxx', 9, '1745-02-01');
insert into fauna(name, avg_age, discovery_date) values('gbb', 60, '1810-01-01');
insert into fauna(name, avg_age, discovery_date) values('hzz', 22, '1790-01-30');
insert into fauna(name, avg_age, discovery_date) values('jeefish', 14, '1990-01-30');
insert into fauna(name, avg_age) values('kpp', 51);
insert into fauna(name, avg_age) values('lvv', 31);
insert into fauna(name, avg_age, discovery_date) values('zgg', 28, '1190-01-01');

select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10 and avg_age <= 20;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950'