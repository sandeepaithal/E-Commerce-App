package org.jsp.ecommerce.service;

import org.jsp.ecommerce.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import static org.jsp.ecommerce.util.ApplicationConstants.VERIFY_LINK;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ECommerceAppEmailService {
  @Autowired
  private JavaMailSender javamailsender;
  
  public String sendWelcomeMail(Merchant merchant,HttpServletRequest request) {
	String siteUrl=request.getRequestURL().toString();
	String url=siteUrl.replace(request.getServletPath(), "");
	String actual_url=url+ VERIFY_LINK + merchant.getToken();
	MimeMessage message=javamailsender.createMimeMessage();
	MimeMessageHelper helper= new MimeMessageHelper(message);
	try {
		helper.setTo(merchant.getEmail());
		helper.setText(actual_url);
		helper.setSubject("ACTIVATION MAIL");
		javamailsender.send(message);
		return "VERIFICATION MAIL HAS BEEN SENT";
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "CANNOT SEND VERIFICATION MAIL";
	}
  }

}
