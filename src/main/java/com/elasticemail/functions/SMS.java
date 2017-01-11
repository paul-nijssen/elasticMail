package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse;

import java.util.HashMap;

/**
 * Managing texting to your clients.
 */
public class SMS extends API
{
    public SMS(String key) {
        super(key);
    }

    /**
     * Checking the return status of sent SMS

     * @param messageSid Comma separated ID numbers of messages.
     * @throws Exception
     */
    public void Callback(String messageSid) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("messageSid", messageSid);
       uploadValues(API_URI + "/sms/callback", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Send a short SMS Message (maximum of 1600 characters) to any mobile phone.

     * @param to Mobile number you want to message. Can be any valid mobile number in E.164 format. To provide the country code you need to provide "+" before the number.  If your URL is not encoded then you need to replace the "+" with "%2B" instead.
     * @param body Body of your message. The maximum body length is 160 characters.  If the message body is greater than 160 characters it is split into multiple messages and you are charged per message for the number of message required to send your length
     * @throws Exception
     */
    public void Send(String to, String body) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("to", to);
       values.put("body", body);
       uploadValues(API_URI + "/sms/send", values, APIResponse.VoidApiResponse.class);
   }

}

