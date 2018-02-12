package com.rest.api.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String errCode, String errMessage) {
		this.errCode=errCode;
		this.errMessage=errMessage; 
	}
	
	
	private String errCode;
	private String errMessage;
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
}
