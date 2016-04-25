package com.dataart.selenium.tests;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.newUserRegistration;
import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.BasicPage;
import com.dataart.selenium.pages.HeaderPage;
import com.dataart.selenium.pages.RegistrationPage;

public class RegistrationTest extends BaseTest{

	private RegistrationPage registrationPage;
	private BasicPage basicPage;
	private HeaderPage headerPage;
	private User user;
	
	@BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
		basicPage = initPage(BasicPage.class); // finding basicPage's elements and and BasicPage's init
		registrationPage = basicPage.reloadRegistrationPage(); // all registrationPage elements are founded here
		headerPage = initPage(HeaderPage.class); // finding elements and HeaderPage init
        user = newUserRegistration(); //  I set new user data here
    }
	
	@Test
    public void correctLoginTest() {
		registrationPage.registerNewUser(user); // filling RegistrationPage inputs and submit
		assertThat(headerPage.getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());      
        System.out.println("Oleg, registerNewUser is finished!");
    }
}
