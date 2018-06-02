-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: MusicSystem
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.17.10.1

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_name_uindex` (`name`),
  UNIQUE KEY `admin_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `singer` varchar(32) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `album` varchar(32) DEFAULT NULL,
  `pic_url` varchar(64) DEFAULT NULL,
  `song_url` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'A Good Night','SONY music','John Legend','2018-04-06','A Good Night','/resources/img/A Good Night.jpg','/resources/song/A Good Night.mp3'),(2,'Change','SONY music','Charlie Puth','2018-03-23','Voicenotes','/resources/img/Voicenotes.jpg','/resources/song/Change.mp3'),(3,'Done For Me','SONY music','Charlie Puth','2017-05-11','Voicenotes','/resources/img/Voicenotes.jpg','/resources/song/Done For Me.mp3'),(4,'Flames','PLG','David Guetta','2018-03-23','Flames','/resources/img/Flames.jpg','/resources/song/Flames.mp3'),(5,'FRIENDS','SONY music','Marshmello','2018-02-09','FRIENDS','/resources/img/FRIENDS.jpg','/resources/song/FRIENDS.mp3'),(6,'On the Low','SONY music','Tove Styrke','2018-04-06','On the Low','/resources/img/On the Low.jpg','/resources/song/On the Low.mp3'),(7,'Me So Bad','SONY music','Tinashe','2018-03-30','Me So Bad','/resources/img/Me So Bad.jpg','/resources/song/Me So Bad.mp3'),(8,'Like I Do','SONY music','David Guetta','2018-02-22','Like I Do','/resources/img/Like I Do.jpg','/resources/song/Like I Do.mp3'),(9,'This Is Me','SONY music','Keala Settle','2018-03-23','This Is Me','/resources/img/This Is Me.jpg','/resources/song/This Is Me.mp3'),(10,'One Kiss','SONY music','Calvin Harris','2018-04-06','One Kiss','/resources/img/One Kiss.jpg','/resources/song/One Kiss.mp3'),(11,'Perfect for Me','SONY music','Daniel Powter','2018-04-06','Perfect for Me','/resources/img/Perfect for Me.jpg','/resources/song/Perfect for Me.mp3'),(12,'What If','SONY music','Coldplay','2005-06-06','X & Y','/resources/img/X & Y.jpg','/resources/song/What If.mp3'),(13,'My Wretched Love','SONY music','My Wretched Love','2018-04-12','My Wretched Love','/resources/img/My Wretched Love.jpg','/resources/song/My Wretched Love.mp3'),(14,'Dancer','SONY music','Flo Rida','2018-03-02','Dancer','/resources/img/Dancer.jpg','/resources/song/Dancer.mp3'),(15,'Top Off','SONY music','DJ Khaled','2018-03-02','Top Off','/resources/img/Top Off.jpg','/resources/song/Top Off.mp3'),(16,'Man of the Woods','SONY music','Justin Timberlake','2018-02-02','Man of the Woods','/resources/img/Man of the Woods.jpg','/resources/song/Man of the Woods.mp3'),(17,'No Excuses','SONY music','Meghan Trainor','2018-03-01','No Excuses','/resources/img/No Excuses.jpg','/resources/song/No Excuses.mp3'),(18,'Lullaby','SONY music','Sigala','2018-02-23','Lullaby','/resources/img/Lullaby.jpg','/resources/song/Lullaby.mp3'),(19,'Nostalgia','SONY music','MØ','2018-03-30','Nostalgia','/resources/img/Nostalgia.jpg','/resources/song/Nostalgia.mp3'),(20,'Everything You Need','SONY music','Michael Learns To Rock','2018-03-21','STILL','/resources/img/STILL.jpg','/resources/song/Everything You Need.mp3'),(21,'Paradise','SONY music','George Ezra','2018-01-19','Paradise','/resources/img/Paradise.jpg','/resources/song/Paradise.mp3'),(22,'Watch Out!','SONY music','Rich Brian','2018-04-04','watch out!','/resources/img/watch out!.jpg','/resources/song/Watch Out!.mp3'),(23,'Happy','SONY music','AREA21','2018-02-09','Happy','/resources/img/Happy.jpg','/resources/song/Happy.mp3'),(24,'All of Me','SONY music','John Legend','2018-02-09','DARKNESS AND LIGHT','/resources/img/DARKNESS AND LIGHT.jpg','/resources/song/All of Me.mp3'),(25,'I Need a Woman to Love','SONY music','Kesha','2018-04-05','Universal Love','/resources/img/Universal Love.jpg','/resources/song/I Need a Woman to Love.mp3'),(26,'Meant to Be','SONY music','Bebe Rexha','2017-08-11','All Your Fault','/resources/img/All Your Fault.jpg','/resources/song/Meant to Be.mp3'),(27,'Zombie','SONY music','Bad Wolves','2018-01-19','Zombie','/resources/img/Zombie.jpg','/resources/song/Zombie.mp3'),(28,'Let You Down','SONY music','NF','2017-09-15','Let You Down','/resources/img/Let You Down.jpg','/resources/song/Let You Down.mp3'),(29,'Boy','SONY music','Lee Brice','2017-09-15','Boy','/resources/img/Boy.jpg','/resources/song/Boy.mp3'),(30,'Love Lies','SONY music','Khalid','2018-02-16','Love Lies','/resources/img/Love Lies.jpg','/resources/song/Love Lies.mp3');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-25 13:40:41
