package com.oauth.client.model;



public class AccessTokenForm {
	private String clientId;
	private String clientSecret;
	private String authCode;
	private String redirectUrl;
	private String base_token_url;
	private String credentials;
	private String encodedCredentials;
	private String accessTokenRequestUrl;
	private String tokenStringReponse;
	private String accessTokenString;
	private String resourceRequestURL;
	private String resourceRequestHeader;
	 
	private String urlIndex;
	private String nextRUL ;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getBase_token_url() {
		return base_token_url;
	}
	public void setBase_token_url(String base_token_url) {
		this.base_token_url = base_token_url;
	}
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getEncodedCredentials() {
		return encodedCredentials;
	}
	public void setEncodedCredentials(String encodedCredentials) {
		this.encodedCredentials = encodedCredentials;
	}
	public String getAccessTokenRequestUrl() {
		return accessTokenRequestUrl;
	}
	public void setAccessTokenRequestUrl(String accessTokenRequestUrl) {
		this.accessTokenRequestUrl = accessTokenRequestUrl;
	}
	public String getTokenStringReponse() {
		return tokenStringReponse;
	}
	public void setTokenStringReponse(String tokenStringReponse) {
		this.tokenStringReponse = tokenStringReponse;
	}
	public String getAccessTokenString() {
		return accessTokenString;
	}
	public void setAccessTokenString(String accessTokenString) {
		this.accessTokenString = accessTokenString;
	}
	public String getNextRUL() {
		return nextRUL;
	}
	public void setNextRUL(String nextRUL) {
		this.nextRUL = nextRUL;
	}
	public String getResourceRequestURL() {
		return resourceRequestURL;
	}
	public void setResourceRequestURL(String resourceRequestURL) {
		this.resourceRequestURL = resourceRequestURL;
	}
	public String getResourceRequestHeader() {
		return resourceRequestHeader;
	}
	public void setResourceRequestHeader(String resourceRequestHeader) {
		this.resourceRequestHeader = resourceRequestHeader;
	}
	public String getUrlIndex() {
		return urlIndex;
	}
	public void setUrlIndex(String urlIndex) {
		this.urlIndex = urlIndex;
	}
	 
	
	
}
