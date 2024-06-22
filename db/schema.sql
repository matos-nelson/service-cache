create table if not exists book (
  id BIGSERIAL PRIMARY KEY,
  name varchar(150),
  author varchar(100)
)
