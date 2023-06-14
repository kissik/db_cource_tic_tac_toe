CREATE SEQUENCE global_sequence;

ALTER TABLE ACCOUNT ALTER COLUMN id SET DEFAULT nextval('global_sequence');
ALTER TABLE GAME ALTER COLUMN id SET DEFAULT nextval('global_sequence');
