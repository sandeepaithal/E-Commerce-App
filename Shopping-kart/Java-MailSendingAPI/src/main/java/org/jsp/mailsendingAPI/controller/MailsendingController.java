package org.jsp.mailsendingAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponseWrapper;

@RestController
@CrossOrigin
public class MailsendingController {

	@Autowired
	private JavaMailSender javamailsender;
	private String token;

	@PostMapping("/send-mail")
	public String sendMail(HttpServletRequest request, @RequestParam String email_id) {
		String siteurl = request.getRequestURL().toString();
		String url = siteurl.replace(request.getServletPath(), "/verify");
		MimeMessage message = javamailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setSubject("Account Verification");
			helper.setText(url);
			helper.setTo(email_id);
			javamailsender.send(message);
			return "Mail has been sent";
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Cannot send email";
		}
	}
	@GetMapping("/verify")
	public String verify(@RequestParam String token) {
		if(this.token.equals(token)) {
			return "verification succesfull";
		}
		else {
			return "cannot verify";
		}
	}

}