-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: kinetic_fitness
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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `CLIENT_NUMBER` int(11) DEFAULT NULL,
  `LAST_NAME` text,
  `FIRST_NAME` text,
  `STREET1` text,
  `STREET2` text,
  `CITY` text,
  `STATE` text,
  `ZIP` text,
  `MEMBERSHIP_TIER` int(11) DEFAULT NULL,
  `PROMOTIONAL_NUMBER` int(11) DEFAULT NULL,
  `CLASSES_TAKEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Anderson','Aaron','100 1st St','Apt 1','Amber','AL','11111',1,0,4),(2,'Brink','Bella','22 2nd Ave','NULL','Becham','IA','22222',4,2,30),(3,'Clinton','Christine','3 3rd St','Lot 3','Creek Crack','CA','33333-3333',2,1,18),(4,'Drake','Dillan','404 4th Ct','NULL','Dover','DE','44444',1,1,10),(5,'Eleanor','Eli','5000 5th Pl','NULL','Earhart','FL','55555',3,0,14),(6,'Fresh','Forrest','6 6th Cr','#6','Farley','FL','66666-6666',4,0,20),(7,'Garner','Gail','777 7th Dr','NULL','Glow','GA','77777',2,0,0),(8,'Harris','Helen','88 8th Ave','Bldg 8','Harley','HI','88888',3,2,16);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membership` (
  `MEMBERSHIP_TIER` int(11) DEFAULT NULL,
  `NAME` text,
  `PRICE` int(11) DEFAULT NULL,
  `CLASSES_PER_MONTH` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
INSERT INTO `membership` VALUES (1,'Warm-Up',54,4),(2,'Steady Beat',120,10),(3,'High Tempo',168,16),(4,'Ultimate Adrenaline',200,54);
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotions`
--

DROP TABLE IF EXISTS `promotions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotions` (
  `PROMOTIONAL_NUMBER` int(11) DEFAULT NULL,
  `NAME` text,
  `PERCENT_DISCOUNT` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotions`
--

LOCK TABLES `promotions` WRITE;
/*!40000 ALTER TABLE `promotions` DISABLE KEYS */;
INSERT INTO `promotions` VALUES (0,'No Discount',0),(1,'New Student Discount',0.25),(2,'Referral Discount',0.25);
/*!40000 ALTER TABLE `promotions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-29 21:21:36
