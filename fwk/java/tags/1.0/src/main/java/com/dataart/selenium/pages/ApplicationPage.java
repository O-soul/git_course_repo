package com.dataart.selenium.pages;

import java.io.File;
import java.util.List;


import org.json.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import com.dataart.selenium.framework.Settings;
import com.dataart.selenium.framework.Utils;

public class ApplicationPage extends BasicPage {

	public HeaderPage getHeader() {
		return initPage(HeaderPage.class);
	}

	private String discription;
	private String catigory;
	private String author;
	private String textToParse;
	private String downloadsCount;
	JSONObject obj;
	JSONObject obj2;
	private String appTitle;
	private String appDescription;
	private String appCategory;
	private StringBuilder randString;
	private WebElement completedAppTitle;
	private WebElement completedAppDiscription;

	@FindBy(xpath="//input[@value='Login']")WebElement loginButton;
	@FindBy(linkText="Details")WebElement details;
	@FindBy(className="description")List<WebElement> information;	
	@FindBy(className="downloads")WebElement numberOfDownloads;
	@FindBy(linkText="Download")WebElement downloadButton;
	@FindBy(xpath="xhtml:html")WebElement JSONtext;

	@FindBy(linkText="My applications")WebElement myApplication;
	@FindBy(name="title")WebElement applicationTitle;
	@FindBy(name="description")WebElement applicationDescription;
	@FindBy(name="category")WebElement applicationCategory;
	@FindBy(xpath="//input[@value='Create']")WebElement createApplication;

	@FindBy(xpath="//input[@type='file' and @name='image']")WebElement image;
	@FindBy(xpath="//input[@type='file' and @name='icon']")WebElement icon;

	@FindBy(linkText="Edit")WebElement edit;
	@FindBy(xpath="//input[@value='Update']")WebElement update;
	@FindBy(className="content")WebElement editCompleteText;
	@FindBy(linkText="Home")WebElement home;
	@FindBy(linkText="Delete")WebElement delete;


	public void checkDownload(){
		getHomePage();
		clickElement(details);
		getAppInformation();
		clickElement(downloadButton);
	}

	private void getAppInformation(){
		discription = information.get(0).getText();
		catigory = information.get(1).getText();
		author = information.get(2).getText();
		downloadsCount = numberOfDownloads.getText();
	}

	public boolean parsingSuccess(){
		textToParse = JSONtext.getText();
		try {			 			
			obj = new JSONObject(textToParse);
			String jsonDiscriptionValue = "Description: " + obj.getString("description");				
			String jsonCatigoryValue = "Category: " + obj.getJSONObject("category").getString("title");
			String jsonAuthorName = "Author: " + obj.getJSONObject("author").getString("name");						
			int jsonNumberOfDownloads = obj.getInt("numberOfDownloads");
			if(jsonDiscriptionValue.equals(discription)&&jsonCatigoryValue.equals(catigory)&&jsonAuthorName.equals(author)
					&& jsonNumberOfDownloads == numberOfDownloadsToInt(downloadsCount)){
				return true;
			}
			else return false;
		} catch (JSONException e) {	e.printStackTrace(); return false;}		
	}

	public int numberOfDownloadsToInt(String numberOfDownloads){ // convert string "123" to int 123
		return Integer.parseInt(numberOfDownloads.substring(numberOfDownloads.indexOf(":") + 2))+ 1; 			
	}

	private void getHomePage(){
		try{
			clickElement(loginButton);}
		catch(Exception e){};
	} 

	public void applicationData(){		
		appTitle = generateMyFavoriteAppName();    
		appDescription = "simple description";
		appCategory = "Maps";
	}

	private String generateMyFavoriteAppName() {
		String name = "App";
		randString = new StringBuilder(name);
		int count = (int)(Math.random()*7) + 1; 
		for(int i = 0; i < count; i++){
			randString.append(name.charAt((int)(Math.random() * name.length() - 1)));
		}
		return randString.toString();			
	}

	public void createNewApp(boolean imageAndIcon){
		clickElement(myApplication);
		Utils.waitForElementPresent("//a[text()='Click to add new application']").click(); // wait for element and click it
		applicationData();				
		applicationTitle.sendKeys(appTitle);
		applicationDescription.sendKeys(appDescription);
		selectElement(applicationCategory, appCategory);
		if(imageAndIcon){		
			image.sendKeys(settings.pathToIcon());
			icon.sendKeys(settings.pathToImage());		  					
		}
		clickElement(createApplication);
	}

