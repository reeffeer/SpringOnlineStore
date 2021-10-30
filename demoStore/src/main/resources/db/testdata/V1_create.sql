create table users
(
    id              bigserial primary key,
    username        varchar(30) not null unique,
    password        varchar(50) not null,
    firebase_token  varchar(255) unique,
    status          int,
    email           varchar(50) unique,
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

create table roles
(
    id          bigserial primary key,
    name        varchar(50) not null unique,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table users_roles
(
    user_id     bigint not null references users (id),
    role_id     bigint not null references roles (id),
    primary key (user_id, role_id)
);

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       numeric(10, 2),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table categories
(
    id          bigserial primary key,
    title       varchar(255),
    description varchar(5000)
);

create table products_categories
(
    product_id  bigint,
    category_id bigint,
    foreign key (product_id) references products (id),
    foreign key (category_id) references categories (id)
);

create table orders
(
    id          bigserial primary key,
    owner_id    bigint references users (id),
    price       numeric(10, 2),
    address     varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table order_items
(
    id              bigserial primary key,
    order_id        bigint references orders (id),
    product_id      bigint references products (id),
    title           varchar(255),
    quantity        int,
    price_product   numeric(10, 2),
    price           numeric(10, 2),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table mail_verification_tokens (
                                          id                    bigserial,
                                          token                 varchar(255),
                                          user_id               bigint not null references users (id),
                                          expiry_date           timestamp default current_timestamp
);