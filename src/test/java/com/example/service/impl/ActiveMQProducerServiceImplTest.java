package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.entry.MailEntry;
import com.example.service.ActiveMQProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ActiveMQProducerServiceImplTest {

    @Autowired
    private ActiveMQProducerService activeMQProducerService;

    @Test
    public void sendTopicMessage() {
        MailEntry mailEntry = new MailEntry();
        mailEntry.setTo("992611060@qq.com");
        mailEntry.setContent("This is a test Message");
        mailEntry.setSubject("异步发送邮件");
        this.activeMQProducerService.sendTopicMessage(mailEntry);
        System.out.println(String.format(" Topic Producer Send Message is %s ", JSON.toJSONString(mailEntry)));
    }

    @Test
    public void sendQueueMessage() {
        MailEntry mailEntry = new MailEntry();
        mailEntry.setTo("992611060@qq.com");
        mailEntry.setContent("This is a test Message");
        mailEntry.setSubject("异步发送邮件");
        this.activeMQProducerService.sendQueueMessage(mailEntry);
        System.out.println(String.format(" Queue Producer Send Message is %s ", JSON.toJSONString(mailEntry)));
    }
}