package com.project.impl;

import com.project.daomain.model.MailModel;
import com.project.service.MailService;
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
     * @param model
     */
    @Override
    public void sendSimpleMail(MailModel model) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.from);
        message.setTo(model.getTo());
        message.setSubject(model.getSubject());
        message.setText(model.getContent());
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            log.error("Send SimpleMail Exception",e);
        }
    }


    /**
     * Send  HTMLMail
     * @param model MailModel
     */
    @Override
    public void sendHtmlMail(MailModel model) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(this.from);
            mimeMessageHelper.setTo(model.getTo());
            mimeMessageHelper.setSubject(model.getSubject());
            mimeMessageHelper.setText(model.getContent(),true);
            javaMailSender.send(message);
            log.info("HTMLMail Send Success");
        } catch (Exception e) {
            log.error("Send  HTMLMail ", e);
        }
    }
}
