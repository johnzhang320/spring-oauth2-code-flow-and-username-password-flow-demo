#!/bin/sh
mvn clean
mvn install

docker rmi -f spring-boot-oauth-server
docker build -t spring-boot-oauth-server .
 
docker run -p 8083:8083 --name spring-boot-oauth-server --link mariadb-server:mariadb spring-boot-oauth-server 