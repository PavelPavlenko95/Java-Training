

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `level` enum('BEGINNER','EXPERT','PRO') NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT '0',
  `purchase_date` date NOT NULL,
  `end_date` date NOT NULL,
  `duration` enum('MONTH','HALF_YEAR','YEAR') NOT NULL,
  `is_personal_trainer_need` tinyint(4) DEFAULT NULL,
  `price` decimal(10,0) NOT NULL,
  `is_payed` tinyint(4) NOT NULL DEFAULT '0',
  `feedback` text,
  PRIMARY KEY (`id`),
  KEY `buyer__fk_idx` (`client_id`),
  CONSTRAINT `buyer__fk` FOREIGN KEY (`client_id`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `prices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices` (
  `order_type` enum('MONTH_WITH_TRAINER','MONTH','YEAR_WITH_TRAINER','YEAR','HALF_YEAR_WITH_TRAINER','HALF_YEAR') NOT NULL,
  `price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`order_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `prices` WRITE;
/*!40000 ALTER TABLE `prices` DISABLE KEYS */;
INSERT INTO `prices` VALUES ('MONTH_WITH_TRAINER',50),('MONTH',30),('YEAR_WITH_TRAINER',540),('YEAR',300),('HALF_YEAR_WITH_TRAINER',280),('HALF_YEAR',160);
/*!40000 ALTER TABLE `prices` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `training_complexes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_complexes` (
  `program_id` int(11) NOT NULL,
  `exercise_id` int(11) NOT NULL,
  `day_number` int(11) NOT NULL,
  `sets_count` int(11) NOT NULL DEFAULT '0',
  `tasks_count` int(11) DEFAULT '1',
  `tasks_number` int(11) NOT NULL,
  PRIMARY KEY (`program_id`,`exercise_id`,`day_number`),
  KEY `training_complexes_exercises_id_fk` (`exercise_id`),
  CONSTRAINT `training_complexes_exercises_id_fk` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`),
  CONSTRAINT `training_complexes_training_programs_id_fk` FOREIGN KEY (`program_id`) REFERENCES `training_programs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `training_complexes` WRITE;
/*!40000 ALTER TABLE `training_complexes` DISABLE KEYS */;
INSERT INTO `training_complexes` VALUES (5,1,1,3,10,2),(5,5,1,1,1,1),(5,6,2,1,1,1),(5,7,1,3,3,3),(5,15,2,4,10,2),(5,29,2,10,10,3),(6,5,1,1,1,1),(6,5,2,1,1,1),(6,5,3,1,1,1),(6,8,1,4,10,2),(6,10,2,10,10,2),(6,11,1,10,10,3),(6,12,3,10,10,3),(6,19,2,10,10,3),(6,19,3,10,10,2),(7,5,1,1,1,1),(7,5,2,2,2,1),(7,6,1,1,1,2),(7,19,2,11,11,3),(7,34,1,10,10,3),(7,36,2,10,10,2);
/*!40000 ALTER TABLE `training_complexes` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `training_programs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_programs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NOT NULL,
  `personal_trainer_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `tasks` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `personal_trainer__fk_idx` (`personal_trainer_id`),
  KEY `client__fk_idx` (`client_id`),
  KEY `author__fk_idx` (`author_id`),
  CONSTRAINT `author__fk` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `client__fk` FOREIGN KEY (`client_id`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `personal_trainer__fk` FOREIGN KEY (`personal_trainer_id`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` char(64) NOT NULL,
  `role` enum('ADMIN','CLIENT','TRAINER') NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin1','25f43b1486ad95a1398e3eeb3d83bc4010015fcc9bedb35b432e00298d5021f7','ADMIN','Екатерина','Клочкова'),(2,'admin2','1c142b2d01aa34e9a36bde480645a57fd69e14155dacfab5a3f9257b77fdc8d8','ADMIN','Евгений','Макаренко'),(3,'admin3','4fc2b5673a201ad9b1fc03dcb346e1baad44351daa0503d5534b4dfdcc4332e0','ADMIN','Виктор','Полейко'),(4,'admin4','110198831a426807bccd9dbdf54b6dcb5298bc5d31ac49069e0ba3d210d970ae','ADMIN','Алексей','Нелипович'),(5,'trainer1','167ec7e469d6e543b4180fdbe60ddacf81563fb178f908896e46a5e86633c702','TRAINER','Джей','Катлер'),(6,'trainer2','16378a428f831c77c6c49def99620f0f17f4ba693df2826ee8fbd6c6d451e4b7','TRAINER','Кай','Грин'),(7,'trainer3','29209ecd78e31959de6fcb45b068f221f1130de844cfddd0b63af57369cec375','TRAINER','Кирилл','Терёшин'),(8,'trainer4','b4c43741731f7cd4857ebfbef06d73aa09ec1c955b6460ff66b5f33f48d18fe0','TRAINER','Ронда','Раузи'),(9,'client1','1917e33407c28366c8e3b975b17e7374589312676b90229adb4ce6e58552e223','CLIENT','Иван','Лопухов'),(10,'client2','3f455143e75d1e7fd659dea57023496da3bd9f2f8908d1e2ac32641cd819d3e3','CLIENT','Михаил','Иванов'),(11,'client3','e8648df64a518b6eda18c1c77a7ed76326308dc41cbbd79fc7827d4be46b1a39','CLIENT','Дмитрий','Боярын'),(12,'client4','9b4335c9f0711919a2224879b3672f479483ce5828d88331271533136a6bcfa0','CLIENT','Николай','Басков'),(13,'client5','777ba368760863c4686dc8b01acb9bb5f82a2c328cfd3874ff9e471d801dcff8','CLIENT','Анна','Исмалова'),(14,'client6','abe7e076687406846d076f2ca328fcfc1c0f3aa99e4fd3a18a3af2ab71b22d1d','CLIENT','Магомед','Магомедов'),(15,'client7','18287a31389e434858e87e5ec808d04a4de238ff05512d6bda818252ede6bc76','CLIENT','Татьяна','Денова'),(16,'client8','7f3388a411826c2b86ad378b9c23f8ea982fb5f083f216a18ba4376da496c615','CLIENT','Екатерина','Рылова'),(17,'client9','b925e8f380de07a600738ccb28047370eb21d9a161631af9cd2ccc4948574015','CLIENT','Елена','Головина'),(18,'client10','6ca4818ffddcd19a3cd8cf5b4331357299b6535893cfdf8757b44ed1c8744020','CLIENT','Иван','Петров'),(19,'client11','1f6f10127b22a77d11a5a89a9817d286b0c8f282327e7b80cc81dc60fbba2670','CLIENT','Иван','Немцов'),(20,'client12','9dad01292bea13b353a4d7d075f99ad96a0a7b984f89cedd9dd0825f3cae3a90','CLIENT','Рахмат','Раисов'),(21,'client13','78a688a635d1ae3395c59399959b8395f3dd03b9861767480e1a218bfaf7c461','CLIENT','Иен','Чан'),(22,'client14','05949de3e906375fbf99e441e5ca9396f8bfcc60d08632d9981dde64be68bbde','CLIENT','Хен','Кун'),(23,'client15','f8abf39352424e6b00edddad36036f3fc6cd3fc312d662bc7ee4992d054285fc','CLIENT','Николай','Тюрин'),(24,'client16','50153f9b531bfef0cff8f701ea4bf58170f23d93218d6bba97ba3562ec2a47c3','CLIENT','Олег','Газманов'),(25,'client17','0a37e8ff8f95d4823016fa39bb0626ff501400fbe9fe728abffa08df69365b79','CLIENT','Ален','Делон'),(26,'client18','f8c7be5f4f8832e74554197a8c3fdf1d6d21e63dba9d200ed10626439d8f8888','CLIENT','Кирилл','Гулькевич'),(27,'client19','bfa9da42ae000032095e414ec766f9a13c89b4b6ad8984482b4b80c2b2359ce1','CLIENT','Билл','Смит'),(28,'client20','7047f4d78e42239681072a525f2a2708353839ba8160d663cff0bd42b0abf19f','CLIENT','Анна','Шурина'),(29,'client21','21b0f8fe30337d93f9cef28aa773e2f8c816abef711024e61227b8267b730499','CLIENT','Алексей','Гридин'),(30,'client22','84c94a5e658c68d1c7c9dfa287aa991da35b0b18fa9a09eaa56ce4a195bc788b','CLIENT','John','Smith'),(31,'client23','6c3ae19ef3690063c67f05128515ffd0a84cab54deb00827c93f392fe8ca2b6d','CLIENT','Василий','Бублик'),(32,'client24','8acf9a706c536757e8f273d3cb33f1d97d0b659231d2275abaf16d52f48291a2','CLIENT','Василий','Балаболов'),(33,'client25','8a5fd1df0c6b3b86530f71bcd0639468eb69f93857de23e8612eb3018e2beef1','CLIENT','Алексей','Макаров'),(34,'client26','7c588aca5cf838d314ea270cc18135dd14d75117a55514854d1cd6a8778023bb','CLIENT','Степан','Епаменко'),(35,'client27','b5a28aad5e27c1e8ef0dd266412d57a8803a0db7c19a9e201f8266279e082f69','CLIENT','Василий','Вакуленко'),(36,'client28','d2fe0d2b0e1124cdd1f7afa91175cc36298d48ea7bf62c08ea2268ec61b87da5','CLIENT','Анастасия','Шворина'),(37,'client29','93af64eba9def4c367d2c1d3a50678e000c700e3d8edf6c5d8509057adb2aa8b','CLIENT','Bill','Gatz'),(38,'client30','31cd45c09948f5049c3211970db51138863c45e0d4e436505756c14bab21b5b0','CLIENT','Кирилл','Масальский'),(39,'client31','f0c0d0e554a31d93385c0ce6905591f7a1b014b9835383cdc9231c331cae780c','CLIENT','Василий','Ивановец'),(40,'client40','a10f2927c565d34734d03e359979e35a9b07f26280caa043c35f032eefbe8fc0','CLIENT','Василий','Вакуленко'),(41,'client41','7ff7f6e938c63e7324dba996269405c412559665c1bc5424cfefab91fa670665','CLIENT','Алексей','Нелипович'),(44,'client55','a05ab6b1315630a678cb48edaba40eebd6ff18c86e31bed43f4382bd5ed856fc','CLIENT','Екатерина','Малюткина'),(45,'client56','c3598ae87cbd778c817c8c8e010c362794846bee57833b3f826c778bd6d3ad47','CLIENT','Екатерина','Керона'),(46,'client65','b75d19b3cc914176dfbcdfa5eacafce360f947bd6c6cd903ac6b0894411cefc8','CLIENT','Алексей','Петухов'),(47,'client59','e846e70876bc20e7abcff7dbe13f054f9df18766d23f598bb17d35174dd14d00','CLIENT','John','Jackson'),(48,'client67','185aa00f56fe08ba74da2bb4f52c3ad9647e4d9addc2c5cb1588086cbd172cf9','CLIENT','Алексей','Ермалович'),(49,'client58','e57532a2501a9d5e7e1e9c39a8922fc37bec13ac454ee41dad9bfbea4f2a45ca','CLIENT','Алексей','Керон'),(50,'client57','0814ac6d7adc758908e8d76691f17195a8f56cc5b1f405f90a4d590297482bf4','CLIENT','Юсуп','Борз'),(51,'client69','09a01b702552d0e84d9e60980383ebc039bcc36be36d1ebf2bb380c244a793bb','CLIENT','Екатерина','Рябченко'),(52,'client37','0396e7bde12a360b57db0190c0b0d338c01b8e6e4a9032e234f972a00f1c7e18','CLIENT','Алексей','Малюткин'),(53,'client34','926cd3d9dac9e8be945dcf64d14908a6f9fda9d0490262460cdefeaa14f853bf','CLIENT','Олег','Бутырин'),(54,'client71','1af5f646b743e1f72abe21a296b4ad97ba0ff44c28d41c2e3460f562ab799d64','CLIENT','Михаил','Селевахин'),(55,'nololMakar','715dcc38360bd86b26fbd2163fd0d10fdd23d376cc3c0a71a8ce2f7dc25e970d','CLIENT','Елена','Селях'),(58,'nololMakar4','7c3afe3a3e156dc5c444f06025c5fbd09535cef5ffcb4d364586c71235ef10fc','CLIENT','Евгений','Макаренко'),(60,'nololMakar7','7c3afe3a3e156dc5c444f06025c5fbd09535cef5ffcb4d364586c71235ef10fc','CLIENT','Евгений','Макаренко'),(61,'nolol1','0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c','CLIENT','Алексей','Миронов'),(62,'nolol2','0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c','CLIENT','Екатерина','Морозова'),(63,'nolol3','0ffe1abd1a08215353c233d6e009613e95eec4253832a761af28ff37ac5a150c','CLIENT','Евгений','Морозов');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-02 14:35:38
