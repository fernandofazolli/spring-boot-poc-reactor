CREATE KEYSPACE sample
WITH durable_writes = true
AND replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
};

CREATE TABLE IF NOT EXISTS  sample.entity_table (
    id UUID,
    payload varchar,
    primary key((id))
);

select * from sample.entity_table;