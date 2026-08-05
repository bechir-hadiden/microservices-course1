CREATE TABLE `t_doctor`
(
    `id`             bigint(20)   NOT NULL AUTO_INCREMENT,
    `first_name`     varchar(255) DEFAULT NULL,
    `last_name`      varchar(255) DEFAULT NULL,
    `speciality`     varchar(255) DEFAULT NULL,
    `license_number` varchar(255) DEFAULT NULL,
    `phone_number`   varchar(255) DEFAULT NULL,
    `available`      boolean      DEFAULT TRUE,
    PRIMARY KEY (`id`)
);
