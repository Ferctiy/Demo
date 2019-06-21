package com.example.service.impl;

import com.example.entry.MailEntry;
import com.example.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * Send SimpleMail
     * @param mailEntry
     */
    @Override
    public void sendSimpleMail(MailEntry mailEntry) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.from);
        message.setTo(mailEntry.getTo());
        message.setSubject(mailEntry.getSubject());
        message.setText(mailEntry.getContent());
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("Send SimpleMail Exception",e);
        }
    }


    /**
     * Send  HTMLMail
     * @param mailEntry MailEntry
     */
    @Override
    public void sendHtmlMail(MailEntry mailEntry) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(this.from);
            mimeMessageHelper.setTo(mailEntry.getTo());
            mimeMessageHelper.setSubject(mailEntry.getSubject());
            mimeMessageHelper.setText(mailEntry.getContent(),true);
            javaMailSender.send(message);
            log.info("HTMLMail Send Success");
        } catch (Exception e) {
            log.error("Send  HTMLMail ", e);
        }
    }
}
