package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;

import java.util.HashMap;
import java.util.UUID;

/**
 * Methods to organize and get results of your surveys
 */
public class Survey extends API
{
    public Survey(String key) {
        super(key);
    }

    /**
     * Adds a new survey

     * @param survey Json representation of a survey
     * @return ApiTypes.Survey
     * @throws Exception
     */
    public ApiTypes.Survey Add(ApiTypes.Survey survey) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("survey", String.valueOf(survey));
       return uploadValues(API_URI + "/survey/add", values, ApiTypes.Survey.class);
   }

    /**
     * Deletes the survey

     * @param publicSurveyID Survey identifier
     * @throws Exception
     */
    public void Delete(UUID publicSurveyID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicSurveyID", String.valueOf(publicSurveyID));
       uploadValues(API_URI + "/survey/delete", values, VoidApiResponse.class);
   }

    /**
     * Export given survey's data to provided format

     * @param publicSurveyID Survey identifier
     * @param fileName Name of your file.
     * @param fileFormat 
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @throws Exception
     */
    public void Export(UUID publicSurveyID, String fileName, ApiTypes.ExportFileFormats fileFormat, ApiTypes.CompressionFormat compressionFormat) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicSurveyID", String.valueOf(publicSurveyID));
       values.put("fileName", fileName);
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       uploadValues(API_URI + "/survey/export", values, VoidApiResponse.class);
   }

    /**
     * Shows all your existing surveys

     * @return ApiTypes.SurveyList
     * @throws Exception
     */
    public ApiTypes.SurveyList List() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/survey/list", values, ApiTypes.SurveyList.class);
   }

    /**
     * Get list of personal answers for the specific survey

     * @param publicSurveyID Survey identifier
     * @return ApiTypes.SurveyResultInfoList
     * @throws Exception
     */
    public ApiTypes.SurveyResultInfoList LoadResponseList(UUID publicSurveyID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicSurveyID", String.valueOf(publicSurveyID));
       return uploadValues(API_URI + "/survey/loadresponselist", values, ApiTypes.SurveyResultInfoList.class);
   }

    /**
     * Get general results of the specific survey

     * @param publicSurveyID Survey identifier
     * @return ApiTypes.SurveyResultsSummaryInfo
     * @throws Exception
     */
    public ApiTypes.SurveyResultsSummaryInfo LoadResults(UUID publicSurveyID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("publicSurveyID", String.valueOf(publicSurveyID));
       return uploadValues(API_URI + "/survey/loadresults", values, ApiTypes.SurveyResultsSummaryInfo.class);
   }

    /**
     * Update the survey information

     * @param survey Json representation of a survey
     * @return ApiTypes.Survey
     * @throws Exception
     */
    public ApiTypes.Survey Update(ApiTypes.Survey survey) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("survey", String.valueOf(survey));
       return uploadValues(API_URI + "/survey/update", values, ApiTypes.Survey.class);
   }

}

