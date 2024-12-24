package com.airline.email.verify;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public String sendEmail(String to,String from,String subject,String message)
	{
		String host = "smtp.gmail.com";

	     // Configure properties for the mail session
	     Properties properties = new Properties();
	     properties.put("mail.smtp.host", host);
	     properties.put("mail.smtp.port", "587");             // Use STARTTLS
	     properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
	     properties.put("mail.smtp.auth", "true");            // Enable authentication

	     // Create a session with the sender's email credentials
	     Session session = Session.getInstance(properties, new Authenticator() {
	         @Override
	         protected PasswordAuthentication getPasswordAuthentication() {
	             return new PasswordAuthentication("swapnilkhandare1001@gmail.com", "pbbc nham licw odwb"); // Use an App Password
	         }
	     });

	     //session.setDebug(true); // Enable debug output for troubleshooting

	     try {
	         // Compose the email
	         MimeMessage mimeMessage = new MimeMessage(session);
	         mimeMessage.setFrom(new InternetAddress(from)); // Sender's email
	         mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // Recipient's email
	         mimeMessage.setSubject(subject); // Email subject
	         mimeMessage.setText(message);   // Email body

	         // Send the email
	         Transport.send(mimeMessage);
	         String sucess="OTP Sent Sucessfully";
	         return sucess;
	         
	     } catch (MessagingException e) {
	         e.printStackTrace();
	     }
		return null;
		
	 }
}
	 

