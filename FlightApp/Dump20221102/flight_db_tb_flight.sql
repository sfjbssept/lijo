CREATE DATABASE  IF NOT EXISTS `flight_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flight_db`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: flight_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `tb_flight`
--

DROP TABLE IF EXISTS `tb_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_flight` (
  `id` int NOT NULL AUTO_INCREMENT,
  `flight_code` varchar(100) DEFAULT NULL,
  `no_of_rows` int DEFAULT NULL,
  `business_class_seats` int DEFAULT NULL,
  `economy_class_seats` int DEFAULT NULL,
  `airline_id` int DEFAULT NULL,
  `aircraft_model` varchar(100) DEFAULT NULL,
  `scheduled_days` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `international_service` tinyint DEFAULT '1',
  `domestic_service` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `airline_id_idx` (`airline_id`),
  CONSTRAINT `airline_id` FOREIGN KEY (`airline_id`) REFERENCES `tb_airline` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_flight`
--

LOCK TABLES `tb_flight` WRITE;
/*!40000 ALTER TABLE `tb_flight` DISABLE KEYS */;
INSERT INTO `tb_flight` VALUES (3,'456',26,24,120,6,'Boeing 737','DAILY','active',1,1),(5,'8186',21,24,90,6,'Boeing 737','DAILY','active',1,1),(6,'8187',21,24,90,6,'Airbus A322','DAILY','active',1,0),(7,'569',21,24,90,10,'Boeing 777','DAILY','active',1,0),(8,'101',20,20,90,9,'Boeing 787','DAILY','active',1,0),(15,'1234',25,20,120,6,'AirBus 360','DAILY','active',1,1),(17,'3421',25,20,120,6,'AirBus 360','DAILY','active',1,1),(19,'7897',25,20,120,6,'AirBus 360','DAILY','active',1,1),(20,'3456',25,20,120,6,'AirBus 360','DAILY','active',1,1),(21,'3422',24,40,70,9,'Boeing 567','DAILY','active',1,1),(33,'6543',12,22,22,10,'AirBus 360','DAILY','active',1,1),(34,'3455',25,40,120,9,'Boeing 777','DAILY','active',1,1),(35,'2342',25,40,120,8,'Boeing 777','DAILY','active',1,1),(36,'3453',30,40,120,10,'AirBus 360','DAILY','active',1,1),(37,'787625',25,20,120,6,'Boeing 777','DAILY','active',1,1),(38,'33',21,3,3,6,'33','DAILY','active',1,1);
/*!40000 ALTER TABLE `tb_flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-02 16:53:09
