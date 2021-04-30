CREATE DATABASE spring_armor_store;

create table users (
    id                  bigserial primary key,
    username            varchar(30) not null unique,
    password            varchar(30) not null unique,
    email               varchar(50) unique,
    first_name          varchar(30) not null,
    last_name           varchar(50) not null,
    phone_number        varchar(30) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

create table roles (
    id                  bigserial primary key,
    name                varchar(50) not null unique,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

create table users_roles (
    user_id             bigint not null references users (id),
    role_id             bigint not null references roles (id),
    primary key (user_id, role_id)
);

create table products (
    id                  bigserial primary key,
    title               varchar(250) not null,
    price               numeric(6,1) not null,
    description         varchar(3000),
    create_at           timestamp default current_timestamp,
    update_at           timestamp default current_timestamp
);

create table categories (
    id                  bigserial primary key,
    title               varchar(250) not null unique,
    description         varchar(1000)
);

create table products_categories (
    product_id          bigserial,
    category_id         bigserial,
    foreign key (product_id) references products (id),
    foreign key (category_id) references categories (id)
);

create table orders (
    id                  bigserial primary key,
    customer_id         bigserial references users (id),
    price               numeric(7,1),
    address             varchar(250),
    create_at           timestamp default current_timestamp,
    update_at           timestamp default current_timestamp
);

create table order_items (
    id                  bigserial primary key,
    order_id            bigserial references orders (id),
    product_id          bigserial references products (id),
    title               varchar(250),
    quantity            int,
    product_price       numeric (10, 1),
    price               numeric (10, 1),
    create_at           timestamp default current_timestamp,
    update_at           timestamp default current_timestamp
);

CREATE TABLE carts (
    id                  uuid primary key,
    customer_id         bigserial references users (id),
    total_price         numeric (10, 1)
);

create table cart_items (
    id                  bigserial primary key,
    cart_id             bigserial references carts (id),
    product_id          bigserial references products (id),
    title               varchar(250),
    quantity            int,
    product_price       numeric (10, 1),
    price               numeric (10, 1),
    create_at           timestamp default current_timestamp,
    update_at           timestamp default current_timestamp
);
