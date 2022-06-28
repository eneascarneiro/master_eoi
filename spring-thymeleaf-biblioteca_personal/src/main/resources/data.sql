delete from `USER_ROLES`;
delete from `ROLE`;
delete from `USER`;

INSERT INTO `USER` (`ID`, `USER_NAME`, `PASSWORD`, `DATE`, ACTIVE)
VALUES
	(1,'admin','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',1),
	(2,'emingora','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',1),
	(3,'nonactiveuser','$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2','2022-05-08',0);
INSERT INTO `USER` (`ID`,ACTIVE ,`DATE`, `PASSWORD`,   `USER_NAME`)
VALUES
    (4,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'jma'),
    (5,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'pepe'),
    (6,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'enrique'),
    (7,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'olga'),
    (8,1,'2022-03-01', '$2a$04$5sT3dri6bOOG2b9P1LETEujUeYMR46G/OVybuBjxBAohlEtDsxmi2', 'luisa');

INSERT INTO `ROLE` (`ID`, `ROLE_NAME`)
VALUES
	(1,'ROLE_ADMIN'),
	(2,'ROLE_USER');

INSERT INTO `USER_ROLES` (`USERS_ID`, `ROLES_ID`)
VALUES
	(1,1),
	(1,2),
	(2,2),
	(3,2),
    (4,2),
    (5,2),
    (6,2),
    (7,2),
    (8,2);


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


INSERT INTO `books`
(`id`,
`book_title`)
VALUES

(1,'Mi libro numero  1'   ),
(2,'Mi libro numero  2'   ),
(3,'Mi libro numero  3'   ),
(4,'Mi libro numero  4'   ),
(5,'Mi libro numero  5'   ),
(6,'Mi libro numero  6'   ),
(7,'Mi libro numero  7'   ),
(8,'Mi libro numero  8'   ),
(9,'Mi libro numero  9'   ),
(10,'Mi libro numero 10'  ),
(11,'Mi libro numero 11'  ),
(12,'Mi libro numero 12'  ),
(13,'Mi libro numero 13'  ),
(14,'Mi libro numero 14'  ),
(15,'Mi libro numero 15'  ),
(16,'Mi libro numero 16'  ),
(17,'Mi libro numero 17'  ),
(18,'Mi libro numero 18'  ),
(19,'Mi libro numero 19'  ),
(20,'Mi libro numero 20'  ),
(21,'Mi libro numero 21'  ),
(22,'Mi libro numero 22'  ),
(23,'Mi libro numero 23'  ),
(24,'Mi libro numero 24'  ),
(25,'Mi libro numero 25'  ),
(26,'Mi libro numero 26'  ),
(27,'Mi libro numero 27'  ),
(28,'Mi libro numero 28'  ),
(29,'Mi libro numero 29'  ),
(30,'Mi libro numero 30'  ),
(31,'Mi libro numero 31'  ),
(32,'Mi libro numero 32'  ),
(33,'Mi libro numero 33'  ),
(34,'Mi libro numero 34'  ),
(35,'Mi libro numero 35'  ),
(36,'Mi libro numero 36'  ),
(37,'Mi libro numero 37'  ),
(38,'Mi libro numero 38'  ),
(39,'Mi libro numero 39'  ),
(40,'Mi libro numero 40'  );



INSERT INTO `books_read` (`id`,`books_id`,`user_id`,`fecha_lectura`) VALUES
(1     ,1  ,1,'2022-05-23'),
(2     ,2  ,1,'2022-05-23'),
(3     ,3  ,1,'2022-05-23'),
(4     ,4  ,1,'2022-05-23'),
(5     ,5  ,1,'2022-05-23'),
(6     ,6  ,1,'2022-05-23'),
(7     ,7  ,1,'2022-05-23'),
(8     ,8  ,1,'2022-05-23'),
(9     ,9  ,1,'2022-05-23'),
(10    ,10 ,1,'2022-05-23'),
(11    ,11 ,1,'2022-05-23'),
(12    ,12 ,1,'2022-05-23'),
(13    ,13 ,1,'2022-05-23'),
(14    ,14 ,1,'2022-05-23'),
(15    ,15 ,1,'2022-05-23'),
(16    ,16 ,2,'2022-05-23'),
(17    ,17 ,2,'2022-05-23'),
(18    ,18 ,2,'2022-05-23'),
(19    ,19 ,2,'2022-05-23'),
(20    ,20 ,2,'2022-05-23'),
(21    ,21 ,2,'2022-05-23'),
(22    ,22 ,2,'2022-05-23'),
(23    ,23 ,2,'2022-05-23'),
(24    ,24 ,2,'2022-05-23'),
(25    ,25 ,3,'2022-05-23'),
(26    ,26 ,3,'2022-05-23'),
(27    ,27 ,3,'2022-05-23'),
(28    ,28 ,3,'2022-05-23'),
(29    ,29 ,3,'2022-05-23'),
(30    ,30 ,3,'2022-05-23'),
(31    ,31 ,3,'2022-05-23'),
(32    ,32 ,3,'2022-05-23'),
(33    ,33 ,3,'2022-05-23'),
(34    ,34 ,4,'2022-05-23'),
(35    ,35 ,4,'2022-05-23'),
(36    ,36 ,4,'2022-05-23'),
(37    ,37 ,4,'2022-05-23'),
(38    ,38 ,4,'2022-05-23'),
(39    ,39 ,4,'2022-05-23'),
(40    ,40 ,4,'2022-05-23')
