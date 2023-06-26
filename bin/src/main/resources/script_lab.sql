CREATE DATABASE `laboratoriosql` /*!40100 DEFAULT CHARACTER SET latin1 */;

-- laboratoriosql.acceso definition

CREATE TABLE `acceso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- laboratoriosql.consulta definition

CREATE TABLE `consulta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idproblema` int(11) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `explicacion` text DEFAULT NULL,
  `solucion` text DEFAULT NULL,
  `explicsolucion` text DEFAULT NULL,
  `solucionalternativa` text DEFAULT NULL,
  `numpracticas` int(11) DEFAULT NULL COMMENT 'Define el numero de veces que se puede hacer practicas de la consulta antes de ejecutarla finalmente',
  `estado` int(11) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `IXFK_consulta_problema` (`idproblema`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- laboratoriosql.examen definition

CREATE TABLE `examen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `fechainicio` timestamp NOT NULL DEFAULT current_timestamp(),
  `fechafin` timestamp NOT NULL DEFAULT current_timestamp(),
  `problema` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `examen_problema_fk` (`problema`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- laboratoriosql.finalsql definition

CREATE TABLE `finalsql` (
  `usuario` varchar(20) DEFAULT NULL,
  `idconsulta` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ssql` text DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp(),
  `resultado` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_final_consulta` (`idconsulta`) USING BTREE,
  KEY `IXFK_final_usuario` (`usuario`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- laboratoriosql.opcion definition

CREATE TABLE `opcion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `consulta` int(11) NOT NULL,
  `examen` int(11) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `opcion_consulta_fk` (`consulta`) USING BTREE,
  KEY `opcion_examen_fk` (`examen`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- laboratoriosql.practica definition

CREATE TABLE `practica` (
  `usuario` int(11) DEFAULT NULL,
  `idconsulta` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ssql` text DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp(),
  `resultado` text DEFAULT NULL,
  `estado` int(1) DEFAULT 0,
  `ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_practica_consulta` (`idconsulta`) USING BTREE,
  KEY `IXFK_practica_usuario` (`usuario`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- laboratoriosql.problema definition

CREATE TABLE `problema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `docente` varchar(50) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `nombrebase` varchar(50) DEFAULT NULL COMMENT 'Almacena el nombre en la base de datos de MySQL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- laboratoriosql.rol definition

CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- laboratoriosql.tabla definition

CREATE TABLE `tabla` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `idproblema` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_tabla_problema` (`idproblema`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena la información de las tablas, el diccionario de datos de información de las mismas';


-- laboratoriosql.usuario definition

CREATE TABLE `usuario` (
  `usuario` varchar(20) NOT NULL COMMENT 'Guarda información del usuario con el cual accede al sistema',
  `nombre` varchar(50) DEFAULT NULL COMMENT 'Almacena información del nombre del usuario',
  `clave` varchar(100) DEFAULT NULL COMMENT 'Almacena la clave del usuario',
  `email` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Almacena información de los usuarios que pueden utilizar el sistema';


-- laboratoriosql.usuariorol definition

CREATE TABLE `usuariorol` (
  `rol` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`rol`,`usuario`),
  KEY `IXFK_usuariorol_rol` (`rol`) USING BTREE,
  KEY `IXFK_usuariorol_usuario` (`usuario`) USING BTREE,
  CONSTRAINT `usuariorol_FK` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuariorol_FK_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;