-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: jardineria
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `autor_seq`
--

LOCK TABLES `autor_seq` WRITE;
/*!40000 ALTER TABLE `autor_seq` DISABLE KEYS */;
INSERT INTO `autor_seq` VALUES (1);
/*!40000 ALTER TABLE `autor_seq` ENABLE KEYS */;
UNLOCK TABLES;

    --
-- Dumping data for table `oficina`
--

LOCK TABLES `oficina` WRITE;
/*!40000 ALTER TABLE `oficina` DISABLE KEYS */;
INSERT INTO `oficina` VALUES (1,'Barcelona','España','Barcelona','08019','+34 93 3561182','Avenida Diagonal, 38','3A escalera Derecha'),(2,'Boston','EEUU','MA','02108','+1 215 837 0825','1550 Court Place','Suite 102'),(3,'Londres','Inglaterra','EMEA','EC2N 1HN','+44 20 78772041','52 Old Broad Street','Ground Floor'),(4,'Madrid','España','Madrid','28032','+34 91 7514487','Bulevar Indalecio Prieto, 32',''),(5,'Paris','Francia','EMEA','75017','+33 14 723 4404','29 Rue Jouffroy d\'abbans',''),(6,'San Francisco','EEUU','CA','94080','+1 650 219 4782','100 Market Street','Suite 300'),(7,'Sydney','Australia','APAC','NSW 2010','+61 2 9264 2451','5-11 Wentworth Avenue','Floor #2'),(8,'Talavera de la Reina','España','Castilla-LaMancha','45632','+34 925 867231','Francisco Aguirre, 32','5º piso (exterior)'),(10,'Tokyo','Japón','Chiyoda-Ku','102-8578','+81 33 224 5000','4-1 Kioicho','');
/*!40000 ALTER TABLE `oficina` ENABLE KEYS */;
UNLOCK TABLES;
    --
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Magaña','Perez',NULL,'marcos@turnos.es','3897','Marcos','Director General',5),(2,'López','Martinez',1,'rlopez@turnos.es','2899','Ruben','Subdirector Marketing',5),(3,'Soria','Carrasco',2,'asoria@turnos.es','2837','Alberto','Subdirector Ventas',5),(4,'Solís','Jerez',2,'msolis@turnos.es','2847','Maria','Secretaria',5),(5,'Rosas','Marquez',3,'frosas@turnos.es','2844','Felipe','Representante Ventas',5),(6,'Ortiz','Serrano',3,'cortiz@turnos.es','2845','Juan Carlos','Representante Ventas',5),(7,'Soria','Jimenez',3,'csoria@turnos.es','2444','Carlos','Director Oficina',1),(8,'López','Murcia',7,'mlopez@turnos.es','2442','Mariano','Representante Ventas',1),(9,'Campoamor','Martín',7,'lcampoamor@turnos.es','2442','Lucio','Representante Ventas',1),(10,'Rodriguez','Huertas',7,'hrodriguez@turnos.es','2444','Hilario','Representante Ventas',1),(11,'Magaña','Perez',3,'manu@turnos.es','2518','Emmanuel','Director Oficina',2),(12,'Martinez','De la Osa',11,'jmmart@hotmail.es','2519','José Manuel','Representante Ventas',2),(13,'Palma','Aceituno',11,'dpalma@turnos.es','2519','David','Representante Ventas',2),(14,'Palma','Aceituno',11,'opalma@turnos.es','2519','Oscar','Representante Ventas',2),(15,'Fignon','',3,'ffignon@gardening.com','9981','Francois','Director Oficina',3),(16,'Narvaez','',15,'lnarvaez@gardening.com','9982','Lionel','Representante Ventas',3),(17,'Serra','',15,'lserra@gardening.com','9982','Laurent','Representante Ventas',3),(18,'Bolton','',3,'mbolton@gardening.com','7454','Michael','Director Oficina',3),(19,'Sanchez','Lopez',18,'wssanchez@gardening.com','7454','Walter Santiago','Representante Ventas',3),(20,'Washington','',3,'hwashington@gardening.com','7565','Hilary','Director Oficina',5),(21,'Paxton','',20,'mpaxton@gardening.com','7565','Marcus','Representante Ventas',5),(22,'Paxton','',20,'lpaxton@gardening.com','7665','Lorena','Representante Ventas',5),(23,'Nishikori','',3,'nnishikori@gardening.com','8734','Nei','Director Oficina',6),(24,'Riko','',23,'nriko@gardening.com','8734','Narumi','Representante Ventas',6),(25,'Nomura','',23,'tnomura@gardening.com','8735','Takuma','Representante Ventas',6),(26,'Johnson','',3,'ajohnson@gardening.com','3321','Amy','Director Oficina',7),(27,'Westfalls','',26,'lwestfalls@gardening.com','3322','Larry','Representante Ventas',7),(28,'Walton','',26,'jwalton@gardening.com','3322','John','Representante Ventas',7),(29,'Fallmer','',3,'kfalmer@gardening.com','3210','Kevin','Director Oficina',7),(30,'Bellinelli','',29,'jbellinelli@gardening.com','3211','Julian','Representante Ventas',7),(31,'Kishi','',29,'mkishi@gardening.com','3211','Mariko','Representante Ventas',7);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'GoldFish','San Francisco',0,'24006','5556901746',3000.45,NULL,NULL,NULL,'False Street 52 2 A','','GoldFish Garden','Daniel G F','USA','','5556901745',5),(3,'Wright','Miami',19,'24010','5557410346',6000,NULL,NULL,NULL,'Wall-e Avenue',NULL,'Gardening Associates','Anne','USA','Miami','5557410345',19),(4,'Flaute','New York',22,'85495','5552323128',12000,NULL,NULL,NULL,'Oaks Avenue nº22',NULL,'Gerudo Valley','Link','USA',NULL,'5552323129',22),(5,'Tendo','Miami',22,'696969','55591233211',600000,NULL,NULL,NULL,'Null Street nº69',NULL,'Tendo Garden','Akane','USA',NULL,'55591233210',22),(6,'Lasas','Fuenlabrada',8,'28945','34914851312',154310,NULL,NULL,NULL,'C/Leganes 15',NULL,'Lasas S.A.','Antonio','Spain','Madrid','34916540145',8),(7,'Bermejo','Madrid',11,'28942','916549872',20000,NULL,NULL,NULL,'C/pintor segundo','Getafe','Beragua','Jose','Spain','Madrid','654987321',11),(8,'Lopez','Madrid',11,'28930','919535678',40000,NULL,NULL,NULL,'C/sinesio delgado','Madrid','Club Golf Puerta del hierro','Paco','Spain','Madrid','62456810',11),(9,'Rengifo','Madrid',11,'28947','916428956',32000,NULL,NULL,NULL,'C/majadahonda','Boadilla','Naturagua','Guillermo','Spain','Madrid','689234750',11),(10,'Serrano','Madrid',11,'28946','916421756',50000,NULL,NULL,NULL,'C/azores','Fuenlabrada','DaraDistribuciones','David','Spain','Madrid','675598001',11),(11,'Tacaño','Madrid',11,'28943','916689215',20000,NULL,NULL,NULL,'C/Lagañas','Fuenlabrada','Madrileña de riegos','Jose','Spain','Madrid','655983045',11),(12,'Lasas','Fuenlabrada',8,'28945','34914851312',154310,NULL,NULL,NULL,'C/Leganes 15',NULL,'Lasas S.A.','Antonio','Spain','Madrid','34916540145',8),(13,'Camunas','San Lorenzo del Escorial',8,'28145','34914871541',16481,NULL,NULL,NULL,'C/Virgenes 45','C/Princesas 2 1ºB','Camunas Jardines S.L.','Pedro','Spain','Madrid','34914873241',8),(14,'Rodriguez','Madrid',8,'28003','34912484764',321000,NULL,NULL,NULL,'C/Nueva York 74',NULL,'Dardena S.A.','Juan','Spain','Madrid','34912453217',8),(15,'Villar','Madrid',30,'28950','914538776',40000,NULL,NULL,NULL,'C/ Oña 34',NULL,'Jardin de Flores','Javier','Spain','Madrid','654865643',30),(16,'Rodriguez','Fuenlabrada',5,'28945','912458657',1500,NULL,NULL,NULL,'C/Leganes24',NULL,'Flores Marivi','Maria','Spain','Madrid','666555444',5),(17,'Fernandez','Montornes del valles',5,'24586','978453216',3500,NULL,NULL,NULL,'C/Luis Salquillo4',NULL,'Flowers, S.A','Beatriz','Spain','Barcelona','698754159',5),(18,'Cruz','Madrid',30,'28011','916548735',5050,NULL,NULL,NULL,'Plaza Magallón 15',NULL,'Naturajardin','Victoria','Spain','Madrid','612343529',30),(19,'Martinez','Santa cruz de Tenerife',12,'38297','912354475',30000,NULL,NULL,NULL,'C/Estancado',NULL,'Golf S.A.','Luis','Spain','Islas Canarias','916458762',12),(20,'Suarez','Barcelona',12,'12320','964493063',20000,NULL,NULL,NULL,'C/Letardo',NULL,'Americh Golf Management SL','Mario','Spain','Cataluña','964493072',12),(21,'Rodrigez','Canarias',12,'35488','914489898',50000,NULL,NULL,NULL,'C/Roman 3',NULL,'Aloha','Cristian','Spain','Canarias','916485852',12),(22,'Camacho','Barcelona',12,'12320','916493211',30000,NULL,NULL,NULL,'Avenida Tibidabo',NULL,'El Prat','Francisco','Spain','Cataluña','916882323',12),(23,'Santillana','Sotogrande',12,'11310','914825645',60000,NULL,NULL,NULL,'C/Paseo del Parque',NULL,'Sotogrande','Maria','Spain','Cadiz','915576622',12),(24,'Gomez','Humanes',30,'28970','916040875',7430,NULL,NULL,NULL,'C/Miguel Echegaray 54',NULL,'Vivero Humanes','Federico','Spain','Madrid','654987690',30),(25,'Muñoz Mena','Fuenlabrada',5,'28574','915483754',4500,NULL,NULL,NULL,'C/Callo 52',NULL,'Fuenla City','Tony','Spain','Madrid','675842139',5),(26,'Sánchez','Madrid',9,'29874','914477777',76000,NULL,NULL,NULL,'Polígono Industrial Maspalomas, Nº52','Móstoles','Jardines y Mansiones Cactus SL','Eva María','Spain','Madrid','916877445',9),(27,'San Martín','Madrid',9,'37845','917897474',100500,NULL,NULL,NULL,'C/Francisco Arce, Nº44','Bustarviejo','Jardinerías Matías SL','Matías','Spain','Madrid','916544147',9),(28,'Lopez','Getafe',30,'28904','916549264',8040,NULL,NULL,NULL,'C/Mar Caspio 43',NULL,'Agrojardin','Benito','Spain','Madrid','675432926',30),(29,'Sanchez','Humanes',5,'28574','974315924',5500,NULL,NULL,NULL,'C/Ibiza 32',NULL,'Top Campo','Joseluis','Spain','Madrid','685746512',5),(30,'Marquez','Fuenlabrada',5,'27584','912475843',7500,NULL,NULL,NULL,'C/Lima 1',NULL,'turnos Sara','Sara','Spain','Madrid','675124537',5),(31,'Jimenez','Fuenlabrada',30,'28945','916159116',3250,NULL,NULL,NULL,'C/Peru 78',NULL,'Campohermoso','Luis','Spain','Madrid','645925376',30),(32,'Toulou','Paris',16,'75010','(33)5120578961',10000,NULL,NULL,NULL,'6 place d Alleray 15Ã¨me',NULL,'france telecom','FraÃ§ois','France',NULL,'(33)5120578961',16),(33,'Delacroux','Paris',16,'75058','(33)0140205442',30000,NULL,NULL,NULL,'Quai du Louvre',NULL,'Musée du Louvre','Pierre','France',NULL,'(33)0140205050',16),(35,'Jones','Sydney',31,'2000','2 9283-1695',10000,NULL,NULL,NULL,'level 24, St. Martins Tower.-31 Market St.',NULL,'Tutifruti S.A','Jacob','Australia','Nueva Gales del Sur','2 9261-2433',31),(36,'Romero','Madrid',18,'29643','685249700',6000,NULL,NULL,NULL,'Avenida España',NULL,'Flores S.L.','Antonio','Spain','Fuenlabrada','654352981',18),(37,'Mcain','London',18,'65930','9364875882',10000,NULL,NULL,NULL,'Lihgting Park',NULL,'The Magic Garden','Richard','United Kingdom','London','926523468',18),(38,'Smith','Sydney',31,'2003','2 8005-7162',8000,NULL,NULL,NULL,'176 Cumberland Street The rocks',NULL,'El Jardin Viviente S.L','Justin','Australia','Nueva Gales del Sur','2 8005-7161',31);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cliente_seq`
--

