package com.m2p.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m2p.web.mail.MailService;

@Controller
public class UrlRouter {

	@Autowired private MailService mailService;
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> sendMail(@RequestBody MailSendDto mailDto) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			mailService.sendMail(mailDto.getName(), mailDto.getFromMailId(), mailDto.getMobileNo(),
					mailDto.getQueryBody());
			result.put("result", "success");
		} catch (Exception pe) {
			result.put("result", "failure");
		}
		
		return result;
	}
}
