-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema IoT_SmartBuilding
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema IoT_SmartBuilding
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `IoT_SmartBuilding` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `IoT_SmartBuilding` ;

-- -----------------------------------------------------
-- Table `IoT_SmartBuilding`.`TB_event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `IoT_SmartBuilding`.`TB_event` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `module_id` VARCHAR(4) NOT NULL,
  `time` DATETIME NOT NULL DEFAULT now(),
  `temp` FLOAT NOT NULL,
  `smoke` FLOAT NOT NULL,
  `gyro` FLOAT NOT NULL,
  `fire` FLOAT NOT NULL,
  `issue` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`event_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IoT_SmartBuilding`.`TB_action`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `IoT_SmartBuilding`.`TB_action` (
  `module_id` VARCHAR(4) NOT NULL,
  `url` VARCHAR(50) NOT NULL,
  `time` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`module_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IoT_SmartBuilding`.`TB_HR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `IoT_SmartBuilding`.`TB_HR` (
  `hr_id` INT NOT NULL,
  `id` VARCHAR(16) NOT NULL,
  `pw` VARCHAR(16) NOT NULL,
  `name` VARCHAR(10) NOT NULL,
  `location_id` INT NOT NULL,
  `tel` VARCHAR(12) NOT NULL,
  `email` VARCHAR(20) NOT NULL,
  `sex` VARCHAR(1) NOT NULL,
  `birthday` VARCHAR(8) NOT NULL,
  `level` VARCHAR(1) NOT NULL,
  `FCM` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IoT_SmartBuilding`.`TB_fire_ex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `IoT_SmartBuilding`.`TB_fire_ex` (
  `fire_ex_id` INT NOT NULL,
  `location_id` INT NOT NULL,
  `ex_date` DATE NOT NULL,
  `check_date` DATETIME NOT NULL,
  PRIMARY KEY (`fire_ex_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IoT_SmartBuilding`.`TB_module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `IoT_SmartBuilding`.`TB_module` (
  `module_id` VARCHAR(4) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `ip` VARCHAR(16) NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`module_id`),
  CONSTRAINT `fk_TB_module_TB_event`
    FOREIGN KEY (`module_id`)
    REFERENCES `IoT_SmartBuilding`.`TB_event` (`module_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_module_TB_action1`
    FOREIGN KEY (`module_id`)
    REFERENCES `IoT_SmartBuilding`.`TB_action` (`module_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IoT_SmartBuilding`.`TB_location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `IoT_SmartBuilding`.`TB_location` (
  `location_id` INT NOT NULL,
  `location` VARCHAR(4) NOT NULL,
  `dept_name` VARCHAR(20) NOT NULL,
  `manager` VARCHAR(16) NULL,
  `dept_tel` VARCHAR(12) NULL,
  PRIMARY KEY (`location_id`),
  CONSTRAINT `fk_TB_location_TB_HR1`
    FOREIGN KEY (`location_id`)
    REFERENCES `IoT_SmartBuilding`.`TB_HR` (`location_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_location_TB_fire_ex1`
    FOREIGN KEY (`location_id`)
    REFERENCES `IoT_SmartBuilding`.`TB_fire_ex` (`location_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_location_TB_module1`
    FOREIGN KEY (`location_id`)
    REFERENCES `IoT_SmartBuilding`.`TB_module` (`location_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `IoT_SmartBuilding`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `IoT_SmartBuilding`.`table1` (
)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
