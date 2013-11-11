SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `poptomatoesdb` DEFAULT CHARACTER SET utf8 ;
USE `poptomatoesdb` ;

-- -----------------------------------------------------
-- Table `poptomatoesdb`.`Cinemahall`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `poptomatoesdb`.`Cinemahall` (
  `ID` INT(11) NOT NULL ,
  `Name` VARCHAR(50) NOT NULL ,
  `Rows` INT(10) UNSIGNED NOT NULL ,
  `Seats` INT(10) UNSIGNED NOT NULL ,
  `SpecialSeats` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'CinemaHalls table';


-- -----------------------------------------------------
-- Table `poptomatoesdb`.`Movie`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `poptomatoesdb`.`Movie` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Title` VARCHAR(50) NOT NULL ,
  `Duration` INT(10) UNSIGNED NOT NULL ,
  `ReleaseDate` DATE NOT NULL ,
  `Genre` VARCHAR(50) NULL DEFAULT NULL ,
  `PG` BINARY(1) NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COMMENT = 'Movies table';


-- -----------------------------------------------------
-- Table `poptomatoesdb`.`Row`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `poptomatoesdb`.`Row` (
  `Number` INT(10) UNSIGNED NOT NULL ,
  `Cinemahall_ID` INT(11) NOT NULL ,
  `Seats` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`Number`, `Cinemahall_ID`) ,
  INDEX `fk_Row_Cinemahall1_idx` (`Cinemahall_ID` ASC) ,
  CONSTRAINT `fk_Row_Cinemahall1`
    FOREIGN KEY (`Cinemahall_ID` )
    REFERENCES `poptomatoesdb`.`Cinemahall` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Rows table';


-- -----------------------------------------------------
-- Table `poptomatoesdb`.`Showtime`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `poptomatoesdb`.`Showtime` (
  `ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Movie_ID` INT(11) NOT NULL ,
  `Cinemahall_ID` INT(11) NOT NULL ,
  `Date` VARCHAR(10) NOT NULL ,
  `Time` TIME NOT NULL ,
  `Auditors` INT(10) UNSIGNED NOT NULL DEFAULT '0' ,
  `3D` BINARY(1) NOT NULL DEFAULT '0' ,
  `IsNew` BINARY(1) NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`ID`, `Movie_ID`, `Cinemahall_ID`) ,
  INDEX `fk_showtime_movie_idx` (`Movie_ID` ASC) ,
  INDEX `fk_showtime_cinemahall1_idx` (`Cinemahall_ID` ASC) ,
  CONSTRAINT `fk_showtime_movie`
    FOREIGN KEY (`Movie_ID` )
    REFERENCES `poptomatoesdb`.`Movie` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_showtime_cinemahall1`
    FOREIGN KEY (`Cinemahall_ID` )
    REFERENCES `poptomatoesdb`.`Cinemahall` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Showtime table';

USE `poptomatoesdb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
