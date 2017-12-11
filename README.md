# POC - EUREKA

### O que é?

Esta é uma prova de conceito usando Tecnologias da Spring Cloud.

Nos exemplos abaixo, vamos criar um serviço de CRUD para Clientes se conectando ao servidor Postgres e EXPOR para o mundo através do Spring Zuul.

### Onde ficará as informações?

No banco Postgres e exposto no Zuul

Ou seja: Postgres <- poc-data <- eureka-server <- poc-client <- poc-zuul

# Rodando tudo:

```bash
sudo mvn clean package
sudo docker-compose up -d
curl -i -X POST -H "Content-Type:application/json" -d "{  \"nome\" : \"Zuul\" }" http://localhost/api/data/cliente
curl http://localhost/api/data/cliente/1
curl http://localhost/api/poc/primeiro
```

OPA: Subir todas aplicações leva um tempo. O Comando "primeiro" estará sujeito a disponibilidade do Ribbon.

# Tecnologias
1. Postgres 10.1 (docker)
2. poc-data:
    - POSTGRES 10.1
    - Spring HATEOAS
    - Spring Data REST uses the HAL format for JSON output. It is flexible and offers a convenient way to supply links adjacent to the data that is served.
    - Eureka Client. Microservice Registration and Discovery with Spring Cloud and Netflix's Eureka
    - [Example Protocol](https://spring.io/guides/gs/accessing-data-rest/)
3. Eureka Server (docker)
4. poc-client:
    - Spring Eureka Client for Exposing "/primeiro" Entry Point
    - Spring Ribbon Client for Consumes "poc-data" microservice
5. poc-zuul:
    - Spring Zuul Proxy Microservices
