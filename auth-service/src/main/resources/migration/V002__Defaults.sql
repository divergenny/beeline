insert into users (username, first_name, last_name, email, password)
values('admin', 'Иван', 'Иванов', 'admin@gmail.ru', '$2a$10$QewUvIJ2k0lzE.Qh2awTIeAamTrvWntntm5pFlBG63RZDkQMA67Sa');


insert into roles
("name")
values('USER'), ('ADMIN');


insert into user_roles (user_id, role_id)
select u.id, r.id from users u, roles r where username = 'admin';
