CREATE DATABASE  IF NOT EXISTS `fogcarport` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fogcarport`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: fogcarport
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `carport`
--

DROP TABLE IF EXISTS `carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carport` (
  `carportid` int(11) NOT NULL AUTO_INCREMENT,
  `carportName` varchar(45) NOT NULL,
  `roofType` varchar(45) NOT NULL,
  `roofShape` varchar(45) NOT NULL,
  PRIMARY KEY (`carportid`),
  UNIQUE KEY `carportid_UNIQUE` (`carportid`),
  UNIQUE KEY `carportName_UNIQUE` (`carportName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
INSERT INTO `carport` VALUES (1,'enkelt rejset tag','rejset','betonsten'),(2,'enkelt flat tag','flat','plasttrapez'),(3,'enkest rejset tag med skur','rejset','betonsten'),(4,'enktelt flat tag med skur','flat','plasttrapez');
/*!40000 ALTER TABLE `carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`customerid`),
  UNIQUE KEY `customerid_UNIQUE` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Jesper Jespersen','1234','kunde@somewhere.com','customer'),(2,'Mads Madsen','1234','admin@somewhere.com','employee'),(3,'Henrik Henriksen','1234','henrik@somewhere.com','customer'),(4,'Casper Caspersen','1234','casper@somewhere.com','customer');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemlist`
--

DROP TABLE IF EXISTS `itemlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemlist` (
  `orderid` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  KEY `orderid_idx` (`orderid`),
  KEY `itemid_idx` (`itemid`),
  CONSTRAINT `itemid` FOREIGN KEY (`itemid`) REFERENCES `items` (`itemid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderid` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemlist`
--

LOCK TABLES `itemlist` WRITE;
/*!40000 ALTER TABLE `itemlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'97x97mm. trykimp. Stolpe','stk',50,'Stolper nedgraves 90cm i jord'),(2,'25x200mm. trykimp. Brædt','stk',15,NULL),(3,'25x125mm. trykimp. Brædt','stk',10,NULL),(4,'38x73mm. Lægte ubh.','stk',10,NULL),(5,'45x195mm. spærtræ ubh.','stk',15,'Spær, monteres på rem'),(6,'19x100mm. trykimp. Brædt','stk',10,NULL),(7,'Plastmo Ecolite blåtonet','stk',40,'Tagplader monteres på spær'),(8,'Plastmo bundskruer 200stk','pakke',30,'Skruer til tagplader'),(9,'Hulbånd 1x20mm. 10meter','rulle',50,'Til vindkryds på spær'),(10,'Universalbeslag 190mm. højre','stk',15,'Til montering af spær på rem'),(11,'Universalbeslag 190mm. venstre','stk',15,'Til montering af spær på rem'),(12,'4,5x60mm. skruer 200stk','pakke',30,'Til montering af stern og vandbrædt'),(13,'4,0x50mm. beslagskruer 250stk','pakke',40,'Til montering af universalbeslag og hulbånd'),(14,'Bræddebolt 10x120mm.','stk',15,'Til montering af rem på stolper'),(15,'Firkantskiver 40x40x10mm.','stk',20,'Til montering af rem på stolper'),(16,'4,5x70mm. skruer 400stk','pakke',40,'Til montering af yderste beklædning'),(17,'4,5x50mm. skruer 300stk','pakke',40,'Til montering af yderste beklædning'),(18,'Stalddørsgreb 50x75','sæt',20,'Til lås på dør i skur'),(19,'T-Hængsel 390mm.','stk',20,'Til skurdør'),(20,'Vinkelbeslag 35','stk',15,'Til montering af løsholter i skur');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `Height` int(11) NOT NULL,
  `Length` int(11) NOT NULL,
  `Width` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`orderid`),
  UNIQUE KEY `orderid_UNIQUE` (`orderid`),
  KEY `customerid_idx` (`customerid`),
  CONSTRAINT `customerid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (12,1,250,700,300,'2018-05-08'),(15,1,250,700,400,'2018-05-08'),(16,1,250,700,400,'2018-05-08'),(17,1,250,600,400,'2018-05-09'),(18,1,250,700,400,'2018-05-09'),(19,1,250,500,300,'2018-05-12'),(20,1,250,600,300,'2018-05-12'),(21,1,250,700,400,'2018-05-12'),(22,1,250,500,300,'2018-05-12'),(23,1,250,600,300,'2018-05-12'),(24,1,250,700,400,'2018-05-12'),(25,1,250,500,300,'2018-05-12'),(26,1,250,600,300,'2018-05-12'),(27,1,250,700,400,'2018-05-12'),(28,1,250,500,300,'2018-05-12'),(29,1,250,600,300,'2018-05-12'),(30,1,250,700,400,'2018-05-12'),(31,1,250,500,300,'2018-05-12'),(32,1,250,700,400,'2018-05-12'),(33,1,250,600,300,'2018-05-12'),(34,1,250,500,300,'2018-05-12'),(35,1,250,700,400,'2018-05-13'),(36,4,250,500,300,'2018-05-13'),(37,4,250,700,400,'2018-05-13'),(38,4,250,600,300,'2018-05-13'),(39,4,250,500,300,'2018-05-13'),(40,3,250,700,400,'2018-05-13'),(41,3,250,600,400,'2018-05-13'),(42,3,250,500,300,'2018-05-13'),(43,3,250,700,400,'2018-05-13'),(44,1,250,500,300,'2018-05-14');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standardcarport`
--

DROP TABLE IF EXISTS `standardcarport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standardcarport` (
  `stdcarportid` int(11) NOT NULL AUTO_INCREMENT,
  `heigth` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `stddescription` text,
  PRIMARY KEY (`stdcarportid`),
  UNIQUE KEY `idstandardcarport_UNIQUE` (`stdcarportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standardcarport`
--

LOCK TABLES `standardcarport` WRITE;
/*!40000 ALTER TABLE `standardcarport` DISABLE KEYS */;
/*!40000 ALTER TABLE `standardcarport` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-14 17:13:19
