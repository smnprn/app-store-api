package com.smnprn.appstorevisualizer.service;

import com.smnprn.appstorevisualizer.utils.EmailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {
    private final JavaMailSender mailSender;
    private final static Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("smnprn@gmail.com");
            mailSender.send(message);
        } catch (MessagingException e) {
            LOG.error("Fail to send email", e);
            throw  new IllegalStateException("Failed to send email");
        }
    }
}
