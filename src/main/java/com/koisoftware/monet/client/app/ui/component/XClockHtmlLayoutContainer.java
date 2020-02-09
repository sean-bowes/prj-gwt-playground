package com.koisoftware.monet.client.app.ui.component;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;

/**
 * Created by sb90320 on 11/8/2014.
 */
public interface XClockHtmlLayoutContainer extends XTemplates {
    //@XTemplate("<table width=\"100%\" height=\"100%\"><tbody><tr><td height=\"100%\" class=\"cell1\" /></tr></tbody></table>")
    @XTemplate("<embed src=\"flash/wtsclock001.swf?color=FF9900&wtsid=US-NY\" width=\"50\" height=\"50\" wmode=\"transparent\" type=\"application/x-shockwave-flash\" />")
    SafeHtml getTemplate();
}
