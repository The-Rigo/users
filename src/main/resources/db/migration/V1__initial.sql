---create rol table
create table rol (
                     id integer not null,
                     name varchar(100) not null,
                     primary key (id)
);
create sequence rol_sequence as integer increment 1;

---create user table
create table users(
                      id bigint not null,
                      username varchar(150) not null,
                      password varchar(150) not null,
                      email varchar(150) not null,
                      created_at timestamp,
                      primary key (id)
);
create sequence users_sequence as integer increment 1;