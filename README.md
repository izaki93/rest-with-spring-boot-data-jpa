# rest-with-spring-boot-data-jpa

The service is built on top of [SpringBoot 2.4.5](https://spring.io/projects/spring-boot) framework and [PostgreSQL](https://www.postgresql.org) database.

Other important technologies:
- [Gradle](https://gradle.org)
- [Liquibase](https://www.liquibase.org)	
- [Lombok](https://projectlombok.org)
- [Spring AOP](https://docs.spring.io/spring-framework/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html)
- [Swagger](https://swagger.io/)

# Requirments
For development, you will need Java 8, PostgreSQL installed.

#Pre-requisites
PostgreSQL is installed. Next sql queries have been executed:

```
CREATE DATABASE spring-rest-db;

* change the DB user name and password to match your own :
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/spring-rest-db
    username: ###{YOUR_DB_USER_NAME_HERE}
    password: ###{YOUR_DB_PASSWORD_HERE}
```

# Getting started

1. Build project:
 ```bash
 gradle build
 ```
2. Clean project:
```bash
 gradle clean
 ```
3. Launch application:
 ```bash
 Execute Gradle task 'bootRun'
 ```

#Swagger API Reference
The Swagger API can be found at http://host:port:swagger-ui.html#/
