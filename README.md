# Spring Boot Embedded Mongo Reactive 
> Spring Boot Embedded Mongo Reactive Api
>
<img src="https://github.com/susimsek/spring-boot-embedded-mongo-reactive/blob/main/images/spring-boot-embedded-mongo-reactive.png" alt="Spring Boot Embedded Mongo Reactive" width="100%" height="100%"/> 

## Prerequisites

* Java 11
* Maven 3.3+
* Docker 19.03+
* Docker Compose 1.25+

## Installation

```sh
./mvnw -Pprod compile jib:dockerBuild
```

```sh
docker-compose up -d 
```

## Used Technologies

* Spring Boot 2.4.2
* Mongodb (Prod Environment)
* Embedded Mongodb (Dev Environment)
* Spring Boot Web Flux
* Problem Spring Web Flux
* SpringDoc Openapi Web Flux Core
* SpringDoc Openapi Web Flux Ui
* Spring Boot Actuator
* Maven Jib Plugin
* Maven Clean Plugin
* Maven Enforcer Plugin
* Mapstruct
* Lombok
* Dev Tools
* Spring Boot Test

## SpringDoc OpenApi

> You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

<img src="https://github.com/susimsek/spring-boot-embedded-mongo-reactive/blob/main/images/springdoc-openapi.png" alt="SpringDoc Openapi" width="100%" height="100%"/> 