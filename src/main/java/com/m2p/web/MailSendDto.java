package com.m2p.web;

public class MailSendDto {

	private String fromMailId;
	
	private String mobileNo;
	
	private String queryBody;
	
	private String name;

	public String getFromMailId() {
		return fromMailId;
	}

	public void setFromMailId(String fromMailId) {
		this.fromMailId = fromMailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getQueryBody() {
		return queryBody;
	}

	public void setQueryBody(String queryBody) {
		this.queryBody = queryBody;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
