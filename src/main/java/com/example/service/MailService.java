package com.example.service;

import com.example.entry.MailEntry;

/**
 * Send EMail
 */
public interface MailService {

    /**
     * Send SimpleMail
     * @param mailEntry
     */
    void sendSimpleMail(MailEntry mailEntry);

    /**
     * Send HTMLMail
     * @param mailEntry
     */
    void sendHtmlMail(MailEntry mailEntry);
}
