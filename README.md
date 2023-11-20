# WK Consultas API

Aplicação construída utilizando Java 17 e Spring Boot que tem como objetivo disponibilizar os dados através de APIs para consulta de pessoas do banco de sangue.

## Rodando a aplicação

### Pré requisitos:
```text
* Java JDK 17
* Docker
* Maven
```

## Desenvolvimento

Para rodar a aplicação em modo de desenvolvimento importar o projeto na sua IDE favorita e executar o método `main` na classe `WkConsultApplication`

## Build

Para gerar um build com os artefatos basta executar o seguinte comando:

`mvn clean package`

O artefatos será gerado no diretório `target/wk-consult-1.0.0.jar`

## Docker

Para rodar a aplicação local de maneira fácil foi criado um arquivo `docker-compose.yml` na raiz do projeto.

Para criar os containers da aplicação e do banco de dados MySQL execute o seguinte comando:
`docker compose up -d`

Para destruir o container criado anteriormente execute o seguinte comando:
`docker compose down`

## APIs para realizar as chamadas:

- Quantidade por estado:

  curl --location 'http://localhost:8080/persons/amount-by-estado'


- IMCs por intervalo de idade:

  curl --location 'http://localhost:8080/persons/imcs-by-age-range'


- Percentual de obesos por sexo:

  curl --location 'http://localhost:8080/persons/percent-overweight'


- Média de idade por tipo sanguíneo:

  curl --location 'http://localhost:8080/persons/blood-type-age-average'


- Quantidade de receptores por tipo sanguineo:

  curl --location 'http://localhost:8080/persons/blood-type-receptors-amount'

