<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



      <meta charset="utf-8">
      <title>Spring boot Oauth2 Demo Master </title>

      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/common.css" rel="stylesheet">
  </head>

  <body>


<div class="container">

    <div class="starter-template center-block">
         <h2 class="text-info text-center">Demo Spring Boot OAuth2 Security Enhancement</h2>
         
         <h4 class="text-info">1.  OAuth2 Authorization Code Flow Enhancement--Front End Encrypting Password in Login Page of Authorization Server</h3>
        <h5>  .  <a href="http://localhost:8082/spring-boot-oauth-code-client/getDashboard">http://localhost:8082/spring-boot-oauth-code-client/getDashboard (Detail Code Flow)</a></h5>
	    <h5>  .  <a href="http://localhost:8082/spring-boot-oauth-code-client/getBankAccount">http://localhost:8082/spring-boot-oauth-code-client/getBankAccount</a></h5>
         
        <h4  class="text-info">2.  OAuth2 Authorization Password Flow Enhancement--Encrypting Username/Password in Token Request of OAuth2 Client</h4>
        <h5>  .  <a href="http://localhost:8094/spring-boot-oauth-password-client/getDashboard">http://localhost:8094/spring-boot-oauth-code-client/getDashboard (Detail Password Flow)</a></h5>
	    <h5>  .  <a href="http://localhost:8094/spring-boot-oauth-password-client/getBankAccount">http://localhost:8094/spring-boot-oauth-code-client/getBankAccount</a></h5>
      
 
        
    </div>

</div>
    <div class="container">
         <a href="http://localhost:8080/SpringbootAdvancedDemo" class="btn btn-primary">Home Page</a>
    
        
    </div>
</body>
</html>