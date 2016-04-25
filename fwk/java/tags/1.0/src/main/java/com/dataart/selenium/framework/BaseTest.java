package com.dataart.selenium.framework;

import org.testng.annotations.*;

public class BaseTest  {
    private static Settings settings = new Settings();

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() {
        BasePage.driver = settings.getDriver(); // we got browser here(it's set in Settings class)
        BasePage.settings = settings;
        BasePage.driver.get(settings.getBaseUrl()); // we got url here(it's set in Settings class)
        if (!settings.getBrowser().equals(BrowserType.HTMLUNIT)) // just a comparing
            BasePage.driver.manage().window().maximize();
        
      System.out.println("Oleg, @BeforeSuite is finished!");
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        BasePage.driver.close();
        System.out.println("Oleg, @AfterSuite is finished!");
    }
}
