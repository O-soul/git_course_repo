package com.dataart.selenium.pages;

import java.io.File;
import java.util.List;


import org.json.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import com.dataart.selenium.framework.Settings;

public class HomePage extends BasicPage {

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

	@FindBy(xpath="//input[@value='Login']")WebElement loginButton;
	@FindBy(linkText="Details")WebElement details;
	@FindBy(className="description")List<WebElement> information;	
	@FindBy(className="downloads")WebElement numberOfDownloads;
	@FindBy(linkText="Download")WebElement downloadButton;
	@FindBy(xpath="xhtml:html")WebElement text;

	@FindBy(linkText="My applications")WebElement myApplication;
	@FindBy(linkText="Click to add new application")WebElement addNewApplication;
	@FindBy(name="title")WebElement applicationTitle;
	@FindBy(name="description")WebElement applicationDescription;
	@FindBy(name="category")WebElement applicationCategory;
	@FindBy(xpath="//input[@value='Create']")WebElement createApplication;

	@FindBy(xpath="//input[@type='file' and @name='image']")WebElement image;
	@FindBy(xpath="//input[@type='file' and @name='icon']")WebElement icon;

	@FindBy(className="name")WebElement completedAppTitle;
	@FindBy(className="description")WebElement completedAppDiscription;

	@FindBy(linkText="Edit")WebElement edit;
	@FindBy(xpath="//input[@value='Update']")WebElement update;
	@FindBy(className="content")WebElement editCompleteText;


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
		textToParse = text.getText();
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
		appTitle = "My favorite_ application";
		appDescription = "simple description";
		appCategory = "Maps";
	}

	public void createNewApp(boolean imageAndIcon){
		clickElement(myApplication);
		clickElement(addNewApplication); 
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

	public boolean isAppDisplayedCorrectly(){
		if(completedAppTitle.getText().trim().equals(appTitle)&& completedAppDiscription.getText().trim().equals(appDescription)){// fail
			return true;
		}
		else return false;
	}

	public boolean isIconDisplayedCorrectly(){
		try{
			driver.findElement(By.xpath("//img[@alt='"+appTitle+"']"));}
		catch(NoSuchElementException e){return false;}		
		return true;
	}

	public boolean downloadIspossible(){
		clickElement(details);
		clickElement(downloadButton);	
		textToParse = text.getText();
		applicationData();
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
		clickElement(details);
		for(int i = 0; i < 10; i++ ){
			clickElement(downloadButton);
			driver.navigate().back();}		
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
		applicationData();
		getAppInformation();
		if(completedAppTitle.getText().trim().equals(appTitle)&& discription.trim().equals(appDescription)&& catigory.trim().equals(appCategory)){
			return true;
		}
		else return false;
	}

}


