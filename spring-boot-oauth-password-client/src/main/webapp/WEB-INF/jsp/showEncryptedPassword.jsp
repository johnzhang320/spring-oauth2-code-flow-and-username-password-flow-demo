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

        <form:form method="POST" action="http://localhost:8094/spring-boot-oauth-password-client/showPasswordFlow.html" modelAttribute="accessTokenForm" >
           <div class="form-group row">
           		<h2 class="text-info text-center">Demo OAuth2 Password Flow Enhancement </h2>
                <h3 class="text-info text-center">Encrypt Username and Password in OAuth Client  </h3>
       		 
           	  	<h4 class="text-info text-center">OAuth2 Encrypted Username and Password in Token Request URL </h4>  
           	  	 
           </div>
             <div class="form-group row">
			  <Label for="accessTokenRequestUrl"  class="text-info col-sm-2 col-form-label">Encrypted Token Request Url</Label> 
	            <spring:bind path="redirectUrl">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-10">
	                 
 	                    <form:input type="text" path="accessTokenRequestUrl" class="form-control"
	                                placeholder="accessTokenRequestUrl"></form:input>
	                    <form:errors path="accessTokenRequestUrl"></form:errors>
	                </div>
	            </spring:bind>
  			</div>
  			  <div class="form-group row">
			  <Label for="encryptedUserInfo"  class="text-info col-sm-2 col-form-label">Encrypted User Info</Label> 
	            <spring:bind path="redirectUrl">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-10">
	                 
 	                    <form:input type="text" path="encryptedUserInfo" class="form-control"
	                                placeholder="encryptedUserInfo"></form:input>
	                    <form:errors path="encryptedUserInfo"></form:errors>
	                </div>
	            </spring:bind>
  			</div>
           <div class="form-group row">
			  <Label for="encodedCredentials"  class="text-info col-sm-2 col-form-label">Encoded Credentials</Label> 
				<spring:bind path="encodedCredentials">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-9">
	                	 
	                    <form:input type="text" path="encodedCredentials" class="form-control"
	                                placeholder="encodedCredentials"></form:input>
	                    <form:errors path="encodedCredentials"></form:errors>
	                </div>
	            </spring:bind>
            </div>
            
		     
          
  			 <div class="form-group ${status.error ? 'has-error' : ''} col-sm-4">
           		 <button class="btn btn-primary btn-block btn-left col-md-3" type="submit">Get OAuth2 Token</button>
	 	    </div>	
	 	   
        </form:form>
	    	   
	 </div>
     
	   <div class="container">
            <H4 class="text-center text-info text-lg"> Authorization Password Flow</H4>
           
            <img   class="center-block" src="${contextPath}/resources/images/Demo_OAuth2_Authorization_Password_Flow_Enhancement.jpg" width="90%" height="90%">
     </div>   
      
  
  </body>
</html>
