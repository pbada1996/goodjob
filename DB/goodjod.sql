-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-06-2019 a las 06:07:07
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
  `idPerfilProfesional` int(11) NOT NULL,
  `PPNombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`idPerfilProfesional`, `PPNombre`) VALUES
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
  `DNombre` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`idDistrito`, `DNombre`) VALUES
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
-- Estructura de tabla para la tabla `tipopremiun`
--

CREATE TABLE `tipopremiun` (
  `idTipoPremiun` int(11) NOT NULL,
  `TPnombre` varchar(100) NOT NULL,
  `TPdescripcion` varchar(500) NOT NULL,
  `TPprecio` double NOT NULL,
  `TPcantidadPost` int(11) NOT NULL,
  `TPfechaInicio` datetime NOT NULL,
  `TPfechaExpiracion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `UFoto` blob DEFAULT NULL,
  `Unombre` varchar(50) NOT NULL,
  `UPaterno` varchar(50) NOT NULL,
  `UMaterno` varchar(50) NOT NULL,
  `Udni` bigint(20) DEFAULT NULL,
  `UPasaporte` bigint(20) DEFAULT NULL,
  `UfechaNacimiento` date NOT NULL,
  `Ucelular` bigint(20) DEFAULT NULL,
  `idPerfilP` int(11) NOT NULL,
  `Ucorreo` varchar(50) NOT NULL,
  `idDistrito` int(11) NOT NULL,
  `Udireccion` varchar(150) DEFAULT NULL,
  `Upass` varchar(20) NOT NULL,
  `idTipoPremiun` int(11) DEFAULT NULL,
  `UfechaRegistro` date NOT NULL,
  `Uestado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `UFoto`, `Unombre`, `UPaterno`, `UMaterno`, `Udni`, `UPasaporte`, `UfechaNacimiento`, `Ucelular`, `idPerfilP`, `Ucorreo`, `idDistrito`, `Udireccion`, `Upass`, `idTipoPremiun`, `UfechaRegistro`, `Uestado`) VALUES
(2, NULL, 'anthony', 'cachi', 'ayala', 63571099, NULL, '1999-01-03', 985863707, 5, 'anthonyca18m@gmail.com', 17, 'comas city #123', 'admin', NULL, '2019-06-25', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`idPerfilProfesional`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`idDistrito`);

--
-- Indices de la tabla `tipopremiun`
--
ALTER TABLE `tipopremiun`
  ADD PRIMARY KEY (`idTipoPremiun`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `Udni` (`Udni`),
  ADD KEY `idDistrito` (`idDistrito`),
  ADD KEY `idPerfilP` (`idPerfilP`),
  ADD KEY `idTipoPremiun` (`idTipoPremiun`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `idPerfilProfesional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `distrito`
--
ALTER TABLE `distrito`
  MODIFY `idDistrito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `tipopremiun`
--
ALTER TABLE `tipopremiun`
  MODIFY `idTipoPremiun` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idDistrito`) REFERENCES `distrito` (`idDistrito`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idPerfilP`) REFERENCES `carreras` (`idPerfilProfesional`),
  ADD CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`idTipoPremiun`) REFERENCES `tipopremiun` (`idTipoPremiun`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
