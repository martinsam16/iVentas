-- MySQL dump 10.16  Distrib 10.1.35-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: sistcomp
-- ------------------------------------------------------
-- Server version	10.1.35-MariaDB

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
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `CODDETVEN` int(11) NOT NULL,
  `PRODUCTO_CODPRO` int(11) NOT NULL,
  `VENTA_CODVEN` int(11) NOT NULL,
  `CANTPRODETVEN` int(11) NOT NULL,
  `DSCPRODETVEN` double(2,2) NOT NULL,
  `ESTDETVEN` char(1) NOT NULL,
  PRIMARY KEY (`CODDETVEN`),
  KEY `DETALLE_VENTA_PRODUCTO` (`PRODUCTO_CODPRO`),
  KEY `DETALLE_VENTA_VENTA` (`VENTA_CODVEN`),
  CONSTRAINT `DETALLE_VENTA_PRODUCTO` FOREIGN KEY (`PRODUCTO_CODPRO`) REFERENCES `producto` (`CODPRO`),
  CONSTRAINT `DETALLE_VENTA_VENTA` FOREIGN KEY (`VENTA_CODVEN`) REFERENCES `venta` (`CODVEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `CODLOG` int(11) NOT NULL AUTO_INCREMENT,
  `PERSONA_CODPER` int(11) NOT NULL,
  `USRLOG` varchar(30) NOT NULL,
  `PSWLOG` varchar(10) NOT NULL,
  `ESTLOG` char(1) NOT NULL,
  PRIMARY KEY (`CODLOG`),
  KEY `LOGIN_PERSONA` (`PERSONA_CODPER`),
  CONSTRAINT `LOGIN_PERSONA` FOREIGN KEY (`PERSONA_CODPER`) REFERENCES `persona` (`CODPER`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,1,'masa72','@72720455','A'),(2,2,'made12','@12121212','A'),(3,5,'in:v34','@34528750','A');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `CODMAR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMMAR` varchar(50) NOT NULL,
  PRIMARY KEY (`CODMAR`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'HP'),(2,'DELL'),(3,'SONY'),(4,'Apple'),(5,'NINTENDO'),(6,'DEMO'),(7,'LG'),(8,'GOOGLE'),(9,'SAMSUNG'),(10,'HALION');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `CODMOD` int(11) NOT NULL AUTO_INCREMENT,
  `NOMMOD` varchar(100) NOT NULL,
  `MARCA_CODMAR` int(11) NOT NULL,
  PRIMARY KEY (`CODMOD`),
  KEY `MODELO_MARCA` (`MARCA_CODMAR`),
  CONSTRAINT `MODELO_MARCA` FOREIGN KEY (`MARCA_CODMAR`) REFERENCES `marca` (`CODMAR`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'DESKTOP',1),(2,'VORTEX',1),(3,'THINKPAD 123',2),(4,'OPTIPLEX 360',2),(5,'GKL',3),(6,'IPHONE XR',4),(7,'SWATCH',4),(8,'SWITCH',5),(9,'OPTIPLEX 980',2),(10,'1',6),(11,'2',6),(12,'4',6),(13,'NEXUS',8),(14,'J200M',9),(15,'J700M',9),(16,'8',6),(17,'HA-968',10),(18,'JAVADAVABO',10);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `CODPER` int(11) NOT NULL AUTO_INCREMENT,
  `NOMPER` varchar(100) NOT NULL,
  `APEPER` varchar(100) NOT NULL,
  `DNIPER` char(8) NOT NULL,
  `TLFPER` char(12) NOT NULL,
  `TIPPER` char(1) NOT NULL COMMENT 'A - admin\nV - vendedor\nC - cliente',
  PRIMARY KEY (`CODPER`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Martín Alexis','Samán Arata','72720455','+51974091056','A'),(2,'María del Rosario','Delgado Revattaa','12121212','+51000000000','V'),(3,'Pedro','Suárez Vértiz','12345678','+51123456789','C'),(4,'Franchesco','Virgoliini','12341234','+34123432123','C'),(5,'Inventariador',':v','34528750','+12123456789','I');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `CODPRO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMPRO` varchar(200) NOT NULL,
  `MODELO_CODMOD` int(11) NOT NULL,
  `SERPRO` varchar(100) NOT NULL,
  `PREPRO` double(8,2) NOT NULL,
  `URLIMGPRO` varchar(300) NOT NULL,
  PRIMARY KEY (`CODPRO`),
  KEY `PRODUCTO_MODELO` (`MODELO_CODMOD`),
  CONSTRAINT `PRODUCTO_MODELO` FOREIGN KEY (`MODELO_CODMOD`) REFERENCES `modelo` (`CODMOD`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'USB TIPO C',2,'XXX-XXX-XXX',100.00,'PASA EL LINK PRRO'),(2,'TELEVISOR OLED 11p',5,'YYY-YYY-YYY',200.50,'LINK'),(3,'PC i5 4RAM',9,'XYZ-XZXX-LL-MKSO',1290.00,'https://www.blairtg.com/walmart-img/dell/980/PC-DELL-980-D_LCD-KM.jpg');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `CODVEN` int(11) NOT NULL AUTO_INCREMENT,
  `CODPERCOMVEN` int(11) NOT NULL,
  `CODPERVENVEN` int(11) NOT NULL,
  `FECVEN` date NOT NULL,
  `HOVEN` int(11) NOT NULL,
  PRIMARY KEY (`CODVEN`),
  KEY `VENTA_PERSONA_CODPERCOMVE` (`CODPERCOMVEN`),
  KEY `VENTA_PERSONA_CODPERVENVE` (`CODPERVENVEN`),
  CONSTRAINT `VENTA_PERSONA_CODPERCOMVE` FOREIGN KEY (`CODPERCOMVEN`) REFERENCES `persona` (`CODPER`),
  CONSTRAINT `VENTA_PERSONA_CODPERVENVE` FOREIGN KEY (`CODPERVENVEN`) REFERENCES `persona` (`CODPER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-06 15:18:34
