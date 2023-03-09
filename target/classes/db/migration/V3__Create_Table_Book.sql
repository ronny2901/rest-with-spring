CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(80) NOT NULL,
  `launch_date` datetime(6) NOT NULL,
  `price` decimal(65,2) NOT NULL,
  `title` longtext,

  PRIMARY KEY (`id`)
)