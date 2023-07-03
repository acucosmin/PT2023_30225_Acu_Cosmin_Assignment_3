CREATE TABLE `schooldb`.`client` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `age` INT NOT NULL,
    `adress` VARCHAR(45)NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `schooldb`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `supply` INT NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `schooldb`.`invoice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idclient` INT NOT NULL,
  `idproduct` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`idclient`) REFERENCES `client`(`id`),
  FOREIGN KEY (`idproduct`) REFERENCES `product`(`id`)
);

INSERT INTO `schooldb`.`client` (`id`, `name`, `age`, `adress`)
VALUES (1, 'John Smith', 35, '123 Main St'),
	   (2, 'Jane Doe', 27, '456 Park Ave'), 
       (3, 'Bob Johnson', 42, '789 5th St');
       
INSERT INTO `schooldb`.`product` (`id`, `name`, `price`, `supply`)
VALUES (1, 'Soap', 3, 200), 
       (2, 'Toothpaste', 2, 150),
       (3, 'Razor', 10, 50);
       
INSERT INTO `schooldb`.`invoice` (`id`, `idclient`, `idproduct`, `quantity`)
VALUES (1, 1, 1, 2),
	   (2, 1, 3, 15),
	   (3, 3, 2, 4);


