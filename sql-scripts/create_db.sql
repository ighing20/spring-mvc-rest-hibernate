DROP SCHEMA IF EXISTS `db_clientes_crud`;

CREATE SCHEMA `db_clientes_crud`;

USE `db_clientes_crud`;

DROP TABLE IF EXISTS `clientes`;
 
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `segundo_nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;