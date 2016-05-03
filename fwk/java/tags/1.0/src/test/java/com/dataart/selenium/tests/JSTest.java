package com.dataart.selenium.tests;

import static com.dataart.selenium.framework.BasePage.initPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.dataart.selenium.models.UserBuilder.admin;
import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.AjaxPage;
import com.dataart.selenium.pages.JSPage;
import com.dataart.selenium.pages.RegistrationPage;

public class JSTest extends BaseTest{
	
	private JSPage jsPage;
	
	private User user;
	
	@BeforeMethod(alwaysRun = true)
	public void openAjaxPage(){
		basicPage.forceLogout(); 
		jsPage = initPage(JSPage.class);		
		user = admin();	
		loginPage.loginAs(user); 	
	}
	
	@Test(enabled = true)
	public void WhooHooooCorrect(){
		jsPage.inputAndProcess();
		Assert.assertTrue(jsPage.successAllert());
	}

}
