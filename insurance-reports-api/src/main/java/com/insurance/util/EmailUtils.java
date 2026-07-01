package com.insurance.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(String to,String subject, String body , File file) {
		
		try {
			
			//for mail with attachment otherwise "SimpleMailMessage" can use
			MimeMessage mimeMsg = mailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
			
			//set subject
			helper.setSubject(subject);
			//set body
			//the 2nd argument true is use to for html code in the mail body
			helper.setText(body, true);
			helper.setTo(to);
			//adding the file attachment
			helper.addAttachment(body, file);
			
			
			mailSender.send(mimeMsg);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return true;
	}

}
