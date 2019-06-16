create DATABASE mydb;

create table Rules (
	pk_id integer primary key,
	rightsDescription character varying (50),
	adding boolean,
	commenting boolean,
	attachingFiles boolean,
	stateVeiw boolean,
	updateOrdter boolean,
	deleteOrder boolean
);


create table roleInSystem (
	pk_id integer primary key,
	fk_id_roleRights integer references Rules(pk_id),
	typeOfRole character varying (30)
);

create table category (
	pk_id integer primary key,
	categoryName character varying (20)
);

create table states (
	pk_id integer primary key,
	stateName character varying (20)
);

create table items (
	pk_id integer primary key,
	fk_id_state integer references states(pk_id),
	fk_id_category integer references category(pk_id),
	itemName character varying (50),
	description character varying (200)
);


create table users (
	pk_id integer primary key,
	fk_id_roleInSystem integer references roleInSystem(pk_id),
	fk_id_items integer references items(pk_id),
	userLogin character varying (30),
	userPassword character varying (30)
);




create table attachedFiles (
	pk_id integer primary key,
	fk_id_orders integer references items(pk_id),
	filesPath text
);

create table comments (
	pk_id integer primary key,
	fk_id_orders integer references items(pk_id),
	description text
);