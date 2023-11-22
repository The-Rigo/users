---create user_rol table
create table user_rol(
                         id integer not null,
                         active boolean not null,
                         created_at timestamp not null,
                         user_id bigint,
                         rol_id integer,
                         primary key (id)
);

create sequence user_rol_sequence as integer increment 1;

alter table user_rol add constraint FK_user_rol_RefUser foreign key (user_id)
    references users (id) on delete restrict on update restrict;

alter table user_rol add constraint FK_user_rol_RefRol foreign key (rol_id)
    references rol (id) on delete restrict on update restrict;

---create user_detail
create table user_detail(
                            id bigint not null,
                            first_name varchar(100),
                            last_name varchar(100),
                            age integer,
                            birth_day date,
                            user_id bigint,
                            primary key (id)
);

create sequence user_detail_sequence as integer increment 1;

alter table user_detail add constraint FK_UserDetail_RefUser foreign key (user_id)
    references users (id) on delete restrict on update restrict;