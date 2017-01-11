package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;

import java.util.HashMap;
import java.util.UUID;

/**
 * 
 */
public class Export extends API
{
    public Export(String key) {
        super(key);
    }

    /**
     * Check the current status of the export.

     * @param publicExportID 
     * @return ApiTypes.ExportStatus
     * @throws Exception
     */
    public ApiTypes.ExportStatus CheckStatus(UUID publicExportID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicExportID", String.valueOf(publicExportID));
       return uploadValues(API_URI + "/export/checkstatus", values, ApiTypes.ExportStatus.class);
   }

    /**
     * Summary of export type counts.

     * @return ApiTypes.ExportTypeCounts
     * @throws Exception
     */
    public ApiTypes.ExportTypeCounts CountByType() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/export/countbytype", values, ApiTypes.ExportTypeCounts.class);
   }

    /**
     * Delete the specified export.

     * @param publicExportID
     * @throws Exception
     */
    public void Delete(UUID publicExportID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicExportID", String.valueOf(publicExportID));
       uploadValues(API_URI + "/export/delete", values, VoidApiResponse.class);
   }

    /**
     * Returns a list of all exported data.

     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ExportList
     * @throws Exception
     */
    public ApiTypes.ExportList List(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/export/list", values, ApiTypes.ExportList.class);
   }

}

