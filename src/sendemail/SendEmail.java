/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendemail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "sxxxx@hotmail.com";//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "dxxxxc@gmail.com";//change accordingly
        final String username = "dilsh7";//change accordingly
        final String password = "xxxxxx";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            for (int i = 0; i < 100; i++) {
                // Set Subject: header field
                message.setSubject("Testing Subject"+ i);

                // Now set the actual message
                message.setText("Hello, this is sample for to check send "
                        + "email using JavaMailAPI ");

                // Send message
                Transport.send(message);
            }

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
