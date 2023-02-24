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

        <form:form method="POST" action="http://localhost:8094/spring-boot-oauth-password-client/showDashboardDemo.html" modelAttribute="accessTokenForm" >
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
            
		     
           
  		   <h4 class="text-info text-center">Display the Token which we just obtained from Authorization Server </h4>  
        	
             <div class="form-group row">
			  <Label for="accessTokenString"  class="text-info col-sm-2 col-form-label">Access Token String</Label> 
	            <spring:bind path="accessTokenString">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-10">
	                 
 	                    <form:input type="text" path="accessTokenString" class="form-control"
	                                placeholder="accessTokenString"></form:input>
	                    <form:errors path="accessTokenString"></form:errors>
	                </div>
	            </spring:bind>
  			</div>
  			<div class="form-group row">
			  <Label for="tokenStringReponse"  class="text-info col-sm-2 col-form-label">Full Token JSON Response</Label> 
	            <spring:bind path="tokenStringReponse">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-9">
	                 
 	                    <form:input type="text" path="tokenStringReponse" class="form-control"
	                                placeholder="tokenStringReponse"></form:input>
	                    <form:errors path="tokenStringReponse"></form:errors>
	                </div>
	            </spring:bind>
  			</div>
  			  
  	      <h4 class="text-info text-center">We will send GET Request to Resource Server (see the URL) via request header 'Authorization  Bearer + Access Token </h4> 
 	
  			<div class="form-group row">
			  <Label for="resourceRequestURL"  class="text-info col-sm-2 col-form-label">Resource Server Request URL</Label> 
	            <spring:bind path="resourceRequestURL">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-9">
	                 
 	                    <form:input type="text" path="resourceRequestURL" class="form-control"
	                                placeholder="resourceRequestURL"></form:input>
	                    <form:errors path="resourceRequestURL"></form:errors>
	                </div>
	            </spring:bind>
  			</div>
  			
  			<div class="form-group row">
			  <Label for="resourceRequestHeader"  class="text-info col-sm-2 col-form-label">Resource Server Request Header</Label> 
	            <spring:bind path="resourceRequestHeader">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-9">
	                 
 	                    <form:input type="text" path="resourceRequestHeader" class="form-control"
	                                placeholder="resourceRequestHeader"></form:input>
	                    <form:errors path="resourceRequestHeader"></form:errors>
	                </div>
	            </spring:bind>
  			</div>
  			 
          	<h4 class="text-info text-center">Authorization Server will redirect to User's Application Page inside of Oauth Client to finally display your data </h4> 
       		<div class="form-group row">
			  <Label for="redirectUrl"  class="text-info col-sm-2 col-form-label">Redirect URL to Client Page</Label> 
	            <spring:bind path="redirectUrl">
	                <div class="form-group ${status.error ? 'has-error' : ''} col-sm-9">
	                 
 	                    <form:input type="text" path="redirectUrl" class="form-control"
	                                placeholder="redirectUrl"></form:input>
	                    <form:errors path="redirectUrl"></form:errors>
	                </div>
	            </spring:bind>
  			</div> 
  			 <div class="form-group ${status.error ? 'has-error' : ''} col-sm-4">
           		 <button class="btn btn-primary btn-block btn-left col-md-4" type="submit">Get Resource and Display Redirect Page</button>
	 	    </div>	
	 	   
        </form:form>
	    	   
	 </div>
   
     <div class="container">
            <H4 class="text-center text-info text-lg"> Authorization Password Flow</H4>
           
            <img   class="center-block" src="${contextPath}/resources/images/Demo_OAuth2_Authorization_Password_Flow_Enhancement.jpg" width="90%" height="90%">
     </div>   
  
  </body>
</html>
