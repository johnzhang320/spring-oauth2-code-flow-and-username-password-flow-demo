package com.oauth.client.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.frontend.encrypt.utils.EncryptionUtils;
import com.oauth.client.model.AccessTokenForm;
import com.oauth.client.model.AuthPasswordForm;
import com.oauth.client.model2.BankAccount;
import com.oauth.client.model2.User;
import com.oauth.client.utils.OAuthUtils;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GetAuthPasswordController {
	public static final String LOCAL_CONTEXT_PATH="http://localhost:8094/spring-boot-oauth-password-client";
	public static final String SERVER_CONTEXT_PATH="http://localhost:8084/spring-boot-oauth-password-server";
	public static final String SHOW_PASSWORD_FLOW=LOCAL_CONTEXT_PATH+"/showEncryptedPassword.html";
	
	public static final String CLIENT_ID="my-trusted-client";
	public static final String CLIENT_SECRET="secret";
	
	public static final String USER_NAME="larry123";
	
	public static final String PASSWORD="helloworld";
	
	
	
	public static final String ACCESS_TOKEN_URI[]= {
			SERVER_CONTEXT_PATH+"/oauth/token",
			SERVER_CONTEXT_PATH+"/oauth/token",
			"https://localhost:8443/oauth/token"
 	};
	public static final String AUTHORIZE_URI[]= {
			SERVER_CONTEXT_PATH+"/oauth/authorize",
			SERVER_CONTEXT_PATH+"/oauth/authorize",
			"https://localhost:8443/oauth/authorize"
 	};
	public static final String[] REDIRECT_URI= {
			LOCAL_CONTEXT_PATH+"/showDashboard.html",
			LOCAL_CONTEXT_PATH+"/showBankAccount.html",
			"https://localhost:8083/oauth_client/marshall.html"
	};
	public static final String[] CLIENT_APP_URI= {
			LOCAL_CONTEXT_PATH+"/getDashboard",
			LOCAL_CONTEXT_PATH+"/getBankAccount",
			"https://localhost:8083/oauth_client/marshall.html"
	};
	
	public static final String[] RESOURCE_SERVICE_URI= {
			SERVER_CONTEXT_PATH+"/safebox/getDashboardList",
			SERVER_CONTEXT_PATH+"/safebox/getBankAccountList",
			"https://localhost:8443/marshall/renewone.html"
	};
	 

	
	static Logger Log = Logger.getLogger(GetAuthPasswordController.class);
	
	public void setIndex(HttpServletRequest request, Integer index) {
		request.getSession().setAttribute("urlIndex", index);
	}
	public Integer getIndex(HttpServletRequest request) {
		return (Integer) request.getSession().getAttribute("urlIndex");
	}
	public AccessTokenForm getToken(HttpServletRequest request) {
		return (AccessTokenForm) request.getSession().getAttribute("accessTokenForm");
	}
	public void setToken(HttpServletRequest request, AccessTokenForm atForm) {
		request.getSession().setAttribute("accessTokenForm", atForm);
	}
	
	
	/*
	 *  
	 * Show Demo Page for fetch authorization code
	 */
	@RequestMapping(value = "/getDashboard", method = RequestMethod.GET)
	
	public ModelAndView getDashboard(HttpServletRequest request) throws Exception {
		setIndex(request, 0);
		if (getToken(request)!=null) {
			return ShowPageWithToken(request);
			 
		}  
		ModelAndView model= new ModelAndView("getAccessToken");
		AuthPasswordForm form = new AuthPasswordForm();
		form.setResponse_type("password");
		form.setClient_id(CLIENT_ID);
		form.setClient_secret(CLIENT_SECRET);
		form.setRedirect_uri(REDIRECT_URI[0]);
		form.setResource_uri(RESOURCE_SERVICE_URI[0]);
		form.setAuthorize_uri(SHOW_PASSWORD_FLOW);
		form.setUrlIndex("0");
		form.setClient_app_uri(CLIENT_APP_URI[0]);
		form.setScope("read");
		model.addObject("authPasswordForm",form);
		model.addObject("authorize_uri",form.getAuthorize_uri());
		 
		return model;
	}
	
	@RequestMapping(value = "/getBankAccount", method = RequestMethod.GET)
	public ModelAndView getBankAccount(HttpServletRequest request) throws Exception{
		setIndex(request, 1);
		 
		if (getToken(request)!=null) {
			return ShowPageWithToken(request);
			 
		}  
		ModelAndView model= new ModelAndView("getAccessToken");
		AuthPasswordForm form = new AuthPasswordForm();
		form.setResponse_type("password");
		form.setClient_id(CLIENT_ID);
		form.setClient_secret(CLIENT_SECRET);
		form.setRedirect_uri(REDIRECT_URI[1]);
		form.setResource_uri(RESOURCE_SERVICE_URI[1]);
		form.setAuthorize_uri(SHOW_PASSWORD_FLOW);
		form.setUrlIndex("1");
		form.setClient_app_uri(CLIENT_APP_URI[1]);
		form.setScope("read");
		model.addObject("authPasswordForm",form);
		model.addObject("authorize_uri",form.getAuthorize_uri());
		return model;
	}
	
	@RequestMapping(value = "/showEncryptedPassword.html", method = RequestMethod.POST)
	public ModelAndView showEncryptedPassword(@Valid @ModelAttribute("accessTokenForm") AccessTokenForm accessTokenForm
			,HttpServletRequest req) throws Exception {
		Integer index = getIndex(req);
		AccessTokenForm atForm = new AccessTokenForm();
		ModelAndView model = new ModelAndView("showEncryptedPassword");
		
		atForm.setClientId(CLIENT_ID);
		atForm.setClientSecret(CLIENT_SECRET);



		
		String credentials = CLIENT_ID+":"+CLIENT_SECRET;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		
	 
		atForm.setEncodedCredentials(encodedCredentials);
		
		String enPassword = EncryptionUtils.getInstance().encrypt(PASSWORD);
		
		String enUser = EncryptionUtils.getInstance().encrypt(USER_NAME);
		
		String seeds=EncryptionUtils.getInstance().getseedStr4IV();
		
		StringBuffer access_token_url = new StringBuffer();
		access_token_url.append(ACCESS_TOKEN_URI[index]);

		access_token_url.append("?grant_type=password");
		access_token_url.append("&username="+enUser);
		access_token_url.append("&password="+enPassword+"|"+seeds);
		atForm.setAccessTokenRequestUrl(access_token_url.toString());

		atForm.setEncryptedUserInfo("username: "+enUser+"      password: "+enPassword+"|"+seeds );
		model.addObject("accessTokenForm", atForm);
	 	return model;
	}
	
	@RequestMapping(value = "/showPasswordFlow.html", method = RequestMethod.POST)
	public ModelAndView showAccessTokenForm(@Valid @ModelAttribute("authPasswordForm") AuthPasswordForm authPasswordForm
			,HttpServletRequest req) throws Exception {
		Integer index = getIndex(req);
		AccessTokenForm atForm = new AccessTokenForm();
		atForm.setClientId(CLIENT_ID);
		atForm.setClientSecret(CLIENT_SECRET);

		 
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String credentials = CLIENT_ID+":"+CLIENT_SECRET;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		atForm.setCredentials(encodedCredentials);
		
		String enPassword = EncryptionUtils.getInstance().encrypt(PASSWORD);
		
		String enUser = EncryptionUtils.getInstance().encrypt(USER_NAME);
		
		String seeds=EncryptionUtils.getInstance().getseedStr4IV();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.add("Authorization", "Basic " + encodedCredentials);
		atForm.setEncodedCredentials("Authorization, Basic " + encodedCredentials);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);

		StringBuffer access_token_url = new StringBuffer();
		access_token_url.append(ACCESS_TOKEN_URI[index]);

		access_token_url.append("?grant_type=password");
		access_token_url.append("&username="+enUser);
		access_token_url.append("&password="+enPassword+"|"+seeds);
		atForm.setEncryptedUserInfo("username: "+enUser+"      password: "+enPassword+"|"+seeds );
		Log.info("access_token_url="+access_token_url.toString());
		atForm.setAccessTokenRequestUrl(access_token_url.toString());

		response = restTemplate.exchange(access_token_url.toString(), HttpMethod.POST, request, String.class);

		String tokenString = "Token Not Found";
		
		if (response.getStatusCode()==HttpStatus.OK) {
		
		   tokenString = response.getBody();
		   
		   Log.info("Responsed Token Info ="+tokenString);
		   atForm.setTokenStringReponse(tokenString);
		    
		   tokenString = OAuthUtils.getJsonValue(tokenString, "access_token");
		   atForm.setAccessTokenString(tokenString);
		}  
		
			ModelAndView model = new ModelAndView("showAuthorizationPasswordFlow");
			atForm.setResourceRequestURL(RESOURCE_SERVICE_URI[index]);
			atForm.setRedirectUrl(REDIRECT_URI[index]);
			atForm.setResourceRequestHeader("Authorization, Bearer " + atForm.getAccessTokenString());
			Log.info("Authorization Access Token------" + atForm.getAccessTokenString()); 
			model.addObject("accessTokenForm", atForm);
			// save token to session
			setToken(req,atForm);
	 		return model;
	}
 
	/*
	 *  After Demo Form Submit to Authorization Server
	 *  Once User Authorized , the Server call back this service by redirect_url
	 */
	@RequestMapping(value = "/showDashboardDemo.html", method = RequestMethod.POST)
	public ModelAndView showDashboardDemo(
			@Valid @ModelAttribute("accessTokenForm") AccessTokenForm accessTokenForm
			,HttpServletRequest req) throws JsonProcessingException, IOException {
		
		Integer index = getIndex(req);
		
		String token = accessTokenForm.getAccessTokenString();

		Log.info("Received Access Token="+token);

		

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		
		headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers1);
		
		RestTemplate restTemplate = new RestTemplate();
		String url =RESOURCE_SERVICE_URI[index];
		Log.info("Resource URL ="+url);
		
	ModelAndView model = new ModelAndView("dashboard");
		
		if (index==0) {
			model = new ModelAndView("dashboard");
			ResponseEntity<User[]> users = restTemplate.exchange(url, HttpMethod.GET, entity, User[].class);
			User[] userArray = users.getBody();
			List<User> list =Arrays.asList(userArray);
			list.forEach(x->System.out.println(x.getName()+","+x.getAddress()+","+x.getEmail()));
			model.addObject("users", list);
		} else if (index==1) {
			model = new ModelAndView("bankaccount");
			ResponseEntity<BankAccount[]> users = restTemplate.exchange(url, HttpMethod.GET, entity, BankAccount[].class);
			BankAccount[] userArray = users.getBody();
			List<BankAccount> list =Arrays.asList(userArray);
			list.forEach(x->System.out.println(x.getName()+","+x.getAddress()+","+x.getEmail()));
			model.addObject("bankAccount", list);
		}
			
		
		model.addObject("fullTokenString", "Rediret URL:<br/>"+REDIRECT_URI[index]+"<br/><br/>Resource Server URL:<br/>"+url+"<br/><br/>"+"Oauth Access Token Information:<br/>"
				+accessTokenForm.getTokenStringReponse().replace(",", ",<br/>").replace("{","{<br/>").replace("}", "<br/>}"));
		return model;
	}
	
	 
	public ModelAndView ShowPageWithToken(HttpServletRequest req) throws JsonProcessingException, IOException {
		
		Integer index = getIndex(req);
		
		AccessTokenForm atForm = getToken(req);

		String token = atForm.getAccessTokenString();
		
		Log.info("Received Access Token="+token);

		

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		
		headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers1);
		
		RestTemplate restTemplate = new RestTemplate();
		String url =RESOURCE_SERVICE_URI[index];
		Log.info("Resource URL ="+url);
		
		

		ModelAndView model = new ModelAndView("dashboard");
		
		if (index==0) {
			model = new ModelAndView("dashboard");
			ResponseEntity<User[]> users = restTemplate.exchange(url, HttpMethod.GET, entity, User[].class);
			User[] userArray = users.getBody();
			List<User> list =Arrays.asList(userArray);
			list.forEach(x->System.out.println(x.getName()+","+x.getAddress()+","+x.getEmail()));
			model.addObject("users", list);
		} else if (index==1) {
			model = new ModelAndView("bankaccount");
			ResponseEntity<BankAccount[]> users = restTemplate.exchange(url, HttpMethod.GET, entity, BankAccount[].class);
			BankAccount[] userArray = users.getBody();
			List<BankAccount> list =Arrays.asList(userArray);
			list.forEach(x->System.out.println(x.getName()+","+x.getAddress()+","+x.getEmail()));
			model.addObject("bankAccount", list);
		}
		
		
		model.addObject("fullTokenString", "Authorization Code="+atForm.getAuthCode()+"<br/><br/>Rediret URL:<br/>"+REDIRECT_URI[index]+"<br/><br/>Resource Server URL:<br/>"+url+"<br/><br/>"+"Oauth Access Token Information:<br/>"
				+atForm.getTokenStringReponse().replace(",", ",<br/>").replace("{","{<br/>").replace("}", "<br/>}"));
		return model;
	}
}
	
	 