CREATE TABLE person(
   nome           VARCHAR(100) NOT NULL PRIMARY KEY
  ,cpf            VARCHAR(14) NOT NULL
  ,rg             VARCHAR(12) NOT NULL
  ,data_nasc      DATE  NOT NULL
  ,sexo           VARCHAR(9) NOT NULL
  ,mae            VARCHAR(100) NOT NULL
  ,pai            VARCHAR(100) NOT NULL
  ,email          VARCHAR(300) NOT NULL
  ,cep            VARCHAR(9) NOT NULL
  ,endereco       VARCHAR(250) NOT NULL
  ,numero         INTEGER  NOT NULL
  ,bairro         VARCHAR(200) NOT NULL
  ,cidade         VARCHAR(100) NOT NULL
  ,estado         VARCHAR(2) NOT NULL
  ,telefone_fixo  VARCHAR(16) NOT NULL
  ,celular        VARCHAR(16) NOT NULL
  ,altura         NUMERIC(5,2) NOT NULL
  ,peso           INTEGER  NOT NULL
  ,tipo_sanguineo VARCHAR(5) NOT NULL
);