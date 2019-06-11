create table body(
 id serial primary key,
 type text);
create table engine(
 id serial primary key,
 type text);
create table gearbox(
 id serial primary key,
 type text);
create table auto(
	brend text primary key,
	auto_gearbox_id integer NOT NULL references gearbox(id),
	auto_body_id integer NOT NULL references body(id)),
	auto_engine_id integer NOT NULL references engine(id));
insert into engine(type)(
	values('mechanic'),('robot'),('auto');
insert into gearbox(type)(
	values('disel'),('gasoline'),('electronic'),('hydrid'));
insert into body(type)(
	values('universails'),('hatcback'),('sedan'),('minivan'),('cabrio'));
insert into auto(
	values('bmw',1,1,1),
	('toyota',2,2,2));
select * from gearbox
	where (select auto_gearbox_id from auto where auto.brend = 'bmw')!=gearbox.id;
select * from engine
	where (select auto_engine_id from auto where auto.brend = 'bmw')!=engine.id;
select * from body
	where (select auto_body_id from auto where auto.brend = 'bmw')!=body.id;