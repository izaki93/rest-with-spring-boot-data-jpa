CREATE TABLE IF NOT EXISTS student(
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  first_name VARCHAR(32) NOT NULL,
  last_name VARCHAR(32) NULL,
  email VARCHAR(32) NULL,
  created TIMESTAMP NULL,
  modified TIMESTAMP NULL
);
