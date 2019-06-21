package com.example.entry;

import lombok.Data;

/**
 * MailEntry
 */
@Data
public class MailEntry {
    private String to;
    private String subject;
    private String content;
}
