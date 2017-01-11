package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;
import com.elasticemail.ApiTypes.StringList;

import java.util.HashMap;

/**
 * Sending and monitoring progress of your Campaigns
 */
public class Campaign extends API
{
    public Campaign(String key) {
        super(key);
    }

    /**
     * Adds a campaign to the queue for processing based on the configuration
     * @param campaign Json representation of a campaign
     * @return int
     * @throws Exception
     */
    public int Add(ApiTypes.Campaign campaign) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("apikey", API_KEY);
       values.put("campaign", String.valueOf(campaign));
       return uploadValues(API_URI + "/campaign/add", values, int.class);
   }

    /**
     * Copy selected campaign
     * @param channelID ID number of selected Channel.
     * @throws Exception
     */
    public void Copy(int channelID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelID", String.valueOf(channelID));
       uploadValues(API_URI + "/campaign/copy", values, VoidApiResponse.class);
   }

    /**
     * Delete selected campaign
     * @param channelID ID number of selected Channel.
     * @throws Exception
     */
    public void Delete(int channelID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("channelID", String.valueOf(channelID));
       uploadValues(API_URI + "/campaign/delete", values, VoidApiResponse.class);
   }

    /**
     * Export selected campaigns to chosen file format.
     * @param campaignNames
     * @param fileFormat 
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file.
     * @throws Exception
     */
    public void Export(StringList campaignNames, ApiTypes.ExportFileFormats fileFormat, ApiTypes.CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("campaignNames", String.valueOf(campaignNames));
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       uploadValues(API_URI + "/campaign/export", values, VoidApiResponse.class);
   }

    /**
     * List all of your campaigns
     * @param search Text fragment used for searching.
     * @param offset How many items should be loaded ahead.
     * @param limit Maximum of loaded items.
     * @return ApiTypes.CampaignChannelList
     * @throws Exception
     */
    public ApiTypes.CampaignChannelList List(String search, int offset, int limit) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("search", search);
       values.put("offset", String.valueOf(offset));
       values.put("limit", String.valueOf(limit));
       return uploadValues(API_URI + "/campaign/list", values, ApiTypes.CampaignChannelList.class);
   }

    /**
     * Updates a previously added campaign.  Only Active and Paused campaigns can be updated.
     * @param campaign Json representation of a campaign
     * @return int
     * @throws Exception
     */
    public int Update(ApiTypes.Campaign campaign) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("apikey", API_KEY);
       values.put("campaign", String.valueOf(campaign));
       return uploadValues(API_URI + "/campaign/update", values, int.class);
   }

}

