package com.dataart.selenium.framework;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum BrowserType { // this class is used in BaseTest class(row 13) for to now if we have got correct browser
    FIREFOX,
    IE,
    GC,
    OPERA,
    HTMLUNIT;

    private static Map<String, BrowserType> browsersMap = new HashMap<String, BrowserType>();

    static {
        browsersMap.put("firefox", BrowserType.FIREFOX);
        browsersMap.put("ie", BrowserType.IE);
        browsersMap.put("gc", BrowserType.GC);
        browsersMap.put("opera", BrowserType.OPERA);
        browsersMap.put("htmlunit", BrowserType.HTMLUNIT);
    }

    public static BrowserType Browser(String name) {
        BrowserType browserType = browsersMap.get(name.toLowerCase().trim());
        if (browserType == null) {
            throw new UnknownBrowserException("Unknown browser [" + name + "]. Use one of following: "
                    + StringUtils.join(browsersMap.keySet().toArray(), ", "));
        }
        return browserType;
    }
}
