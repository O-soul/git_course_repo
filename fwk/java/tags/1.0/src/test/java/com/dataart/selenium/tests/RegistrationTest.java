package com.dataart.selenium.tests;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.newDeveloperRegistration;
import static com.dataart.selenium.models.UserBuilder.newUserRegistration;
import static com.dataart.selenium.models.UserBuilder.nextUserRegistration;
import static com.dataart.selenium.models.UserBuilder.userRegistration;
import static org.fest.assertions.Assertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.HeaderPage;
import com.dataart.selenium.pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

	private RegistrationPage registrationPage;			
	private HeaderPage headerPage;
	private User user;
	
	@BeforeMethod(alwaysRun = true)
    public void openRegistrationPage() {
		basicPage.forceLogout(); // load LoginPage
	    registrationPage = initPage(RegistrationPage.class); // all registrationPage elements are founded here		
		headerPage = initPage(HeaderPage.class); // we store different warnings in this class      
    }
	
	@Test
    public void registrationNewUSER() {
		user = userRegistration(); //  I set new user data here
		registrationPage.registerNewRole(user, "USER"); // filling RegistrationPage inputs and click submit
		assertThat(headerPage.getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());             
		successMessage("registrationNewUSER");
    }
	
	@Test
    public void registrationNewUSERThanLogoutAndLogin() {
		user = newUserRegistration(); //  I set new user data here
		registrationPage.registerNewRole(user, "USER"); // filling RegistrationPage inputs and submit
		assertHeader(user);
		registrationPage = registrationPage.Logout();		
		registrationPage.verifyLogin(user);	// 	verify if we can to login
		assertHeader(user);		
		successMessage("registrationNewUSERThanLogoutAndLogin");
	}
	
	@Test
    public void developerCanUpload() {
		user = newDeveloperRegistration(); //  I set new developer data here
		registrationPage.registerNewRole(user, "DEVELOPER"); 
		assertHeader(user);
		registrationPage.tryToOpenUploadPage();
		Assert.assertEquals(registrationPage.getCurrentUrl(), "http://localhost:8080/new");
		successMessage("developerCanUpload");
	}
	
	@Test
    public void userCannotUpload() {
		user = nextUserRegistration(); 
		registrationPage.registerNewRole(user, "USER"); 
		assertHeader(user);
		Assert.assertFalse(registrationPage.checkUploadAvailable()); 
		successMessage("userCannotUpload");
	}
	
	
	
	private void assertHeader(User user){
		assertThat(headerPage.getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
	}
	
}
