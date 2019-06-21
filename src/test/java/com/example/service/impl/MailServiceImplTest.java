package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.entry.MailEntry;
import com.example.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MailServiceImplTest {

    @Autowired
    protected MailService MailService;

    /**
     * Send Simple Mail
     */
    @Test
    public void sendSimpleMail() {
        MailEntry mailEntry = new MailEntry();
        mailEntry.setTo("992611060@qq.com");
        mailEntry.setContent("This is a test Message");
        mailEntry.setSubject("异步发送邮件");
        this.MailService.sendSimpleMail(mailEntry);
        System.out.println("Send info" + JSON.toJSONString(mailEntry));
    }

    /**
     * Send HTMLMail
     */
    @Test
    public void sendHtmlMail() {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MailEntry mailEntry = new MailEntry();
        mailEntry.setTo("992611060@qq.com");
        mailEntry.setContent(content);
        mailEntry.setSubject("异步发送邮件");
        this.MailService.sendHtmlMail(mailEntry);
        System.out.println("Send info" + JSON.toJSONString(mailEntry));
    }
}