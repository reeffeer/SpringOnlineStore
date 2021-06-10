INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (username, password, email)
VALUES ('brook', '$2y$12$yr/ufWL6JQClwu.8vlcGuuIAkRODMOkIupVUzzRMqQvBqpUgn3xA2', 'br@gmail.com'),
       ('brook1', '$2y$12$yr/ufWL6LQClwu.8vlcFyuIAkAIVMOkIupVUzzRMqQvBqpUgn4xH7', 'bro@gmail.com');

INSERT INTO users_roles (user_id, role_id)
VALUES (1,1),
       (2,2);

INSERT INTO products (title, price)
VALUES ('Dark Hammer', 1500),
       ('Shadow Cloak', 7200.5),
       ('Dragon Leather Boots', 15000),
       ('Heaven Helmet', 12700);
INSERT INTO categories (title, description)
VALUES ('weapon', 'all kinds of axes, swords, spears, bows, etc.'),
       ('outfit', 'shoes, clothes, belts, bags, etc.'),
       ('armor', 'different kinds of armor'),
       ('accessories', 'different magic and non-magic things and ingredients, amulets');







