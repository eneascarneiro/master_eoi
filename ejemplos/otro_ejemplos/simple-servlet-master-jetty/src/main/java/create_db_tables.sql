drop table books;
CREATE TABLE `books` (
  `book_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `book_title` varchar(255) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
drop table books_read;
CREATE TABLE `books_read` (
  `books_read_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  `fecha_lectura` datetime DEFAULT NULL,
  PRIMARY KEY (`books_read_id`),
  KEY `book_id` (`book_id`),
  KEY `usuario_id` (`usuario_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

drop table usuario;
CREATE TABLE `usuario` (
  `usuario_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `usuario` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `fecha_insert` datetime DEFAULT NULL,
  `fecha_update` datetime DEFAULT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `nombre_usuario` (`usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `gestion_libros`.`usuario`
(`usuario_id`,
`usuario`,
`password`,
`fecha_insert`,
`fecha_update`)
VALUES
(1,
'jma',
'12345',
'2022-05-23',
'2022-05-23');
INSERT INTO `gestion_libros`.`usuario`
(`usuario_id`,
`usuario`,
`password`,
`fecha_insert`,
`fecha_update`)
VALUES
(2,
'luis',
'12345',
'2022-05-23',
'2022-05-23');



INSERT INTO `gestion_libros`.`usuario`
(`usuario_id`,
`usuario`,
`password`,
`fecha_insert`,
`fecha_update`)
VALUES
(3,
'juan',
'12345',
'2022-05-23',
'2022-05-23');

INSERT INTO `gestion_libros`.`usuario`
(`usuario_id`,
`usuario`,
`password`,
`fecha_insert`,
`fecha_update`)
VALUES
(4,
'luisa',
'12345',
'2022-05-23',
'2022-05-23');

INSERT INTO `gestion_libros`.`books`
(`book_id`,
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



INSERT INTO `gestion_libros`.`books_read` (`books_read_id`,`book_id`,`usuario_id`,`fecha_lectura`) VALUES
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
