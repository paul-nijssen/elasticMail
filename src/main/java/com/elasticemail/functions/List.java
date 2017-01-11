package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.ApiTypes;
import com.elasticemail.ApiTypes.StringList;
import com.elasticemail.APIResponse;

import java.util.HashMap;

/**
 * API methods for managing your Lists
 */
public class List extends API
{
    public List(String key) {
        super(key);
    }

    /**
     * Create new list, based on filtering rule or list of IDs

     * @param listName Name of your list.
     * @param createEmptyList True to create an empty list, otherwise false. Ignores rule and emails parameters if provided.
     * @param allowUnsubscribe True: Allow unsubscribing from this list. Otherwise, false
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @return int
     * @throws Exception
     */
    public int Add(String listName, Boolean createEmptyList, Boolean allowUnsubscribe, String rule, StringList emails, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       values.put("createEmptyList", String.valueOf(createEmptyList));
       values.put("allowUnsubscribe", String.valueOf(allowUnsubscribe));
       values.put("rule", rule);
       values.put("emails", String.valueOf(emails));
       values.put("allContacts", String.valueOf(allContacts));
       return uploadValues(API_URI + "/list/add", values, int.class);
   }

    /**
     * Add Contacts to chosen list

     * @param listName Name of your list.
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @throws Exception
     */
    public void AddContacts(String listName, String rule, StringList emails, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       values.put("rule", rule);
       values.put("emails", String.valueOf(emails));
       values.put("allContacts", String.valueOf(allContacts));
       uploadValues(API_URI + "/list/addcontacts", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Create a series of nth selection lists from an existing list or segment

     * @param listName Name of your list.
     * @param numberOfLists The number of evenly distributed lists to create.
     * @param excludeBlocked True if you want to exclude contacts that are currently in a blocked status of either unsubscribe, complaint or bounce. Otherwise, false.
     * @param allowUnsubscribe True: Allow unsubscribing from this list. Otherwise, false
     * @param rule Query used for filtering.
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @throws Exception
     */
    public void CreateNthSelectionLists(String listName, int numberOfLists, Boolean excludeBlocked, Boolean allowUnsubscribe, String rule, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       values.put("numberOfLists", String.valueOf(numberOfLists));
       values.put("excludeBlocked", String.valueOf(excludeBlocked));
       values.put("allowUnsubscribe", String.valueOf(allowUnsubscribe));
       values.put("rule", rule);
       values.put("allContacts", String.valueOf(allContacts));
       uploadValues(API_URI + "/list/createnthselectionlists", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Create a new list with randomized contacts from an existing list or segment

     * @param listName Name of your list.
     * @param count Number of items.
     * @param excludeBlocked True if you want to exclude contacts that are currently in a blocked status of either unsubscribe, complaint or bounce. Otherwise, false.
     * @param allowUnsubscribe True: Allow unsubscribing from this list. Otherwise, false
     * @param rule Query used for filtering.
     * @param allContacts True: Include every Contact in your Account. Otherwise, false
     * @return int
     * @throws Exception
     */
    public int CreateRandomList(String listName, int count, Boolean excludeBlocked, Boolean allowUnsubscribe, String rule, Boolean allContacts) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       values.put("count", String.valueOf(count));
       values.put("excludeBlocked", String.valueOf(excludeBlocked));
       values.put("allowUnsubscribe", String.valueOf(allowUnsubscribe));
       values.put("rule", rule);
       values.put("allContacts", String.valueOf(allContacts));
       return uploadValues(API_URI + "/list/createrandomlist", values, int.class);
   }

    /**
     * Deletes List and removes all the Contacts from it (does not delete Contacts).

     * @param listName Name of your list.
     * @throws Exception
     */
    public void Delete(String listName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       uploadValues(API_URI + "/list/delete", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Shows all your existing lists

     * @return ApiTypes.ListList
     * @throws Exception
     */
    public ApiTypes.ListList list() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/list/list", values, ApiTypes.ListList.class);
   }

    /**
     * Returns detailed information about specific list.
     * @param listName Name of your list.
     * @return ApiTypes.List
     * @throws Exception
     */
    public ApiTypes.List Load(String listName) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
        values.put("apikey", API_KEY);
       values.put("listName", listName);
       return uploadValues(API_URI + "/list/load", values, ApiTypes.List.class);
   }

    /**
     * Remove selected Contacts from your list

     * @param listName Name of your list.
     * @param rule Query used for filtering.
     * @param emails Comma delimited list of contact emails
     * @throws Exception
     */
    public void RemoveContacts(String listName, String rule, StringList emails) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       values.put("rule", rule);
       values.put("emails", String.valueOf(emails));
       uploadValues(API_URI + "/list/removecontacts", values, APIResponse.VoidApiResponse.class);
   }

    /**
     * Update existing list

     * @param listName Name of your list.
     * @param newListName Name of your list if you want to change it.
     * @param allowUnsubscribe True: Allow unsubscribing from this list. Otherwise, false
     * @throws Exception
     */
    public void Update(String listName, String newListName, Boolean allowUnsubscribe) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("listName", listName);
       values.put("newListName", newListName);
       values.put("allowUnsubscribe", String.valueOf(allowUnsubscribe));
       uploadValues(API_URI + "/list/update", values, APIResponse.VoidApiResponse.class);
   }

}

