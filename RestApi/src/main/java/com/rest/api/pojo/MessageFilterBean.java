package com.rest.api.pojo;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;

public class MessageFilterBean {

	@MatrixParam("hello")
	private String helloMessage;

	@HeaderParam("token")
	private String token;

	public String getHelloMessage() {
		return helloMessage;
	}

	public void setHelloMessage(String helloMessage) {
		this.helloMessage = helloMessage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
