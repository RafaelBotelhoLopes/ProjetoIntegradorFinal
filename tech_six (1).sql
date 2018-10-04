-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 04-Out-2018 às 16:24
-- Versão do servidor: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tech_six`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargos`
--

CREATE TABLE IF NOT EXISTS `cargos` (
`codigo` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `salario` double NOT NULL,
  `codSetor` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Extraindo dados da tabela `cargos`
--

INSERT INTO `cargos` (`codigo`, `nome`, `salario`, `codSetor`) VALUES
(1, 'Oftalmologista geral', 6535.19, 1),
(2, 'Plástica e Vias Lacrimais', 6535.19, 1),
(3, 'Oftalmologista pediátrico', 6535.19, 1),
(4, 'Oftalmologista especialista Nero-oftalmologia', 6535.19, 1),
(5, 'Enfermeiro Especialista', 2071.25, 1),
(6, 'Estagiário de Enfermagens', 931.47, 4),
(7, 'Anestesista', 5530.42, 1),
(8, 'Contabilista', 2128.31, 2),
(9, 'Administrativo', 1592.97, 2),
(10, 'Auxiliar Administrativo', 1062.87, 2),
(11, 'Secretária', 1055.93, 3),
(12, 'Segurança', 1393.62, 4),
(13, 'Serviços Gerais', 964.11, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidades`
--

CREATE TABLE IF NOT EXISTS `cidades` (
`codigo` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `consultas`
--

CREATE TABLE IF NOT EXISTS `consultas` (
`codigo` int(11) NOT NULL,
  `data_consulta` date NOT NULL,
  `codPaciente` int(11) NOT NULL,
  `codFuncionario` int(11) NOT NULL,
  `codLaudo` int(11) DEFAULT NULL,
  `laudo` text
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
`codigo` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf` varchar(30) NOT NULL,
  `rg` varchar(30) NOT NULL,
  `telefone` varchar(30) NOT NULL,
  `estado_civil` varchar(30) NOT NULL,
  `escolaridade` varchar(30) DEFAULT NULL,
  `endereco` varchar(50) NOT NULL,
  `nacionalidade` varchar(20) DEFAULT 'Brasil',
  `codCargo` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `laudos`
--

CREATE TABLE IF NOT EXISTS `laudos` (
`codigo` int(11) NOT NULL,
  `diagnostico` text,
  `codFuncionario` int(11) NOT NULL,
  `codPaciente` int(11) NOT NULL,
  `codConsulta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pacientes`
--

CREATE TABLE IF NOT EXISTS `pacientes` (
`codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  `nascimento` date DEFAULT NULL,
  `telefone` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `rg` varchar(50) NOT NULL,
  `estado_civil` varchar(30) NOT NULL,
  `plano_saude` varchar(50) DEFAULT NULL,
  `codCidade` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `setores`
--

CREATE TABLE IF NOT EXISTS `setores` (
`codigo` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `setores`
--

INSERT INTO `setores` (`codigo`, `nome`) VALUES
(1, 'Medico'),
(2, 'Administracao'),
(3, 'Secretaria'),
(4, 'Outros');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargos`
--
ALTER TABLE `cargos`
 ADD PRIMARY KEY (`codigo`), ADD KEY `codSetor` (`codSetor`);

--
-- Indexes for table `cidades`
--
ALTER TABLE `cidades`
 ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `consultas`
--
ALTER TABLE `consultas`
 ADD PRIMARY KEY (`codigo`), ADD KEY `codPaciente` (`codPaciente`), ADD KEY `codFuncionario` (`codFuncionario`), ADD KEY `codLaudo` (`codLaudo`);

--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
 ADD PRIMARY KEY (`codigo`), ADD KEY `codCargo` (`codCargo`);

--
-- Indexes for table `laudos`
--
ALTER TABLE `laudos`
 ADD PRIMARY KEY (`codigo`), ADD KEY `codFuncionario` (`codFuncionario`), ADD KEY `codPaciente` (`codPaciente`), ADD KEY `codConsulta` (`codConsulta`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
 ADD PRIMARY KEY (`codigo`), ADD KEY `codCidade` (`codCidade`);

--
-- Indexes for table `setores`
--
ALTER TABLE `setores`
 ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cargos`
--
ALTER TABLE `cargos`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `cidades`
--
ALTER TABLE `cidades`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `consultas`
--
ALTER TABLE `consultas`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `funcionarios`
--
ALTER TABLE `funcionarios`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `laudos`
--
ALTER TABLE `laudos`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `setores`
--
ALTER TABLE `setores`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cargos`
--
ALTER TABLE `cargos`
ADD CONSTRAINT `cargos_ibfk_1` FOREIGN KEY (`codSetor`) REFERENCES `setores` (`codigo`);

--
-- Limitadores para a tabela `consultas`
--
ALTER TABLE `consultas`
ADD CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`codPaciente`) REFERENCES `pacientes` (`codigo`),
ADD CONSTRAINT `consultas_ibfk_2` FOREIGN KEY (`codFuncionario`) REFERENCES `funcionarios` (`codigo`),
ADD CONSTRAINT `consultas_ibfk_3` FOREIGN KEY (`codLaudo`) REFERENCES `laudos` (`codigo`);

--
-- Limitadores para a tabela `funcionarios`
--
ALTER TABLE `funcionarios`
ADD CONSTRAINT `funcionarios_ibfk_1` FOREIGN KEY (`codCargo`) REFERENCES `cargos` (`codigo`);

--
-- Limitadores para a tabela `laudos`
--
ALTER TABLE `laudos`
ADD CONSTRAINT `laudos_ibfk_1` FOREIGN KEY (`codFuncionario`) REFERENCES `funcionarios` (`codigo`),
ADD CONSTRAINT `laudos_ibfk_2` FOREIGN KEY (`codPaciente`) REFERENCES `pacientes` (`codigo`),
ADD CONSTRAINT `laudos_ibfk_3` FOREIGN KEY (`codConsulta`) REFERENCES `consultas` (`codigo`);

--
-- Limitadores para a tabela `pacientes`
--
ALTER TABLE `pacientes`
ADD CONSTRAINT `pacientes_ibfk_1` FOREIGN KEY (`codCidade`) REFERENCES `cidades` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
