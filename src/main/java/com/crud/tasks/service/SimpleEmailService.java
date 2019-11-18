package com.crud.tasks.service;


import com.crud.tasks.domain.Mail;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail) {

        LOGGER.info("Start przygotowywania maila");

        try {
           // SimpleMailMessage mailMessage = createMailMessage(receiverEmail, subject, message);
            javaMailSender.send(createMailMessage(mail));

            LOGGER.info("Mail wysłany");

        } catch (MailException e) {
            LOGGER.error("Failed to process email sending", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        EmailValidator validator = EmailValidator.getInstance();

        if (validator.isValid(mail.getMailTo())) {
            mailMessage.setCc(mail.getToCC());
        }
/*
        if (mail.getToCC() != "" ) {
            mailMessage.setCc(mail.getToCC());
        }
*/
        return mailMessage;
    }

}
