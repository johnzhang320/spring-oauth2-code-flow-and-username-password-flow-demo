<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Get Authorization Code</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>
	
		
    <div class="d-flex justify-content-center align-items-center container">

        <form:form method="POST" action="http://localhost:8082/spring-boot-oauth-code-client/getAccessToken.html"  modelAttribute="accessTokenForm">
           <div class="form-group row">
           		<h2 class="text-info text-center">Demo OAuth2 Authorization Code Flow Enhancement </h2>
           		<h4 class="text-info text-center">Already get the Authorization Code </h4>
           	 
           		
           </div>
           <div class="form-group row">
	            <Label for="authCode"  class="text-info col-sm-2 col-form-label">Received Authorization Code</Label> 
	            <spring:bind path="authCode">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-4">
	                    <form:input type="text" path="authCode" class="form-control" autofocus="true"></form:input>
	                    <form:errors path="authCode"></form:errors>
	                </div>
	            </spring:bind>
		   </div>
		   <br>
  			
  			 <div class="form-group ${status.error ? 'has-error' : ''} col-sm-4">
           		 <button class="btn btn-primary btn-block btn-left col-md-4" type="submit">Continue Demo</button>
	 	    </div>	
	 	   
        </form:form>
	    	   
	 </div>
     <div class="container">
            <H4 class="text-center text-info text-lg"> Authorization Code Flow</H4>
           
            <img   class="center-block" src="${contextPath}/resources/images/Demo_OAuth2_Authorization_Code_Flow_Enhancement.jpg" width="90%" height="90%">
     </div>
	    
  
  </body>
</html>
