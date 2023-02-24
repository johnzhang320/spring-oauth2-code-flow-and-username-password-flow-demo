<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



      <meta charset="utf-8">
      <title>Spring Oauth2 Demo Master </title>

      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/common.css" rel="stylesheet">
  </head>

  <body>


<div class="container">

    <div class="starter-template center-block">
         <h2 class="text-info text-center">Spring Oauth2 Demo</h2>
         <h3 class="text-info">1.  Spring boot, Oauth2 Authorization Code Flow , Server's Login Page Encrypting Password</h3>
        <h4>  .  <a href="http://localhost:8082/spring-boot-oauth-code-client/getDashboard">http://localhost:8082/spring-boot-oauth-code-client/getDashboard</a></h4>
	    <h4>  .  <a href="http://localhost:8082/spring-boot-oauth-code-client/getBankAccount">http://localhost:8082/spring-boot-oauth-code-client/getBankAccount</a></h4>
         
        <h3  class="text-info">2.  Spring4 Oauth2 Password Flow </h3>
         <h4>  .  <a href="javascript:popoutWindow('http://localhost:8080/SpringbootAdvancedDemo/oauth2.html','Spring Oauth2 Passowrd Flow Demo',1050,950);"  style="height:15px;line-height:15px;">
	    http://localhost:8080/SpringbootAdvancedDemo/oauth2.html</a></h4>
     
 	   
   <!--       <h3 class="text-info">3. Single Sign On(SSO) Application Authorized by Spring boot OAuth2 Server</h3>-->
        <h3 class="text-info">3. Single Sign On(SSO) Application Authorized by Okta Service</h3>
        <h4>  .  <a href="http://localhost:8092/spring-boot-okta-sso-client/dashboard">http://localhost:8092/spring-boot-okta-sso-client/dashboard</a></h4>
	    <h4>  .  <a href="http://localhost:8092/spring-boot-okta-sso-client/bankaccount">http://localhost:8092/spring-boot-okta-sso-client/bankaccount</a></h4>
	
        
        <h3 class="text-info">4. Single Sign On(SSO) Application Authorized by Social Media Accounts(Google / Facebook)</h3>
        
    </div>

</div>
    <div class="container">
         <a href="http://localhost:8080/SpringbootAdvancedDemo" class="btn btn-primary">Home Page</a>
    
        
    </div>
</body>
</html>