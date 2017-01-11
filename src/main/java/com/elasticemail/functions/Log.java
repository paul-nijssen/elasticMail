package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;

import java.util.Date;
import java.util.HashMap;

/**
 * Methods to check logs of your campaigns
 */
public class Log extends API
{
   public Log(String key) {
      super(key);
   }

   /**
     * Cancels emails that are waiting to be sent.

     * @param channelName Name of selected channel.
     * @param transactionID ID number of transaction
     * @throws Exception
     */
    public void CancelInProgress(String channelName, String transactionID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelName", channelName);
       values.put("transactionID", transactionID);
       uploadValues(API_URI + "/log/cancelinprogress", values, VoidApiResponse.class);
   }

    /**
     * Track link clicks

     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @param channelName Name of selected channel.
     * @return ApiTypes.LinkTrackingDetails
     * @throws Exception
     */
    public ApiTypes.LinkTrackingDetails LinkTracking(Date from, Date to, int limit, int offset, String channelName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("from", String.valueOf(from));
       values.put("to", String.valueOf(to));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("channelName", channelName);
       return uploadValues(API_URI + "/log/linktracking", values, ApiTypes.LinkTrackingDetails.class);
   }

    /**
     * Returns logs filtered by specified parameters.

     * @param statuses List of comma separated message statuses: 0 or all, 1 for ReadyToSend, 2 for InProgress, 4 for Bounced, 5 for Sent, 6 for Opened, 7 for Clicked, 8 for Unsubscribed, 9 for Abuse Report
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param channelName Name of selected channel.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @param includeEmail True: Search includes emails. Otherwise, false.
     * @param includeSms True: Search includes SMS. Otherwise, false.
     * @param messagecategory ID of message category
     * @return ApiTypes.Log
     * @throws Exception
     */
    public ApiTypes.Log Load(ApiTypes.LogJobStatusList statuses, Date from, Date to, String channelName, int limit, int offset, Boolean includeEmail, Boolean includeSms, int messagecategory) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("statuses", String.valueOf(statuses));
       values.put("from", String.valueOf(from));
       values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("includeEmail", String.valueOf(includeEmail));
       values.put("includeSms", String.valueOf(includeSms));
       values.put("messagecategory", String.valueOf(messagecategory));
       return uploadValues(API_URI + "/log/load", values, ApiTypes.Log.class);
   }

    /**
     * Retry sending of temporarily not delivered message.

     * @param msgID ID number of selected message.
     * @throws Exception
     */
    public void RetryNow(String msgID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("msgID", msgID);
       uploadValues(API_URI + "/log/retrynow", values, VoidApiResponse.class);
   }

    /**
     * Loads summary information about activity in chosen date range.

     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @param channelName Name of selected channel.
     * @param interval 'Hourly' for detailed information, 'summary' for daily overview
     * @param transactionID ID number of transaction
     * @return ApiTypes.LogSummary
     * @throws Exception
     */
    public ApiTypes.LogSummary Summary(Date from, Date to, String channelName, String interval, String transactionID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("from", String.valueOf(from));
       values.put("to", String.valueOf(to));
       values.put("channelName", channelName);
       values.put("interval", interval);
       values.put("transactionID", transactionID);
       return uploadValues(API_URI + "/log/summary", values, ApiTypes.LogSummary.class);
   }

}

