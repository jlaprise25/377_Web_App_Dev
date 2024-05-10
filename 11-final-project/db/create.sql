CREATE SCHEMA `highscores` ;

CREATE TABLE `times` (
  `tim_id` int NOT NULL AUTO_INCREMENT,
  `tim_name` varchar(45) NOT NULL,
  `tim_time` varchar(45) NOT NULL,
  PRIMARY KEY (`tim_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
