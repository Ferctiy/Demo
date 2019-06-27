package com.project.service;


import com.project.daomain.model.MailModel;

/**
 * Send EMail
 */
public interface MailService {

    /**
     * Send SimpleMail
     *
     * @param model MailModel
     */
    void sendSimpleMail(MailModel model);

    /**
     * Send HTMLMail
     *
     * @param model MailEntry
     */
    void sendHtmlMail(MailModel model);
}
