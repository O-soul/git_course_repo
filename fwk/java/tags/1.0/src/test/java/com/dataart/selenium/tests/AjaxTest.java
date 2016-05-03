package com.dataart.selenium.tests;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.newDeveloperRegistration;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.AjaxPage;
import com.dataart.selenium.pages.RegistrationPage;



public class AjaxTest extends BaseTest{

	private AjaxPage ajaxPage;
	private RegistrationPage registrationPage;
	private User user;

	@BeforeMethod(alwaysRun = true)
	public void openAjaxPage(){
		basicPage.forceLogout(); 
		ajaxPage = initPage(AjaxPage.class);
		registrationPage = initPage(RegistrationPage.class);
		user = newDeveloperRegistration();		
		registrationPage.registerNewRole(user, "DEVELOPER");
	}

	@Test(enabled = true)
	public void twoValidNumbers(){	
		ajaxPage.result(2, 3);
		Assert.assertTrue(ajaxPage.correctResult());
	}

	@Test(enabled = true)
	public void validNumberAndString(){	
		ajaxPage.result(2, "word");
		Assert.assertTrue(ajaxPage.incorrectResult());
	}

}
