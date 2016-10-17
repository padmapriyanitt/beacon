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
  	sourceCluster VARCHAR(30),
  	targetCluster VARCHAR(30),
  	frequencyInSec bigint,
  	tags VARCHAR(100),
  	component VARCHAR(30),
  	aclOwner VARCHAR(30),
  	aclGroup VARCHAR(30),
  	aclPermission VARCHAR(30),
  	retryAttempts int,
  	queue varchar(30),
  	maxEvents int
);	


CREATE TABLE if not exists peers (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	source_id BIGINT,
	target_id BIGINT

);

CREATE TABLE if not exists beacon (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	source_cluster VARCHAR(100)
);
insert into beacon (source_cluster) values ('');