package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;

import java.util.HashMap;

/**
 * Manages your segments - dynamically created lists of contacts
 */
public class Segment extends API
{
    public Segment(String key) {
        super(key);
    }

    /**
     * Create new segment, based on specified RULE.

     * @param segmentName Name of your segment.
     * @param rule Query used for filtering.
     * @return ApiTypes.Segment
     * @throws Exception
     */
    public ApiTypes.Segment Add(String segmentName, String rule) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       values.put("rule", rule);
       return uploadValues(API_URI + "/segment/add", values, ApiTypes.Segment.class);
   }

    /**
     * Delete existing segment.

     * @param segmentName Name of your segment.
     * @throws Exception
     */
    public void Delete(String segmentName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       uploadValues(API_URI + "/segment/delete", values, VoidApiResponse.class);
   }

    /**
     * Lists all your available Segments

     * @param includeHistory True: Include history of last 30 days. Otherwise, false.
     * @return ApiTypes.SegmentList
     * @throws Exception
     */
    public ApiTypes.SegmentList List(Boolean includeHistory) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("includeHistory", String.valueOf(includeHistory));
       return uploadValues(API_URI + "/segment/list", values, ApiTypes.SegmentList.class);
   }

    /**
     * Rename or change RULE for your segment

     * @param segmentName Name of your segment.
     * @param newSegmentName New name of your segment if you want to change it.
     * @param rule Query used for filtering.
     * @return ApiTypes.Segment
     * @throws Exception
     */
    public ApiTypes.Segment Update(String segmentName, String newSegmentName, String rule) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("segmentName", segmentName);
       values.put("newSegmentName", newSegmentName);
       values.put("rule", rule);
       return uploadValues(API_URI + "/segment/update", values, ApiTypes.Segment.class);
   }

}

