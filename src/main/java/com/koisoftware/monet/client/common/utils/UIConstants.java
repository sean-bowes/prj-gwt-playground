package com.koisoftware.monet.client.common.utils;

/**
 * Global Constants for all screens.
 *
 * @author Tarun Kathuria
 */
public class UIConstants {

    public static int SECTION_HEADER_HEIGHT = 22;

    public static int MAX_EXCEL_EXPORT_COUNT = 2000;

    /**
     * Upload servet
     */
    public static final String FILE_UPLOAD_SERVLET = "FileUploadServlet";
    public static final String FILE_DOWNLOAD_SERVLET = "FileDownloadServlet";


    public static String CONTENT_PROVIDER = "/monet";//      "";//

    //Security Constants
    public static String PRINCIPAL_REQUEST_HEADER = "x-citiportal-LoginID";
    public static String MONET_HOME_PAGE = "/monet.html";
    public static String ACCESS_DENIED_PAGE = "/accessDenied.html";
    public static String LOGIN_LISTING_PAGE = "/login.jsp";
    public static String SESSION_AUTHENTICATED_USER = "SESSION_AUTHENTICATED_USER";
    public static String AUTH_FORMFIELD_USERNAME = "j_username";


    //Image Identifier Strings
    public static String IMAGE_OPEN_MARGIN_CALL = CONTENT_PROVIDER + "/images/citi_icons/icon_clock.gif";
    public static String IMAGE_SUSPECT_DATA = CONTENT_PROVIDER + "/images/citi_icons/icon_alert.gif";
    public static String IMAGE_IMMEDIATE_ATTENTION = CONTENT_PROVIDER + "/images/icons/icon-alert.gif";
    public static String IMAGE_PAST_DUE = CONTENT_PROVIDER + "/images/icons/icon-clock2.gif";
    public static String IMAGE_HIGH_PRIORITY = CONTENT_PROVIDER + "/images/icons/icon-h.gif";
    public static String IMAGE_APPROVAL_PENDING = CONTENT_PROVIDER + "/images/icons/searchsmall.png";
    public static String IMAGE_EVENT_ROUTED = CONTENT_PROVIDER + "/images/icons/icon-people.gif";
    public static String IMAGE_ADDITIONAL_INFO = CONTENT_PROVIDER + "/images/icons/icon-i.gif";
    public static String IMAGE_ACTION_LISTING = CONTENT_PROVIDER + "/images/icons/searchsmall.png";
    public static String IMAGE_SCRATCH_PAD = CONTENT_PROVIDER + "/images/citi_icons/icon_ManagementProfile.gif";
    public static String IMAGE_CPM_CLIENT = CONTENT_PROVIDER + "/images/icons/icon-folder-sm.gif";
    public static String IMAGE_HELP = CONTENT_PROVIDER + "/images/icons/searchsmall.png";
    public static String IMAGE_MULTIPLE_INFO = CONTENT_PROVIDER + "/images/icons/icon-M.gif";

    //MouseOver Hover Identifier Strings
    public static String HOVERHTML_OPEN_MARGIN_CALL = "Open Margin Call";
    public static String HOVERHTML_SUSPECT_DATA = "Suspected Data";
    public static String HOVERHTML_IMMEDIATE_ATTENTION = "Immediate Attention Required";
    public static String HOVERHTML_PAST_DUE = "Past Due";
    public static String HOVERHTML_HIGH_PRIORITY = "High Priority";
    public static String HOVERHTML_APPROVAL_PENDING = "Approval Pending";
    public static String HOVERHTML_EVENT_ROUTED = "Event Routed";
    public static String HOVERHTML_ADDITIONAL_INFO = "Additional Info";
    public static String HOVERHTML_ACTION_LISTING = "Action Listing";
    public static String HOVERHTML_SCRATCH_PAD = "Scratch Pad";
    public static String HOVERHTML_CPM_CLIENT = "CPM Client";
    public static String HOVERHTML_HELP = "Context Sensitive Help";
    public static String HOVERHTML_MULTIPLE_INFO = "Multiple Information (e.g. Legal Entities, Accounts)";

    //Loading page icon.
    public static String IMAGE_LOADING_ANIMATED = CONTENT_PROVIDER + "/images/icons/icon_loading.gif";

    // Protected Resources - Make sure the following values match the ResourcID in MONET_RESOURCE table.
    public static String RESOURCE_CLIENTSEARCH_SPECIALFLAGS = "RESOURCE_CLIENTSEARCH_SPECIALFLAGS";
    //

    // Service Manager Types Enum //icgint
    public static enum ServiceManagerType {
        MarginCenter, ClientSearch, AgreementManager, ExposureManager
    }

    ;

    public static String NOT_AUTHORIZED_MESSAGE = "   You are not authorized to access this page.  Please email <a href='mailto:ICG MONET- Support Team'>ICG MONET- Support Team</a> for access.";

    public static String UPLOAD_APP_NAME = "UPLOAD_APP_NAME";
    public static String UPLOAD_APP_NAME_PRICE = "UPLOAD_APP_NAME_PRICE";
    public static String UPLOAD_APP_NAME_AGREEMENTS = "UPLOAD_APP_NAME_AGREEMENTS";
    public static String MARGIN_CENTER_SID = "MARGIN_CENTER_SID";

    public static String BUTTON_TITLE_SEARCH = "Search";
    public static String TITLE_SHOW_CRITERIA = "Show Criteria";
    public static String GRID_TITLE_SEARCH_RESULTS = "Search Results";
    public static String WARNING_DIALOG_TITLE = "Warning";
    public static String CLIENT_ACCOUNT_POPUP_TITLE = "Client / Account Details";
    public static String PRODUCT_POPUP_TITLE = "Product Details";

}
