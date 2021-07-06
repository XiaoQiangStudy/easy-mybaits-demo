CREATE TABLE IF NOT EXISTS `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` tinyint unsigned DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `create_time` datetime DEFAULT current_timestamp COMMENT '电子邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;