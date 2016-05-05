package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.dataart.selenium.framework.Utils.isElementPresent;

public class BasicPage extends BasePage {

	public final static By logoutBy = By.xpath("//a[contains(text(), 'Logout')]");
	public final static By flash = By.xpath("//p[@class='flash']");
	@FindBy(xpath="//input[@value='Login']")WebElement loginButton;
	Select select;

	public LoginPage forceLogout() { // here is a logout in any case
		driver.get(settings.getBaseUrl()); 
		if (isElementPresent(logoutBy)) {
			driver.findElement(logoutBy).click();
		}
		return initPage(LoginPage.class);
	}

	public String getFlashMessage() {
		if (isElementPresent(flash)) {
			return driver.findElement(flash).getText();
		}
		return null;
	}

	public void clickElement(WebElement element){
		element.click();
	}

	public void selectElement(WebElement element, String value){
		select = new Select(element);
		select.selectByVisibleText(value); 
	}

	public String currentUrl(){
		return driver.getCurrentUrl();
	}



}
