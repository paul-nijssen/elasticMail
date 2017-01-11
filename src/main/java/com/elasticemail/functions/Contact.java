package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.ApiTypes;
import com.elasticemail.ApiTypes.StringList;
import com.elasticemail.FileData;
import com.elasticemail.APIResponse;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/**
 * Methods used to manage your Contacts.
 */
public class Contact extends API
{
   public Contact(String key) {
      super(key);
   }

   /**
     * Activate contacts that are currently blocked.
     * @param activateAllBlocked Activate all your blocked contacts.  Passing True will override email list and activate all your blocked contacts.
     * @param emails Comma delimited list of contact emails
     * @throws Exception
     */
    public void ActivateBlocked(Boolean activateAllBlocked, StringList emails) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("activateAllBlocked", String.valueOf(activateAllBlocked));
       values.put("emails", String.valueOf(emails));
       uploadValues(API_URI + "/contact/activateblocked", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Add a new contact and optionally to one of your lists.  Note that your API KEY is not required for this call.
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @param email Proper email address.
     * @param publicListID ID code of list
     * @param listName Name of your list.
     * @param title Title
     * @param firstName First name.
     * @param lastName Last name.
     * @param phone Phone number
     * @param mobileNumber Mobile phone number
     * @param notes Free form field of notes
     * @param gender Your gender
     * @param birthDate Date of birth in YYYY-MM-DD format
     * @param city City.
     * @param state State or province.
     * @param postalCode Zip/postal code.
     * @param country Name of country.
     * @param organizationName Name of organization
     * @param website HTTP address of your website.
     * @param annualRevenue Annual revenue of contact
     * @param industry Industry contact works in
     * @param numberOfEmployees Number of employees
     * @param type 
     * @param return_Url URL to navigate to after account creation
     * @param source_Url The url for activation for private branding.
     * @param activation_Return_Url The url to return the contact to after activation.
     * @param activation_Template The custom template for double optin-in activation. Requires {url} merge tag.
     * @param requiresActivation True, if you want to send an activation notice to double opt-in the contact. Otherwise, false
     * @return String
     * @throws Exception
     */
    public String Add(String publicAccountID, String email, String[] publicListID, String[] listName, String title, String firstName, String lastName, String phone, String mobileNumber, String notes, String gender, Date birthDate, String city, String state, String postalCode, String country, String organizationName, String website, int annualRevenue, String industry, int numberOfEmployees, ApiTypes.ContactSource type, String return_Url, String source_Url, String activation_Return_Url, String activation_Template, Boolean requiresActivation) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("publicAccountID", publicAccountID);
       values.put("email", email);
       values.put("publicListID", String.valueOf(publicListID));
       values.put("listName", String.valueOf(listName));
       values.put("title", title);
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("phone", phone);
       values.put("mobileNumber", mobileNumber);
       values.put("notes", notes);
       values.put("gender", gender);
       values.put("birthDate", String.valueOf(birthDate));
       values.put("city", city);
       values.put("state", state);
       values.put("postalCode", postalCode);
       values.put("country", country);
       values.put("organizationName", organizationName);
       values.put("website", website);
       values.put("annualRevenue", String.valueOf(annualRevenue));
       values.put("industry", industry);
       values.put("numberOfEmployees", String.valueOf(numberOfEmployees));
       values.put("type", String.valueOf(type));
       values.put("return_Url", return_Url);
       values.put("source_Url", source_Url);
       values.put("activation_Return_Url", activation_Return_Url);
       values.put("activation_Template", activation_Template);
       values.put("requiresActivation", String.valueOf(requiresActivation));
       return uploadValues(API_URI + "/contact/add", values, String.class);
   }

   public String Add(ApiTypes.Contact contact, String listName) throws Exception {
      HashMap<String, String> values = new HashMap<String, String>();
//      values.put("publicAccountID",contact.publicAccountID);
      values.put("email", contact.email);
      values.put("listName", listName);
//      values.put("publicListID", String.valueOf(publicListID));
//      values.put("listName", String.valueOf(contact.listName));
      values.put("title", contact.title);
      values.put("firstName", contact.firstname);
      values.put("lastName", contact.lastname);
      values.put("phone", contact.phone);
      values.put("mobileNumber", contact.mobilenumber);
      values.put("notes", contact.notes);
      values.put("gender", contact.gender);
      values.put("birthDate", dateFormatter.format(contact.birthdate));
      values.put("city", contact.city);
      values.put("state", contact.state);
      values.put("postalCode", contact.zip);
      values.put("country", contact.country);
      values.put("organizationName", contact.organizationname);
      values.put("website", contact.websiteurl);
      values.put("annualRevenue", String.valueOf(contact.annualrevenue));
      values.put("industry", contact.industry);
      values.put("numberOfEmployees", String.valueOf(contact.numberofemployees));
//      values.put("type", String.valueOf(contact.type));
//      values.put("return_Url", contact.return_Url);
//      values.put("source_Url", contact.source_Url);
//      values.put("activation_Return_Url", contact.activation_Return_Url);
//      values.put("activation_Template", contact.activation_Template);
//      values.put("requiresActivation", String.valueOf(Contact.requiresActivation));
      return uploadValues(API_URI + "/contact/add", values, String.class);
   }

