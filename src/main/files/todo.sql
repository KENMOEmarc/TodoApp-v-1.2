-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 21 avr. 2025 à 07:47
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `todo`
--
DROP DATABASE IF EXISTS `todo`;
CREATE DATABASE IF NOT EXISTS `todo`;
-- --------------------------------------------------------

--
-- Structure de la table `todoitem`
--

DROP TABLE IF EXISTS `todoitem`;
CREATE TABLE IF NOT EXISTS `todoitem` (
  `id` varchar(100) NOT NULL,
  `title` varchar(40) NOT NULL DEFAULT 'Title',
  `note` text NOT NULL,
  `createAt` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `todoitem`
--

INSERT INTO `todoitem` (`id`, `title`, `note`, `createAt`) VALUES
('c53a1e33-556b-465b-a506-6ddc0f559245', 'Stromae', 'Sodad  Ave Cesaria', '2025-03-02'),
('56ad2d79-b7b2-4c37-9d01-b00e47a44474', 'Le Métis noir', 'Fabregas Plus haut', '2025-03-02'),
('835f7e59-2eb8-4c7e-8a88-42f45cc050ae', 'BTS 2025', 'Je débarque en mode Cuirassé pour tout niquer.', '2025-04-14'),
('f6e5a84f-e58a-433e-9ab9-bdac9bff4186', 'Larry le malicieux', 'Je vais te toucher la nuit.', '2025-04-07'),
('d849fa71-8cbd-4774-802f-61930ed8baf3', 'Martyrisé', 'Ferre Gola x JDT', '2025-04-07'),
('5f6fd7e0-e0e7-4371-90b0-fd7bd6e98778', 'Optimiser le tri', 'Et perfotmer my TodoApp.\n', '2025-04-07'),
('e5195eb7-d1ab-47cc-b1dd-3d526192ac50', 'Mea Culpa', 'Na koya ko ceder eh !\nVie nanga na kufa oh !\nNa bimbua neti ouh ouh engelu\nAdieuuu euh ouh ouh ouh na tika laté oh !', '2025-04-10'),
('48ea53d9-a61f-443b-ac66-1cf2a5b602a9', 'Chien De La Casse', 'Va leur dire que les loups sont dans la forêt', '2025-04-14'),
('215acd5a-8e21-4d8f-8cd5-c6d1cc668a36', 'zdxgf', 'sdfg', '2025-04-14'),
('11eea88d-e36f-42bf-bdba-25e35d49dcec', 'srfyh', 'zsfrhg', '2025-04-14'),
('5422796f-2edc-4056-aa9e-431d826839ca', 'Platine O Plomo Amigo', 'Passe par Feneu si ça t\'amuse, passe par sevran pour le Gravuge', '2025-04-14');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
