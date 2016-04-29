package com.dataart.selenium.tests;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;
import static com.dataart.selenium.models.UserBuilder.newDeveloperRegistration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.HomePage;
import com.dataart.selenium.pages.RegistrationPage;

public class ApplicationTest extends BaseTest {

	private HomePage homepage;	
	private RegistrationPage registrationPage;
	private User user;
	
	@BeforeMethod(alwaysRun = true)
    public void openHomePage() {	
		basicPage.forceLogout();
		homepage = initPage(HomePage.class); // all registrationPage elements are founded here	
		registrationPage = initPage(RegistrationPage.class);
    }
	
		
	@Test(enabled = true) // IE: we got a bug here. When we are on a page of any application we can see "# of downloads: 0". Now click "Download",
	      // and we can see " "numberOfDownloads":2 ". We have this bug when we are testing on IE only!
    public void downloadApplication() {	
		user = admin();	
		loginPage.loginAs(user); 
		homepage.checkDownload();		
		Assert.assertTrue(homepage.parsingSuccess());
		successMessage("downloadApplication");
	}
	
	@Test(enabled = true)
	 public void createNewApplication(){///////////////////////////////////////
		user = newDeveloperRegistration();		
		registrationPage.registerNewRole(user, "DEVELOPER");
		homepage.createNewApp(false);				
		softAssert.assertTrue(homepage.isAppDisplayedCorrectly(), "");
		softAssert.assertTrue(homepage.downloadIspossible(), "");
		softAssert.assertAll();
		successMessage("createNewApplication");
	}
	
	@Test(enabled = true)
	 public void editNewApplication(){
		user = newDeveloperRegistration();		
		registrationPage.registerNewRole(user, "DEVELOPER");
		homepage.createNewApp(false);
		homepage.editNewApp();
		Assert.assertTrue(homepage.isEditComplete());
		successMessage("editNewApplication");
	}
		
	@Test(enabled = true)//////////////////////////////////////////////////////////
	 public void createNewApplicationWithImagAndIcon(){
		user = newDeveloperRegistration();		
		registrationPage.registerNewRole(user, "DEVELOPER");
		homepage.createNewApp(true);      			
		softAssert.assertTrue(homepage.isAppDisplayedCorrectly(), "");
		softAssert.assertTrue(homepage.isIconDisplayedCorrectly(),"");
		softAssert.assertAll();
		successMessage("createNewApplicationWithImagAndIcon");
	}
	
	@Test(enabled = true)
	 public void createNewApplicationAndDownloadItManyTimes(){
		user = newDeveloperRegistration();		
		registrationPage.registerNewRole(user, "DEVELOPER");
		homepage.createNewApp(false);  
		homepage.downloadApplication();
		softAssert.assertTrue(homepage.IsAppInMostPopularSection(), "IsAppInMostPopularSection() ");
		softAssert.assertTrue(homepage.ClickMostPopularApplicationAndGoToDetalesPage(), "");
		softAssert.assertAll();
		successMessage("createNewApplicationAndDownloadItManyTimes");
	}
}




