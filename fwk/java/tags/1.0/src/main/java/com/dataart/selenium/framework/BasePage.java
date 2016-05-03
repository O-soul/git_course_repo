package com.dataart.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

public class BasePage {
    public static WebDriver driver; // driver инится первой строчкой в @BeforeSuite.
    public static Settings settings;

    public static <T extends BasePage> T initPage(Class<T> pageClass) { 
        return PageFactory.initElements(driver, pageClass);
    }
}
