# MVP QUICKDEV
## _MOVIE API, by Douglas Eleutério_


O desafio é construir uma API com tema 'Movie'.
Infelizmente meu tempo essa semana foi reduzido graças as demandas do trabalho atual.
Não pude dedicar tempo o suficiente para construir a aplicação como gostaria, para não perder a oportunidade, estou enviando da forma que posso.
O que está faltando:
- An unauthenticated /stats route with statistics from the rest api
- Create a Docker setup (container, volumes, etc)
- REST API Documentation
- Unit tests

## Tech

Tecnologias utilizadas no projeto:

- [Java 8]
- [Spring Boot 2.1.8]
- [Spring Data]
- [Spring Security]
- [MySQL]
- [Token JWT]
- [Flyway]
- [Maven]
- [Junit]

Aidicionamente, iria enviar uma aplicação que utiliza RestAssured para testes de API's, caso tivesse tempo para focar.

## Installation

Necessita ter instalado JDK 8 ou Superior
Maven 3.x.x ou superior
MySQL 8.x.x

Para desenvolvimento, foi utilizado IntelliJ, mas é indiferente, pois com uso de Maven, o processo de importação é facilitado pelo Framework

Para executar o projeto, além da importação para sua IDE, pode executar via linha de comando.
Para executar via linha de comando, após realizar download do projeto e acessar a pasta raiz, execute o seguinte comando em seu terminal, considerando que o Maven esteja instalado.

```sh
mvn spring-boot:run
```
Atenção ao banco de dados, ele está configurado para conectar na porta 3306 com as credenciais:
- user: root
- password: root

As configurações podem ser alteradas no arquivo application.properties localizado na pasta 'src/main/resources'

Após a execução o sistema estará pronto para receber requisições do tipo REST na porta 8080.

## Autenticação

Para a criação de um usuário, enviar uma requisição do tipo POST para
http://localhost:8080/api/auth/signup com um 'corpo' do tipo JSON obedecendo o layout

``` json
{
    "username": "douglasE",
    "email": "douglas-nesgocios@hotmail.com",
    "password": "123456",
    "role":[
        "ROLE_ADMIN"
    ]
}
```

Após registro do usuário, necessitamos fazer login para recebermos nossas credenciais.
Para obter o token de acesso, enviar uma requisição do tipo POST para http://localhost:8080/api/auth/signin com um 'corpo' do tipo JSON obedecendo o layout:

```json
{
    "username": "douglasE",
    "password": "123456"
}
```

Deverá receber o seguinte objeto JSON no corpo da resposta
```json
{
    "id": 1,
    "username": "douglasE",
    "email": "douglas-nesgocios@hotmail.com",
    "roles": [
        "ROLE_USER"
    ],
    "tokenType": "Bearer",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkb3VnbGFzRSIsImlhdCI6MTYzMDA5MzUyMywiZXhwIjoxNjMwMDk0NDIzfQ.wz88rUYEoLXI9YoPhHp4mO9UyGUZaHYx0cWJtRWDWVing5ps-oqK4DJvivRLo-oFS5l2XICYEkCjINWEYwcvYg"
}
```
Seu token de acesso será o hash retornado como value da variável 'accesstoken', como no exemplo:

```text
 "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkb3VnbGFzRSIsImlhdCI6MTYzMDA5MzUyMywiZXhwIjoxNjMwMDk0NDIzfQ.wz88rUYEoLXI9YoPhHp4mO9UyGUZaHYx0cWJtRWDWVing5ps-oqK4DJvivRLo-oFS5l2XICYEkCjINWEYwcvYg"
 ```

Com token em mãos, estará habilitado para enviar requisições durante um período de '900000' milisegundos, posteriormente, terá que obter uma nova chave.

Para enviar um filme para registro, deverá utilizar o método POST, inserir seu token do tipo Bearer nas configurações e inserir o objeto JSON no 'corpo' da requisição obedecendo o layout:

 ```json
 {
        "title":"The Matrix",
        "releaseDate": "2021-08-25T13:09:51.014+0000",
        "genre": "SCI-FI",
        "overview": "Fine",
        "coverImage": "No Image",
        "rating": 5.0
}
```

Será retornado uma resposta com Status Code 200 e um objeto no corpo da resposta similar ao abaixo:
```json
{
    "message": "Movie saved: ",
    "date": "2021-08-27T19:52:54.427+0000",
    "obj": {
        "id": 10,
        "title": "The Matrix",
        "releaseDate": "2021-08-25T13:09:51.014+0000",
        "genre": "SCI-FI",
        "overview": "Fine",
        "coverImage": "No Image",
        "rating": 5.0
    }
}
```

O Sistema está pronto para Armazenar, Deletar, Recuperar por Id, Recuperar por Title.
Não tive tempo para implementar o PUT e também não tive tempo de implementar as consultas públicas, que eram, quantidade de filmes e quantidade por genero, a aplicação já possui uma rota públic configurada para a implementação, a rota é: "/api/public/** configurada na classe 'WebSecurityConfig'

Não será possível prosseguir com as demais instruções pois tenho uma reunião iniciando em 5 minutos e tenho até as 16:00 do dia de hoje para finalizar a POC.


Obrigado pela oportunidade, gostaria que fosse levada em consideração o pouco tempo que pude dispor para implementação.
