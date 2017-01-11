package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.ApiTypes;
import com.elasticemail.FileData;
import com.elasticemail.APIResponse;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Managing attachments uploaded to your account.
 */
public class Attachment extends API
{
    public Attachment(String key) {
        super(key);
    }

    /**
     * Permanently deletes attachment file from your account
     * @param attachmentID ID number of your attachment.
     * @throws Exception
     */
    public void Delete(long attachmentID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("attachmentID", String.valueOf(attachmentID));
       uploadValues(API_URI + "/attachment/delete", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Gets address of chosen Attachment
     * @param fileName Name of your file.
     * @param attachmentID ID number of your attachment.
     * @return FileData
     * @throws Exception
     */
    public FileData Get(String fileName, long attachmentID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("fileName", fileName);
       values.put("attachmentID", String.valueOf(attachmentID));
       return uploadValues(API_URI + "/attachment/get", values, FileData.class);
   }

    /**
     * Lists your available Attachments
     * @param msgID ID number of selected message.
     * @return ApiTypes.AttachmentList
     * @throws Exception
     */
    public ApiTypes.AttachmentList List(String msgID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("msgID", msgID);
       return uploadValues(API_URI + "/attachment/list", values, ApiTypes.AttachmentList.class);
   }

    /**
     * Permanently removes attachment file from your account
     * @param fileName Name of your file.
     * @throws Exception
     */
    public void Remove(String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("fileName", fileName);
       uploadValues(API_URI + "/attachment/remove", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Uploads selected file to the server using http form upload format (MIME multipart/form-data) or PUT method.
     * @param attachmentFile Content of your attachment.
     * @return ApiTypes.Attachment
     * @throws Exception
     */
    public ApiTypes.Attachment Upload(FileData attachmentFile) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return httpPostFile(API_URI + "/attachment/upload", Arrays.asList(attachmentFile), values, ApiTypes.Attachment.class);
   }

}

