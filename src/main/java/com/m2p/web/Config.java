package com.m2p.web;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Config {

	@Value("${smtp.mail.username}")
	private String mailId;
	
	@Value("${smtp.mail.password}")
	private String password;
	
	@Value("${smtp.host}")
	private String smtpHost;
	
	@Value("${smtp.port}")
	private int smtpPort;
	
	@Value("${mail.smtp.starssl.enable}")
	private String sslEnable;
	
	@Value("${mail.smtp.auth}")
	private boolean smtpAuth;
	
	@Value("${mail.pop3.socketFactory.class}")
	private String pop3SslFactory;
	
	@Value("${mail.smtp.socketFactory.class}")
	private String smtpSslFactory;
	
	@Value("${mail.smtp.socketFactory.fallback}")
	private boolean fallback;
	
	@Value("${mail.smtp.socketFactory.port}")
	private int socketPort;
	
	@Value("${mail.smtp.auth}")
	private boolean smptpAuth;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(smtpHost);
		mailSender.setPort(smtpPort);
		mailSender.setUsername(mailId);
		mailSender.setPassword(password);
		Properties properties = new Properties();
		//mail.smtp.starssl.enable=true
		//mail.smtp.auth=true
		properties.put("mail.smtp.auth", smptpAuth);
		/*properties.put("mail.pop3.socketFactory.class", pop3SslFactory);
		properties.put("mail.smtp.socketFactory.fallback", fallback);
		properties.put("mail.smtp.socketFactory.port", socketPort);*/
		properties.put("mail.smtp.starttls.enable", sslEnable);
		mailSender.setJavaMailProperties(properties);
		return mailSender;
	}
	
	/*public Properties javaMailProperties() {
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.pop3.socketFactory.class", pop3SslFactory);
		javaMailProperties.setProperty("mail.smtp.socketFactory.class", smtpSslFactory);
		javaMailProperties.setProperty("mail.smtp.socketFactory.fallback", fallback);
		javaMailProperties.setProperty("mail.smtp.socketFactory.port", socketPort);
		//mail.smtp.starssl.enable=true
		//mail.smtp.auth=true
		javaMailProperties.setProperty("mail.smtp.starssl.enable", sslEnable);
		javaMailProperties.setProperty("mail.smtp.auth", smptpAuth);
		return javaMailProperties;
	}*/
}
