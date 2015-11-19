package com.m2p.web.mail;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {
	
	@Autowired
	private MailSender javaMailSender;
	
	@Value("${smtp.mail.content}")
	private String mailBody;
	
	@Value("${smtp.mail.username}")
	private String toMail;
	
	@Value("${smtp.mail.password}")
	private String password;

	@Override
	public void sendMail(String name, String mail, String phoneNo, String body) throws MailException {
		// TODO Auto-generated method stub
		MessageFormat mf = new MessageFormat(mailBody);
		String mailContent = mf.format(new Object[]{name, mail, phoneNo, body});
		
		SimpleMailMessage message = new SimpleMailMessage();
		 
		message.setFrom(toMail);
		message.setTo(toMail);
		message.setSubject("New Post from M2P Website");
		message.setText(mailContent);
		javaMailSender.send(message);	
		
	}

}
