package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.ApiTypes;
import com.elasticemail.APIResponse;

import java.util.HashMap;

/**
 * Managing and editing templates of your emails
 */
public class Template extends API
{
    public Template(String key) {
        super(key);
    }

    /**
     * Create new Template. Needs to be sent using POST method
     * @param templateType 0 for API connections
     * @param templateName Name of template.
     * @param subject Default subject of email.
     * @param fromEmail Default From: email address.
     * @param fromName Default From: name.
     * @param templateScope Enum: 0 - private, 1 - public, 2 - mockup
     * @param bodyHtml HTML code of email (needs escaping).
     * @param bodyText Text body of email.
     * @param css CSS style
     * @param originalTemplateID ID number of original template.
     * @return int
     * @throws Exception
     */
    public int Add(ApiTypes.TemplateType templateType, String templateName, String subject, String fromEmail, String fromName, ApiTypes.TemplateScope templateScope, String bodyHtml, String bodyText, String css, int originalTemplateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateType", String.valueOf(templateType));
       values.put("templateName", templateName);
       values.put("subject", subject);
       values.put("fromEmail", fromEmail);
       values.put("fromName", fromName);
       values.put("templateScope", String.valueOf(templateScope));
       values.put("bodyHtml", bodyHtml);
       values.put("bodyText", bodyText);
       values.put("css", css);
       values.put("originalTemplateID", String.valueOf(originalTemplateID));
       return uploadValues(API_URI + "/template/add", values, int.class);
   }

    /**
     * Check if template is used by campaign.

     * @param templateID ID number of template.
     * @return Boolean
     * @throws Exception
     */
    public Boolean CheckUsage(int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       return uploadValues(API_URI + "/template/checkusage", values, Boolean.class);
   }

    /**
     * Copy Selected Template

     * @param templateID ID number of template.
     * @param templateName Name of template.
     * @param subject Default subject of email.
     * @param fromEmail Default From: email address.
     * @param fromName Default From: name.
     * @return ApiTypes.Template
     * @throws Exception
     */
    public ApiTypes.Template Copy(int templateID, String templateName, String subject, String fromEmail, String fromName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       values.put("templateName", templateName);
       values.put("subject", subject);
       values.put("fromEmail", fromEmail);
       values.put("fromName", fromName);
       return uploadValues(API_URI + "/template/copy", values, ApiTypes.Template.class);
   }

    /**
     * Delete template with the specified ID

     * @param templateID ID number of template.
     * @throws Exception
     */
    public void Delete(int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       uploadValues(API_URI + "/template/delete", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Search for references to images and replaces them with base64 code.

     * @param templateID ID number of template.
     * @return String
     * @throws Exception
     */
    public String GetEmbeddedHtml(int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       return uploadValues(API_URI + "/template/getembeddedhtml", values, String.class);
   }

    /**
     * Lists your templates

     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.TemplateList
     * @throws Exception
     */
    public ApiTypes.TemplateList GetList(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/template/getlist", values, ApiTypes.TemplateList.class);
   }

    /**
     * Load template with content

     * @param templateID ID number of template.
     * @param ispublic
     * @return ApiTypes.Template
     * @throws Exception
     */
    public ApiTypes.Template LoadTemplate(int templateID, Boolean ispublic) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       values.put("ispublic", String.valueOf(ispublic));
       return uploadValues(API_URI + "/template/loadtemplate", values, ApiTypes.Template.class);
   }

    /**
     * Removes previously generated screenshot of template

     * @param templateID ID number of template.
     * @throws Exception
     */
    public void RemoveScreenshot(int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       uploadValues(API_URI + "/template/removescreenshot", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Saves screenshot of chosen Template

     * @param base64Image Image, base64 coded.
     * @param templateID ID number of template.
     * @return String
     * @throws Exception
     */
    public String SaveScreenshot(String base64Image, int templateID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("base64Image", base64Image);
       values.put("templateID", String.valueOf(templateID));
       return uploadValues(API_URI + "/template/savescreenshot", values, String.class);
   }

    /**
     * Update existing template, overwriting existing data. Needs to be sent using POST method.

     * @param templateID ID number of template.
     * @param templateScope Enum: 0 - private, 1 - public, 2 - mockup
     * @param templateName Name of template.
     * @param subject Default subject of email.
     * @param fromEmail Default From: email address.
     * @param fromName Default From: name.
     * @param bodyHtml HTML code of email (needs escaping).
     * @param bodyText Text body of email.
     * @param css CSS style
     * @param removeScreenshot
     * @throws Exception
     */
    public void Update(int templateID, ApiTypes.TemplateScope templateScope, String templateName, String subject, String fromEmail, String fromName, String bodyHtml, String bodyText, String css, Boolean removeScreenshot) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("templateID", String.valueOf(templateID));
       values.put("templateScope", String.valueOf(templateScope));
       values.put("templateName", templateName);
       values.put("subject", subject);
       values.put("fromEmail", fromEmail);
       values.put("fromName", fromName);
       values.put("bodyHtml", bodyHtml);
       values.put("bodyText", bodyText);
       values.put("css", css);
       values.put("removeScreenshot", String.valueOf(removeScreenshot));
       uploadValues(API_URI + "/template/update", values, APIResponse.VoidApiResponse.class);
   }

}

