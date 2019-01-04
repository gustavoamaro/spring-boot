package br.com.gustavoamaro.springboot.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	public void send(String guestName, String guestMail){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.mailtrap.io");
            email.setSmtpPort(2525);
            email.setAuthenticator(new DefaultAuthenticator("1d0a8f092c864e", "7e42aea4e2fea2"));
//            email.setSSLOnConnect(true);

            email.setFrom("guestslist@gustavoamaro.com.br");
            email.setSubject("You have been invited by GuestsList");
            email.setMsg("Hello " + guestName + ". You have been invited by GuestsList.");
            email.addTo(guestMail);
            email.send();

        } catch (EmailException e) {
            throw new IllegalStateException(e);
        }
    }
}