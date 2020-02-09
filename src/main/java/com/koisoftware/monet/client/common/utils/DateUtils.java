package com.koisoftware.monet.client.common.utils;

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

/**
 * Date utils
 */
public final class DateUtils {

    public static final String MONET_DATE_FORMAT = "dd-MMM-yy";
    public static final String MONET_DATE_FORMAT_TIME = "h:mm a";

    public static String formatDate(Date date) {
        if (date == null)
            return "";

        return DateTimeFormat.getFormat(MONET_DATE_FORMAT).format(date);
    }

    public static String formatDateTime(Date date) {
        if (date == null)
            return "";

        return DateTimeFormat.getFormat(MONET_DATE_FORMAT + " " + MONET_DATE_FORMAT_TIME).format(date);
    }
}
