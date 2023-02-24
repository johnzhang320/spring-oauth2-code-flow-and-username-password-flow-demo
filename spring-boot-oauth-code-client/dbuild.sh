#!/bin/sh
mvn clean
mvn install

docker rmi -f spring-boot-oauth-code-client
docker build -t spring-boot-oauth-code-client .
docker run -p 8082:8082 spring-boot-oauth-code-client 
 