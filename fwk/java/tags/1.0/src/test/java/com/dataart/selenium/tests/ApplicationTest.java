package com.dataart.selenium.tests;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.newDeveloperRegistration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.ApplicationPage;
import com.dataart.selenium.pages.RegistrationPage;
public class ApplicationTest extends BaseTest {

	private ApplicationPage applicationPage;	
	private RegistrationPage registrationPage;
	private User user;

	@BeforeMethod(alwaysRun = true)
	public void openHomePage() {	
		basicPage.forceLogout(); 
		applicationPage = initPage(ApplicationPage.class); // all registrationPage elements are founded here	
		registrationPage = initPage(RegistrationPage.class);
		user = newDeveloperRegistration();	
		registrationPage.registerNewRole(user, "DEVELOPER");
	}


	@Test(enabled = true) // IE: we got a bug here. When we are on a page of any application we can see "# of downloads: 0". Now click "Download",
	// and we can see " "numberOfDownloads":2 ". We have this bug when we are testing on IE only!
	public void downloadApplication() {					
		applicationPage.checkDownload();		
		Assert.assertTrue(applicationPage.parsingSuccess());
		successMessage("downloadApplication");
	}

	@Test(enabled = true)
	public void createNewApplication(){							
		applicationPage.createNewApp(false);				
		softAssert.assertTrue(applicationPage.isAppDisplayedCorrectly(), "");
		softAssert.assertTrue(applicationPage.downloadNewApplication(), "");
		softAssert.assertAll();
		successMessage("createNewApplication");
	}

	@Test(enabled = true)
	public void editNewApplication(){		
		applicationPage.createNewApp(false);
		applicationPage.editNewApp();
		Assert.assertTrue(applicationPage.isEditComplete());
		successMessage("editNewApplication");
	}

	@Test(enabled = true)
	public void createNewApplicationWithImagAndIcon(){
		applicationPage.createNewApp(true);      			
		softAssert.assertTrue(applicationPage.isAppDisplayedCorrectly(), "");
		softAssert.assertTrue(applicationPage.isIconDisplayedCorrectly(),"");
		softAssert.assertAll();
		successMessage("createNewApplicationWithImagAndIcon");
	}

	@Test(enabled = true)
	public void createNewApplicationAndDownloadItManyTimes(){		
		applicationPage.createNewApp(true);  
		applicationPage.downloadApplication();
		softAssert.assertTrue(applicationPage.IsAppInMostPopularSection(), "");
		softAssert.assertTrue(applicationPage.ClickMostPopularApplicationAndGoToDetalesPage(), "");
		softAssert.assertAll();
		successMessage("createNewApplicationAndDownloadItManyTimes");
	}

	@Test(enabled = true)
	public void deleteApplication(){
		applicationPage.deleteApp();
		Assert.assertFalse(applicationPage.ApplicationIsRemoved());
	}
	
	
}
