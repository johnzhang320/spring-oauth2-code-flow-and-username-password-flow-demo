#!/bin/sh
mvn clean
mvn install

docker rmi -f spring-boot-oauth-master
docker build -t spring-boot-oauth-master .
docker run -p 8081:8081 spring-boot-oauth-master 
 