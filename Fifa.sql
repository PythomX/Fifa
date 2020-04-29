-- MySQL Script generated by MySQL Workbench
-- Wed Apr 29 13:43:09 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fifa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fifa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fifa` DEFAULT CHARACTER SET utf8 ;
USE `fifa` ;

-- -----------------------------------------------------
-- Table `fifa`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nivelAcesso` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`Time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Time` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idUsuario` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_usuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `id_usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `fifa`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`Jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Jogador` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `posicao` ENUM('Goleiro', 'Zagueiro', 'Volante', 'Meia', 'Atacante', 'Lateral D', 'Lateral E') NOT NULL,
  `idTime` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_time_idx` (`idTime` ASC) VISIBLE,
  CONSTRAINT `id_time`
    FOREIGN KEY (`idTime`)
    REFERENCES `fifa`.`Time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`Campeonato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Campeonato` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`Partida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Partida` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `localTime` DATETIME NOT NULL,
  `idCampeonato` BIGINT NOT NULL,
  `idPrimeiroTime` BIGINT NOT NULL,
  `idSegundoTime` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_campeonato_idx` (`idCampeonato` ASC) VISIBLE,
  CONSTRAINT `id_primeiro_time`
    FOREIGN KEY (`idPrimeiroTime`)
    REFERENCES `fifa`.`Time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_segundo_time`
    FOREIGN KEY (`idSegundoTime`)
    REFERENCES `fifa`.`Time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_campeonato`
    FOREIGN KEY (`idCampeonato`)
    REFERENCES `fifa`.`Campeonato` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`Gol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Gol` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `tempo` VARCHAR(10) NOT NULL,
  `idPartida` BIGINT NOT NULL,
  `idJogador` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_partida_idx` (`idPartida` ASC) VISIBLE,
  INDEX `id_jogador_idx` (`idJogador` ASC) VISIBLE,
  CONSTRAINT `id_partida`
    FOREIGN KEY (`idPartida`)
    REFERENCES `fifa`.`Partida` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_jogador`
    FOREIGN KEY (`idJogador`)
    REFERENCES `fifa`.`Jogador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`CampTimes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`CampTimes` (
  `idCamp` BIGINT NOT NULL,
  `idTime` BIGINT NOT NULL,
  INDEX `idCamp_idx` (`idCamp` ASC) VISIBLE,
  INDEX `idTime_idx` (`idTime` ASC) VISIBLE,
  CONSTRAINT `idCamp`
    FOREIGN KEY (`idCamp`)
    REFERENCES `fifa`.`Campeonato` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTime`
    FOREIGN KEY (`idTime`)
    REFERENCES `fifa`.`Time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `fifa`.`Usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `fifa`;
INSERT INTO `fifa`.`Usuario` (`id`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (1, 'Pedro', 'Pedrin', '123456789', 1);
INSERT INTO `fifa`.`Usuario` (`id`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (2, 'Marcos', 'Marquin', '123', 0);
INSERT INTO `fifa`.`Usuario` (`id`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (3, 'Juca', 'Juquinha', '123654', 0);
INSERT INTO `fifa`.`Usuario` (`id`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (4, 'Mateus', 'Teus', '123123', 0);

COMMIT;

