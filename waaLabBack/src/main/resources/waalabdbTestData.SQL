INSERT INTO users (id, name, email, password, firstname, lastname) VALUES (1, 'John Doe', 'john@example.com', 'password123', 'John', 'Doe');
INSERT INTO users (id, name, email, password, firstname, lastname) VALUES (2, 'Jane Smith', 'jane@example.com', 'password123', 'Jane', 'Smith');

INSERT INTO role (id, role) VALUES (1, 'USER');
INSERT INTO role (id, role) VALUES (2, 'ADMIN');

-- Insert test data into the user_roles table
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1); -- Assign USER role to John Doe
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2); -- Assign ADMIN role to Jane Smith
-- Insert test data into the posts table
INSERT INTO post (id, title, content, author, id_user) VALUES (1, 'Post 1', 'This is the content of post 1', 'John Doe', 1);
INSERT INTO post(id, title, content, author, id_user) VALUES (2, 'Post 2', 'This is the content of post 2', 'Jane Smith', 2);

-- Insert test data into the comments table
INSERT INTO comment (id, name, post_id) VALUES (1, 'This is a comment for post 1', 1);
INSERT INTO comment (id, name, post_id) VALUES (2, 'This is another comment for post 1', 1);
INSERT INTO comment (id, name, post_id) VALUES (3, 'This is a comment for post 2', 2);