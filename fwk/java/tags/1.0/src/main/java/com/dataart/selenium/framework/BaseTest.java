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
    public static SoftAssert softAssert; 
    

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() {
        BasePage.driver = settings.getDriver();       
        BasePage.settings = settings;        
        BasePage.driver.get(settings.getBasicAuthenticationUrl()); // set "settings.getBasicAuthenticationUrl()" to run tests with Basic Authentication.        	
        if (!settings.getBrowser().equals(BrowserType.HTMLUNIT)) 
            BasePage.driver.manage().window().maximize(); 
        basicPage = initPage(BasicPage.class);    
        loginPage = initPage(LoginPage.class);    
        softAssert = new SoftAssert();
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        BasePage.driver.close();
    }
    
    public static void successMessage(String methodName){
    	System.out.println("Oleg, "+ methodName +": SUCCESS!");
    }
}
