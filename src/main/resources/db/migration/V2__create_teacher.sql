CREATE TABLE `teachers` (
  `id`          INT                     NOT NULL AUTO_INCREMENT,
  `version`     INT                     NOT NULL DEFAULT 0,
  `name`        VARCHAR(45)             NOT NULL,
  `age`         INT                     NOT NULL,
  `sex`         ENUM('MALE', 'FEMALE')  NOT NULL,
  `created`     TIMESTAMP               NOT NULL DEFAULT now(),
  `modified`    TIMESTAMP               NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));