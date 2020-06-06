CREATE TABLE IF NOT EXISTS `blogs` (
   `id` INT UNSIGNED AUTO_INCREMENT,
   `article_id` INT,
   `create_time` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `articles` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `content` VARCHAR(1000),
    `create_time` DATE,
    `views` INT,
    PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;