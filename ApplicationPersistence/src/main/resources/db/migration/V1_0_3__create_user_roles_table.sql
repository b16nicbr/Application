CREATE TABLE USER_ROLES(
role_id int NOT NULL,
user_id int NOT NULL,
PRIMARY KEY (role_id, user_id)
);