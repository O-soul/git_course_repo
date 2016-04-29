package com.dataart.selenium.framework;

import static com.dataart.selenium.framework.BasePage.initPage;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.dataart.selenium.pages.BasicPage;
import com.dataart.selenium.pages.LoginPage;

public class BaseTest  {
    private static Settings settings = new Settings();
    public static BasicPage basicPage;
    public static LoginPage loginPage;
    //TODO  SDFSD
    public static SoftAssert softAssert; 

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() {
        BasePage.driver = settings.getDriver(); // we got browser here(it's set in Settings class)
        BasePage.settings = settings;
        BasePage.driver.get(settings.getBaseUrl()); // we got url here(it's set in Settings class)
        if (!settings.getBrowser().equals(BrowserType.HTMLUNIT)) // just a comparing
            BasePage.driver.manage().window().maximize();
        
        basicPage = initPage(BasicPage.class);    // finding BasicPage's elements and BasicPage init
        loginPage = initPage(LoginPage.class);    // the same
        softAssert = new SoftAssert();
      System.out.println("Oleg, @BeforeSuite is finished!");
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        BasePage.driver.close();
        System.out.println("Oleg, @AfterSuite is finished!");
    }
    
    public static void successMessage(String methodName){
    	System.out.println("Oleg, "+ methodName +": SUCCESS!");
    }
}
