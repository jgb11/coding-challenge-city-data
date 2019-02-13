# coding-challenge-city-data

This is a Spring Boot REST application.
- Manages security with Spring Security
- Configuration is stored independent in a git repository using Spring Cloud Config
- Active endpoints can be tested with Swagger
- Uses mongoDB as database to store cities information

## swagger

Swagger UI: http://localhost:8090/swagger-ui.html

## spring security

*Users:*

user/userPass
admin/adminPass

## spring cloud config on docker (how to)

*Against remote git repository:*
```bash
$ docker run -d -p 8888:8888 \
    --net codingchallenge \
    --name spring-cloud-config \
    -e SPRING_CLOUD_CONFIG_SERVER_GIT_URI=<uri> \
    -e SPRING_CLOUD_CONFIG_SERVER_GIT_USERNAME=<user> \
    -e SPRING_CLOUD_CONFIG_SERVER_GIT_PASSWORD=<password> \
    -e SPRING_CLOUD_CONFIG_SERVER_GIT_CLONE_ON_START=true \
    hyness/spring-cloud-config-server:2.1.0.RELEASE
```
*Against local git repository:*
```bash
$ docker run -d -p 8888:8888 \
    --net codingchallenge \
    --name spring-cloud-config \
    -v /path/to/config/files/dir:/config \
    -e SPRING_PROFILES_ACTIVE=native \
    hyness/spring-cloud-config-server:2.1.0.RELEASE
```

## mongodb on docker (how to)

```bash
$ docker run -d -p 27017:27017 \
    --net codingchallenge
    --name mongodb1 \
    -v /home/jgb/projects/coding-challenge/coding-challenge-mongodb-datadir:/data/db \
    -p 27017:27017 \
    mongo:4.0
```
