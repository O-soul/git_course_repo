package com.dataart.selenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	private static WebDriver driver = BasePage.driver;

	public static WebElement waitForElementPresent(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))); 
		return element;
	}

	public static boolean isElementPresent(String xpath) {
		return driver.findElements(By.xpath(xpath)).size() > 0;
	}

	public static boolean isElementPresent(By by) {
		return driver.findElements(by).size() > 0;
	}

	public static String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static void deleteAllCookies(){
		driver.manage().deleteAllCookies();
	}

}
