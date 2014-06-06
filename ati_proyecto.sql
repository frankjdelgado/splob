-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.35-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para ati_proyecto
CREATE DATABASE IF NOT EXISTS `ati_proyecto` /*!40100 DEFAULT CHARACTER SET utf32 */;
USE `ati_proyecto`;


-- Volcando estructura para tabla ati_proyecto.t_categoria
CREATE TABLE IF NOT EXISTS `t_categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id del hasgtag',
  `hashtag` varchar(255) DEFAULT '' COMMENT 'hashtag',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- Volcando datos para la tabla ati_proyecto.t_categoria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `t_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_categoria` ENABLE KEYS */;


-- Volcando estructura para tabla ati_proyecto.t_equipo
CREATE TABLE IF NOT EXISTS `t_equipo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id del equipo',
  `nombre` varchar(255) DEFAULT '' COMMENT 'nombre del equipo',
  `pais` varchar(200) DEFAULT '' COMMENT 'pais del equipo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf32;

-- Volcando datos para la tabla ati_proyecto.t_equipo: ~32 rows (aproximadamente)
/*!40000 ALTER TABLE `t_equipo` DISABLE KEYS */;
INSERT INTO `t_equipo` (`id`, `nombre`, `pais`) VALUES
	(1, '', 'Brasil'),
	(2, '', 'Argentina'),
	(3, '', 'Colombia'),
	(4, '', 'Uruguay'),
	(5, '', 'Belgica'),
	(6, '', 'Alemania'),
	(7, '', 'España'),
	(8, '', 'Suiza'),
	(9, '', 'Algeria'),
	(10, '', 'Camerun'),
	(11, '', 'Costa de Marfil'),
	(12, '', 'Ghana'),
	(13, '', 'Nigeria'),
	(14, '', 'Chile'),
	(15, '', 'Ecuador'),
	(16, '', 'Australia'),
	(17, '', 'Japon'),
	(18, '', 'Iran'),
	(19, '', 'Korea del Sur'),
	(20, '', 'Costa Rica'),
	(21, '', 'Honduras'),
	(22, '', 'México'),
	(23, '', 'Estados Unidos'),
	(24, '', 'Boznia y Herzegovina'),
	(25, '', 'Croacia'),
	(26, '', 'Inglaterra'),
	(27, '', 'Francia'),
	(28, '', 'Grecia'),
	(29, '', 'Italia'),
	(30, '', 'Holanda'),
	(31, '', 'Portugal'),
	(32, '', 'Rusia');
/*!40000 ALTER TABLE `t_equipo` ENABLE KEYS */;


-- Volcando estructura para tabla ati_proyecto.t_post
CREATE TABLE IF NOT EXISTS `t_post` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id del post',
  `imagen` varchar(1024) DEFAULT NULL COMMENT 'ubicacion del archivo',
  `contenido` varchar(255) DEFAULT NULL COMMENT 'contenido del psot',
  `tipo` bit(1) DEFAULT NULL COMMENT 'indicador de si es un evento',
  `fecha_creacion` datetime DEFAULT NULL COMMENT 'fecha de creacion',
  `fecha_calendario` datetime DEFAULT NULL COMMENT 'fecha de  inicio',
  `usuario` int(10) unsigned DEFAULT NULL COMMENT 'usuario que creo el post',
  PRIMARY KEY (`id`),
  KEY `usuario_post_id` (`usuario`),
  CONSTRAINT `usuario_post_id` FOREIGN KEY (`usuario`) REFERENCES `t_usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf32;

-- Volcando datos para la tabla ati_proyecto.t_post: ~18 rows (aproximadamente)
/*!40000 ALTER TABLE `t_post` DISABLE KEYS */;
INSERT INTO `t_post` (`id`, `imagen`, `contenido`, `tipo`, `fecha_creacion`, `fecha_calendario`, `usuario`) VALUES
	(1, NULL, 'asdfasdf', b'00000000', '2014-06-03 20:30:18', NULL, 5),
	(2, 'pentakill.jpg', 'contenido 2, ahora con imagen', b'00000000', '2014-06-03 20:35:57', NULL, 5),
	(3, 'pentakill.jpg', 'asdf', b'00000000', '2014-06-03 21:59:45', NULL, 5),
	(4, 'bg_champion_zed_1920x1080.jpg', 'asdfa asdf as', b'00000000', '2014-06-03 21:59:52', NULL, 5),
	(5, 'shadow_isles_1920x1080.jpg', 'asdf', b'10000000', '2014-06-03 23:55:19', '2014-06-03 00:00:00', 5),
	(6, NULL, 'asdf2', b'10000000', '2014-06-04 00:00:47', '2014-06-02 00:00:00', 5),
	(7, 'bg_champion_mordekaiser_1920x1080.jpg', 'otro', b'10000000', '2014-06-04 00:21:14', '2014-06-04 00:00:00', 5),
	(8, NULL, 'asdfasdfasdf', b'10000000', '2014-06-04 00:29:06', '2014-06-04 00:00:00', 5),
	(10, NULL, 'prueba final si no estamos jodidos', b'10000000', '2014-06-04 00:37:42', '2014-06-04 00:00:00', 5),
	(11, NULL, 'tendremos json?', b'10000000', '2014-06-04 00:56:07', '2014-06-04 00:00:00', 5),
	(12, NULL, 'asdf', b'10000000', '2014-06-04 01:11:49', '2014-06-04 00:00:00', 5),
	(13, NULL, 'ble ble', b'00000000', '2014-06-04 12:49:39', NULL, 5),
	(14, NULL, 'ble ble', b'00000000', '2014-06-04 12:49:39', NULL, 5),
	(15, NULL, 'bla bla bla bla ', b'00000000', '2014-06-04 12:52:25', NULL, 5),
	(16, NULL, 'con ususario', b'00000000', '2014-06-04 19:56:21', NULL, 5),
	(17, NULL, 'otra vez con usuario', b'00000000', '2014-06-04 20:01:03', NULL, 5),
	(18, NULL, 'sera la buena?', b'00000000', '2014-06-04 20:05:03', NULL, 5),
	(19, 'bg_champion_mordekaiser_1920x1080.jpg', ' sadfasdfsafd', b'00000000', '2014-06-04 20:11:45', NULL, 5);
/*!40000 ALTER TABLE `t_post` ENABLE KEYS */;


-- Volcando estructura para tabla ati_proyecto.t_post_categoria
CREATE TABLE IF NOT EXISTS `t_post_categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'un id',
  `post` int(10) unsigned DEFAULT NULL COMMENT 'id del  post',
  `categoria` int(10) unsigned DEFAULT NULL COMMENT 'id de la categoria',
  PRIMARY KEY (`id`),
  KEY `categoria_id` (`categoria`),
  KEY `post_id` (`post`),
  CONSTRAINT `categoria_id` FOREIGN KEY (`categoria`) REFERENCES `t_categoria` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `post_id` FOREIGN KEY (`post`) REFERENCES `t_post` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COMMENT='tabla intermedia entre post y  categoria';

