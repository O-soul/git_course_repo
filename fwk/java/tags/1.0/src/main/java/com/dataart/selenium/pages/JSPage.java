package com.dataart.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dataart.selenium.framework.BasePage;

public class JSPage extends BasePage {

	@FindBy(linkText="JS test page")WebElement JSTestPage;
	@FindBy(id="left")WebElement left;
	@FindBy(id="top")WebElement top;
	@FindBy(id="process")WebElement process;

	JavascriptExecutor js;
	Alert alert;
 
	public void inputAndProcess(){
		JSTestPage.click();
		left.clear();
		top.clear();	
		js = (JavascriptExecutor) driver;
		if (driver instanceof JavascriptExecutor){	
			Object topPosition = js.executeScript("return Math.round($('.flash').position().top);");
			Object leftPosition = js.executeScript("return Math.round($('.flash').position().left);"); 				
			js.executeScript("document.getElementById('top').value = '"+topPosition.toString()+"';");
			js.executeScript("document.getElementById('left').value = '"+leftPosition.toString()+"';");			
			process.click();;   
		}
	}

	public boolean successAllert(){
		alert = driver.switchTo().alert();		
		if(alert.getText().equals("Whoo Hoooo! Correct!")){
			alert.accept();
			return true;
		}
		else 
			alert.dismiss();
		return false;


	}


}