delete from `USER_ROLES`;
delete from `ROLE`;
delete from `USER`;

INSERT INTO `USER` (`ID`, `USER_NAME`, `PASSWORD`, `DATE`, ACTIVE)
VALUES
	(1,'admin','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',1),
	(2,'emingora','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',1),
	(3,'nonactiveuser','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',0);

INSERT INTO `ROLE` (`ID`, `ROLE_NAME`)
VALUES
	(1,'ROLE_ADMIN'),
	(2,'ROLE_USER');

INSERT INTO `USER_ROLES` (`USERS_ID`, `ROLES_ID`)
VALUES
	(1,1),
	(1,2),
	(2,2),
	(3,2);

-- Menu
INSERT INTO `MENU` (`ID`, `DESCRIPTION`, `APP_ORDER`, `ACTIVE`, `URL`)
VALUES
	(1,'Home',0, 1, '/'),
	(2,'Tasks',1, 1, '/tasks'),
	(3,'Admin',100, 1, '/admin');

INSERT INTO `MENU_ROLES` (`MENU_ID`, `ROLES_ID`)
VALUES
	(1,1),
	(1,2),
	(2,1),
	(2,2),
	(3,1);

-- Tasks
INSERT INTO `TASK` (`ID`, `USER_ID`, `STARTING_DATE`, `ENDING_DATE`, `NAME`)
VALUES
    (1, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 1'),
    (2, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 2'),
    (3, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 3'),
    (4, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 4'),
    (5, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 5'),
    (6, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 6'),
    (7, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 7'),
    (8, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 8'),
    (9, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 9'),
    (10, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 10'),
    (11, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 11'),
    (12, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 12'),
    (13, 2, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'TASK 13'),
    (14, 1, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'ADMIN TASK 1'),
    (15, 1, '2022-05-08T07:00:00', '2022-05-08T07:00:00', 'ADMIN TASK 2');
