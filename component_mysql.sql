CREATE TABLE `test`.`component` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(20) NOT NULL COMMENT '',
  `parent_id` INT NOT NULL DEFAULT -1 COMMENT '',
  `child_ids` VARCHAR(50) NULL COMMENT '',
  `arginfo` VARCHAR(100) NULL COMMENT '',
  `version` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)  COMMENT ''
)ENGINE InnoDB, CHARSET=utf8;