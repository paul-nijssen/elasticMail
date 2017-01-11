package com.elasticemail.functions;

import com.elasticemail.API;
import com.elasticemail.APIResponse.VoidApiResponse;
import com.elasticemail.ApiTypes;
import com.elasticemail.ApiTypes.StringList;

import java.util.Date;
import java.util.HashMap;

/**
 * Methods for managing your account and subaccounts.
 */
public class Account extends API {
    public Account(String key) {
        super(key);
    }

    /**
     * Create new subaccount and provide most important data about it.
     * @param email Proper email address.
     * @param accountType Type of account: 1 for Transactional Email, 2 for Marketing Email.
     * @param password Current password.
     * @param confirmPassword Repeat new password.
     * @param requiresEmailCredits True, if account needs credits to send emails. Otherwise, false
     * @param enableLitmusTest True, if account is able to send template tests to Litmus. Otherwise, false
     * @param requiresLitmusCredits True, if account needs credits to send emails. Otherwise, false
     * @param dailySendLimit Amount of emails account can send daily
     * @param maxContacts Maximum number of contacts the account can havelkd
     * @param enablePrivateIPRequest True, if account can request for private IP on its own. Otherwise, false
     * @param sendActivation True, if you want to send activation email to this account. Otherwise, false
     * @param return_Url URL to navigate to after account creation
     * @param sendingPermission Sending permission setting for account
     * @param enableContactFeatures True, if you want to use Advanced Tools.  Otherwise, false
     * @return String
     * @throws Exception
     */
    public String AddSubAccount(String email, ApiTypes.AccountType accountType, String password, String confirmPassword, Boolean requiresEmailCredits, Boolean enableLitmusTest, Boolean requiresLitmusCredits, int dailySendLimit, int maxContacts, Boolean enablePrivateIPRequest, Boolean sendActivation, String return_Url, ApiTypes.SendingPermission sendingPermission, Boolean enableContactFeatures) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("email", email);
       values.put("accountType", String.valueOf(accountType));
       values.put("password", password);
       values.put("confirmPassword", confirmPassword);
       values.put("requiresEmailCredits", String.valueOf(requiresEmailCredits));
       values.put("enableLitmusTest", String.valueOf(enableLitmusTest));
       values.put("requiresLitmusCredits", String.valueOf(requiresLitmusCredits));
       values.put("dailySendLimit", String.valueOf(dailySendLimit));
       values.put("maxContacts", String.valueOf(maxContacts));
       values.put("enablePrivateIPRequest", String.valueOf(enablePrivateIPRequest));
       values.put("sendActivation", String.valueOf(sendActivation));
       values.put("return_Url", return_Url);
       if (sendingPermission != null) values.put("sendingPermission", String.valueOf(sendingPermission));
       values.put("enableContactFeatures", String.valueOf(enableContactFeatures));
       return uploadValues(API_URI + "/account/addsubaccount", values, String.class);
   }

    /**
     * Add email, template or litmus credits to a sub-account
     * @param creditType Type of credits to add (EmailCredits, TemplateCredits or LitmusCredits
     * @param credits Amount of credits to add
     * @param notes Specific notes about the transaction
     * @param subAccountEmail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @throws Exception
     */
    public void AddSubAccountCredits(String creditType, int credits, String notes, String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("creditType", creditType);
       values.put("credits", String.valueOf(credits));
       values.put("notes", notes);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       uploadValues(API_URI + "/account/addsubaccountcredits", values, VoidApiResponse.class);
   }

    /**
     * Change your email address. Remember, that your email address is used as login!
     * @param sourceUrl URL from which request was sent.
     * @param newEmail New email address.
     * @param confirmEmail New email address.
     * @throws Exception
     */
    public void ChangeEmail(String sourceUrl, String newEmail, String confirmEmail) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("sourceUrl", sourceUrl);
       values.put("newEmail", newEmail);
       values.put("confirmEmail", confirmEmail);
       uploadValues(API_URI + "/account/changeemail", values, VoidApiResponse.class);
   }

    /**
     * Create new password for your account. Password needs to be at least 6 characters long.
     * @param currentPassword Current password.
     * @param newPassword New password for account.
     * @param confirmPassword Repeat new password.
     * @throws Exception
     */
    public void ChangePassword(String currentPassword, String newPassword, String confirmPassword) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("currentPassword", currentPassword);
       values.put("newPassword", newPassword);
       values.put("confirmPassword", confirmPassword);
       uploadValues(API_URI + "/account/changepassword", values, VoidApiResponse.class);
   }

    /**
     * Deletes specified Subaccount
     * @param notify True, if you want to send an email notification. Otherwise, false
     * @param subAccountEmail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @throws Exception
     */
    public void DeleteSubAccount(Boolean notify, String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("notify", String.valueOf(notify));
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       uploadValues(API_URI + "/account/deletesubaccount", values, VoidApiResponse.class);
   }

    /**
     * Returns API Key for the given Sub Account.
     * @param subaccountEmail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @return String
     * @throws Exception
     */
    public String GetSubAccountApiKey(String subaccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subaccountEmail", subaccountEmail);
       values.put("publicAccountID", publicAccountID);
       return uploadValues(API_URI + "/account/getsubaccountapikey", values, String.class);
   }

    /**
     * Lists all of your subaccounts
     * @return ApiTypes.SubAccountList
     * @throws Exception
     */
    public ApiTypes.SubAccountList GetSubAccountList() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/getsubaccountlist", values, ApiTypes.SubAccountList.class);
   }

    /**
     * Loads your account. Returns detailed information about your account.
     * @return ApiTypes.Account
     * @throws Exception
     */
    public ApiTypes.Account Load() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/load", values, ApiTypes.Account.class);
   }

    /**
     * Load advanced options of your account
     * @return ApiTypes.AdvancedOptions
     * @throws Exception
     */
    public ApiTypes.AdvancedOptions LoadAdvancedOptions() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadadvancedoptions", values, ApiTypes.AdvancedOptions.class);
   }

    /**
     * Lists email credits history
     * @return ApiTypes.EmailCreditsList
     * @throws Exception
     */
    public ApiTypes.EmailCreditsList LoadEmailCreditsHistory() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loademailcreditshistory", values, ApiTypes.EmailCreditsList.class);
   }

    /**
     * Lists litmus credits history
     * @return ApiTypes.LitmusCreditsList
     * @throws Exception
     */
    public ApiTypes.LitmusCreditsList LoadLitmusCreditsHistory() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadlitmuscreditshistory", values, ApiTypes.LitmusCreditsList.class);
   }

    /**
     * Shows queue of newest notifications - very useful when you want to check what happened with mails that were not received.
     * @return ApiTypes.NotificationQueueList
     * @throws Exception
     */
    public ApiTypes.NotificationQueueList LoadNotificationQueue() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadnotificationqueue", values, ApiTypes.NotificationQueueList.class);
   }

    /**
     * Lists all payments
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @param fromDate Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param toDate Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @return ApiTypes.PaymentList
     * @throws Exception
     */
    public ApiTypes.PaymentList LoadPaymentHistory(int limit, int offset, Date fromDate, Date toDate) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       values.put("fromDate", String.valueOf(fromDate));
       values.put("toDate", String.valueOf(toDate));
       return uploadValues(API_URI + "/account/loadpaymenthistory", values, ApiTypes.PaymentList.class);
   }

    /**
     * Lists all referral payout history
     * @return ApiTypes.PaymentList
     * @throws Exception
     */
    public ApiTypes.PaymentList LoadPayoutHistory() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadpayouthistory", values, ApiTypes.PaymentList.class);
   }

    /**
     * Shows information about your referral details
     * @return ApiTypes.Referral
     * @throws Exception
     */
    public ApiTypes.Referral LoadReferralDetails() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadreferraldetails", values, ApiTypes.Referral.class);
   }

    /**
     * Shows latest changes in your sending reputation
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.ReputationHistoryList
     * @throws Exception
     */
    public ApiTypes.ReputationHistoryList LoadReputationHistory(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/account/loadreputationhistory", values, ApiTypes.ReputationHistoryList.class);
   }

    /**
     * Shows detailed information about your actual reputation score
     * @return ApiTypes.ReputationDetail
     * @throws Exception
     */
    public ApiTypes.ReputationDetail LoadReputationImpact() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/loadreputationimpact", values, ApiTypes.ReputationDetail.class);
   }

    /**
     * Returns detailed spam check.
     * @param limit Maximum of loaded items.
     * @param offset How many items should be loaded ahead.
     * @return ApiTypes.SpamCheckList
     * @throws Exception
     */
    public ApiTypes.SpamCheckList LoadSpamCheck(int limit, int offset) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("limit", String.valueOf(limit));
       values.put("offset", String.valueOf(offset));
       return uploadValues(API_URI + "/account/loadspamcheck", values, ApiTypes.SpamCheckList.class);
   }

    /**
     * Lists email credits history for sub-account
     * @param subAccountEmail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @return ApiTypes.EmailCreditsList
     * @throws Exception
     */
    public ApiTypes.EmailCreditsList LoadSubAccountsEmailCreditsHistory(String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       return uploadValues(API_URI + "/account/loadsubaccountsemailcreditshistory", values, ApiTypes.EmailCreditsList.class);
   }

    /**
     * Loads settings of subaccount
     * @param subAccountemail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @return ApiTypes.SubAccountSettings
     * @throws Exception
     */
    public ApiTypes.SubAccountSettings LoadSubAccountSettings(String subAccountemail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subAccountemail", subAccountemail);
       values.put("publicAccountID", publicAccountID);
       return uploadValues(API_URI + "/account/loadsubaccountsettings", values, ApiTypes.SubAccountSettings.class);
   }

    /**
     * Lists litmus credits history for sub-account
     * @param subAccountEmail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @return ApiTypes.LitmusCreditsList
     * @throws Exception
     */
    public ApiTypes.LitmusCreditsList LoadSubAccountsLitmusCreditsHistory(String subAccountEmail, String publicAccountID) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       return uploadValues(API_URI + "/account/loadsubaccountslitmuscreditshistory", values, ApiTypes.LitmusCreditsList.class);
   }

    /**
     * Shows usage of your account in given time.
     * @param from Starting date for search in YYYY-MM-DDThh:mm:ss format.
     * @param to Ending date for search in YYYY-MM-DDThh:mm:ss format.
     * @return ApiTypes.UsageList
     * @throws Exception
     */
    public ApiTypes.UsageList LoadUsage(Date from, Date to) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("from", String.valueOf(from));
       values.put("to", String.valueOf(to));
       return uploadValues(API_URI + "/account/loadusage", values, ApiTypes.UsageList.class);
   }

    /**
     * Manages your apikeys.
     * @param apiKey APIKey you would like to manage.
     * @param action Specific action you would like to perform on the APIKey
     * @return StringList
     * @throws Exception
     */
    public StringList ManageApiKeys(String apiKey, ApiTypes.APIKeyAction action) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("apiKey", apiKey);
       values.put("action", String.valueOf(action));
       return uploadValues(API_URI + "/account/manageapikeys", values, StringList.class);
   }

    /**
     * Shows summary for your account.
     * @return ApiTypes.AccountOverview
     * @throws Exception
     */
    public ApiTypes.AccountOverview Overview() throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       return uploadValues(API_URI + "/account/overview", values, ApiTypes.AccountOverview.class);
   }

    /**
     * Remove email, template or litmus credits from a sub-account
     * @param creditType Type of credits to add (EmailCredits, TemplateCredits or LitmusCredits
     * @param notes Specific notes about the transaction
     * @param subAccountEmail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @param credits Amount of credits to remove
     * @param removeAll Remove all credits of this type from sub-account (overrides credits if provided)
     * @throws Exception
     */
    public void RemoveSubAccountCredits(String creditType, String notes, String subAccountEmail, String publicAccountID, int credits, Boolean removeAll) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("creditType", creditType);
       values.put("notes", notes);
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       values.put("credits", String.valueOf(credits));
       values.put("removeAll", String.valueOf(removeAll));
       uploadValues(API_URI + "/account/removesubaccountcredits", values, VoidApiResponse.class);
   }

    /**
     * Request a private IP for your Account
     * @param count Number of items.
     * @param notes Free form field of notes
     * @throws Exception
     */
    public void RequestPrivateIP(int count, String notes) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("count", String.valueOf(count));
       values.put("notes", notes);
       uploadValues(API_URI + "/account/requestprivateip", values, VoidApiResponse.class);
   }

    /**
     * Update sending and tracking options of your account.
     * @param enableClickTracking True, if you want to track clicks. Otherwise, false
     * @param enableLinkClickTracking True, if you want to track by link tracking. Otherwise, false
     * @param skipListUnsubscribe True, if you do not want to use list-unsubscribe headers. Otherwise, false
     * @param autoTextFromHtml True, if text BODY of message should be created automatically. Otherwise, false
     * @param allowCustomHeaders True, if you want to apply custom headers to your emails. Otherwise, false
     * @param bccEmail Email address to send a copy of all email to.
     * @param contentTransferEncoding Type of content encoding
     * @param emailNotificationForError True, if you want bounce notifications returned. Otherwise, false
     * @param emailNotificationEmail Specific email address to send bounce email notifications to.
     * @param webNotificationUrl URL address to receive web notifications to parse and process.
     * @param webNotificationForSent True, if you want to send web notifications for sent email. Otherwise, false
     * @param webNotificationForOpened True, if you want to send web notifications for opened email. Otherwise, false
     * @param webNotificationForClicked True, if you want to send web notifications for clicked email. Otherwise, false
     * @param webNotificationForUnsubscribed True, if you want to send web notifications for unsubscribed email. Otherwise, false
     * @param webNotificationForAbuseReport True, if you want to send web notifications for complaint email. Otherwise, false
     * @param webNotificationForError True, if you want to send web notifications for bounced email. Otherwise, false
     * @param hubCallBackUrl URL used for tracking action of inbound emails
     * @param inboundDomain Domain you use as your inbound domain
     * @param inboundContactsOnly True, if you want inbound email to only process contacts from your account. Otherwise, false
     * @param lowCreditNotification True, if you want to receive low credit email notifications. Otherwise, false
     * @param enableUITooltips True, if account has tooltips active. Otherwise, false
     * @param enableContactFeatures True, if you want to use Advanced Tools.  Otherwise, false
     * @return ApiTypes.AdvancedOptions
     * @throws Exception
     */
    public ApiTypes.AdvancedOptions UpdateAdvancedOptions(Boolean enableClickTracking, Boolean enableLinkClickTracking, Boolean skipListUnsubscribe, Boolean autoTextFromHtml, Boolean allowCustomHeaders, String bccEmail, String contentTransferEncoding, Boolean emailNotificationForError, String emailNotificationEmail, String webNotificationUrl, Boolean webNotificationForSent, Boolean webNotificationForOpened, Boolean webNotificationForClicked, Boolean webNotificationForUnsubscribed, Boolean webNotificationForAbuseReport, Boolean webNotificationForError, String hubCallBackUrl, String inboundDomain, Boolean inboundContactsOnly, Boolean lowCreditNotification, Boolean enableUITooltips, Boolean enableContactFeatures) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("enableClickTracking", String.valueOf(enableClickTracking));
       values.put("enableLinkClickTracking", String.valueOf(enableLinkClickTracking));
       values.put("skipListUnsubscribe", String.valueOf(skipListUnsubscribe));
       values.put("autoTextFromHtml", String.valueOf(autoTextFromHtml));
       values.put("allowCustomHeaders", String.valueOf(allowCustomHeaders));
       values.put("bccEmail", bccEmail);
       values.put("contentTransferEncoding", contentTransferEncoding);
       values.put("emailNotificationForError", String.valueOf(emailNotificationForError));
       values.put("emailNotificationEmail", emailNotificationEmail);
       values.put("webNotificationUrl", webNotificationUrl);
       values.put("webNotificationForSent", String.valueOf(webNotificationForSent));
       values.put("webNotificationForOpened", String.valueOf(webNotificationForOpened));
       values.put("webNotificationForClicked", String.valueOf(webNotificationForClicked));
       values.put("webNotificationForUnsubscribed", String.valueOf(webNotificationForUnsubscribed));
       values.put("webNotificationForAbuseReport", String.valueOf(webNotificationForAbuseReport));
       values.put("webNotificationForError", String.valueOf(webNotificationForError));
       values.put("hubCallBackUrl", hubCallBackUrl);
       values.put("inboundDomain", inboundDomain);
       values.put("inboundContactsOnly", String.valueOf(inboundContactsOnly));
       values.put("lowCreditNotification", String.valueOf(lowCreditNotification));
       values.put("enableUITooltips", String.valueOf(enableUITooltips));
       values.put("enableContactFeatures", String.valueOf(enableContactFeatures));
       return uploadValues(API_URI + "/account/updateadvancedoptions", values, ApiTypes.AdvancedOptions.class);
   }

    /**
     * Update settings of your private branding. These settings are needed, if you want to use Elastic Email under your brand.
     * @param enablePrivateBranding True: Turn on or off ability to send mails under your brand. Otherwise, false
     * @param logoUrl URL to your logo image.
     * @param supportLink Address to your support.
     * @param privateBrandingUrl Subdomain for your rebranded service
     * @param smtpAddress Address of SMTP server.
     * @param smtpAlternative Address of alternative SMTP server.
     * @param paymentUrl URL for making payments.
     * @throws Exception
     */
    public void UpdateCustomBranding(Boolean enablePrivateBranding, String logoUrl, String supportLink, String privateBrandingUrl, String smtpAddress, String smtpAlternative, String paymentUrl) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("enablePrivateBranding", String.valueOf(enablePrivateBranding));
       values.put("logoUrl", logoUrl);
       values.put("supportLink", supportLink);
       values.put("privateBrandingUrl", privateBrandingUrl);
       values.put("smtpAddress", smtpAddress);
       values.put("smtpAlternative", smtpAlternative);
       values.put("paymentUrl", paymentUrl);
       uploadValues(API_URI + "/account/updatecustombranding", values, VoidApiResponse.class);
   }

    /**
     * Update http notification URL.
     * @param url URL of notification.
     * @param settings Http notification settings serialized to JSON 
     * @throws Exception
     */
    public void UpdateHttpNotification(String url, String settings) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("url", url);
       values.put("settings", settings);
       uploadValues(API_URI + "/account/updatehttpnotification", values, VoidApiResponse.class);
   }

    /**
     * Update your profile.
     * @param firstName First name.
     * @param lastName Last name.
     * @param company Company name.
     * @param address1 First line of address.
     * @param address2 Second line of address.
     * @param city City.
     * @param state State or province.
     * @param zip Zip/postal code.
     * @param countryID Numeric ID of country.
     * @param deliveryReason Why your clients are receiving your emails.
     * @param marketingConsent True if you want to receive newsletters from Elastic Email. Otherwise, false.
     * @param website HTTP address of your website.
     * @param logoUrl URL to your logo image.
     * @param taxCode Code used for tax purposes.
     * @param phone Phone number
     * @throws Exception
     */
    public void UpdateProfile(String firstName, String lastName, String company, String address1, String address2, String city, String state, String zip, String countryID, String deliveryReason, Boolean marketingConsent, String website, String logoUrl, String taxCode, String phone) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("firstName", firstName);
       values.put("lastName", lastName);
       values.put("company", company);
       values.put("address1", address1);
       values.put("address2", address2);
       values.put("city", city);
       values.put("state", state);
       values.put("zip", zip);
       values.put("countryID", countryID);
       values.put("deliveryReason", deliveryReason);
       values.put("marketingConsent", String.valueOf(marketingConsent));
       values.put("website", website);
       values.put("logoUrl", logoUrl);
       values.put("taxCode", taxCode);
       values.put("phone", phone);
       uploadValues(API_URI + "/account/updateprofile", values, VoidApiResponse.class);
   }

    /**
     * Updates settings of specified subaccount
     * @param requiresEmailCredits True, if account needs credits to send emails. Otherwise, false
     * @param monthlyRefillCredits Amount of credits added to account automatically
     * @param requiresLitmusCredits True, if account needs credits to send emails. Otherwise, false
     * @param enableLitmusTest True, if account is able to send template tests to Litmus. Otherwise, false
     * @param dailySendLimit Amount of emails account can send daily
     * @param emailSizeLimit Maximum size of email including attachments in MB's
     * @param enablePrivateIPRequest True, if account can request for private IP on its own. Otherwise, false
     * @param maxContacts Maximum number of contacts the account can havelkd
     * @param subAccountEmail Email address of sub-account
     * @param publicAccountID Public key for limited access to your account such as contact/add so you can use it safely on public websites.
     * @param sendingPermission Sending permission setting for account
     * @param enableContactFeatures True, if you want to use Advanced Tools.  Otherwise, false
     * @throws Exception
     */
    public void UpdateSubAccountSettings(Boolean requiresEmailCredits, int monthlyRefillCredits, Boolean requiresLitmusCredits, Boolean enableLitmusTest, int dailySendLimit, int emailSizeLimit, Boolean enablePrivateIPRequest, int maxContacts, String subAccountEmail, String publicAccountID, ApiTypes.SendingPermission sendingPermission, Boolean enableContactFeatures) throws Exception {
       HashMap<String, String> values = new HashMap<String, String>();
       values.put("apikey", API_KEY);
       values.put("requiresEmailCredits", String.valueOf(requiresEmailCredits));
       values.put("monthlyRefillCredits", String.valueOf(monthlyRefillCredits));
       values.put("requiresLitmusCredits", String.valueOf(requiresLitmusCredits));
       values.put("enableLitmusTest", String.valueOf(enableLitmusTest));
       values.put("dailySendLimit", String.valueOf(dailySendLimit));
       values.put("emailSizeLimit", String.valueOf(emailSizeLimit));
       values.put("enablePrivateIPRequest", String.valueOf(enablePrivateIPRequest));
       values.put("maxContacts", String.valueOf(maxContacts));
       values.put("subAccountEmail", subAccountEmail);
       values.put("publicAccountID", publicAccountID);
       if (sendingPermission != null) values.put("sendingPermission", String.valueOf(sendingPermission));
       values.put("enableContactFeatures", String.valueOf(enableContactFeatures));
       uploadValues(API_URI + "/account/updatesubaccountsettings", values, VoidApiResponse.class);
   }

}

