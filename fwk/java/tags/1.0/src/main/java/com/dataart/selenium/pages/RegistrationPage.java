package com.dataart.selenium.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dataart.selenium.models.User;

public class RegistrationPage extends BasicPage{ // my class


	@FindBy(linkText="Register as a new user")WebElement registerNewUserButton;
	@FindBy(name="name")WebElement name;
	@FindBy(name="password")WebElement password;
	@FindBy(name="fname")WebElement fname;
	@FindBy(name="lname")WebElement lname;	
	@FindBy(name="passwordConfirm")WebElement passwordConfirm;
	@FindBy(name="role")WebElement roleBox;
	@FindBy(xpath="//input[@value='Register']")WebElement registrationSubmit;
	@FindBy(linkText="Logout")WebElement logout;
	@FindBy(name="j_username")WebElement loginUsername;
	@FindBy(name="j_password")WebElement loginpassword;
	@FindBy(xpath="//input[@value='Login']")WebElement loginSubmit;
	@FindBy(linkText="Click to add new application")WebElement addNewAppButton;
	@FindBy(linkText="My applications")WebElement myApplicationsButton;


	public void registerNewRole(User user, String role){
		registerNewUserButton.click(); 
		registrationClear();
		name.sendKeys(user.getUsername());
		fname.sendKeys(user.getFname());
		lname.sendKeys(user.getLname());
		password.sendKeys(user.getPassword());
		passwordConfirm.sendKeys(user.getPassword());				 	
		selectElement(roleBox, role);
		clickElement(registrationSubmit);	
	}
	private void registrationClear(){
		name.clear();
		fname.clear();
		lname.clear();
		password.clear();
		passwordConfirm.clear();
	}


	public RegistrationPage Logout(){
		clickElement(logout);	
		return initPage(RegistrationPage.class); // need to reinitialize RegistrationPage, cause the DOM has been reloaded after Click(logout);	
	}

	public void verifyLogin(User user){
		loginUsername.clear(); 
		loginpassword.clear();
		loginUsername.sendKeys(user.getUsername());
		loginpassword.sendKeys(user.getPassword());
		clickElement(loginSubmit);
	}

	public void tryToOpenUploadPage(){
		clickElement(myApplicationsButton); // go to DownloadPage now
		clickElement(addNewAppButton); 				
	}

	public String getCurrentUrl(){
		return currentUrl(); // now check current url
	}

	public boolean checkUploadAvailable(){
		try{
			return myApplicationsButton.isDisplayed();		
		}
		catch(Exception e){
			return false;
		}
	}

}
