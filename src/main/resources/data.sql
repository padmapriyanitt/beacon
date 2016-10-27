CREATE TABLE if not exists clusters (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(30),
  description  VARCHAR(200),
  colo VARCHAR(30),
  name_node_uri VARCHAR(100),
  execute_uri VARCHAR(100),
  wf_engine_uri VARCHAR(100),
  messaging_uri VARCHAR(100),
  hs2_uri VARCHAR(100),
  tags VARCHAR(100),
  custom_properties VARCHAR(100),
  acl VARCHAR(100)
);

create table if not exists policies (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  	name VARCHAR(30),
  	dataset varchar(200),
  	source_cluster VARCHAR(30),
  	target_cluster VARCHAR(30),
  	frequency_in_sec bigint,
  	status VARCHAR(30),
  	tags VARCHAR(100),
  	type VARCHAR(100),
  	component VARCHAR(30),
  	acl_owner VARCHAR(30),
  	acl_group VARCHAR(30),
  	acl_permission VARCHAR(30),
  	retry_attempts int,
  	queue varchar(30),
  	max_events int
);	

create table if not exists instances (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	name VARCHAR(30),
	last_run long,
	policy_id bigint,
	progress int,
	start_time TIMESTAMP,
	status VARCHAR(30)
);

CREATE TABLE if not exists peers (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	source_id BIGINT,
	target_id BIGINT

);

CREATE TABLE if not exists configuration (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	name VARCHAR(100),
	val VARCHAR(100)
);
--insert into configuration (name,val) values ('source_cluster','');