-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pbl4
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pbl4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pbl4` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pbl4` ;

-- -----------------------------------------------------
-- Table `pbl4`.`_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_account` (
  `userName` VARCHAR(255) NOT NULL,
  `passWord` VARCHAR(100) NOT NULL,
  `decentralization` TINYINT(1) NOT NULL,
  PRIMARY KEY (`userName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_area` (
  `idArea` INT NOT NULL,
  `nameArea` VARCHAR(255) NOT NULL,
  `descr` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`idArea`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_client` (
  `idClient` INT NOT NULL,
  `nameClient` VARCHAR(50) NOT NULL,
  `mailManager` VARCHAR(255) NOT NULL,
  `idArea` INT NOT NULL,
  `lastTimeOnline` DATETIME NOT NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idClient`),
  INDEX `fk_mail_client_idx` (`mailManager` ASC) VISIBLE,
  INDEX `fk_client_area_idx` (`idArea` ASC) VISIBLE,
  CONSTRAINT `fk_client_area`
    FOREIGN KEY (`idArea`)
    REFERENCES `pbl4`.`_area` (`idArea`),
  CONSTRAINT `fk_mail_client`
    FOREIGN KEY (`mailManager`)
    REFERENCES `pbl4`.`_account` (`userName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_typegate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_typegate` (
  `idTypeGate` INT NOT NULL,
  `nameTypeGate` VARCHAR(50) NULL DEFAULT NULL,
  `descript` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idTypeGate`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`vendor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`vendor` (
  `idVendor` INT NOT NULL,
  `Name Vendor` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idVendor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_device` (
  `idDevice` INT NOT NULL,
  `nameDevice` VARCHAR(50) NOT NULL,
  `typeDevice` VARCHAR(50) NOT NULL,
  `typeGate` INT NOT NULL,
  `idVendor` INT NOT NULL,
  PRIMARY KEY (`idDevice`),
  INDEX `fk_vendor_idx` (`idVendor` ASC) VISIBLE,
  INDEX `fk_typeGate_idx` (`typeGate` ASC) VISIBLE,
  CONSTRAINT `fk_typeGate`
    FOREIGN KEY (`typeGate`)
    REFERENCES `pbl4`.`_typegate` (`idTypeGate`),
  CONSTRAINT `fk_vendor`
    FOREIGN KEY (`idVendor`)
    REFERENCES `pbl4`.`vendor` (`idVendor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_gate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_gate` (
  `idGate` INT NOT NULL,
  `idTypeGate` INT NOT NULL,
  `status` TINYINT(1) NOT NULL,
  `nameGate` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idGate`),
  INDEX `fk_gate_type_idx` (`idTypeGate` ASC) VISIBLE,
  CONSTRAINT `fk_gate_type`
    FOREIGN KEY (`idTypeGate`)
    REFERENCES `pbl4`.`_typegate` (`idTypeGate`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_connect`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_connect` (
  `idGate` INT NULL DEFAULT NULL,
  `idDevice` INT NOT NULL,
  `timeStart` DATETIME NOT NULL,
  `timeEnd` DATETIME NOT NULL,
  INDEX `fk_connect_device_idx` (`idDevice` ASC) VISIBLE,
  INDEX `fk_connect_gate_idx` (`idGate` ASC) VISIBLE,
  CONSTRAINT `fk_connect_device`
    FOREIGN KEY (`idDevice`)
    REFERENCES `pbl4`.`_device` (`idDevice`),
  CONSTRAINT `fk_connect_gate`
    FOREIGN KEY (`idGate`)
    REFERENCES `pbl4`.`_gate` (`idGate`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_gateofclient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_gateofclient` (
  `idClient` INT NOT NULL,
  `idGate` INT NOT NULL,
  INDEX `fk_detail_client_idx` (`idClient` ASC) VISIBLE,
  INDEX `fk_detail_gate_idx` (`idGate` ASC) VISIBLE,
  CONSTRAINT `fk_detail_client`
    FOREIGN KEY (`idClient`)
    REFERENCES `pbl4`.`_client` (`idClient`),
  CONSTRAINT `fk_detail_gate`
    FOREIGN KEY (`idGate`)
    REFERENCES `pbl4`.`_gate` (`idGate`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_limit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_limit` (
  `idLimit` INT NOT NULL,
  `descr` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idLimit`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`_server`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`_server` (
  `idServer` INT NOT NULL,
  `nameServer` VARCHAR(255) NOT NULL,
  `status` TINYINT(1) NOT NULL,
  `mailServer` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idServer`),
  INDEX `fk_mailserver_account_idx` (`mailServer` ASC) VISIBLE,
  CONSTRAINT `fk_mailserver_account`
    FOREIGN KEY (`mailServer`)
    REFERENCES `pbl4`.`_account` (`userName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`request` (
  `idrequest` INT NOT NULL,
  `descrip` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idrequest`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `pbl4`.`messenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pbl4`.`messenger` (
  `idMess` INT NOT NULL,
  `idLimit` INT NOT NULL,
  `idClient` INT NOT NULL,
  `idServer` INT NOT NULL,
  `timeSend` DATETIME NOT NULL,
  `idrequest` INT NOT NULL,
  PRIMARY KEY (`idMess`),
  INDEX `fk_mess_limit_idx` (`idLimit` ASC) VISIBLE,
  INDEX `fk_mess_server_idx` (`idServer` ASC) VISIBLE,
  INDEX `fk_mess_client_idx` (`idClient` ASC) VISIBLE,
  CONSTRAINT `fk_mess_client`
    FOREIGN KEY (`idClient`)
    REFERENCES `pbl4`.`_client` (`idClient`),
  CONSTRAINT `fk_mess_limit`
    FOREIGN KEY (`idLimit`)
    REFERENCES `pbl4`.`_limit` (`idLimit`),
  CONSTRAINT `fk_mess_request`
    FOREIGN KEY (`idMess`)
    REFERENCES `pbl4`.`request` (`idrequest`),
  CONSTRAINT `fk_mess_server`
    FOREIGN KEY (`idServer`)
    REFERENCES `pbl4`.`_server` (`idServer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
