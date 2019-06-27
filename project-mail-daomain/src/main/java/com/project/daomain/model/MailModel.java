package com.project.daomain.model;

import lombok.Data;

@Data
public class MailModel {
    private String to;
    private String subject;
    private String content;
}