	private void findPopulareAppTitleAnddDiscription(){
		completedAppTitle = driver.findElement(By.xpath("//img[@alt='"+appTitle+"']//ancestor::div[@class='application']//*[@class='name']"));//fail
		completedAppDiscription =  driver.findElement(By.xpath("//img[@alt='"+appTitle+"']//ancestor::div[@class='application']//*[@class='description']"));
	}

	public boolean isAppDisplayedCorrectly(){
		try{
			driver.findElement(By.xpath("//img[@alt='"+appTitle+"']"));
			String comAppTit = driver.findElement(By.xpath("//img[@alt='"+appTitle+"']//ancestor::div[@class='app']//*[@class='name']")).getText().trim();				
			String comAppDiscrTit = driver.findElement(By.xpath("//img[@alt='"+appTitle+"']//ancestor::div[@class='app']//*[@class='description']")).getText().trim();

			if(comAppTit.equals(appTitle) && comAppDiscrTit.equals(appDescription)){ // FAIL
				return true;
			}
			else System.out.println("not equal in if - isAppDisplayedCorrectly(): "+"\""+comAppTit+"\""+" not equal to "+"\""+appTitle+"\""); 
			     System.out.println("And "+"\""+comAppDiscrTit+"\""+" not equal to "+"\""+appDescription+"\""); 
			return false;}
		catch(NoSuchElementException e){System.out.println("Oleg, we have "+e.getMessage()); return false;}	
	}

	public boolean isIconDisplayedCorrectly(){
		try{
			driver.findElement(By.xpath("//img[@alt='"+appTitle+"']"));}
		catch(NoSuchElementException e){System.out.println(e.getMessage()); return false;}		
		return true;
	}

	public boolean downloadNewApplication(){
		driver.findElement(By.xpath("//a[@href='/app?title="+appTitle+"']")).click();
		clickElement(downloadButton);	
		textToParse = JSONtext.getText();
		try {
			obj = new JSONObject(textToParse);
			return appTitle.equals(obj.getString("title"));			
		} catch (JSONException e) {return false;}	
	} 

	public void editNewApp(){
		clickElement(details);
		clickElement(edit);
		applicationDescription.sendKeys("editing...");
		selectElement(applicationCategory, "News");
		clickElement(update);		
	}

	public boolean isEditComplete(){
		return "Application edited".equals(editCompleteText.getText().trim());
	}

	public void downloadApplication(){
		clickElement(driver.findElement(By.xpath("//a[@href='/app?title="+appTitle+"']")));		
		for(int i = 0; i < 10; i++ ){
			clickElement(downloadButton);
			driver.navigate().back();}		
		clickElement(home);   // I wasn't asked to click "Home", but I have to do it for page would appear in Most Popular section.
	}

	private WebElement popularApplicationIsExist(){		
		return driver.findElement(By.xpath("//div[@class='popular-container']//a[@href='/app?title="+appTitle+"']"));
	}

	public boolean IsAppInMostPopularSection(){		
		try{
			popularApplicationIsExist();
		}
		catch(NoSuchElementException e){
			return false;
		}
		return true;
	}

	public boolean ClickMostPopularApplicationAndGoToDetalesPage(){
		popularApplicationIsExist().click();		
		getAppInformation();
		findPopulareAppTitleAnddDiscription();

		String comAppTit = completedAppTitle.getText().trim();
		String comAppDiscrTit = completedAppDiscription.getText().trim();

		if(comAppTit.equals(appTitle)&& comAppDiscrTit.equals("Description: "+ appDescription)&& catigory.trim().equals("Category: "+ appCategory)){
			return true;
		}
		else return false;
	}

	public void deleteApp(){
		createNewApp(false);
		driver.findElement(By.xpath("//a[@href='/app?title="+appTitle+"']")).click();
		delete.click();	
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public boolean ApplicationIsRemoved(){
		myApplication.click();
		try{
			driver.findElement(By.xpath("//img[@alt='"+appTitle+"']//ancestor::div[@class='app']//*[@class='name']"));}
		catch(NoSuchElementException e) { return false; }
		return true;
	}
	
}


