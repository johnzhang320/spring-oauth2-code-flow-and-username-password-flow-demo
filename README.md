# spring-oauth2-code-flow-and-username-password-flow-demo
Demo Oauth2 code flow and username/password flow , show detail data change and work flow chart. Frontend encrypts password

# Envirnoment

 Eclipse
 
 Spring boot 1.5.8
 
 Spring boot MVC
 
 Spring Base JSP
 
 Bootstrap
 
 Spring boot Security
 
 MySQL 8.0.3
 
 Spring boot OAuth2
 
 JDK 1.8
 
 # MySQL Setup
 
 Download MySQL starter such as Mac Pro, run mysql-8.0.29-macos12-x86_64.dmg. When we have chance setup password for "root", set it as 'mypassword" 
 
 after you run
 
    git clone https://github.com/johnzhang320/spring-oauth2-code-flow-and-username-password-flow-demo.git 
 
 go to directory "spring-oauth2-code-flow-and-username-password-flow-demo"
 
 run command
 
 ~/$ mysql -u root -p 
 sql>password: mypassword
    
 sql>create database securitydb;
 sql>quit
 
 ~/$ mysql -u root -p securitydb < securitydb.sql
 
 # Sequence of Start Services
   
 
 