    /**
     * Manually add or update a contacts status to Abuse, Bounced or Unsubscribed status (blocked).
     * @param email Proper email address.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @throws Exception
     */
    public void AddBlocked(String email, ApiTypes.ContactStatus status) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("status", String.valueOf(status));
       uploadValues(API_URI + "/contact/addblocked", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Change any property on the contact record.
     * @param email Proper email address.
     * @param name Name of the contact property you want to change.
     * @param value Value you would like to change the contact property to.
     * @throws Exception
     */
    public void ChangeProperty(String email, String name, String value) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("name", name);
       values.put("value", value);
       uploadValues(API_URI + "/contact/changeproperty", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Changes status of selected Contacts. You may provide RULE for selection or specify list of Contact IDs.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @throws Exception
     */
    public void ChangeStatus(ApiTypes.ContactStatus status, String rule, StringList emails, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("status", String.valueOf(status));
       values.put("rule", rule);
       values.put("emails", String.valueOf(emails));
       values.put("allContacts", String.valueOf(allContacts));
       uploadValues(API_URI + "/contact/changestatus", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Returns number of Contacts, RULE specifies contact Status.
     * @param rule Query used for filtering.
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @return ApiTypes.ContactStatusCounts
     * @throws Exception
     */
    public ApiTypes.ContactStatusCounts CountByStatus(String rule, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("rule", rule);
       values.put("allContacts", String.valueOf(allContacts));
       return uploadValues(API_URI + "/contact/countbystatus", values, ApiTypes.ContactStatusCounts.class);
   }

    /**
     * Permanantly deletes the contacts provided.  You can provide either a qualified rule or a list of emails (comma separated string).
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @throws Exception
     */
    public void Delete(String rule, StringList emails, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("rule", rule);
       values.put("emails", String.valueOf(emails));
       values.put("allContacts", String.valueOf(allContacts));
       uploadValues(API_URI + "/contact/delete", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Export selected Contacts to JSON.
     * @param fileFormat
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @param compressionFormat FileResponse compression format. None or Zip.
     * @param fileName Name of your file.
     * @throws Exception
     */
    public void Export(ApiTypes.ExportFileFormats fileFormat, String rule, StringList emails, Boolean allContacts, ApiTypes.CompressionFormat compressionFormat, String fileName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("fileFormat", String.valueOf(fileFormat));
       values.put("rule", rule);
       values.put("emails", String.valueOf(emails));
       values.put("allContacts", String.valueOf(allContacts));
       values.put("compressionFormat", String.valueOf(compressionFormat));
       values.put("fileName", fileName);
       uploadValues(API_URI + "/contact/export", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * List of all contacts. If you have not specified RULE, all Contacts will be listed.
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ContactList
     * @throws Exception
     */
    public ApiTypes.ContactList List(Boolean allContacts, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("allContacts", String.valueOf(allContacts));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/contact/list", values, ApiTypes.ContactList.class);
   }

   public ApiTypes.ContactList List(String rule, int limit, int offset) throws Exception {
      HashMap<String, String> values = new HashMap<String, String>();
      values.put("apikey", API_KEY);
      values.put("rule", rule);
      values.put("limit", String.valueOf(limit));
      values.put("offset", String.valueOf(offset));
      return uploadValues(API_URI + "/contact/list", values, ApiTypes.ContactList.class);
   }

    /**
     * Load blocked contacts
     * @param search Text fragment used for searching.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.BlockedContactList
     * @throws Exception
     */
    public ApiTypes.BlockedContactList LoadBlocked(String search, ApiTypes.ContactStatus status, int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("search", search);
       if (status != null) values.put("status", String.valueOf(status));
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/contact/loadblocked", values, ApiTypes.BlockedContactList.class);
   }

    /**
     * Load detailed contact information
     * @param email Proper email address.
     * @return ApiTypes.Contact
     * @throws Exception
     */
    public ApiTypes.Contact LoadContact(String email) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       return uploadValues(API_URI + "/contact/loadcontact", values, ApiTypes.Contact.class);
   }

    /**
     * Shows detailed history of chosen Contact.
     * @param email Proper email address.
     * @return ApiTypes.ContactHistoryList
     * @throws Exception
     */
    public ApiTypes.ContactHistoryList LoadHistory(String email) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       return uploadValues(API_URI + "/contact/loadhistory", values, ApiTypes.ContactHistoryList.class);
   }

    /**
     * Add new Contact to one of your Lists.
     * @param emails Comma delimited list of contact emails
     * @param firstName First name.
     * @param lastName Last name.
     * @param title Title
     * @param organization Name of organization
     * @param city City.
     * @param country Name of country.
     * @param state State or province.
     * @param zip Zip/postal code.
     * @param listID ID number of selected list.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @throws Exception
     */
    public void QuickAdd(StringList emails, String firstName, String lastName, String title, String organization, String city, String country, String state, String zip, int listID, ApiTypes.ContactStatus status) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("emails", String.valueOf(emails));
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("title", title);
       values.put("organization", organization);
       values.put("city", city);
       values.put("country", country);
       values.put("state", state);
       values.put("zip", zip);
       values.put("listID", String.valueOf(listID));
       values.put("status", String.valueOf(status));
       uploadValues(API_URI + "/contact/quickadd", values, APIResponse.VoidApiResponse.class);
   }

   public void QuickAdd(ApiTypes.Contact contact, int listID, ApiTypes.ContactStatus status) throws Exception {
      HashMap<String, String> values = new HashMap<String, String>();
      values.put("apikey", API_KEY);
      values.put("emails", String.valueOf(contact.email));
      values.put("firstName", contact.firstname);
      values.put("lastName", contact.lastname);
      values.put("title", contact.title);
      values.put("organization", contact.organizationname);
      values.put("city", contact.city);
      values.put("country", contact.country);
      values.put("state", contact.state);
      values.put("zip", contact.zip);
      values.put("listID", String.valueOf(listID));
      values.put("status", String.valueOf(status));
      uploadValues(API_URI + "/contact/quickadd", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Update selected contact
     * @param email Proper email address.
     * @param newEmail New email address.
     * @param firstName First name.
     * @param lastName Last name.
     * @param company Company name.
     * @param title Title
     * @param city City.
     * @param state State or province.
     * @param country Name of country.
     * @param zip Zip/postal code.
     * @param birthDate Date of birth in YYYY-MM-DD format
     * @param gender Your gender
     * @param phone Phone number
     * @param activate True, if Contact should be activated. Otherwise, false
     * @param industry Industry contact works in
     * @param numberOfEmployees Number of employees
     * @param annualRevenue Annual revenue of contact
     * @param purchaseCount Number of purchases contact has made
     * @param firstPurchase Date of first purchase in YYYY-MM-DD format
     * @param lastPurchase Date of last purchase in YYYY-MM-DD format
     * @param notes Free form field of notes
     * @param websiteUrl Website of contact
     * @param mobileNumber Mobile phone number
     * @param faxNumber Fax number
     * @param linkedInBio Biography for Linked-In
     * @param linkedInConnections Number of Linked-In connections
     * @param twitterBio Biography for Twitter
     * @param twitterUsername User name for Twitter
     * @param twitterProfilePhoto URL for Twitter photo
     * @param twitterFollowerCount Number of Twitter followers
     * @param pageViews Number of page views
     * @param visits Number of website visits
     * @return ApiTypes.Contact
     * @throws Exception
     */
    public ApiTypes.Contact Update(String email, String newEmail, String firstName, String lastName, String company, String title, String city, String state, String country, String zip, String birthDate, String gender, String phone, String activate, String industry, int numberOfEmployees, String annualRevenue, int purchaseCount, String firstPurchase, String lastPurchase, String notes, String websiteUrl, String mobileNumber, String faxNumber, String linkedInBio, int linkedInConnections, String twitterBio, String twitterUsername, String twitterProfilePhoto, int twitterFollowerCount, int pageViews, int visits) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("newEmail", newEmail);
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("company", company);
       values.put("title", title);
       values.put("city", city);
       values.put("state", state);
       values.put("country", country);
       values.put("zip", zip);
       values.put("birthDate", dateFormatter.format(birthDate));
       values.put("gender", gender);
       values.put("phone", phone);
       values.put("activate", activate);
       values.put("industry", industry);
       values.put("numberOfEmployees", String.valueOf(numberOfEmployees));
       values.put("annualRevenue", annualRevenue);
       values.put("purchaseCount", String.valueOf(purchaseCount));
       values.put("firstPurchase", firstPurchase);
       values.put("lastPurchase", lastPurchase);
       values.put("notes", notes);
       values.put("websiteUrl", websiteUrl);
       values.put("mobileNumber", mobileNumber);
       values.put("faxNumber", faxNumber);
       values.put("linkedInBio", linkedInBio);
       values.put("linkedInConnections", String.valueOf(linkedInConnections));
       values.put("twitterBio", twitterBio);
       values.put("twitterUsername", twitterUsername);
       values.put("twitterProfilePhoto", twitterProfilePhoto);
       values.put("twitterFollowerCount", String.valueOf(twitterFollowerCount));
       values.put("pageViews", String.valueOf(pageViews));
       values.put("visits", String.valueOf(visits));
       return uploadValues(API_URI + "/contact/update", values, ApiTypes.Contact.class);
   }

   public ApiTypes.Contact Update(ApiTypes.Contact contact) throws Exception {
      HashMap<String, String> values = new HashMap<String, String>();
      values.put("apikey", API_KEY);
//      values.put("publicAccountID",contact.publicAccountID);
      values.put("email", contact.email);
//      values.put("publicListID", String.valueOf(contact.publicListID));
//      values.put("listName", String.valueOf(contact.listName));
      values.put("title", contact.title);
      values.put("firstName", contact.firstname);
      values.put("lastName", contact.lastname);
      values.put("phone", contact.phone);
      values.put("mobileNumber", contact.mobilenumber);
      values.put("notes", contact.notes);
      values.put("gender", contact.gender);
      put(values,"birthDate", contact.birthdate);
      values.put("city", contact.city);
      values.put("state", contact.state);
      values.put("postalCode", contact.zip);
      values.put("zip", contact.zip);
      values.put("country", contact.country);
      values.put("organizationName", contact.organizationname);
      values.put("website", contact.websiteurl);
      values.put("annualRevenue", String.valueOf(contact.annualrevenue));
      values.put("industry", contact.industry);
      values.put("numberOfEmployees", String.valueOf(contact.numberofemployees));
//      values.put("type", String.valueOf(contact.type));
//      values.put("return_Url", contact.return_Url);
//      values.put("source_Url", contact.source_Url);
//      values.put("activation_Return_Url", contact.activation_Return_Url);
//      values.put("activation_Template", contact.activation_Template);
//      values.put("requiresActivation", String.valueOf(Contact.requiresActivation));

      if (contact.newEmail != null) {
         values.put("newEmail", contact.newEmail);
      }
//      values.put("activate", contact.activate);
      values.put("industry", contact.industry);
      values.put("numberOfEmployees", String.valueOf(contact.numberofemployees));

      values.put("purchaseCount", String.valueOf(contact.purchasecount));
      put(values,"firstPurchase", contact.firstpurchase);
      put(values,"lastPurchase", contact.lastpurchase);
      values.put("notes", contact.notes);
      values.put("websiteUrl", contact.websiteurl);
      values.put("faxNumber", contact.faxnumber);
      values.put("linkedInBio", contact.linkedinbio);
      values.put("linkedInConnections", String.valueOf(contact.linkedinconnections));
      values.put("twitterBio", contact.twitterbio);
      values.put("twitterUsername", contact.twitterusername);
      values.put("twitterProfilePhoto", contact.twitterprofilephoto);
      values.put("twitterFollowerCount", String.valueOf(contact.twitterfollowercount));
      values.put("pageViews", String.valueOf(contact.pageviews));
      values.put("visits", String.valueOf(contact.visits));
      return uploadValues(API_URI + "/contact/update", values, ApiTypes.Contact.class);
   }

    /**
     * Upload contacts in CSV file.
     * @param listID ID number of selected list.
     * @param contactFile Name of CSV file with Contacts.
     * @param status Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
     * @return int
     * @throws Exception
     */
    public int Upload(int listID, FileData contactFile, ApiTypes.ContactStatus status) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listID", String.valueOf(listID));
       values.put("status", String.valueOf(status));
       return httpPostFile(API_URI + "/contact/upload", Arrays.asList(contactFile), values, int.class);
   }

}