-- Volcando datos para la tabla ati_proyecto.t_post_categoria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `t_post_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_post_categoria` ENABLE KEYS */;


-- Volcando estructura para tabla ati_proyecto.t_usuario
CREATE TABLE IF NOT EXISTS `t_usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `alias` varchar(64) DEFAULT '' COMMENT 'alias del usuario',
  `password` varchar(64) DEFAULT '' COMMENT 'contraseña del usuario',
  `email` varchar(255) DEFAULT '' COMMENT 'email del usuario',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf32;

-- Volcando datos para la tabla ati_proyecto.t_usuario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `t_usuario` DISABLE KEYS */;
INSERT INTO `t_usuario` (`id`, `alias`, `password`, `email`) VALUES
	(5, 'marvin2', '8d969eef6ecad3c29a3a629280e686cf03f5d5a86aff3ca1200923adc6c92', 'marvin@asdf.com');
/*!40000 ALTER TABLE `t_usuario` ENABLE KEYS */;


-- Volcando estructura para tabla ati_proyecto.t_usuario_equipo
CREATE TABLE IF NOT EXISTS `t_usuario_equipo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'un id',
  `usuario` int(10) unsigned DEFAULT NULL COMMENT 'usuario que tiene un equipo favorito',
  `equipo` int(10) unsigned DEFAULT NULL COMMENT 'equipo favorito de un ususario',
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario`),
  KEY `equipo_id` (`equipo`),
  CONSTRAINT `equipo_id` FOREIGN KEY (`equipo`) REFERENCES `t_equipo` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `usuario_id` FOREIGN KEY (`usuario`) REFERENCES `t_usuario` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COMMENT='tabla intermedio entre usuario y equipo';

-- Volcando datos para la tabla ati_proyecto.t_usuario_equipo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `t_usuario_equipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_usuario_equipo` ENABLE KEYS */;


-- Volcando estructura para vista ati_proyecto.v_post_hashtag
/* Error de SQL (1356): View 'ati_proyecto.v_post_hashtag' references invalid table(s) or column(s) or function(s) or definer/invoker of view lack rights to use them */

-- Volcando estructura para vista ati_proyecto.v_post_hashtag
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `v_post_hashtag`;
CREATE DEFINER=`root`@`localhost` VIEW `ati_proyecto`.`v_post_hashtag` AS SELECT
t_post_categoria.id,
t_post.id AS post_id,
t_post.titulo,
t_post.contenido,
t_post.tipo,
t_post.fecha_creacion,
t_post.fecha_inicio,
t_post.fecha_fin,
t_post.usuario,
t_categoria.id AS hash_id,
t_categoria.hashtag
FROM
t_post
INNER JOIN t_post_categoria ON t_post_categoria.post = t_post.id
INNER JOIN t_categoria ON t_post_categoria.categoria = t_categoria.id
ORDER BY
t_post.fecha_creacion DESC ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
