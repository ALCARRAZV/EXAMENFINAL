/*
SQLyog Community v8.71 
MySQL - 5.6.26 : Database - mascota
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mascota` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mascota`;

/*Table structure for table `atencion` */

DROP TABLE IF EXISTS `atencion`;

CREATE TABLE `atencion` (
  `idAtencion` int(11) NOT NULL,
  `fechaAtencion` date NOT NULL,
  `horaAtencion` time NOT NULL,
  `diagnostico` varchar(200) NOT NULL,
  `Personal_idPersonal` int(11) NOT NULL,
  `idMascota` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idAtencion`),
  KEY `fk_Atencion_Personal1_idx` (`Personal_idPersonal`),
  KEY `fk_Atencion_mascotaPorCliente1_idx` (`idMascota`,`idCliente`),
  CONSTRAINT `fk_Atencion_Personal1` FOREIGN KEY (`Personal_idPersonal`) REFERENCES `personal` (`idPersonal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atencion_mascotaPorCliente1` FOREIGN KEY (`idMascota`, `idCliente`) REFERENCES `mascotaporcliente` (`idMascota`, `idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `atencion` */

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fecha_naci` date NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` char(9) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

insert  into `cliente`(`idCliente`,`nombres`,`apellidos`,`fecha_naci`,`direccion`,`telefono`,`email`) values (1,'Kevin Ivan','Altamirano Hoyos','1999-05-29','urb. Gregorio Albarracin','935086978','ivan123altamirano@gmail.com'),(2,'Nathaly Iraida','De la Roca Tinoco','2000-09-27','av. Victor Malasquez','935086978','nathy.libra@gmail.com');

/*Table structure for table `mascota` */

DROP TABLE IF EXISTS `mascota`;

CREATE TABLE `mascota` (
  `idMascota` int(11) NOT NULL,
  `nombreMascota` varchar(45) NOT NULL,
  `nombreCliente` varchar(45) NOT NULL,
  `raza` varchar(45) NOT NULL,
  PRIMARY KEY (`idMascota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mascota` */

insert  into `mascota`(`idMascota`,`nombreMascota`,`nombreCliente`,`raza`) values (1,'Chimuelo','Kevin Altamirano','Pastor Aleman'),(2,'Lazzy','Nathaly de la roca','Pastor Aleman'),(3,'Michifu','Nathaly de la roca','Burmilla'),(4,'Crocki','Kevin Altamirano','Bodtail Americano'),(5,'Sandor','Joaquin Altamirano','Mini Lop');

/*Table structure for table `mascotaporcliente` */

DROP TABLE IF EXISTS `mascotaporcliente`;

CREATE TABLE `mascotaporcliente` (
  `idMascota` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `estado` char(1) NOT NULL,
  PRIMARY KEY (`idMascota`,`idCliente`),
  KEY `fk_cliente_has_mascota_mascota1_idx` (`idMascota`),
  KEY `fk_cliente_has_mascota_cliente_idx` (`idCliente`),
  CONSTRAINT `fk_cliente_has_mascota_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_mascota_mascota1` FOREIGN KEY (`idMascota`) REFERENCES `mascota` (`idMascota`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mascotaporcliente` */

/*Table structure for table `personal` */

DROP TABLE IF EXISTS `personal`;

CREATE TABLE `personal` (
  `idPersonal` int(11) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(80) NOT NULL,
  `dni` char(8) NOT NULL,
  `telefono` char(9) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`idPersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `personal` */

insert  into `personal`(`idPersonal`,`nombres`,`apellidos`,`dni`,`telefono`,`cargo`,`email`) values (1,'Kevin Ivan','Altamirano Hoyos','75821744','935086978','veterinario','ivan123altamirano@gmail.com'),(2,'Nathaly Iraida','De la Roca Tinoco','75821744','935086978','especialista veterinario','nathi.libra@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
