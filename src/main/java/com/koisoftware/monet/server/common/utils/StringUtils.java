package com.koisoftware.monet.server.common.utils;

/**
 * Created by sb90320 on 11/22/2014.
 */
public class StringUtils {
    public static String escapeHtml(String html) {
        if (html == null) {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
