drop table tb_poi if exists
create table tb_poi (
	id integer generated by default as identity (start with 1), 
	name varchar(100), 
	x integer, 
	y integer,
	primary key(id));