INSERT INTO car (car_number, warranty_date) VALUES ('1111 KK-4', '2020-11-22 10:40:00');
INSERT INTO car (car_number, warranty_date) VALUES ('2222 KK-4', NOW());
INSERT INTO car (car_number, warranty_date) VALUES ('3333 IK-4', NOW());
INSERT INTO car (car_number, warranty_date) VALUES ('4444 IK-4', NOW());
INSERT INTO car (car_number, warranty_date) VALUES ('5555 IK-4', NOW());
INSERT INTO car (car_number, warranty_date) VALUES ('6666 IK-4', NOW());
INSERT INTO car (car_number, warranty_date) VALUES ('7777 IK-4', NOW());

INSERT INTO client (email, first_name, second_name) VALUES ('Client1@gmail.com',  'ClientName1', 'ClientName1');
INSERT INTO client (email, first_name, second_name) VALUES ('Client2@gmail.com',  'ClientName2', 'ClientName2');
INSERT INTO client (email, first_name, second_name) VALUES ('Client3@gmail.com',  'ClientName3', 'ClientName3');
INSERT INTO client (email, first_name, second_name) VALUES ('Client4@gmail.com',  'ClientName4', 'ClientName4');
INSERT INTO client (email, first_name, second_name) VALUES ('Client5@gmail.com',  'ClientName5', 'ClientName5');
INSERT INTO client (email, first_name, second_name) VALUES ('Client6@gmail.com',  'ClientName6', 'ClientName6');
INSERT INTO client (email, first_name, second_name) VALUES ('Client7@gmail.com',  'ClientName7', 'ClientName7');

INSERT INTO master (first_name, second_name) VALUES ('MasterName1', 'MasterName1');
INSERT INTO master (first_name, second_name) VALUES ('MasterName2', 'MasterName2');
INSERT INTO master (first_name, second_name) VALUES ('MasterName3', 'MasterName3');
INSERT INTO master (first_name, second_name) VALUES ('MasterName4', 'MasterName4');
INSERT INTO master (first_name, second_name) VALUES ('MasterName5', 'MasterName5');
INSERT INTO master (first_name, second_name) VALUES ('MasterName6', 'MasterName6');
INSERT INTO master (first_name, second_name) VALUES ('MasterName7', 'MasterName7');

INSERT INTO order_status (id, name) VALUES (1, 'Awaiting the start of maintenance');
INSERT INTO order_status (id, name) VALUES (2, 'In the process of maintenance');
INSERT INTO order_status (id, name) VALUES (3, 'Maintenance suspended');
INSERT INTO order_status (id, name) VALUES (4, 'Maintenance completed');
INSERT INTO order_status (id, name) VALUES (5, 'Vehicle handed over to the owner');

INSERT INTO order (car_id, client_id, status_id) VALUES (1, 1, 1);
INSERT INTO order (car_id, client_id, status_id) VALUES (2, 2, 1);
INSERT INTO order (car_id, client_id, status_id) VALUES (3, 3, 1);
INSERT INTO order (car_id, client_id, status_id) VALUES (4, 4, 1);
INSERT INTO order (car_id, client_id, status_id) VALUES (5, 5, 1);
INSERT INTO order (car_id, client_id, status_id) VALUES (6, 6, 1);
INSERT INTO order (car_id, client_id, status_id) VALUES (7, 7, 1);




