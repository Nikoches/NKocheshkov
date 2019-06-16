create table engine(
 id text primary key,power integer,
 valve integer);
create table body(
 id text primary key,
 type text);
create table transmission(id text primary key,
gears integer);
create table auto(
 brend text primary key,
 auto_trns_id text NOT NULL references transmission(id),
 auto_eng_id text NOT NULL references engine(id),
 auto_body_id text NOT NULL references body(id));
 
 insert into engine
 values('W2',6),
 ('W4',8),
 ('W6',12);

insert into transmission
	values('D1',4),
 ('D2',5),
 ('D3',6),
 ('D4',7);
 
insert into body
	values('WAG','hatchback'),
 ('GM','universails'),
 ('toyota','sedan');
 
 insert into auto
	values('mercedes','D1','W2','WAG');
	
insert into auto
	values('ford','D2','W4','GM');
	
 insert into auto
	values('toyota','D3','W6','toyota');
	
	select auto.brend,transmission.id,transmission.gears,engine.id,engine.valve,body.id,body.type from auto
 join body on auto_body_id = body.id
 join engine on auto_eng_id = engine.id
 join transmission on auto_trns_id = transmission.id;
 
 
 select transmission.id,transmission.gears,engine.id,engine.valve,body.id,body.type from body,transmission,engine
	where (select auto_trns_id from auto where auto.brend = 'mercedes')!=transmission.id and (select auto_eng_id from auto where auto.brend = 'mercedes')!=engine.id and (select auto_body_id from auto where auto.brend = 'mercedes')!=body.id;
	
	select t.id, t.gears from transmission as t
left join  auto a on a.auto_trns_id = t.id
where a.brend is null;