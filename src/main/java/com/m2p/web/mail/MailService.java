package com.m2p.web.mail;

import org.springframework.mail.MailException;

public interface MailService {

	void sendMail(String name, String mail, String phoneNo, String body) throws MailException;
}