LOCK TABLES `cliente_seq` WRITE;
/*!40000 ALTER TABLE `cliente_seq` DISABLE KEYS */;
INSERT INTO `cliente_seq` VALUES (1);
/*!40000 ALTER TABLE `cliente_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `compras_seq`
--

LOCK TABLES `compras_seq` WRITE;
/*!40000 ALTER TABLE `compras_seq` DISABLE KEYS */;
INSERT INTO `compras_seq` VALUES (1);
/*!40000 ALTER TABLE `compras_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comprasimplificada`
--

LOCK TABLES `comprasimplificada` WRITE;
/*!40000 ALTER TABLE `comprasimplificada` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprasimplificada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comprasimplificada_seq`
--

LOCK TABLES `comprasimplificada_seq` WRITE;
/*!40000 ALTER TABLE `comprasimplificada_seq` DISABLE KEYS */;
INSERT INTO `comprasimplificada_seq` VALUES (1);
/*!40000 ALTER TABLE `comprasimplificada_seq` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `detalle_compra_seq`
--

LOCK TABLES `detalle_compra_seq` WRITE;
/*!40000 ALTER TABLE `detalle_compra_seq` DISABLE KEYS */;
INSERT INTO `detalle_compra_seq` VALUES (1);
/*!40000 ALTER TABLE `detalle_compra_seq` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `empleado_seq`
--

LOCK TABLES `empleado_seq` WRITE;
/*!40000 ALTER TABLE `empleado_seq` DISABLE KEYS */;
INSERT INTO `empleado_seq` VALUES (1);
/*!40000 ALTER TABLE `empleado_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `etiqueta`
--

LOCK TABLES `etiqueta` WRITE;
/*!40000 ALTER TABLE `etiqueta` DISABLE KEYS */;
INSERT INTO `etiqueta` VALUES (102,'Rural'),(152,'Urbano a medias'),(153,'Montaña'),(154,'Montaña de nuevo'),(251,'Montaña de nuevo'),(252,'Bares por la noche');
/*!40000 ALTER TABLE `etiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `etiqueta_embeddable`
--

LOCK TABLES `etiqueta_embeddable` WRITE;
/*!40000 ALTER TABLE `etiqueta_embeddable` DISABLE KEYS */;
INSERT INTO `etiqueta_embeddable` VALUES (102,'Rural'),(152,'Urbano a medias'),(153,'Montaña'),(154,'Montaña de nuevo'),(251,'Montaña de nuevo'),(252,'Bares por la noche');
/*!40000 ALTER TABLE `etiqueta_embeddable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `etiqueta_mientidad`
--

LOCK TABLES `etiqueta_mientidad` WRITE;
/*!40000 ALTER TABLE `etiqueta_mientidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `etiqueta_mientidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `etiqueta_seq`
--

LOCK TABLES `etiqueta_seq` WRITE;
/*!40000 ALTER TABLE `etiqueta_seq` DISABLE KEYS */;
INSERT INTO `etiqueta_seq` VALUES (252);
/*!40000 ALTER TABLE `etiqueta_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `galeria`
--

LOCK TABLES `galeria` WRITE;
/*!40000 ALTER TABLE `galeria` DISABLE KEYS */;
INSERT INTO `galeria` VALUES (5,'img1','/img/team-1.jpg',20),(6,'img1','/img/team-2.jpg',12),(7,'img3','/img/team-3.jpg',5),(8,'elemento 4','/img/team-4.jpg',17),(9,'test alta','/img/team_2.jpg',16);
/*!40000 ALTER TABLE `galeria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `galeria_embeddable`
--

LOCK TABLES `galeria_embeddable` WRITE;
/*!40000 ALTER TABLE `galeria_embeddable` DISABLE KEYS */;
INSERT INTO `galeria_embeddable` VALUES (12,'adadad','/img/team-2.jpg',15),(13,'otro','/img/team-2.jpg',8),(14,'Carmen','/img/team-4.jpg',4),(15,'1','/img/team-2.jpg',6),(16,'dos de nuevo','/img/team-2.jpg',2),(17,'Una mas','/img/team-4.jpg',15),(18,'','/img/team_3.jpg',4),(19,'','/img/team_3.jpg',4),(20,'prueba','/img/team_3.jpg',4);
/*!40000 ALTER TABLE `galeria_embeddable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `galeria_etiqueta_embeddable`
--

LOCK TABLES `galeria_etiqueta_embeddable` WRITE;
/*!40000 ALTER TABLE `galeria_etiqueta_embeddable` DISABLE KEYS */;
INSERT INTO `galeria_etiqueta_embeddable` VALUES (102,12,'Doy de modifico la relacion con:102','2023-06-08 17:29:33.635150'),(102,13,'Doy de modifico la relacion con:102','2023-02-17 11:40:48.808347'),(102,17,'Doy de modifico la relacion con:102','2023-05-19 11:03:06.242422'),(102,20,'Doy de alta la relacion con:102','2023-06-13 19:13:33.835942'),(152,12,'Doy de modifico la relacion con:152','2023-06-08 17:29:33.635150'),(152,13,'Doy de modifico la relacion con:152','2023-02-17 11:40:48.808347'),(152,14,'Doy de modifico la relacion con:152','2023-06-07 18:24:14.555652'),(152,15,'Doy de modifico la relacion con:152','2023-05-22 09:56:59.909426'),(152,16,'Doy de modifico la relacion con:152','2023-06-09 16:26:29.740104'),(152,17,'Doy de modifico la relacion con:152','2023-05-19 11:03:06.242422'),(153,12,'Doy de modifico la relacion con:153','2023-06-08 17:29:33.635150'),(153,13,'Doy de modifico la relacion con:153','2023-02-17 11:40:48.808347'),(153,14,'Doy de modifico la relacion con:153','2023-06-07 18:24:14.555652'),(153,15,'Doy de modifico la relacion con:153','2023-05-22 09:56:59.909426'),(153,17,'Doy de modifico la relacion con:153','2023-05-19 11:03:06.242422'),(154,13,'Doy de modifico la relacion con:154','2023-02-17 11:40:48.808347'),(154,14,'Doy de modifico la relacion con:154','2023-06-07 18:24:14.555652'),(154,16,'Doy de modifico la relacion con:154','2023-06-09 16:26:29.740104'),(154,17,'Doy de modifico la relacion con:154','2023-05-19 11:03:06.242422'),(251,13,'Doy de modifico la relacion con:251','2023-02-17 11:40:48.808347'),(252,13,'Doy de modifico la relacion con:252','2023-02-17 11:40:48.808347'),(252,14,'Doy de modifico la relacion con:252','2023-06-07 18:24:14.555652');
/*!40000 ALTER TABLE `galeria_etiqueta_embeddable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `galeria_etiqueta_mientidad`
--

LOCK TABLES `galeria_etiqueta_mientidad` WRITE;
/*!40000 ALTER TABLE `galeria_etiqueta_mientidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `galeria_etiqueta_mientidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `galeria_etiquetas`
--

LOCK TABLES `galeria_etiquetas` WRITE;
/*!40000 ALTER TABLE `galeria_etiquetas` DISABLE KEYS */;
INSERT INTO `galeria_etiquetas` VALUES (6,102),(7,152),(8,152),(9,152),(8,153),(9,153),(6,154),(7,154);
/*!40000 ALTER TABLE `galeria_etiquetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `galeria_mientidad`
--

LOCK TABLES `galeria_mientidad` WRITE;
/*!40000 ALTER TABLE `galeria_mientidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `galeria_mientidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gestorincidencias`
--

LOCK TABLES `gestorincidencias` WRITE;
/*!40000 ALTER TABLE `gestorincidencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `gestorincidencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `incidencia`
--

LOCK TABLES `incidencia` WRITE;
/*!40000 ALTER TABLE `incidencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lector`
--

LOCK TABLES `lector` WRITE;
/*!40000 ALTER TABLE `lector` DISABLE KEYS */;
INSERT INTO `lector` VALUES (1,'Luis');
/*!40000 ALTER TABLE `lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lector_seq`
--

LOCK TABLES `lector_seq` WRITE;
/*!40000 ALTER TABLE `lector_seq` DISABLE KEYS */;
INSERT INTO `lector_seq` VALUES (1);
/*!40000 ALTER TABLE `lector_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `libro_lector`
--

LOCK TABLES `libro_lector` WRITE;
/*!40000 ALTER TABLE `libro_lector` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro_lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `libro_seq`
--

LOCK TABLES `libro_seq` WRITE;
/*!40000 ALTER TABLE `libro_seq` DISABLE KEYS */;
INSERT INTO `libro_seq` VALUES (1);
/*!40000 ALTER TABLE `libro_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `localizacionlibros`
--

LOCK TABLES `localizacionlibros` WRITE;
/*!40000 ALTER TABLE `localizacionlibros` DISABLE KEYS */;
/*!40000 ALTER TABLE `localizacionlibros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `localizacionlibros_seq`
--

LOCK TABLES `localizacionlibros_seq` WRITE;
/*!40000 ALTER TABLE `localizacionlibros_seq` DISABLE KEYS */;
INSERT INTO `localizacionlibros_seq` VALUES (1);
/*!40000 ALTER TABLE `localizacionlibros_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,1,'Inicio',0,'/',NULL),(2,1,'Login',1,'/usuarios/login',NULL),(3,1,'General',10,'',NULL),(4,0,'Books',20,'/books',3),(5,0,'Books read',30,'/booksreads',NULL),(6,0,'Books sold',40,'/bookssolds',NULL),(7,1,'Usuarios',50,'',NULL),(8,0,'Lista de usuarios',51,'/usuarios',7),(9,0,'Registrar usarios',52,'/usuarios/registro',7),(10,1,'Clientes',60,NULL,NULL),(11,0,'Lista de clientes',61,'/clientes',10),(12,0,'Registrar cliente',62,'/clientes/registro',10),(13,1,'Etiquetas',70,NULL,NULL),(14,0,'Lista de etiquetas',71,'/etiquetas',13),(15,0,'Registro',72,'/etiquetas/registro',13),(16,1,'Catálogo',80,NULL,NULL),(17,1,'Mookup',81,'/galeria/embed',16),(18,1,'Registro',82,'/galeria/embed/registro',16),(19,1,'Logout',9999,'/logout',NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_ANONIMOUS'),(4,'ROLE_VENTAS'),(5,'ROLE_ENTRENADOR'),(6,'ROLE_JUGADOR');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Dumping data for table `menu_roles`
--

LOCK TABLES `menu_roles` WRITE;
/*!40000 ALTER TABLE `menu_roles` DISABLE KEYS */;
INSERT INTO `menu_roles` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(1,2),(2,2),(4,2),(5,2),(6,2),(8,2),(9,2),(10,2),(11,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(1,3),(2,3);
/*!40000 ALTER TABLE `menu_roles` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,6,'Desc 1','uno',5,'',NULL),(2,2,'Desc 2','dos',6,NULL,NULL),(3,7,'Desc 3','tres',9,NULL,NULL),(4,8,'Desc 4','cuatrro',3,NULL,NULL);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos_seq`
--

LOCK TABLES `productos_seq` WRITE;
/*!40000 ALTER TABLE `productos_seq` DISABLE KEYS */;
INSERT INTO `productos_seq` VALUES (1);
/*!40000 ALTER TABLE `productos_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (id,email,nombre_usuario,password,active,empleado_id,token)  VALUES (1,'anonimo@anonimo','anonimo','ttt',_binary '',NULL,NULL),(2,'jose.manuel.aroca@gmail.es','jma223333','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(3,'ddd@juan.com','JUan','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(4,'nombre4@eoi.com','nombre4','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(5,'nombre5@eoi.com','nombre5','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(6,'nombre6@eoi.com','nombre6','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(7,'nombre7@eoi.com','nombre7','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(8,'nombre8@eoi.com','nombre8','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(9,'nombre9@eoi.com','nombre9','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(10,'nombre10@eoi.com','nombre10','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(11,'nombre11@eoi.com','nombre11','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(12,'nombre12@eoi.com','nombre12','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(13,'nombre13@eoi.com','nombre13','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(14,'nombre14@eoi.com','nombre14','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(15,'nombre15@eoi.com','nombre15','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(16,'nombre16@eoi.com','nombre16','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(17,'nombre17@eoi.com','nombre17','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(18,'nombre18@eoi.com','nombre18','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(19,'nombre19@eoi.com','nombre19','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(20,'nombre20@eoi.com','nombre20','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(21,'nombre21@eoi.com','nombre21','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(22,'nombre22@eoi.com','nombre22','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(23,'nombre23@eoi.com','nombre23','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(24,'nombre24@eoi.com','nombre24','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(25,'nombre25@eoi.com','nombre25','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(26,'nombre26@eoi.com','nombre26','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(27,'nombre27@eoi.com','nombre27','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(28,'nombre28@eoi.com','nombre28','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(29,'nombre29@eoi.com','nombre29','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(30,'nombre30@eoi.com','nombre30','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(31,'nombre31@eoi.com','nombre31','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(32,'nombre32@eoi.com','nombre32','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(33,'nombre33@eoi.com','nombre33','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(34,'nombre34@eoi.com','nombre34','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(35,'nombre35@eoi.com','nombre35','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(36,'nombre36@eoi.com','nombre36','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(37,'nombre37@eoi.com','nombre37','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(38,'nombre38@eoi.com','nombre38','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(39,'nombre39@eoi.com','nombre39','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(40,'nombre40@eoi.com','nombre40','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(41,'nombre41@eoi.com','nombre41','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(42,'nombre42@eoi.com','nombre42','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(43,'nombre43@eoi.com','nombre43','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(44,'nombre44@eoi.com','nombre44','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(45,'nombre45@eoi.com','nombre45','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(46,'nombre46@eoi.com','nombre46','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(47,'nombre47@eoi.com','nombre47','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(48,'nombre48@eoi.com','nombre48','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(49,'nombre49@eoi.com','nombre49','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(50,'nombre50@eoi.com','nombre50','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(51,'nombre51@eoi.com','nombre51','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(52,'nombre52@eoi.com','nombre52','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(53,'nombre53@eoi.com','nombre53','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(54,'nombre54@eoi.com','nombre54','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(55,'nombre55@eoi.com','nombre55','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(56,'nombre56@eoi.com','nombre56','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(57,'nombre57@eoi.com','nombre57','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(58,'nombre58@eoi.com','nombre58','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(59,'nombre59@eoi.com','nombre59','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(60,'nombre60@eoi.com','nombre60','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(61,'nombre61@eoi.com','nombre61','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(62,'nombre62@eoi.com','nombre62','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(63,'nombre63@eoi.com','nombre63','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(64,'nombre64@eoi.com','nombre64','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(65,'nombre65@eoi.com','nombre65','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(66,'nombre66@eoi.com','nombre66','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(67,'nombre67@eoi.com','nombre67','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(68,'nombre68@eoi.com','nombre68','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(69,'nombre69@eoi.com','nombre69','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(70,'nombre70@eoi.com','nombre70','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(71,'nombre71@eoi.com','nombre71','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(72,'nombre72@eoi.com','nombre72','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(73,'nombre73@eoi.com','nombre73','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(74,'nombre74@eoi.com','nombre74','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(75,'nombre75@eoi.com','nombre75','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(76,'nombre76@eoi.com','nombre76','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(77,'nombre77@eoi.com','nombre77','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(78,'nombre78@eoi.com','nombre78','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(79,'nombre79@eoi.com','nombre79','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(80,'nombre80@eoi.com','nombre80','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(81,'nombre81@eoi.com','nombre81','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(82,'nombre82@eoi.com','nombre82','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(83,'nombre83@eoi.com','nombre83','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(84,'nombre84@eoi.com','nombre84','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(85,'nombre85@eoi.com','nombre85','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(86,'nombre86@eoi.com','nombre86','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(87,'nombre87@eoi.com','nombre87','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(88,'nombre88@eoi.com','nombre88','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(89,'nombre89@eoi.com','nombre89','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(90,'nombre90@eoi.com','nombre90','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(91,'nombre91@eoi.com','nombre91','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(92,'nombre92@eoi.com','nombre92','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(93,'nombre93@eoi.com','nombre93','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(94,'nombre94@eoi.com','nombre94','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(95,'nombre95@eoi.com','nombre95','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(96,'nombre96@eoi.com','nombre96','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(97,'nombre97@eoi.com','nombre97','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(98,'nombre98@eoi.com','nombre98','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(99,'nombre99@eoi.com','nombre99','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(100,'nombre100@eoi.com','nombre100','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(101,'nombre101@eoi.com','nombre101','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(102,'nombre102@eoi.com','nombre102','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(103,'nombre103@eoi.com','nombre103','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(104,'nombre104@eoi.com','nombre104','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(105,'nombre105@eoi.com','nombre105','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(106,'nombre106@eoi.com','nombre106','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(107,'nombre107@eoi.com','nombre1072112','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(108,'nombre108@eoi.com','nombre108','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(109,'nombre109@eoi.com','nombre109','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(110,'nombre110@eoi.com','nombre110','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(111,'nombre111@eoi.com','nombre111','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(112,'nombre112@eoi.com','nombre112','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(113,'nombre113@eoi.com','nombre113','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(114,'nombre114@eoi.com','nombre114','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(115,'nombre115@eoi.com','nombre115fsfwsf','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(116,'nombre116@eoi.com','nombre116','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(117,'nombre117@eoi.com','nombre117ssasas','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(118,'nombre118@eoi.com','nombre118','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(119,'nombre119@eoi.com','nombre119','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(120,'nombre120@eoi.com','nombre120','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(121,'nombre121@eoi.com','nombre121','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(122,'nombre122@eoi.com','nombre122','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(123,'nombre123@eoi.com','nombre123','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(124,'nombre124@eoi.com','nombre124','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(125,'nombre125@eoi.com','nombre125','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(126,'nombre126@eoi.com','nombre126','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(127,'nombre127@eoi.com','nombre127','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(128,'nombre128@eoi.com','nombre128','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(129,'nombre129@eoi.com','nombre129','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(130,'nombre130@eoi.com','nombre130','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(131,'nombre131@eoi.com','nombre131','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(132,'nombre132@eoi.com','nombre132','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(133,'nombre133@eoi.com','nombre133','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(134,'nombre134@eoi.com','nombre134','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(135,'nombre135@eoi.com','nombre135','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(136,'nombre136@eoi.com','nombre136','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(137,'nombre137@eoi.com','nombre137','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(138,'nombre138@eoi.com','nombre138','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(139,'nombre139@eoi.com','nombre139','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(140,'nombre140@eoi.com','nombre140','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(141,'nombre141@eoi.com','nombre141','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(142,'nombre142@eoi.com','nombre142','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(143,'nombre143@eoi.com','nombre143','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(144,'nombre144@eoi.com','nombre144','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(145,'nombre145@eoi.com','nombre145','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(146,'nombre146@eoi.com','nombre146','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(147,'nombre147@eoi.com','nombre147','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(148,'nombre148@eoi.com','nombre148','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(149,'nombre149@eoi.com','nombre149','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(150,'nombre150@eoi.com','nombre150','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(151,'nombre151@eoi.com','nombre151','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(152,'nombre152@eoi.com','nombre152','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(153,'nombre153@eoi.com','nombre153','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(154,'nombre154@eoi.com','nombre154','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(155,'nombre155@eoi.com','nombre155','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(156,'nombre156@eoi.com','nombre156','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(157,'nombre157@eoi.com','nombre157','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(158,'nombre158@eoi.com','nombre158','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(159,'nombre159@eoi.com','nombre159','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(160,'nombre160@eoi.com','nombre160','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(161,'nombre161@eoi.com','nombre161','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(162,'nombre162@eoi.com','nombre162','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(163,'nombre163@eoi.com','nombre163','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(164,'nombre164@eoi.com','nombre164','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(165,'nombre165@eoi.com','nombre165','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(166,'nombre166@eoi.com','nombre166','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(167,'admin@a','admin','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(352,'','','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(402,'','','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(552,'adminj@app.com','adminj','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(602,'adming@g.com','adming','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(652,'adming@g.com','adming','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(702,'admingg@dd','admingg','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(752,'adminfff@e','adminfff','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(802,'adminaa@aa','adminaa','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(852,'adminhh@gg','adminhh','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(902,'admin_kk@kk','admin_kk','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(1102,'pepe@p','pepe','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(1103,'lola@eoi.com','lola','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(1252,'pepe@gmail.com','pepe1','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(1302,'pepe2@gmail.com','pepe2','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(1352,'pepe3@gmail.com','pepe3','$2a$10$UrkQe.T6rPeq0YSVfSwEMeQZL3f6k9FHrOExsIncSgATaShTPNP5q',_binary '',NULL,NULL),(1402,'pepe6@g','pepe6','$2a$10$VnbcpNUAaV/VGziEXGzneOTq1G8Y561v/S84.GPFu.rh2/RfD130W',_binary '',NULL,NULL),(1403,'pepe7@g','pepe7','$2a$10$4FwOPF5DBPYQ7IuhmU/ud.KKDBs1GSU8UOdlime5K2Is0VzvUcDMi',_binary '',NULL,NULL),(1404,'pepe8@gmail.com','pepe8','$2a$10$4FwOPF5DBPYQ7IuhmU/ud.KKDBs1GSU8UOdlime5K2Is0VzvUcDMi',_binary '',NULL,NULL),(1452,'pepe9@gmail.com','pepe9','$2a$10$If7OYCcZB5U32VJeJL76se/Ibs8HU4DatwYNJXX7KEZGU8hUjXWCK',_binary '',NULL,NULL),(1552,'jma@g','jma','$2a$10$9dSCnqOWsuwNLuQItg3if.195YZwOVsR32vZcKZiXKYYwvcvB0hx.',_binary '',NULL,'hdjhgdhlghehghb163403590jnvsbhfskndlgvsdn'),(1602,'a@a','a','$2a$10$Pb/GEo1iKLWO8oO5TKAdpuQHm.Xit0KqDIO.1YAtkOlR/BsaQRcg.',_binary '',NULL,'hdjhgdhlghehghb163403590jnvsbhfskndlgvsdn');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario_roles`
--

LOCK TABLES `usuario_roles` WRITE;
/*!40000 ALTER TABLE `usuario_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario_seq`
--

LOCK TABLES `usuario_seq` WRITE;
/*!40000 ALTER TABLE `usuario_seq` DISABLE KEYS */;
INSERT INTO `usuario_seq` VALUES (1701);
/*!40000 ALTER TABLE `usuario_seq` ENABLE KEYS */;
UNLOCK TABLES;
