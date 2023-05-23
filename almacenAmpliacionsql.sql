-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema almacen
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema almacen
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `almacen` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `almacen` ;

-- -----------------------------------------------------
-- Table `almacen`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `almacen`.`categoria_SEQ`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`categoria_SEQ` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `almacen`.`oferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`oferta` (
  `idoferta` INT NOT NULL AUTO_INCREMENT,
  `oferta` DOUBLE NOT NULL,
  PRIMARY KEY (`idoferta`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `almacen`.`oferta_SEQ`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`oferta_SEQ` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `almacen`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `existencias` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  `fecha_caducidad` DATE NOT NULL,
  `oferta_idoferta` INT NOT NULL,
  PRIMARY KEY (`idproducto`),
  INDEX `fk_producto_categoria_idx` (`categoria_id` ASC) VISIBLE,
  INDEX `FKq4xu6pr5eb7q7juirmleim5gi` (`oferta_idoferta` ASC) VISIBLE,
  CONSTRAINT `fk_producto_categoria`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `almacen`.`categoria` (`id`),
  CONSTRAINT `FKq4xu6pr5eb7q7juirmleim5gi`
    FOREIGN KEY (`oferta_idoferta`)
    REFERENCES `almacen`.`oferta` (`idoferta`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `almacen`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `localizacion` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` VARCHAR(45) NOT NULL,
  `fecha_inicio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`pedidoVenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`pedidoVenta` (
  `idpedidoVenta` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idpedidoVenta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `almacen`.`detalle_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `almacen`.`detalle_venta` (
  `iddetalle_venta` INT NOT NULL AUTO_INCREMENT,
  `precio` FLOAT NOT NULL,
  `cantidad` INT NOT NULL,
    `nombreProveedor` INT NOT NULL,
  `producto_idproducto` INT NOT NULL,
  `pedidoVenta_idpedidoVenta` INT NOT NULL,
  PRIMARY KEY (`iddetalle_venta`, `producto_idproducto`, `pedidoVenta_idpedidoVenta`),
  INDEX `fk_detalle_venta_producto1_idx` (`producto_idproducto` ASC) VISIBLE,
  INDEX `fk_detalle_venta_pedidoVenta1_idx` (`pedidoVenta_idpedidoVenta` ASC) VISIBLE,
  CONSTRAINT `fk_detalle_venta_producto1`
    FOREIGN KEY (`producto_idproducto`)
    REFERENCES `almacen`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_pedidoVenta1`
    FOREIGN KEY (`pedidoVenta_idpedidoVenta`)
    REFERENCES `almacen`.`pedidoVenta` (`idpedidoVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
ALTER TABLE `almacen`.`detalle_venta` 
DROP FOREIGN KEY `fk_detalle_venta_producto1`;
ALTER TABLE `almacen`.`detalle_venta` 
ADD CONSTRAINT `fk_detalle_venta_producto1`
  FOREIGN KEY (`producto_idproducto`)
  REFERENCES `almacen`.`producto` (`idproducto`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

INSERT INTO `oferta` (`idoferta`, `oferta`) VALUES
(1,1),
(2,0.05),
(3,0.1),
(4,0.15),
(5,0.2),
(6,0.25),
(7,0.3),
(8,0.35),
(9,0.4),
(10,0.45),
(11,0.5),
(12,0.55),
(13,0.6),
(14,0.65),
(15,0.7),
(16,0.75);

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Bebidas'),
(2, 'Condimentos'),
(3, 'Repostería'),
(4, 'Huevos y Lácteos'),
(5, 'Granos y Cereales'),
(6, 'Carnes'),
(7, 'Frutas y Verduras'),
(8, 'Pescado y Marisco'),
(9, 'Congelados'),
(10, 'Limpieza');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
