package com.elasticemail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class ApiTypes {
    /**
     * Detailed information about your account
     */
    public static class Account {
        /**
         * Code used for tax purposes.
         */
        public String taxcode;

        /**
         * Public key for limited access to your account such as contact/add so you can use it safely on public websites.
         */
        public String publicaccountid;

        /**
         * ApiKey that gives you access to our SMTP and HTTP API's.
         */
        public String apikey;

        /**
         * Second ApiKey that gives you access to our SMTP and HTTP API's.  Used mainly for changing ApiKeys without disrupting services.
         */
        public String apikey2;

        /**
         * True, if account is a subaccount. Otherwise, false
         */
        public Boolean issub;

        /**
         * The number of subaccounts this account has.
         */
        public long subaccountscount;

        /**
         * Number of status: 1 - Active
         */
        public int statusnumber;

        /**
         * Account status: Active
         */
        public String statusformatted;

        /**
         * Type of account: 1 for Transactional Email, 2 for Marketing Email.
         */
        public AccountType accounttype;

        /**
         * URL form for payments.
         */
        public String paymentformurl;

        /**
         * URL to your logo image.
         */
        public String logourl;

        /**
         * HTTP address of your website.
         */
        public String website;

        /**
         * True: Turn on or off ability to send mails under your brand. Otherwise, false
         */
        public Boolean enableprivatebranding;

        /**
         * Address to your support.
         */
        public String supportlink;

        /**
         * Subdomain for your rebranded service
         */
        public String privatebrandingurl;

        /**
         * First name.
         */
        public String firstname;

        /**
         * Last name.
         */
        public String lastname;

        /**
         * Company name.
         */
        public String company;

        /**
         * First line of address.
         */
        public String address1;

        /**
         * Second line of address.
         */
        public String address2;

        /**
         * City.
         */
        public String city;

        /**
         * State or province.
         */
        public String state;

        /**
         * Zip/postal code.
         */
        public String zip;

        /**
         * Numeric ID of country.
         */
        public int countryid;

        /**
         * Phone number
         */
        public String phone;

        /**
         * Proper email address.
         */
        public String email;

        /**
         * URL for affiliating.
         */
        public String affiliatelink;

        /**
         * Numeric reputation
         */
        public double reputation;

        /**
         * Amount of emails sent from this account
         */
        public long totalemailssent;

        /**
         * Amount of emails sent from this account
         */
        public long monthlyemailssent;

        /**
         * Amount of emails sent from this account
         */
        public BigDecimal credit;

        /**
         * Amount of email credits
         */
        public int emailcredits;

        /**
         * Amount of emails sent from this account
         */
        public BigDecimal priceperemail;

        /**
         * Why your clients are receiving your emails.
         */
        public String deliveryreason;

        /**
         * URL for making payments.
         */
        public String accountpaymenturl;

        /**
         * Address of SMTP server.
         */
        public String smtp;

        /**
         * Address of alternative SMTP server.
         */
        public String smtpalternative;

        /**
         * Status of automatic payments configuration.
         */
        public String autocreditstatus;

        /**
         * When AutoCreditStatus is Enabled, the credit level that triggers the credit to be recharged.
         */
        public BigDecimal autocreditlevel;

        /**
         * When AutoCreditStatus is Enabled, the amount of credit to be recharged.
         */
        public BigDecimal autocreditamount;

        /**
         * Amount of emails account can send daily
         */
        public int dailysendlimit;

        /**
         * Creation date.
         */
        public Date datecreated;

        /**
         * True, if you have enabled link tracking. Otherwise, false
         */
        public Boolean linktracking;

        /**
         * Type of content encoding
         */
        public String contenttransferencoding;

        /**
         * Amount of Litmus credits
         */
        public BigDecimal litmuscredits;

        /**
         * Enable advanced tools on your Account.
         */
        public Boolean enablecontactfeatures;

    }

    /**
     * Basic overview of your account
     */
    public static class AccountOverview {
        /**
         * Amount of emails sent from this account
         */
        public long totalemailssent;

        /**
         * Amount of emails sent from this account
         */
        public BigDecimal credit;

        /**
         * Cost of 1000 emails
         */
        public BigDecimal costperthousand;

        /**
         * Number of messages in progress
         */
        public long inprogresscount;

        /**
         * Number of contacts currently with blocked status of Unsubscribed, Complaint, Bounced or InActive
         */
        public long blockedcontactscount;

        /**
         * Numeric reputation
         */
        public double reputation;

        /**
         * Number of contacts
         */
        public long contactcount;

        /**
         * Number of created campaigns
         */
        public long campaigncount;

        /**
         * Number of available templates
         */
        public long templatecount;

        /**
         * Number of created subaccounts
         */
        public long subaccountcount;

        /**
         * Number of active referrals
         */
        public long referralcount;

    }

    /**
     *
     */
    public enum AccountType {
        /**
         * Account is used for sending transactional mail only.
         */
        TRANSACTIONAL,

        /**
         * Account is used for sending bulk marketing email
         */
        MARKETING
    }

    /**
     * Lists advanced sending options of your account.
     */
    public static class AdvancedOptions {
        /**
         * True, if you want to track clicks. Otherwise, false
         */
        public Boolean enableclicktracking;

        /**
         * True, if you want to track by link tracking. Otherwise, false
         */
        public Boolean enablelinkclicktracking;

        /**
         * True, if text BODY of message should be created automatically. Otherwise, false
         */
        public Boolean autotextformat;

        /**
         * True, if you want bounce notifications returned. Otherwise, false
         */
        public Boolean emailnotificationforerror;

        /**
         * True, if you want to send web notifications for sent email. Otherwise, false
         */
        public Boolean webnotificationforsent;

        /**
         * True, if you want to send web notifications for opened email. Otherwise, false
         */
        public Boolean webnotificationforopened;

        /**
         * True, if you want to send web notifications for clicked email. Otherwise, false
         */
        public Boolean webnotificationforclicked;

        /**
         * True, if you want to send web notifications for unsubscribed email. Otherwise, false
         */
        public Boolean webnotificationforunsubscribed;

        /**
         * True, if you want to send web notifications for complaint email. Otherwise, false
         */
        public Boolean webnotificationforabuse;

        /**
         * True, if you want to send web notifications for bounced email. Otherwise, false
         */
        public Boolean webnotificationforerror;

        /**
         * True, if you want to receive low credit email notifications. Otherwise, false
         */
        public Boolean lowcreditnotification;

        /**
         * True, if you want inbound email to only process contacts from your account. Otherwise, false
         */
        public Boolean inboundcontactsonly;

        /**
         * True, if this account is a sub-account. Otherwise, false
         */
        public Boolean issubaccount;

        /**
         * True, if this account resells Elastic Email. Otherwise, false.
         */
        public Boolean isownedbyreseller;

        /**
         * True, if you want to enable list-unsubscribe header. Otherwise, false
         */
        public Boolean enableunsubscribeheader;

        /**
         * True, if you want to apply custom headers to your emails. Otherwise, false
         */
        public Boolean allowcustomheaders;

        /**
         * Email address to send a copy of all email to.
         */
        public String bccemail;

        /**
         * Type of content encoding
         */
        public String contenttransferencoding;

        /**
         * True, if you want to receive bounce email notifications. Otherwise, false
         */
        public String emailnotification;

        /**
         * URL address to receive web notifications to parse and process.
         */
        public String webnotificationurl;

        /**
         * URL used for tracking action of inbound emails
         */
        public String hubcallbackurl;

        /**
         * Domain you use as your inbound domain
         */
        public String inbounddomain;

        /**
         * True, if account has tooltips active. Otherwise, false
         */
        public Boolean enableuitooltips;

        /**
         * True, if you want to use Advanced Tools.  Otherwise, false
         */
        public Boolean enablecontactfeatures;

    }

    /**
     *
     */
    public enum APIKeyAction {
        /**
         * Add an additional APIKey to your Account.
         */
        ADD,

        /**
         * Change this APIKey to a new one.
         */
        CHANGE,

        /**
         * Delete this APIKey
         */
        DELETE
    }

    /**
     * Attachment data
     */
    public static class Attachment {
        /**
         * Name of your file.
         */
        public String filename;

        /**
         * ID number of your attachment
         */
        public String id;

        /**
         * Size of your attachment.
         */
        public int size;

    }

    /**
     * Blocked Contact - Contact returning Hard Bounces
     */
    public static class BlockedContact {
        /**
         * Proper email address.
         */
        public String email;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public ContactStatus status;

        /**
         * RFC error message
         */
        public String friendlyerrormessage;

        /**
         * Last change date
         */
        public String dateupdated;

    }

    /**
     * Summary of bounced categories, based on specified date range.
     */

    public static class BouncedCategorySummary {
        /**
         * Number of messages marked as SPAM
         */
        public long spam;

        /**
         * Number of blacklisted messages
         */
        public long blacklisted;

        /**
         * Number of messages flagged with 'No Mailbox'
         */
        public long nomailbox;

        /**
         * Number of messages flagged with 'Grey Listed'
         */
        public long greylisted;

        /**
         * Number of messages flagged with 'Throttled'
         */
        public long throttled;

        /**
         * Number of messages flagged with 'Timeout'
         */
        public long timeout;

        /**
         * Number of messages flagged with 'Connection Problem'
         */
        public long connectionproblem;

        /**
         * Number of messages flagged with 'SPF Problem'
         */
        public long spfproblem;

        /**
         * Number of messages flagged with 'Account Problem'
         */
        public long accountproblem;

        /**
         * Number of messages flagged with 'DNS Problem'
         */
        public long dnsproblem;

        /**
         * Number of messages flagged with 'WhiteListing Problem'
         */
        public long whitelistingproblem;

        /**
         * Number of messages flagged with 'Code Error'
         */
        public long codeerror;

        /**
         * Number of messages flagged with 'Not Delivered'
         */
        public long notdelivered;

        /**
         * Number of manually cancelled messages
         */
        public long manualcancel;

        /**
         * Number of messages flagged with 'Connection terminated'
         */
        public long connectionterminated;

    }

    /**
     * Campaign
     */

    public static class Campaign {
        /**
         * ID number of selected Channel.
         */
        public int channelid;

        /**
         * Filename
         */
        public String name;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public CampaignStatus status;

        /**
         * List of Segment and List IDs, comma separated
         */
        public String[] targets;

        /**
         * Number of event, triggering mail sending
         */
        public CampaignTriggerType triggertype;

        /**
         * Date of triggered send
         */
        public Date triggerdate;

        /**
         * True, if campaign should be delayed. Otherwise, false.
         */
        public double triggerdelay;

        /**
         * When your next automatic mail will be sent, in days
         */
        public double triggerfrequency;

        /**
         * Date of send
         */
        public int triggercount;

        /**
         * ID number of transaction
         */
        public int triggerchannelid;

        /**
         * Data for filtering event campaigns such as specific link addresses.
         */
        public String triggerdata;

        /**
         * What should be checked for choosing the winner: opens or clicks
         */
        public SplitOptimization splitoptimization;

        /**
         * Number of minutes between sends during optimization period
         */
        public int splitoptimizationminutes;

        /**
         *
         */
        public CampaignTemplateList campaigntemplates;

    }

    /**
     * Channel
     */

    public static class CampaignChannel {
        /**
         * ID number of selected Channel.
         */
        public int channelid;

        /**
         * Filename
         */
        public String name;

        /**
         * True, if you are sending a campaign. Otherwise, false.
         */
        public Boolean iscampaign;

        /**
         * ID number of mailer
         */
        public int mailerid;

        /**
         * Date of creation in YYYY-MM-DDThh:ii:ss format
         */
        public Date dateadded;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public CampaignStatus status;

        /**
         * Date of last activity on account
         */
        public Date lastactivity;

        /**
         * Datetime of last action done on campaign.
         */
        public Date lastprocessed;

        /**
         * Id number of parent channel
         */
        public int parentchannelid;

        /**
         * List of Segment and List IDs, comma separated
         */
        public String[] targets;

        /**
         * Number of event, triggering mail sending
         */
        public CampaignTriggerType triggertype;

        /**
         * Date of triggered send
         */
        public Date triggerdate;

        /**
         * True, if campaign should be delayed. Otherwise, false.
         */
        public double triggerdelay;

        /**
         * When your next automatic mail will be sent, in days
         */
        public double triggerfrequency;

        /**
         * Date of send
         */
        public int triggercount;

        /**
         * ID number of transaction
         */
        public int triggerchannelid;

        /**
         * Data for filtering event campaigns such as specific link addresses.
         */
        public String triggerdata;

        /**
         * What should be checked for choosing the winner: opens or clicks
         */
        public SplitOptimization splitoptimization;

        /**
         * Number of minutes between sends during optimization period
         */
        public int splitoptimizationminutes;

        /**
         * ID number of template.
         */
        public int templateid;

        /**
         * Default subject of email.
         */
        public String templatesubject;

        /**
         * Default From: email address.
         */
        public String templatefromemail;

        /**
         * Default From: name.
         */
        public String templatefromname;

        /**
         * Default Reply: email address.
         */
        public String templatereplyemail;

        /**
         * Default Reply: name.
         */
        public String templatereplyname;

        /**
         * Total emails clicked
         */
        public int clickedcount;

        /**
         * Total emails opened.
         */
        public int openedcount;

        /**
         * Overall number of recipients
         */
        public int recipientcount;

        /**
         * Total emails sent.
         */
        public int sentcount;

        /**
         * Total emails sent.
         */
        public int failedcount;

        /**
         * Total emails clicked
         */
        public int unsubscribedcount;

        /**
         * Abuses - mails sent to user without their consent
         */
        public int failedabuse;

        /**
         * List of CampaignTemplate for sending A-X split testing.
         */
        public CampaignChannelList templatechannels;

    }

    /**
     *
     */
    public enum CampaignStatus {
        /**
         * Campaign is logically deleted and not returned by API or interface calls.
         */
        DELETED,

        /**
         * Campaign is curently active and available.
         */
        ACTIVE,

        /**
         * Campaign is currently being processed for delivery.
         */
        PROCESSING,

        /**
         * Campaign is currently sending.
         */
        SENDING,

        /**
         * Campaign has completed sending.
         */
        COMPLETED,

        /**
         * Campaign is currently paused and not sending.
         */
        PAUSED,

        /**
         * Campaign has been cancelled during delivery.
         */
        CANCELLED
    }

    /**
     *
     */

    public static class CampaignTemplate {
        /**
         * ID number of selected Channel.
         */
        public int channelid;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public CampaignStatus status;

        /**
         * ID number of mailer
         */
        public int mailerid;

        /**
         * ID number of template.
         */
        public int templateid;

        /**
         * Default subject of email.
         */
        public String templatesubject;

        /**
         * Default From: email address.
         */
        public String templatefromemail;

        /**
         * Default From: name.
         */
        public String templatefromname;

        /**
         * Default Reply: email address.
         */
        public String templatereplyemail;

        /**
         * Default Reply: name.
         */
        public String templatereplyname;

    }

    /**
     *
     */
    public enum CampaignTriggerType {
        /**
         *
         */
        SENDNOW,

        /**
         *
         */
        FUTURESCHEDULED,

        /**
         *
         */
        ONADD,

        /**
         *
         */
        ONOPEN,

        /**
         *
         */
        ONCLICK
    }

    /**
     * SMTP and HTTP API channel for grouping email delivery
     */

    public static class Channel {
        /**
         * Descriptive name of the channel.
         */
        public String name;

        /**
         * The date the channel was added to your account.
         */
        public Date dateadded;

        /**
         * The date the channel was last sent through.
         */
        public Date lastactivity;

        /**
         * The number of email jobs this channel has been used with.
         */
        public int jobcount;

        /**
         * The number of emails that have been clicked within this channel.
         */
        public int clickedcount;

        /**
         * The number of emails that have been opened within this channel.
         */
        public int openedcount;

        /**
         * The number of emails attempted to be sent within this channel.
         */
        public int recipientcount;

        /**
         * The number of emails that have been sent within this channel.
         */
        public int sentcount;

        /**
         * The number of emails that have been bounced within this channel.
         */
        public int failedcount;

        /**
         * The number of emails that have been unsubscribed within this channel.
         */
        public int unsubscribedcount;

        /**
         * The number of emails that have been marked as abuse or complaint within this channel.
         */
        public int failedabuse;

        /**
         * The total cost for emails/attachments within this channel.
         */
        public BigDecimal cost;

    }

    /**
     * FileResponse compression format
     */
    public enum CompressionFormat {
        /**
         * No compression
         */
        NONE,

        /**
         * Zip compression
         */
        ZIP
    }

    /**
     * Contact
     */

    public static class Contact {
        /**
         * Date of creation in YYYY-MM-DDThh:ii:ss format
         */
        public Date dateadded;

        /**
         * Proper email address.
         */
        public String email;

        /**
         * First name.
         */
        public String firstname;

        /**
         * Last name.
         */
        public String lastname;

        /**
         * Title
         */
        public String title;

        /**
         * Name of organization
         */
        public String organizationname;

        /**
         * City.
         */
        public String city;

        /**
         * Name of country.
         */
        public String country;

        /**
         * State or province.
         */
        public String state;

        /**
         * Zip/postal code.
         */
        public String zip;

        /**
         * Phone number
         */
        public String phone;

        /**
         * Date of birth in YYYY-MM-DD format
         */
        public Date birthdate;

        /**
         * Your gender
         */
        public String gender;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public ContactStatus status;

        /**
         * RFC Error code
         */
        public int bouncederrorcode;

        /**
         * RFC error message
         */
        public String bouncederrormessage;

        /**
         * Total emails sent.
         */
        public int totalsent;

        /**
         * Total emails sent.
         */
        public int totalfailed;

        /**
         * Total emails opened.
         */
        public int totalopened;

        /**
         * Total emails clicked
         */
        public int totalclicked;

        /**
         * Date of first failed message
         */
        public Date firstfaileddate;

        /**
         * Number of fails in sending to this Contact
         */
        public int lastfailedcount;

        /**
         * Last change date
         */
        public Date dateupdated;

        /**
         * Source of URL of payment
         */
        public ContactSource source;

        /**
         * RFC Error code
         */
        public int errorcode;

        /**
         * RFC error message
         */
        public String friendlyerrormessage;

        /**
         * IP address
         */
        public String createdfromip;

        /**
         * Yearly revenue for the contact
         */
        public BigDecimal revenue;

        /**
         * Number of purchases contact has made
         */
        public int purchasecount;

        /**
         * Mobile phone number
         */
        public String mobilenumber;

        /**
         * Fax number
         */
        public String faxnumber;

        /**
         * Biography for Linked-In
         */
        public String linkedinbio;

        /**
         * Number of Linked-In connections
         */
        public int linkedinconnections;

        /**
         * Biography for Twitter
         */
        public String twitterbio;

        /**
         * User name for Twitter
         */
        public String twitterusername;

        /**
         * URL for Twitter photo
         */
        public String twitterprofilephoto;

        /**
         * Number of Twitter followers
         */
        public int twitterfollowercount;

        /**
         * Unsubscribed date in YYYY-MM-DD format
         */
        public Date unsubscribeddate;

        /**
         * Industry contact works in
         */
        public String industry;

        /**
         * Number of employees
         */
        public int numberofemployees;

        /**
         * Annual revenue of contact
         */
        public BigDecimal annualrevenue;

        /**
         * Date of first purchase in YYYY-MM-DD format
         */
        public Date firstpurchase;

        /**
         * Date of last purchase in YYYY-MM-DD format
         */
        public Date lastpurchase;

        /**
         * Free form field of notes
         */
        public String notes;

        /**
         * Website of contact
         */
        public String websiteurl;

        /**
         * Number of page views
         */
        public int pageviews;

        /**
         * Number of website visits
         */
        public int visits;

        /**
         * Number of messages sent last month
         */
        public int lastmonthsent;

        /**
         * Date this contact last opened an email
         */
        public Date lastopened;

        /**
         *
         */
        public Date lastclicked;

        /**
         * Your gravatar hash for image
         */
        public String gravatarhash;

        public String newEmail;

    }

    /**
     * History of chosen Contact
     */

    public static class ContactHistory {
        /**
         * ID of history of selected Contact.
         */
        public int contacthistoryid;

        /**
         * Type of event occured on this Contact.
         */
        public String eventtype;

        /**
         * Numeric code of event occured on this Contact.
         */
        public int eventtypevalue;

        /**
         * Formatted date of event.
         */
        public String eventdate;

        /**
         * Name of selected channel.
         */
        public String channelname;

        /**
         * Name of template.
         */
        public String templatename;

    }

    /**
     *
     */
    public enum ContactSource {
        /**
         * Source of the contact is not known.
         */
        UNKNOWN,

        /**
         * Contact was inputted from the website interface.
         */
        MANUALINPUT,

        /**
         * Contact was uploaded from the website interface.
         */
        LISTUPLOAD,

        /**
         * Contact was added from a public web form.
         */
        WEBFORM,

        /**
         * Contact was added from an API call.
         */
        APICALL
    }

    /**
     *
     */
    public enum ContactStatus {
        /**
         * Number of engaged contacts
         */
        ENGAGED("engaged", -1),

        /**
         * Number of active contacts
         */
        ACTIVE("active", 0),

        /**
         * Number of bounced messages
         */
        BOUNCED("bounce", 1),

        /**
         * Number of unsubscribed messages
         */
        UNSUBSCRIBED("unsubscribed", 2),

        /**
         * Abuses - mails sent to user without their consent
         */
        ABUSE("abuse", 3),

        /**
         * Number of inactive contacts
         */
        INACTIVE("inactive", 4);

        private final int integerValue;
        private String alternativeName;

        ContactStatus(String value, int intValue) {
            alternativeName = value;
            integerValue = intValue;
        }

        @Override
        public String toString() {
            return name();
        }


        public static ContactStatus create(String value) {
            if (value == null) {
                throw new IllegalArgumentException();
            }
            for (ContactStatus v : values()) {
                if (value.contentEquals(String.valueOf(v.integerValue))) {
                    return v;
                }
                if (value.toLowerCase().contentEquals(v.getAlternativeName())) {
                    return v;
                }
            }
            throw new IllegalArgumentException();
        }

        public String getAlternativeName() {
            return alternativeName;
        }
    }

    /**
     * Number of Contacts, grouped by Status;
     */

    public static class ContactStatusCounts {
        /**
         * Number of engaged contacts
         */
        public long engaged;

        /**
         * Number of active contacts
         */
        public long active;

        /**
         * Number of complaint messages
         */
        public long complaint;

        /**
         * Number of unsubscribed messages
         */
        public long unsubscribed;

        /**
         * Number of bounced messages
         */
        public long bounced;

        /**
         * Number of inactive contacts
         */
        public long inactive;

    }

    /**
     * Daily summary of log status, based on specified date range.
     */

    public static class DailyLogStatusSummary {
        /**
         * Date in YYYY-MM-DDThh:ii:ss format
         */
        public String date;

        /**
         * Proper email address.
         */
        public int email;

        /**
         * Number of SMS
         */
        public int sms;

        /**
         * Number of delivered messages
         */
        public int delivered;

        /**
         * Number of opened messages
         */
        public int opened;

        /**
         * Number of clicked messages
         */
        public int clicked;

        /**
         * Number of unsubscribed messages
         */
        public int unsubscribed;

        /**
         * Number of complaint messages
         */
        public int complaint;

        /**
         * Number of bounced messages
         */
        public int bounced;

        /**
         * Number of inbound messages
         */
        public int inbound;

        /**
         * Number of manually cancelled messages
         */
        public int manualcancel;

    }

    /**
     * Domain data, with information about domain records.
     */

    public static class DomainDetail {
        /**
         * Name of selected domain.
         */
        public String domain;

        /**
         * True, if domain is used as default. Otherwise, false,
         */
        public Boolean defaultdomain;

        /**
         * True, if SPF record is verified
         */
        public Boolean spf;

        /**
         * True, if DKIM record is verified
         */
        public Boolean dkim;

        /**
         * True, if MX record is verified
         */
        public Boolean mx;

        /**
         * True, if tracking CNAME record is verified
         */
        public Boolean isrewritedomainvalid;

        /**
         * True, if verification is available
         */
        public Boolean verify;

    }

    /**
     * Detailed information about email credits
     */

    public static class EmailCredits {
        /**
         * Date in YYYY-MM-DDThh:ii:ss format
         */
        public Date date;

        /**
         * Amount of money in transaction
         */
        public BigDecimal amount;

        /**
         * Source of URL of payment
         */
        public String source;

        /**
         * Free form field of notes
         */
        public String notes;

    }

    /**
     *
     */

    public static class EmailJobFailedStatus {
        /**
         *
         */
        public String address;

        /**
         *
         */
        public String error;

        /**
         * RFC Error code
         */
        public int errorcode;

        /**
         *
         */
        public String category;

    }

    /**
     *
     */

    public static class EmailJobStatus {
        /**
         * ID number of your attachment
         */
        public String id;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public String status;

        /**
         *
         */
        public int recipientscount;

        /**
         *
         */
        public EmailJobFailedStatusList failed;

        /**
         * Total emails sent.
         */
        public int failedcount;

        /**
         * Number of delivered messages
         */
        public StringList delivered;

        /**
         *
         */
        public int deliveredcount;

        /**
         *
         */
        public StringList pending;

        /**
         *
         */
        public int pendingcount;

        /**
         * Number of opened messages
         */
        public StringList opened;

        /**
         * Total emails opened.
         */
        public int openedcount;

        /**
         * Number of clicked messages
         */
        public StringList clicked;

        /**
         * Total emails clicked
         */
        public int clickedcount;

        /**
         * Number of unsubscribed messages
         */
        public StringList unsubscribed;

        /**
         * Total emails clicked
         */
        public int unsubscribedcount;

        /**
         *
         */
        public StringList abusereports;

        /**
         *
         */
        public int abusereportscount;

    }

    /**
     *
     */

    public static class EmailSend {
        /**
         * ID number of transaction
         */
        public String transactionid;

    }

    /**
     * Email details formatted in json
     */

    public static class EmailView {
        /**
         * Body (text) of your message.
         */
        public String body;

        /**
         * Default subject of email.
         */
        public String subject;

        /**
         * Starting date for search in YYYY-MM-DDThh:mm:ss format.
         */
        public String from;

    }

    /**
     * Encoding type for the email headers
     */

    public enum EncodingType {
        /**
         * Encoding of th eemail is provided by the sender and not altered.
         */
        USERPROVIDED,

        /**
         * No endcoding is set for the email.
         */
        NONE,

        /**
         * Encoding of the email is in Raw7bit format.
         */
        RAW7BIT,

        /**
         * Encoding of the email is in Raw8bit format.
         */
        RAW8BIT,

        /**
         * Encoding of the email is in QuotedPrintable format.
         */
        QUOTEDPRINTABLE,

        /**
         * Encoding of the email is in Base64 format.
         */
        BASE64,

        /**
         * Encoding of the email is in Uue format.
         */
        UUE
    }

    /**
     * Record of exported data from the system.
     */

    public static class Export {
        /**
         *
         */
        public UUID publicexportid;

        /**
         * Date the export was created
         */
        public Date dateadded;

        /**
         * Type of export
         */
        public String type;

        /**
         * Current status of export
         */
        public String status;

        /**
         * Long description of the export
         */
        public String info;

        /**
         * Name of the file
         */
        public String filename;

        /**
         * Link to download the export
         */
        public String link;

    }

    /**
     * Type of export
     */
    public enum ExportFileFormats {
        /**
         * Export in comma separated values format.
         */
        CSV,

        /**
         * Export in xml format
         */
        XML,

        /**
         * Export in json format
         */
        JSON
    }

    /**
     * Current status of export
     */
    public enum ExportStatus {
        /**
         * Export had an error and can not be downloaded.
         */
        ERROR,

        /**
         * Export is currently loading and can not be downloaded.
         */
        LOADING,

        /**
         * Export is currently available for downloading.
         */
        READY,

        /**
         * Export is no longer available for downloading.
         */
        EXPIRED
    }

    /**
     * Number of Exports, grouped by export type
     */

    public static class ExportTypeCounts {
        /**
         *
         */
        public long log;

        /**
         *
         */
        public long contact;

        /**
         * Json representation of a campaign
         */
        public long campaign;

        /**
         * True, if you have enabled link tracking. Otherwise, false
         */
        public long linktracking;

        /**
         * Json representation of a survey
         */
        public long survey;

    }

    /**
     * Object containig tracking data.
     */

    public static class LinkTrackingDetails {
        /**
         * Number of items.
         */
        public int count;

        /**
         * True, if there are more detailed data available. Otherwise, false
         */
        public Boolean moreavailable;

        /**
         *
         */
        public TrackedLinkList trackedlink;

    }

    /**
     * List of Contacts, with detailed data about its contents.
     */

    public static class List {
        /**
         * ID number of selected list.
         */
        public int listid;

        /**
         * Name of your list.
         */
        public String listname;

        /**
         * Number of items.
         */
        public int count;

        /**
         * ID code of list
         */
        public UUID publiclistid;

        /**
         * Date of creation in YYYY-MM-DDThh:ii:ss format
         */
        public Date dateadded;

        /**
         * True: Allow unsubscribing from this list. Otherwise, false
         */
        public Boolean allowunsubscribe;

    }

    /**
     * Detailed information about litmus credits
     */

    public static class LitmusCredits {
        /**
         * Date in YYYY-MM-DDThh:ii:ss format
         */
        public Date date;

        /**
         * Amount of money in transaction
         */
        public BigDecimal amount;

    }

    /**
     * Logs for selected date range
     */

    public static class Log {
        /**
         * Starting date for search in YYYY-MM-DDThh:mm:ss format.
         */
        public Date from;

        /**
         * Ending date for search in YYYY-MM-DDThh:mm:ss format.
         */
        public Date to;

        /**
         * Number of recipients
         */
        public RecipientList recipients;

    }

    /**
     *
     */
    public enum LogJobStatus {
        /**
         *
         */
        READYTOSEND,

        /**
         *
         */
        WAITINGTORETRY,

        /**
         *
         */
        SENDING,

        /**
         *
         */
        ERROR,

        /**
         *
         */
        SENT,

        /**
         * Number of opened messages
         */
        OPENED,

        /**
         * Number of clicked messages
         */
        CLICKED,

        /**
         * Number of unsubscribed messages
         */
        UNSUBSCRIBED,

        /**
         *
         */
        ABUSEREPORT
    }

    /**
     * Summary of log status, based on specified date range.
     */

    public static class LogStatusSummary {
        /**
         * Starting date for search in YYYY-MM-DDThh:mm:ss format.
         */
        public String from;

        /**
         * Ending date for search in YYYY-MM-DDThh:mm:ss format.
         */
        public String to;

        /**
         * Overall duration
         */
        public double duration;

        /**
         * Number of recipients
         */
        public long recipients;

        /**
         * Number of emails
         */
        public long emailtotal;

        /**
         * Number of SMS
         */
        public long smstotal;

        /**
         * Number of delivered messages
         */
        public long delivered;

        /**
         * Number of bounced messages
         */
        public long bounced;

        /**
         * Number of messages in progress
         */
        public long inprogress;

        /**
         * Number of opened messages
         */
        public long opened;

        /**
         * Number of clicked messages
         */
        public long clicked;

        /**
         * Number of unsubscribed messages
         */
        public long unsubscribed;

        /**
         * Number of complaint messages
         */
        public long complaints;

        /**
         * Number of inbound messages
         */
        public long inbound;

        /**
         * Number of manually cancelled messages
         */
        public long manualcancel;

        /**
         * ID number of template used
         */
        public Boolean templatechannel;

    }

    /**
     * Overall log summary information.
     */

    public static class LogSummary {
        /**
         * Summary of log status, based on specified date range.
         */
        public LogStatusSummary logstatussummary;

        /**
         * Summary of bounced categories, based on specified date range.
         */
        public BouncedCategorySummary bouncedcategorysummary;

        /**
         * Daily summary of log status, based on specified date range.
         */
        public DailyLogStatusSummaryList dailylogstatussummary;

    }

    /**
     * Queue of notifications
     */

    public static class NotificationQueue {
        /**
         * Creation date.
         */
        public String datecreated;

        /**
         * Date of last status change.
         */
        public String statuschangedate;

        /**
         * Actual status.
         */
        public String newstatus;

        /**
         *
         */
        public String reference;

        /**
         * Error message.
         */
        public String errormessage;

        /**
         * Number of previous delivery attempts
         */
        public String retrycount;

    }

    /**
     * Detailed information about existing money transfers.
     */

    public static class Payment {
        /**
         * Date in YYYY-MM-DDThh:ii:ss format
         */
        public Date date;

        /**
         * Amount of money in transaction
         */
        public BigDecimal amount;

        /**
         * Source of URL of payment
         */
        public String source;

    }

    /**
     *
     */
    public enum QuestionType {
        /**
         *
         */
        RADIOBUTTONS,

        /**
         *
         */
        DROPDOWNMENU,

        /**
         *
         */
        CHECKBOXES,

        /**
         *
         */
        LONGANSWER,

        /**
         *
         */
        TEXTBOX,

        /**
         * Date in YYYY-MM-DDThh:ii:ss format
         */
        DATE
    }

    /**
     * Detailed information about message recipient
     */

    public static class Recipient {
        /**
         * True, if message is SMS. Otherwise, false
         */
        public Boolean issms;

        /**
         * ID number of selected message.
         */
        public String msgid;

        /**
         * Ending date for search in YYYY-MM-DDThh:mm:ss format.
         */
        public String to;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public String status;

        /**
         * Name of selected Channel.
         */
        public String channel;

        /**
         * Date in YYYY-MM-DDThh:ii:ss format
         */
        public String date;

        /**
         * Content of message, HTML encoded
         */
        public String message;

        /**
         * True, if message category should be shown. Otherwise, false
         */
        public Boolean showcategory;

        /**
         * ID of message category
         */
        public String messagecategory;

        /**
         * Date of last status change.
         */
        public String statuschangedate;

        /**
         * Date of next try
         */
        public String nexttryon;

        /**
         * Default subject of email.
         */
        public String subject;

        /**
         * Default From: email address.
         */
        public String fromemail;

        /**
         * ID of certain mail job
         */
        public String jobid;

        /**
         * True, if message is a SMS and status is not yet confirmed. Otherwise, false
         */
        public Boolean smsupdaterequired;

        /**
         * Content of message
         */
        public String textmessage;

        /**
         * Comma separated ID numbers of messages.
         */
        public String messagesid;

    }

    /**
     * Referral details for this account.
     */

    public static class Referral {
        /**
         * Current amount of dolars you have from referring.
         */
        public BigDecimal currentreferralcredit;

        /**
         * Number of active referrals.
         */
        public long currentreferralcount;

    }

    /**
     * Detailed sending reputation of your account.
     */

    public static class ReputationDetail {
        /**
         * Overall reputation impact, based on the most important factors.
         */
        public ReputationImpact impact;

        /**
         * Percent of Complaining users - those, who do not want to receive email from you.
         */
        public double abusepercent;

        /**
         * Percent of Unknown users - users that couldn't be found
         */
        public double unknownuserspercent;

        /**
         * Penalty from messages marked as spam.
         */
        public double averagespamscore;

        /**
         * Percent of Bounced users
         */
        public double failedspampercent;

        /**
         * Points from quantity of your emails.
         */
        public double repemailssent;

        /**
         * Average reputation.
         */
        public double averagereputation;

        /**
         * Actual price level.
         */
        public double pricelevelreputation;

        /**
         * Reputation needed to change pricing.
         */
        public double nextpricelevelreputation;

        /**
         * Amount of emails sent from this account
         */
        public String pricelevel;

        /**
         * True, if tracking domain is correctly configured. Otherwise, false.
         */
        public Boolean trackingdomainvalid;

        /**
         * True, if sending domain is correctly configured. Otherwise, false.
         */
        public Boolean senderdomainvalid;

    }

    /**
     * Reputation history of your account.
     */

    public static class ReputationHistory {
        /**
         * Creation date.
         */
        public String datecreated;

        /**
         * Percent of Complaining users - those, who do not want to receive email from you.
         */
        public double abusepercent;

        /**
         * Percent of Unknown users - users that couldn't be found
         */
        public double unknownuserspercent;

        /**
         * Penalty from messages marked as spam.
         */
        public double averagespamscore;

        /**
         * Points from proper setup of your account
         */
        public double setupscore;

        /**
         * Points from quantity of your emails.
         */
        public double repemailssent;

        /**
         * Numeric reputation
         */
        public double reputation;

    }

    /**
     * Overall reputation impact, based on the most important factors.
     */

    public static class ReputationImpact {
        /**
         * Abuses - mails sent to user without their consent
         */
        public double abuse;

        /**
         * Users, that could not be reached.
         */
        public double unknownusers;

        /**
         * Penalty from messages marked as spam.
         */
        public double averagespamscore;

        /**
         * Content analysis.
         */
        public double serverfilter;

        /**
         * Total emails sent.
         */
        public double totalemailsent;

        /**
         * Tracking domain.
         */
        public double trackingdomain;

        /**
         * Sending domain.
         */
        public double senderdomain;

    }

    /**
     * Information about Contact Segment, selected by RULE.
     */

    public static class Segment {
        /**
         * ID number of your segment.
         */
        public int segmentid;

        /**
         * ID of selected account.
         */
        public int accountid;

        /**
         * Filename
         */
        public String name;

        /**
         * Query used for filtering.
         */
        public String rule;

        /**
         * Number of items from last check.
         */
        public long lastcount;

        /**
         * History of segment information.
         */
        public SegmentHistoryList history;

    }

    /**
     * Segment History
     */

    public static class SegmentHistory {
        /**
         * ID number of history.
         */
        public int segmenthistoryid;

        /**
         * ID number of your segment.
         */
        public int segmentid;

        /**
         * ID of selected account.
         */
        public int accountid;

        /**
         * Date in YYYY-MM-DD format
         */
        public int day;

        /**
         * Number of items.
         */
        public long count;

    }

    /**
     *
     */
    public enum SendingPermission {
        /**
         * Sending not allowed.
         */
        NONE,

        /**
         * Allow sending via SMTP only.
         */
        SMTP,

        /**
         * Allow sending via HTTP API only.
         */
        HTTPAPI,

        /**
         * Allow sending via SMTP and HTTP API.
         */
        SMTPANDHTTPAPI,

        /**
         * Allow sending via the website interface only.
         */
        INTERFACE,

        /**
         * Allow sending via SMTP and the website interface.
         */
        SMTPANDINTERFACE,

        /**
         * Allow sendnig via HTTP API and the website interface.
         */
        HTTPAPIANDINTERFACE,

        /**
         * Sending allowed via SMTP, HTTP API and the website interface.
         */
        ALL
    }

    /**
     * Spam check of specified message.
     */

    public static class SpamCheck {
        /**
         * Total spam score from
         */
        public String totalscore;

        /**
         * Date in YYYY-MM-DDThh:ii:ss format
         */
        public String date;

        /**
         * Default subject of email.
         */
        public String subject;

        /**
         * Default From: email address.
         */
        public String fromemail;

        /**
         * ID number of selected message.
         */
        public String msgid;

        /**
         * Name of selected channel.
         */
        public String channelname;

        /**
         *
         */
        public SpamRuleList rules;

    }

    /**
     * Single spam score
     */

    public static class SpamRule {
        /**
         * Spam score
         */
        public String score;

        /**
         * Name of rule
         */
        public String key;

        /**
         * Description of rule.
         */
        public String description;

    }

    /**
     *
     */
    public enum SplitOptimization {
        /**
         * Number of opened messages
         */
        OPENED,

        /**
         * Number of clicked messages
         */
        CLICKED
    }

    /**
     * Subaccount. Contains detailed data of your Subaccount.
     */

    public static class SubAccount {
        /**
         * ID of selected account.
         */
        public String accountid;

        /**
         * Public key for limited access to your account such as contact/add so you can use it safely on public websites.
         */
        public String publicaccountid;

        /**
         * ApiKey that gives you access to our SMTP and HTTP API's.
         */
        public String apikey;

        /**
         * Proper email address.
         */
        public String email;

        /**
         * ID number of mailer
         */
        public String mailerid;

        /**
         * Type of account: 1 for Transactional Email, 2 for Marketing Email.
         */
        public AccountType accounttype;

        /**
         * Date of last activity on account
         */
        public String lastactivity;

        /**
         * Amount of email credits
         */
        public String emailcredits;

        /**
         * True, if account needs credits to send emails. Otherwise, false
         */
        public Boolean requiresemailcredits;

        /**
         * Amount of credits added to account automatically
         */
        public double monthlyrefillcredits;

        /**
         * True, if account needs credits to buy templates. Otherwise, false
         */
        public Boolean requirestemplatecredits;

        /**
         * Amount of Litmus credits
         */
        public BigDecimal litmuscredits;

        /**
         * True, if account is able to send template tests to Litmus. Otherwise, false
         */
        public Boolean enablelitmustest;

        /**
         * True, if account needs credits to send emails. Otherwise, false
         */
        public Boolean requireslitmuscredits;

        /**
         * True, if account can buy templates on its own. Otherwise, false
         */
        public Boolean enablepremiumtemplates;

        /**
         * True, if account can request for private IP on its own. Otherwise, false
         */
        public Boolean enableprivateiprequest;

        /**
         * Amount of emails sent from this account
         */
        public long totalemailssent;

        /**
         * Percent of Unknown users - users that couldn't be found
         */
        public double unknownuserspercent;

        /**
         * Percent of Complaining users - those, who do not want to receive email from you.
         */
        public double abusepercent;

        /**
         * Percent of Bounced users
         */
        public double failedspampercent;

        /**
         * Numeric reputation
         */
        public double reputation;

        /**
         * Amount of emails account can send daily
         */
        public long dailysendlimit;

        /**
         * Name of status: Active, Engaged, Inactive, Abuse, Bounced, Unsubscribed.
         */
        public String status;

    }

    /**
     * Detailed account settings.
     */

    public static class SubAccountSettings {
        /**
         * Proper email address.
         */
        public String email;

        /**
         * True, if account needs credits to send emails. Otherwise, false
         */
        public Boolean requiresemailcredits;

        /**
         * True, if account needs credits to buy templates. Otherwise, false
         */
        public Boolean requirestemplatecredits;

        /**
         * Amount of credits added to account automatically
         */
        public double monthlyrefillcredits;

        /**
         * Amount of Litmus credits
         */
        public BigDecimal litmuscredits;

        /**
         * True, if account is able to send template tests to Litmus. Otherwise, false
         */
        public Boolean enablelitmustest;

        /**
         * True, if account needs credits to send emails. Otherwise, false
         */
        public Boolean requireslitmuscredits;

        /**
         * Maximum size of email including attachments in MB's
         */
        public int emailsizelimit;

        /**
         * Amount of emails account can send daily
         */
        public int dailysendlimit;

        /**
         * Maximum number of contacts the account can havelkd
         */
        public int maxcontacts;

        /**
         * True, if account can request for private IP on its own. Otherwise, false
         */
        public Boolean enableprivateiprequest;

        /**
         * True, if you want to use Advanced Tools.  Otherwise, false
         */
        public Boolean enablecontactfeatures;

        /**
         * Sending permission setting for account
         */
        public SendingPermission sendingpermission;

    }

    /**
     * A survey object
     */

    public static class Survey {
        /**
         * Survey identifier
         */
        public UUID publicsurveyid;

        /**
         * Creation date.
         */
        public Date datecreated;

        /**
         * Last change date
         */
        public Date dateupdated;

        /**
         * Filename
         */
        public String name;

        /**
         * Activate, delete, or pause your survey
         */
        public SurveyStatus status;

        /**
         * Number of results count
         */
        public int resultcount;

        /**
         * Survey's steps info
         */
        public SurveyStepList surveystep;

        /**
         * URL of the survey
         */
        public String surveylink;

    }

    /**
     * Object with the single answer's data
     */

    public static class SurveyResultAnswerInfo {
        /**
         * Answer's content
         */
        public String content;

        /**
         * Identifier of the step
         */
        public int surveystepid;

        /**
         * Identifier of the answer of the step
         */
        public String surveystepanswerid;

    }

    /**
     * Single answer's data with user's specific info
     */

    public static class SurveyResultInfo {
        /**
         * Identifier of the result
         */
        public String surveyresultid;

        /**
         * IP address
         */
        public String createdfromip;

        /**
         * Completion date
         */
        public Date datecompleted;

        /**
         * Start date
         */
        public Date datestart;

        /**
         * Answers for the survey
         */
        public SurveyResultAnswerInfoList surveyresultanswers;

    }

    /**
     * Summary with all the answers
     */

    public static class SurveyResultsSummary {
        /**
         * Answers' statistics
         */
        public HashMap<String, Integer> answers;

        /**
         * Open answers for the question
         */
        public StringList openanswers;

    }

    /**
     * Data on the survey's result
     */

    public static class SurveyResultsSummaryInfo {
        /**
         * Number of items.
         */
        public int count;

        /**
         * Summary statistics
         */
        public HashMap<Integer, SurveyResultsSummary> summary;

    }

    /**
     *
     */
    public enum SurveyStatus {
        /**
         * The survey is deleted
         */
        DELETED,

        /**
         * The survey is not receiving result for now
         */
        PAUSED,

        /**
         * The survey is active and receiving answers
         */
        ACTIVE
    }

    /**
     * Survey's single step info with the answers
     */

    public static class SurveyStep {
        /**
         * Identifier of the step
         */
        public int surveystepid;

        /**
         * Type of the step
         */
        public SurveyStepType surveysteptype;

        /**
         * Type of the question
         */
        public QuestionType questiontype;

        /**
         * Answer's content
         */
        public String content;

        /**
         * Is the answer required
         */
        public Boolean required;

        /**
         * Sequence of the answers
         */
        public int sequence;

        /**
         * Answer object of the step
         */
        public SurveyStepAnswerList surveystepanswer;

    }

    /**
     * Single step's answer object
     */

    public static class SurveyStepAnswer {
        /**
         * Identifier of the answer of the step
         */
        public String surveystepanswerid;

        /**
         * Answer's content
         */
        public String content;

        /**
         * Sequence of the answers
         */
        public int sequence;

    }

    /**
     *
     */
    public enum SurveyStepType {
        /**
         *
         */
        PAGEBREAK,

        /**
         *
         */
        QUESTION,

        /**
         *
         */
        TEXTMEDIA,

        /**
         *
         */
        CONFIRMATIONPAGE,

        /**
         *
         */
        EXPIREDPAGE
    }

    /**
     * Template
     */

    public static class Template {
        /**
         * ID number of template.
         */
        public int templateid;

        /**
         * 0 for API connections
         */
        public TemplateType templatetype;

        /**
         * Filename
         */
        public String name;

        /**
         * Date of creation in YYYY-MM-DDThh:ii:ss format
         */
        public Date dateadded;

        /**
         * CSS style
         */
        public String css;

        /**
         * Default subject of email.
         */
        public String subject;

        /**
         * Default From: email address.
         */
        public String fromemail;

        /**
         * Default From: name.
         */
        public String fromname;

        /**
         * HTML code of email (needs escaping).
         */
        public String bodyhtml;

        /**
         * Text body of email.
         */
        public String bodytext;

        /**
         * ID number of original template.
         */
        public int originaltemplateid;

        /**
         * Enum: 0 - private, 1 - public, 2 - mockup
         */
        public TemplateScope templatescope;

    }

    /**
     * List of templates
     */

    public static class TemplateList {
    }

    /**
     *
     */
    public enum TemplateScope {
        /**
         * Template is available for this account only.
         */
        PRIVATE,

        /**
         * Template is available for this account and it's sub-accounts.
         */
        PUBLIC
    }

    /**
     *
     */
    public enum TemplateType {
        /**
         * Template supports any valid HTML
         */
        RAWHTML,

        /**
         * Template is created and can only be modified in drag and drop editor
         */
        DRAGDROPEDITOR
    }

    /**
     * Information about tracking link and its clicks.
     */

    public static class TrackedLink {
        /**
         * URL clicked
         */
        public String link;

        /**
         * Number of clicks
         */
        public String clicks;

        /**
         * Percent of clicks
         */
        public String percent;

    }

    /**
     * Account usage
     */
    public static class Usage {
    }

    public static class AttachmentList extends ArrayList<Attachment> {
    }

    public static class BlockedContactList extends ArrayList<BlockedContact> {
    }

    public static class CampaignChannelList extends ArrayList<CampaignChannel> {
    }

    public static class CampaignTemplateList extends ArrayList<CampaignTemplate> {
    }

    public static class ChannelList extends ArrayList<Channel> {
    }

    public static class ContactList extends ArrayList<Contact> {
    }

    public static class ContactHistoryList extends ArrayList<ContactHistory> {
    }

    public static class DailyLogStatusSummaryList extends ArrayList<DailyLogStatusSummary> {
    }

    public static class DomainDetailList extends ArrayList<DomainDetail> {
    }

    public static class EmailCreditsList extends ArrayList<EmailCredits> {
    }

    public static class EmailJobFailedStatusList extends ArrayList<EmailJobFailedStatus> {
    }

    public static class ExportList extends ArrayList<Export> {
    }

    public static class ListList extends ArrayList<List> {
    }

    public static class LitmusCreditsList extends ArrayList<LitmusCredits> {
    }

    public static class LogJobStatusList extends ArrayList<LogJobStatus> {
    }

    public static class NotificationQueueList extends ArrayList<NotificationQueue> {
    }

    public static class PaymentList extends ArrayList<Payment> {
    }

    public static class RecipientList extends ArrayList<Recipient> {
    }

    public static class ReputationHistoryList extends ArrayList<ReputationHistory> {
    }

    public static class SegmentList extends ArrayList<Segment> {
    }

    public static class SegmentHistoryList extends ArrayList<SegmentHistory> {
    }

    public static class SpamCheckList extends ArrayList<SpamCheck> {
    }

    public static class SpamRuleList extends ArrayList<SpamRule> {
    }

    public static class StringList extends ArrayList<String> {
    }

    public static class SubAccountList extends ArrayList<SubAccount> {
    }

    public static class SurveyList extends ArrayList<Survey> {
    }

    public static class SurveyResultAnswerInfoList extends ArrayList<SurveyResultAnswerInfo> {
    }

    public static class SurveyResultInfoList extends ArrayList<SurveyResultInfo> {
    }

    public static class SurveyStepList extends ArrayList<SurveyStep> {
    }

    public static class SurveyStepAnswerList extends ArrayList<SurveyStepAnswer> {
    }

    public static class TrackedLinkList extends ArrayList<TrackedLink> {
    }

    public static class UsageList extends ArrayList<Usage> {
    }

}