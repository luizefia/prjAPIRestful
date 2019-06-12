CREATE TABLE `tb_usuario` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(80) NOT NULL,
  `Cargo` varchar(80) NOT NULL,
  `Endereco` varchar(80) NOT NULL,
  `hrTrabalho` varchar(50) NOT NULL,  
  PRIMARY KEY (`Codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `tb_tarefa` (
  `CodigoTarefa` int(11) NOT NULL AUTO_INCREMENT,  
  `CodigoUsuario` int(11) NOT NULL,  
  `Descricao` varchar(80) NOT NULL,
  `TempoEstimado` time NOT NULL,
  `Categoria` varchar(30) NOT NULL,
  `Situacao` varchar(30) NOT NULL,
  PRIMARY KEY (`CodigoTarefa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

Alter table tb_tarefa ADD CONSTRAINT `fk_codusuario` FOREIGN KEY ( `CodigoUsuario` ) REFERENCES `tb_usuario` ( `Codigo` );
