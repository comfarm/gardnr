
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE `checklist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `checklist_category_id` bigint(20) DEFAULT NULL,
  `wiki_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9h6tnli25syndni226xgp652s` (`checklist_category_id`),
  KEY `FKef2l6cfldmgx6mmm7b0151l73` (`wiki_id`),
  CONSTRAINT `FK9h6tnli25syndni226xgp652s` FOREIGN KEY (`checklist_category_id`) REFERENCES `checklist_category` (`id`),
  CONSTRAINT `FKef2l6cfldmgx6mmm7b0151l73` FOREIGN KEY (`wiki_id`) REFERENCES `wiki` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `checklist_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  `image` text,
  `item_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKasph99xmslm0pmfyyc8ga2iyr` (`item_category_id`),
  CONSTRAINT `FKasph99xmslm0pmfyyc8ga2iyr` FOREIGN KEY (`item_category_id`) REFERENCES `item_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

CREATE TABLE `item_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `progress` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `progress_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `tanim_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgneiewrx04ip5gals5awhxy2k` (`tanim_id`),
  CONSTRAINT `FKgneiewrx04ip5gals5awhxy2k` FOREIGN KEY (`tanim_id`) REFERENCES `tanim` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `milestone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `dayNum` smallint(5) DEFAULT NULL,
  `wiki_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgneiewrx04ip5gals5awhxy2kd` (`wiki_id`),
  CONSTRAINT `FKgneiewrx04ip5gals5awhxy2kd` FOREIGN KEY (`wiki_id`) REFERENCES `wiki` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `steps` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `count_days` int(11) NOT NULL,
  `step_num` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `wiki_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdjwelcwavkrxmas9iam181fox` (`wiki_id`),
  CONSTRAINT `FKdjwelcwavkrxmas9iam181fox` FOREIGN KEY (`wiki_id`) REFERENCES `wiki` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `tanim` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user_tbl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `wiki` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS=1;