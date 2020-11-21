\connect walmartdb;


create table orgs_enabled(
    org_id integer primary key not null,
    org_name varchar(30) not null,
    is_enabled boolean not null default true
);

create table users (
    user_id UUID primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20),
    email varchar(30) not null,
    password text not null,
    org_id integer not null
);

alter table users add constraint org_id_fk foreign key (org_id) references orgs_enabled(org_id);
create sequence org_id_seq increment 1 start 1;