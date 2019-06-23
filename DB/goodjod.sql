-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-06-2019 a las 19:07:31
-- Versión del servidor: 10.3.15-MariaDB
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `goodjod`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `idPerfilP` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`idPerfilP`, `Nombre`) VALUES
(1, 'Técnico de Fibra Óptica Planta Interna'),
(2, 'Técnico de Fibra Óptica Panta Externa'),
(3, 'Ingeniero de Redes'),
(4, 'Ingeniero de Tráfico de Red'),
(5, 'Ingeniero de Sistemas'),
(6, 'Especialista de conecterización de Fibra Óptica'),
(7, 'Especialista de MUFAS Ópticas'),
(8, 'Especialista de cableado Estructurado'),
(9, 'Técnico en Red Ftth');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

CREATE TABLE `distrito` (
  `idDistrito` int(11) NOT NULL,
  `Nombre` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`idDistrito`, `Nombre`) VALUES
(1, 'Callao'),
(2, 'Bellavista'),
(3, 'Carmen de La Legua'),
(4, 'La Perla'),
(5, 'La Punta'),
(6, 'Mi Perú'),
(7, 'Ventanilla'),
(8, 'Lima'),
(9, 'Ancón'),
(10, 'Ate'),
(11, 'Barranco'),
(12, 'Breña'),
(13, 'Carabayllo'),
(14, 'Cieneguilla'),
(15, 'Chaclacayo'),
(16, 'Chorrillos'),
(17, 'Comas'),
(18, 'El Agustino'),
(19, 'Independencia'),
(20, 'Jesús María'),
(21, 'La Molina'),
(22, 'La Victoria'),
(23, 'Lince'),
(24, 'Los Olivos'),
(25, 'Lurigancho'),
(26, 'Lurín'),
(27, 'Magdalena del Mar'),
(28, 'Miraflores'),
(29, 'Pachacámac'),
(30, 'Pucusana'),
(31, 'Pueblo Libre'),
(32, 'Puente Piedra'),
(33, 'Punta Hermosa'),
(34, 'Punta Negra'),
(35, 'Rímac'),
(36, 'San Bartolo'),
(37, 'San Borja'),
(38, 'San Isidro'),
(39, 'San Juan de Lurigancho'),
(40, 'San Juan de Miraflores'),
(41, 'San Luis'),
(42, 'San Martín de Porres'),
(43, 'San Miguel'),
(44, 'Santa Anita'),
(45, 'Santa María del Mar'),
(46, 'Santa Rosa'),
(47, 'Santiago de Surco'),
(48, 'Surquillo'),
(49, 'Villa El Salvador'),
(50, 'Villa María del Triunfo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Uid` int(11) NOT NULL,
  `Unombre` varchar(50) NOT NULL,
  `UPaterno` varchar(50) NOT NULL,
  `UMaterno` varchar(50) NOT NULL,
  `Udni` bigint(20) NOT NULL,
  `UfechaNacimiento` date NOT NULL,
  `Ucelular` bigint(20) NOT NULL,
  `idPerfilP` int(11) NOT NULL,
  `Ucorreo` varchar(50) NOT NULL,
  `idDistrito` int(11) NOT NULL,
  `Udireccion` varchar(150) NOT NULL,
  `Upass` varchar(20) NOT NULL,
  `Upremiun` char(1) NOT NULL,
  `Uestado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Uid`, `Unombre`, `UPaterno`, `UMaterno`, `Udni`, `UfechaNacimiento`, `Ucelular`, `idPerfilP`, `Ucorreo`, `idDistrito`, `Udireccion`, `Upass`, `Upremiun`, `Uestado`) VALUES
(1, 'Anthony', 'Cachi', 'Ayala', 63571099, '1999-03-01', 987654321, 2, 'anthony@gmail.com', 2, 'comascity', 'admin', '1', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`idPerfilP`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`idDistrito`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Uid`),
  ADD UNIQUE KEY `Udni` (`Udni`),
  ADD KEY `idDistrito` (`idDistrito`),
  ADD KEY `idPerfilP` (`idPerfilP`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `idPerfilP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `distrito`
--
ALTER TABLE `distrito`
  MODIFY `idDistrito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idPerfilP`) REFERENCES `carreras` (`idPerfilP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
