-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_lineablanca
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_articulo`
--

DROP TABLE IF EXISTS `t_articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_articulo` (
  `id_art` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `precio` float NOT NULL,
  `marca` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`id_art`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_articulo`
--

LOCK TABLES `t_articulo` WRITE;
/*!40000 ALTER TABLE `t_articulo` DISABLE KEYS */;
INSERT INTO `t_articulo` VALUES (1,'Cocina Ind','Cocina con energia electrica',5,1,25,'Indurama','cocina');
/*!40000 ALTER TABLE `t_articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cliente`
--

DROP TABLE IF EXISTS `t_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cliente`
--

LOCK TABLES `t_cliente` WRITE;
/*!40000 ALTER TABLE `t_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cotizacion`
--

DROP TABLE IF EXISTS `t_cotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_cotizacion` (
  `id_cot` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `valor` float NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  PRIMARY KEY (`id_cot`),
  KEY `id_articulo` (`id_articulo`),
  KEY `id_clienteC` (`id_cliente`),
  KEY `id_usuarioC` (`id_usuario`),
  CONSTRAINT `id_articulo` FOREIGN KEY (`id_articulo`) REFERENCES `t_articulo` (`id_art`),
  CONSTRAINT `id_clienteC` FOREIGN KEY (`id_cliente`) REFERENCES `t_cliente` (`id_cliente`),
  CONSTRAINT `id_usuarioC` FOREIGN KEY (`id_usuario`) REFERENCES `t_usuario` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cotizacion`
--

LOCK TABLES `t_cotizacion` WRITE;
/*!40000 ALTER TABLE `t_cotizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_local`
--

DROP TABLE IF EXISTS `t_local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_local` (
  `id_local` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `internet` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_local`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_local`
--

LOCK TABLES `t_local` WRITE;
/*!40000 ALTER TABLE `t_local` DISABLE KEYS */;
INSERT INTO `t_local` VALUES (1,'Centro','2030123',0);
/*!40000 ALTER TABLE `t_local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pagocredito`
--

DROP TABLE IF EXISTS `t_pagocredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_pagocredito` (
  `id_pagoc` int(11) NOT NULL AUTO_INCREMENT,
  `subtotal` float NOT NULL,
  `impuesto` float NOT NULL,
  `nomtarjeta` varchar(50) DEFAULT NULL,
  `numtarjeta` varchar(50) NOT NULL,
  `fechaexp` date NOT NULL,
  PRIMARY KEY (`id_pagoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pagocredito`
--

LOCK TABLES `t_pagocredito` WRITE;
/*!40000 ALTER TABLE `t_pagocredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pagocredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pagoefectivo`
--

DROP TABLE IF EXISTS `t_pagoefectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_pagoefectivo` (
  `id_pagoc` int(11) NOT NULL AUTO_INCREMENT,
  `subtotal` float NOT NULL,
  `impuesto` float NOT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`id_pagoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pagoefectivo`
--

LOCK TABLES `t_pagoefectivo` WRITE;
/*!40000 ALTER TABLE `t_pagoefectivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pagoefectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_usuario`
--

DROP TABLE IF EXISTS `t_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_usuario` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `esSuper` tinyint(1) DEFAULT NULL,
  `id_local` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_localU` (`id_local`),
  CONSTRAINT `id_localU` FOREIGN KEY (`id_local`) REFERENCES `t_local` (`id_local`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_usuario`
--

LOCK TABLES `t_usuario` WRITE;
/*!40000 ALTER TABLE `t_usuario` DISABLE KEYS */;
INSERT INTO `t_usuario` VALUES (2,'Emilio','Moran','1997-06-04','0912345678','Norte','emilio@gmail.com','emilio','emilio','v',0,1);
/*!40000 ALTER TABLE `t_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_venta`
--

DROP TABLE IF EXISTS `t_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL,
  `fecha` date NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_articulo` int(11) NOT NULL,
  `id_pagoE` int(11) DEFAULT NULL,
  `id_pagoC` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_articuloV` (`id_articulo`),
  KEY `id_clienteV` (`id_cliente`),
  KEY `id_pagoCV` (`id_pagoC`),
  KEY `id_pagoEV` (`id_pagoE`),
  KEY `id_usuarioV` (`id_usuario`),
  CONSTRAINT `id_articuloV` FOREIGN KEY (`id_articulo`) REFERENCES `t_articulo` (`id_art`),
  CONSTRAINT `id_clienteV` FOREIGN KEY (`id_cliente`) REFERENCES `t_cliente` (`id_cliente`),
  CONSTRAINT `id_pagoCV` FOREIGN KEY (`id_pagoC`) REFERENCES `t_pagocredito` (`id_pagoc`),
  CONSTRAINT `id_pagoEV` FOREIGN KEY (`id_pagoE`) REFERENCES `t_pagoefectivo` (`id_pagoc`),
  CONSTRAINT `id_usuarioV` FOREIGN KEY (`id_usuario`) REFERENCES `t_usuario` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_venta`
--

LOCK TABLES `t_venta` WRITE;
/*!40000 ALTER TABLE `t_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-21 20:53:05
