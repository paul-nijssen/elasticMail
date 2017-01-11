package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.ApiTypes;
import com.elasticemail.ApiTypes.StringList;
import com.elasticemail.FileData;

import java.util.HashMap;

/**
 *
 */
public class Email extends API {
    public Email(String key) {
        super(key);
    }

    /**
     * Get email batch status
     *
     * @param transactionID    Transaction identifier
     * @param showFailed       Include Bounced email addresses.
     * @param showDelivered    Include Sent email addresses.
     * @param showPending      Include Ready to send email addresses.
     * @param showOpened       Include Opened email addresses.
     * @param showClicked      Include Clicked email addresses.
     * @param showAbuse        Include Reported as abuse email addresses.
     * @param showUnsubscribed Include Unsubscribed email addresses.
     * @param showErrors       Include error messages for bounced emails.
     * @return ApiTypes.EmailJobStatus
     * @throws Exception
     */
    public ApiTypes.EmailJobStatus GetStatus(String transactionID, Boolean showFailed, Boolean showDelivered, Boolean showPending, Boolean showOpened, Boolean showClicked, Boolean showAbuse, Boolean showUnsubscribed, Boolean showErrors) throws Exception {
        HashMap<String, String> values = new HashMap<String, String>();
        values.put("apikey", API_KEY);
        values.put("transactionID", transactionID);
        values.put("showFailed", String.valueOf(showFailed));
        values.put("showDelivered", String.valueOf(showDelivered));
        values.put("showPending", String.valueOf(showPending));
        values.put("showOpened", String.valueOf(showOpened));
        values.put("showClicked", String.valueOf(showClicked));
        values.put("showAbuse", String.valueOf(showAbuse));
        values.put("showUnsubscribed", String.valueOf(showUnsubscribed));
        values.put("showErrors", String.valueOf(showErrors));
        return uploadValues(API_URI + "/email/getstatus", values, ApiTypes.EmailJobStatus.class);
    }

    /**
     * Submit emails
     *
     * @param subject             Email subject
     * @param from                From email address
     * @param fromName            Display name for from email address
     * @param sender              Email address of the sender
     * @param senderName          Display name sender
     * @param msgFrom             Optional parameter. Sets FROM MIME header.
     * @param msgFromName         Optional parameter. Sets FROM name of MIME header.
     * @param replyTo             Email address to reply to
     * @param replyToName         Display name of the reply to address
     * @param to                  List of email recipients (each email is treated separately, like a BCC). Separated by comma or semicolon.
     * @param msgTo               Optional parameter. List of email recipients (visible to all other recipients of the message as TO MIME header). Separated by comma or semicolon.
     * @param msgCC               Optional parameter. List of email recipients (visible to all other recipients of the message as CC MIME header). Separated by comma or semicolon.
     * @param msgBcc              Optional parameter. List of email recipients (each email is treated seperately). Separated by comma or semicolon.
     * @param lists               The name of a contact list you would like to send to. Separate multiple contact lists by commas or semicolons.
     * @param segments            The name of a segment you would like to send to. Separate multiple segments by comma or semicolon. Input "0" for "All Contacts".
     * @param mergeSourceFilename File name one of attachments which is a CSV list of Recipients.
     * @param channel             An ID field (max 60 chars) that can be used for reporting [will default to HTTP API or SMTP API]
     * @param bodyHtml            Html email body
     * @param bodyText            Text email body
     * @param charset             Text value of charset encoding for example: iso-8859-1, windows-1251, utf-8, us-ascii, windows-1250 and more…
     * @param charsetBodyHtml     Sets charset for body html MIME part (overrides default value from charset parameter)
     * @param charsetBodyText     Sets charset for body text MIME part (overrides default value from charset parameter)
     * @param encodingType        0 for None, 1 for Raw7Bit, 2 for Raw8Bit, 3 for QuotedPrintable, 4 for Base64 (Default), 5 for Uue  note that you can also provide the text version such as "Raw7Bit" for value 1.  NOTE: Base64 or QuotedPrintable is recommended if you are validating your domain(s) with DKIM.
     * @param template            The name of an email template you have created in your account.
     * @param attachmentFiles     Attachment files. These files should be provided with the POST multipart file upload, not directly in the request's URL. Should also include merge CSV file
     * @param headers             Optional Custom Headers. Request parameters prefixed by headers_ like headers_customheader1, headers_customheader2. Note: a space is required after the colon before the custom header value. headers_customheader1=customheader1: header-value1 headers_customheader2 = customheader2: header-value2
     * @param postBack            Optional header returned in notifications.
     * @param merge               Request parameters prefixed by merge_ like merge_firstname, merge_lastname. If sending to a template you can send merge_ fields to merge data with the template. Template fields are entered with {firstname}, {lastname} etc.
     * @param timeOffSetMinutes   Number of minutes in the future this email should be sent
     * @return ApiTypes.EmailSend
     * @throws Exception
     */
    public ApiTypes.EmailSend Send(String subject, String from, String fromName, String sender, String senderName, String msgFrom, String msgFromName, String replyTo, String replyToName, StringList to, String[] msgTo, String[] msgCC, String[] msgBcc, StringList lists, StringList segments, String mergeSourceFilename, String channel, String bodyHtml, String bodyText, String charset, String charsetBodyHtml, String charsetBodyText, ApiTypes.EncodingType encodingType, String template, Iterable<FileData> attachmentFiles, HashMap<String, String> headers, String postBack, HashMap<String, String> merge, String timeOffSetMinutes) throws Exception {
        HashMap<String, String> values = new HashMap<String, String>();
        values.put("apikey", API_KEY);
        values.put("subject", subject);
        values.put("from", from);
        values.put("fromName", fromName);
        values.put("sender", sender);
        values.put("senderName", senderName);
        values.put("msgFrom", msgFrom);
        values.put("msgFromName", msgFromName);
        values.put("replyTo", replyTo);
        values.put("replyToName", replyToName);
        values.put("to", String.valueOf(to));
        values.put("msgTo", String.valueOf(msgTo));
        values.put("msgCC", String.valueOf(msgCC));
        values.put("msgBcc", String.valueOf(msgBcc));
        values.put("lists", String.valueOf(lists));
        values.put("segments", String.valueOf(segments));
        values.put("mergeSourceFilename", mergeSourceFilename);
        values.put("channel", channel);
        values.put("bodyHtml", bodyHtml);
        values.put("bodyText", bodyText);
        values.put("charset", charset);
        values.put("charsetBodyHtml", charsetBodyHtml);
        values.put("charsetBodyText", charsetBodyText);
        values.put("encodingType", String.valueOf(encodingType));
        values.put("template", template);
        if (headers != null) values.put("headers", String.valueOf(headers));
        values.put("postBack", postBack);
        if (merge != null) values.put("merge", String.valueOf(merge));
        values.put("timeOffSetMinutes", timeOffSetMinutes);
        return httpPostFile(API_URI + "/email/send", attachmentFiles, values, ApiTypes.EmailSend.class);
    }

    /**
     * View email
     *
     * @param msgID Message identifier
     * @return ApiTypes.EmailView
     * @throws Exception
     */
    public ApiTypes.EmailView View(String msgID) throws Exception {
        HashMap<String, String> values = new HashMap<String, String>();
        values.put("msgID", msgID);
        return uploadValues(API_URI + "/email/view", values, ApiTypes.EmailView.class);
    }

}

