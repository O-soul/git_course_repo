package com.dataart.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;

public class RegistrationPage extends BasePage{ // my class
	
	

	@FindBy(xpath="//input[@name='name']")WebElement username;
	@FindBy(xpath="//input[@name='fname']")WebElement fname;
	@FindBy(xpath="//input[@name='lname']")WebElement lname;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//input[@name='passwordConfirm']")WebElement passwordConfirm;
	@FindBy(xpath="//select[@name='role']")WebElement role;
	@FindBy(xpath="//input[@value='Register']")WebElement submit;
	
	public void registerNewUser(User user){
		username.clear();
		fname.clear();
		lname.clear();
		password.clear();
		passwordConfirm.clear();
		username.sendKeys(user.getUsername());
		fname.sendKeys(user.getFname());
		lname.sendKeys(user.getLname());
		password.sendKeys(user.getPassword());
		passwordConfirm.sendKeys(user.getPassword());				
		Select select = new Select(role);
		select.selectByVisibleText("USER"); 					
		submit.click();	
	}
}
