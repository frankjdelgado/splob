/*
Navicat MySQL Data Transfer

Source Server         : PinzonDB
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : ati_proyecto

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2014-06-05 12:05:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_categoria
-- ----------------------------
DROP TABLE IF EXISTS `t_categoria`;
CREATE TABLE `t_categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id del hasgtag',
  `hashtag` varchar(255) DEFAULT '' COMMENT 'hashtag',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- ----------------------------
-- Records of t_categoria
-- ----------------------------

-- ----------------------------
-- Table structure for t_equipo
-- ----------------------------
DROP TABLE IF EXISTS `t_equipo`;
CREATE TABLE `t_equipo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id del equipo',
  `nombre` varchar(255) DEFAULT '' COMMENT 'nombre del equipo',
  `pais` varchar(200) DEFAULT '' COMMENT 'pais del equipo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf32;

-- ----------------------------
-- Records of t_equipo
-- ----------------------------
INSERT INTO `t_equipo` VALUES ('1', '', 'Brasil');
INSERT INTO `t_equipo` VALUES ('2', '', 'Argentina');
INSERT INTO `t_equipo` VALUES ('3', '', 'Colombia');
INSERT INTO `t_equipo` VALUES ('4', '', 'Uruguay');
INSERT INTO `t_equipo` VALUES ('5', '', 'Belgica');
INSERT INTO `t_equipo` VALUES ('6', '', 'Alemania');
INSERT INTO `t_equipo` VALUES ('7', '', 'España');
INSERT INTO `t_equipo` VALUES ('8', '', 'Suiza');
INSERT INTO `t_equipo` VALUES ('9', '', 'Algeria');
INSERT INTO `t_equipo` VALUES ('10', '', 'Camerun');
INSERT INTO `t_equipo` VALUES ('11', '', 'Costa de Marfil');
INSERT INTO `t_equipo` VALUES ('12', '', 'Ghana');
INSERT INTO `t_equipo` VALUES ('13', '', 'Nigeria');
INSERT INTO `t_equipo` VALUES ('14', '', 'Chile');
INSERT INTO `t_equipo` VALUES ('15', '', 'Ecuador');
INSERT INTO `t_equipo` VALUES ('16', '', 'Australia');
INSERT INTO `t_equipo` VALUES ('17', '', 'Japon');
INSERT INTO `t_equipo` VALUES ('18', '', 'Iran');
INSERT INTO `t_equipo` VALUES ('19', '', 'Korea del Sur');
INSERT INTO `t_equipo` VALUES ('20', '', 'Costa Rica');
INSERT INTO `t_equipo` VALUES ('21', '', 'Honduras');
INSERT INTO `t_equipo` VALUES ('22', '', 'México');
INSERT INTO `t_equipo` VALUES ('23', '', 'Estados Unidos');
INSERT INTO `t_equipo` VALUES ('24', '', 'Boznia y Herzegovina');
INSERT INTO `t_equipo` VALUES ('25', '', 'Croacia');
INSERT INTO `t_equipo` VALUES ('26', '', 'Inglaterra');
INSERT INTO `t_equipo` VALUES ('27', '', 'Francia');
INSERT INTO `t_equipo` VALUES ('28', '', 'Grecia');
INSERT INTO `t_equipo` VALUES ('29', '', 'Italia');
INSERT INTO `t_equipo` VALUES ('30', '', 'Holanda');
INSERT INTO `t_equipo` VALUES ('31', '', 'Portugal');
INSERT INTO `t_equipo` VALUES ('32', '', 'Rusia');

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post` (
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

-- ----------------------------
-- Records of t_post
-- ----------------------------
INSERT INTO `t_post` VALUES ('1', null, 'asdfasdf', '\0', '2014-06-03 20:30:18', null, '5');
INSERT INTO `t_post` VALUES ('2', 'pentakill.jpg', 'contenido 2, ahora con imagen', '\0', '2014-06-03 20:35:57', null, '5');
INSERT INTO `t_post` VALUES ('3', 'pentakill.jpg', 'asdf', '\0', '2014-06-03 21:59:45', null, '5');
INSERT INTO `t_post` VALUES ('4', 'bg_champion_zed_1920x1080.jpg', 'asdfa asdf as', '\0', '2014-06-03 21:59:52', null, '5');
INSERT INTO `t_post` VALUES ('5', 'shadow_isles_1920x1080.jpg', 'asdf', '', '2014-06-03 23:55:19', '2014-06-03 00:00:00', '5');
INSERT INTO `t_post` VALUES ('6', null, 'asdf2', '', '2014-06-04 00:00:47', '2014-06-02 00:00:00', '5');
INSERT INTO `t_post` VALUES ('7', 'bg_champion_mordekaiser_1920x1080.jpg', 'otro', '', '2014-06-04 00:21:14', '2014-06-04 00:00:00', '5');
INSERT INTO `t_post` VALUES ('8', null, 'asdfasdfasdf', '', '2014-06-04 00:29:06', '2014-06-04 00:00:00', '5');
INSERT INTO `t_post` VALUES ('10', null, 'prueba final si no estamos jodidos', '', '2014-06-04 00:37:42', '2014-06-04 00:00:00', '5');
INSERT INTO `t_post` VALUES ('11', null, 'tendremos json?', '', '2014-06-04 00:56:07', '2014-06-04 00:00:00', '5');
INSERT INTO `t_post` VALUES ('12', null, 'asdf', '', '2014-06-04 01:11:49', '2014-06-04 00:00:00', '5');
INSERT INTO `t_post` VALUES ('13', null, 'ble ble', '\0', '2014-06-04 12:49:39', null, '5');
INSERT INTO `t_post` VALUES ('14', null, 'ble ble', '\0', '2014-06-04 12:49:39', null, '5');
INSERT INTO `t_post` VALUES ('15', null, 'bla bla bla bla ', '\0', '2014-06-04 12:52:25', null, '5');
INSERT INTO `t_post` VALUES ('16', null, 'con ususario', '\0', '2014-06-04 19:56:21', null, '5');
INSERT INTO `t_post` VALUES ('17', null, 'otra vez con usuario', '\0', '2014-06-04 20:01:03', null, '5');
INSERT INTO `t_post` VALUES ('18', null, 'sera la buena?', '\0', '2014-06-04 20:05:03', null, '5');
INSERT INTO `t_post` VALUES ('19', 'bg_champion_mordekaiser_1920x1080.jpg', ' sadfasdfsafd', '\0', '2014-06-04 20:11:45', null, '5');

-- ----------------------------
-- Table structure for t_post_categoria
-- ----------------------------
DROP TABLE IF EXISTS `t_post_categoria`;
CREATE TABLE `t_post_categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'un id',
  `post` int(10) unsigned DEFAULT NULL COMMENT 'id del  post',
  `categoria` int(10) unsigned DEFAULT NULL COMMENT 'id de la categoria',
  PRIMARY KEY (`id`),
  KEY `categoria_id` (`categoria`),
  KEY `post_id` (`post`),
  CONSTRAINT `categoria_id` FOREIGN KEY (`categoria`) REFERENCES `t_categoria` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `post_id` FOREIGN KEY (`post`) REFERENCES `t_post` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COMMENT='tabla intermedia entre post y  categoria';

-- ----------------------------
-- Records of t_post_categoria
-- ----------------------------

-- ----------------------------
-- Table structure for t_usuario
-- ----------------------------
DROP TABLE IF EXISTS `t_usuario`;
CREATE TABLE `t_usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `alias` varchar(64) DEFAULT '' COMMENT 'alias del usuario',
  `password` varchar(64) DEFAULT '' COMMENT 'contraseña del usuario',
  `email` varchar(255) DEFAULT '' COMMENT 'email del usuario',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf32;

-- ----------------------------
-- Records of t_usuario
-- ----------------------------
INSERT INTO `t_usuario` VALUES ('5', 'marvin2', '8d969eef6ecad3c29a3a629280e686cf03f5d5a86aff3ca1200923adc6c92', 'marvin@asdf.com');

-- ----------------------------
-- Table structure for t_usuario_equipo
-- ----------------------------
DROP TABLE IF EXISTS `t_usuario_equipo`;
CREATE TABLE `t_usuario_equipo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'un id',
  `usuario` int(10) unsigned DEFAULT NULL COMMENT 'usuario que tiene un equipo favorito',
  `equipo` int(10) unsigned DEFAULT NULL COMMENT 'equipo favorito de un ususario',
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario`),
  KEY `equipo_id` (`equipo`),
  CONSTRAINT `equipo_id` FOREIGN KEY (`equipo`) REFERENCES `t_equipo` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `usuario_id` FOREIGN KEY (`usuario`) REFERENCES `t_usuario` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COMMENT='tabla intermedio entre usuario y equipo';

-- ----------------------------
-- Records of t_usuario_equipo
-- ----------------------------

-- ----------------------------
-- View structure for v_post_hashtag
-- ----------------------------
DROP VIEW IF EXISTS `v_post_hashtag`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_post_hashtag` AS SELECT
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
