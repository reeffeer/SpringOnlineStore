insert into roles (name)
values
('ROLE_USER'),
('ROLE_ADMIN');

insert into users (username, password, email)
values
('user1', '$2y$12$yr/ojWL6JQCpku.5vlcGuuIAkROTMOkIupVUzzRMqQvBqpUgn4xA2', 'user1@gmail.com'),
('user2', '$2y$12$yr/ojWL6JQCpku.5vlcGuuIAkROTMOkIupVUzzRMqQvBqpUgn4xA2', 'user2@gmail.com');

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 2);

insert into products (title, price)
values
('Mystery Island', 300),
('National Geography', 120),
('Anatomy for artists', 900);

insert into categories (title, description)
values
('magazines', 'different journals'),
('fiction', 'different genres'),
('educational books', 'different teaching literature'),
('english books', 'different books in english');
