-- MySQL Script generated by MySQL Workbench
-- Mon May  4 14:43:08 2020
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
-- Table `fifa`.`Time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Time` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `idTime` BIGINT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nivelAcesso` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idTime_idx` (`idTime` ASC) VISIBLE,
  CONSTRAINT `idTimeUsuario`
    FOREIGN KEY (`idTime`)
    REFERENCES `fifa`.`Time` (`id`)
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
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fifa`.`Partida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Partida` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `dataHora` TIMESTAMP NOT NULL,
  `finalizado` TINYINT NOT NULL,
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


-- -----------------------------------------------------
-- Table `fifa`.`Rank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fifa`.`Rank` (
  `idRank` BIGINT NOT NULL AUTO_INCREMENT,
  `idChamp` BIGINT NOT NULL,
  `idTime` BIGINT NOT NULL,
  `vitorias` VARCHAR(45) NOT NULL,
  `derrotas` VARCHAR(45) NOT NULL,
  `empates` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRank`),
  INDEX `idChamp_idx` (`idChamp` ASC) VISIBLE,
  INDEX `idTime_idx` (`idTime` ASC) VISIBLE,
  CONSTRAINT `idChampRank`
    FOREIGN KEY (`idChamp`)
    REFERENCES `fifa`.`Campeonato` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTimeRank`
    FOREIGN KEY (`idTime`)
    REFERENCES `fifa`.`Time` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `fifa`.`Time`
-- -----------------------------------------------------
START TRANSACTION;
USE `fifa`;
INSERT INTO `fifa`.`Time` (`id`, `nome`) VALUES (1, 'Real Madrid');
INSERT INTO `fifa`.`Time` (`id`, `nome`) VALUES (2, 'Barcelona');
INSERT INTO `fifa`.`Time` (`id`, `nome`) VALUES (3, 'Juventus');
INSERT INTO `fifa`.`Time` (`id`, `nome`) VALUES (4, 'Paris ');

COMMIT;


-- -----------------------------------------------------
-- Data for table `fifa`.`Usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `fifa`;
INSERT INTO `fifa`.`Usuario` (`id`, `idTime`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (1, 1, 'Pedro', 'Pedrin', '123456789', 1);
INSERT INTO `fifa`.`Usuario` (`id`, `idTime`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (2, 2, 'Marcos', 'Marquin', '123', 0);
INSERT INTO `fifa`.`Usuario` (`id`, `idTime`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (3, 3, 'Juca', 'Juquinha', '123654', 0);
INSERT INTO `fifa`.`Usuario` (`id`, `idTime`, `nome`, `login`, `senha`, `nivelAcesso`) VALUES (4, 4, 'Mateus', 'Teus', '123123', 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `fifa`.`Jogador`
-- -----------------------------------------------------
START TRANSACTION;
USE `fifa`;
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (1, 'T. Courtois', 'Goleiro', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (2, 'Sergio Ramos', 'Zagueiro', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (3, 'R. Varane', 'Zagueiro', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (4, 'F. Mendy', 'Lateral E', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (5, 'D. Carvajal', 'Lateral D', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (6, 'Casemiro', 'Volante', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (7, 'T. Kroos', 'Volante', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (8, 'F. Valverde', 'Volante', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (9, 'L. Modric', 'Meia', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (10, 'Isco', 'Atacante', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (11, 'L. Jovic', 'Atacante', 1);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (12, 'M. Ter Stegen', 'Goleiro', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (13, 'S. Umtiti', 'Zagueiro', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (14, 'G. Pique', 'Zagueiro', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (15, 'Junior', 'Lateral E', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (16, 'N. Semedo', 'Lateral D', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (17, 'S. Busquets', 'Meia', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (18, 'F. de Jong', 'Volante', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (19, 'I. Rakitic', 'Volante', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (20, 'A. Vidal', 'Atacante', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (21, 'A. Griezmann', 'Atacante', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (22, 'L. Messi', 'Atacante', 2);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (23, 'W. Szczesny', 'Goleiro', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (24, 'M. De Ligt', 'Zagueiro', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (25, 'L. Bonucci', 'Zagueiro', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (26, 'Alex Sandro', 'Lateral D', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (27, 'J. Cuadradro', 'Lateral E', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (28, 'M. Pjanie', 'Meia', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (29, 'B. Matuidi', 'Volante', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (30, 'R. Bentancur', 'Volante', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (31, 'C. Ronaldo', 'Atacante', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (32, 'G. Higuaín', 'Atacante', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (33, 'P. Dybala', 'Atacante', 3);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (34, 'K. Navas', 'Goleiro', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (35, 'Thiago Silva', 'Zagueiro', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (36, 'T. Kehrer', 'Zagueiro', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (37, 'M. Bakker', 'Lateral E', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (38, 'T. Meunier', 'Lateral D', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (39, 'T. Kouassi', 'Meia', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (40, 'A. Herrera', 'Meia', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (41, 'J. Draxler', 'Volante', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (42, 'P. Sarabia', 'Volante', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (43, 'K. Mbappé', 'Atacante', 4);
INSERT INTO `fifa`.`Jogador` (`id`, `nome`, `posicao`, `idTime`) VALUES (44, 'E. Cavani', 'Atacante', 4);

COMMIT;

