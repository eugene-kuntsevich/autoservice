INSERT INTO car (car_number, warranty_date) VALUES ("1234 AB-7",  NOW());
INSERT INTO car (car_number, warranty_date) VALUES ("5678 KK-3",  DATE_ADD(NOW(), INTERVAL 30 DAY));
INSERT INTO car (car_number, warranty_date) VALUES ("2222 IK-4",  '2020-11-22 10:40:00');

INSERT INTO client (email, first_name, second_name) VALUES ('Ivanov@gmail.com',  'Ivan', 'Ivanov');
INSERT INTO client (email, first_name, second_name) VALUES ('Antonov@gmail.com',  'Anton', 'Antonov');
INSERT INTO client (email, first_name, second_name) VALUES ('Petrov@gmail.com',  'Petr', 'Petrov');

INSERT INTO master (first_name, second_name) VALUES ('Semen', 'Semenov');
INSERT INTO master (first_name, second_name) VALUES ('Nikolay', 'Nikolaev');
INSERT INTO master (first_name, second_name) VALUES ('Konstantin', 'Konstantinov');

INSERT INTO order_status (id, name) VALUES (1, 'Awaiting the start of maintenance');
INSERT INTO order_status (id, name) VALUES (2, 'In the process of maintenance');
INSERT INTO order_status (id, name) VALUES (3, 'Maintenance suspended');
INSERT INTO order_status (id, name) VALUES (4, 'Maintenance completed');
INSERT INTO order_status (id, name) VALUES (5, 'Vehicle handed over to the owner');
INSERT INTO order_status (id, name) VALUES (6, 'The status that I came up with');

