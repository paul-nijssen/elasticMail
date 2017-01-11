package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;
import com.elasticemail.ApiTypes.StringList;
import com.elasticemail.FileData;

import java.util.HashMap;

/**
 * SMTP and HTTP API channels for grouping email delivery.
 */
public class Channel extends API
{
    public Channel(String key) {
        super(key);
    }

    /**
     * Manually add a channel to your account to group email
     * @param name Descriptive name of the channel
     * @return String
     * @throws Exception
     */
    public String Add(String name) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       return uploadValues(API_URI + "/channel/add", values, String.class);
   }

    /**
     * Delete the channel.
     * @param name The name of the channel to delete.
     * @throws Exception
     */
    public void Delete(String name) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       uploadValues(API_URI + "/channel/delete", values, VoidApiResponse.class);
   }

    /**
     * Export channels in CSV file format.
     * @param channelNames
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file.
     * @return FileData
     * @throws Exception
     */
    public FileData ExportCsv(StringList channelNames, ApiTypes.CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelNames", String.valueOf(channelNames));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/channel/exportcsv", values, FileData.class);
   }

    /**
     * Export channels in JSON file format.
     * @param channelNames
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file.
     * @return FileData
     * @throws Exception
     */
    public FileData ExportJson(StringList channelNames, ApiTypes.CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelNames", String.valueOf(channelNames));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/channel/exportjson", values, FileData.class);
   }

    /**
     * Export channels in XML file format.
     * @param channelNames
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file.
     * @return FileData
     * @throws Exception
     */
    public FileData ExportXml(StringList channelNames, ApiTypes.CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelNames", String.valueOf(channelNames));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       return uploadValues(API_URI + "/channel/exportxml", values, FileData.class);
   }

    /**
     * List all of your channels
     * @return ApiTypes.ChannelList
     * @throws Exception
     */
    public ApiTypes.ChannelList List() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/channel/list", values, ApiTypes.ChannelList.class);
   }

    /**
     * Rename an existing channel.
     * @param name The name of the channel to update.
     * @param newName The new name for the channel.
     * @return String
     * @throws Exception
     */
    public String Update(String name, String newName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("name", name);
       values.put("newName", newName);
       return uploadValues(API_URI + "/channel/update", values, String.class);
   }

}

