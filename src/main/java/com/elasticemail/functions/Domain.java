package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;

import java.util.HashMap;

/**
 * Managing sender domains. Creating new entries and validating domain records.
 */
public class Domain extends API
{
    public Domain(String key) {
        super(key);
    }

    /**
     * Add new domain to account
     * @param domain Name of selected domain.
     * @throws Exception
     */
    public void Add(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/add", values, VoidApiResponse.class);
   }

    /**
     * Deletes configured domain from account
     * @param domain Name of selected domain.
     * @throws Exception
     */
    public void Delete(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/delete", values, VoidApiResponse.class);
   }

    /**
     * Lists all domains configured for this account.
     * @return ApiTypes.DomainDetailList
     * @throws Exception
     */
    public ApiTypes.DomainDetailList List() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/domain/list", values, ApiTypes.DomainDetailList.class);
   }

    /**
     * Verification of email addres set for domain.
     * @param domain Default email sender, example: mail@yourdomain.com
     * @throws Exception
     */
    public void SetDefault(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/setdefault", values, VoidApiResponse.class);
   }

    /**
     * Verification of DKIM record for domain
     * @param domain Name of selected domain.
     * @throws Exception
     */
    public void VerifyDkim(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/verifydkim", values, VoidApiResponse.class);
   }

    /**
     * Verification of MX record for domain
     * @param domain Name of selected domain.
     * @throws Exception
     */
    public void VerifyMX(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/verifymx", values, VoidApiResponse.class);
   }

    /**
     * Verification of SPF record for domain
     * @param domain Name of selected domain.
     * @throws Exception
     */
    public void VerifySpf(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/verifyspf", values, VoidApiResponse.class);
   }

    /**
     * Verification of tracking CNAME record for domain
     * @param domain Name of selected domain.
     * @throws Exception
     */
    public void VerifyTracking(String domain) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("domain", domain);
       uploadValues(API_URI + "/domain/verifytracking", values, VoidApiResponse.class);
   }

}

