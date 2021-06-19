# Desafio Zup

# Projeto de Implementação de controle de veículos de usuários

## BackEnd hospedado
### Heroku  - https://apizupveiculosfipe.herokuapp.com/desafio/swagger-ui.html


## Tecnologia utilizada

- Java 8
- Spring Boot 2.51
- Spring cloud Feign 2020.0.3
- Spring Data Jpa - Hibernate
- Spring Validation  
- Spring Web
- SpringDoc Openapi
- Maven
- 

## Escopo
	Projeto de manipulação de Veículos e usuários 

## Persistencia

- PostgreSql versão 13.2.1
    -  Banco de dados - postgres

##Lista dos EndPoints local

1. Web Api com endpoints utilizando https://localhost:8080/desafio
2. Documentação da api para listar os EndPoints - https://localhost:8080/swagger-ui.html

###Lista geral de EndPoints

1. /desafio/usuario - Lista todos os usuários - utilizando requisição Get
2. /desafio/usuario - Adiciona um usuário - utilizando requisição Post
3. /desafio/usuario/id - Lista um usuário por id - utilizando requisição Get
4. /desafio/usuario/id - Apaga um usuário por id - utilizando requisição Delete
5. /desafio/usuario/id - Altera um usuário por id - utilizando requisição Put

6. /desafio/veiculos - seque o mesmo padrão do usuários
7. /desafio/veiculo/idcliente - lista os veículos de um determinado cliente
   
8. /desafio/listagem/id - lista os veículos de um determinado cliente com opção de verificar 
    dias do rodizio e se está ativo na data atual.

