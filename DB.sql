CREATE DATABASE `tarefas-db`;

CREATE TABLE `tarefas-db`.`tarefa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `data_entrega` timestamp NOT NULL,
  `responsavel` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;