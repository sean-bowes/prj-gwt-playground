package com.koisoftware.monet.client.common.utils;

import com.google.gwt.i18n.client.NumberFormat;

/**
 * client string utils
 */
public final class StringUtils {

    public static boolean hasLength(String s) {
        if (s == null)
            return false;

        if (s.trim().length() == 0)
            return false;
        else
            return true;
    }

    public static String display(Object d) {
        if (d == null)
            return "";

        return "" + d;
    }

    public static String display(Integer i) {
        if (i == null)
            return "";

        return String.valueOf(i);
    }

    public static String display(Boolean b) {
        if (b == null)
            return "";

        if (b)
            return "YES";
        else return "NO";
    }

    public static String display(String s) {
        if (s == null)
            return "";

        return s;
    }

    public static String display(Double d) {
        if (d == null)
            return "";

        return "" + d;
    }


    public static String money(Double d) {
        if (d == null)
            return "";

        return NumberFormat.getFormat("#,##0").format(d);
    }

    public static String price(Double d) {
        if (d == null)
            return "";

        return NumberFormat.getFormat("#,##0.000000").format(d);
    }

    public static Double parse(String s) {
        if (s == null)
            return null;
        try {
            s = s.replaceAll(",", ""); // in case there are commas
            return Double.parseDouble(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer parseInt(String s) {
        if (s == null)
            return null;
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public native static boolean validateEmail(String address) /*-{
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if (reg.test(address) == false) {
            return false;
        } else return true;
    }-*/;
}
