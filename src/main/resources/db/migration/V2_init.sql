INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (username, password, email)
VALUES ('brook', '$2y$12$yr/ufWL6JQClwu.8vlcGuuIAkRODMOkIupVUzzRMqQvBqpUgn3xA2', 'br@mail.ru'),
       ('brook', '$2y$12$yr/ufWL6LQClwu.8vlcFyuIAkAIVMOkIupVUzzRMqQvBqpUgn4xH7', 'br@mail.ru');

INSERT INTO users_roles (user_id, role_id)
VALUES (1,1),
       (2,2);

INSERT INTO products (title, price)
VALUES ('Dark Hammer', 1500, 'the heavy and mighty weapon'),
       ('Shadow Cloak', 7200.5, 'the cloak was made in the shadow lands by misty spirits'),
       ('Dragon Leather Boots', 15000, 'the great armor for your feet'),
       ('Heaven Helmet', 12700, 'no one knows who made this helmet');
INSERT INTO categories (title, description)
VALUES ('weapon', 'all kinds of axes, swords, spears, bows, etc.'),
       ('outfit', 'shoes, clothes, belts, bags, etc.'),
       ('armor', 'different kinds of armor'),
       ('accessories', 'different magic and non-magic things and ingredients, amulets');







