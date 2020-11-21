drop database walmartdb;
drop user walmart;
drop sequence user_seq;
create user walmart with password 'walmart@123';
create database walmartdb  with template=template0 owner=walmart;
\connect walmartdb;
alter default privileges grant all on tables to walmart;
alter default privileges grant all on sequences to walmart;

create table orgs_enabled(
    org_id integer primary key not null,
    org_name varchar(30) not null,
    is_enabled boolean not null default true
);

create table users (
    user_id UUID primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(30) not null,
    password text not null,
    org_id integer not null
);

alter table users add constraint org_id_fk foreign key (org_id) references orgs_enabled(org_id);

create sequence user_seq increment 1 start 1;
create sequence org_id increment 1 start 1;