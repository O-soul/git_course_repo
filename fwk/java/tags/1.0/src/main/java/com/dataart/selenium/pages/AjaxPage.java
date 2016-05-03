package com.dataart.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.framework.Utils;

public class AjaxPage extends BasePage{

	@FindBy(linkText="Ajax test page")WebElement ajaxTestPage;
	@FindBy(id="x")WebElement inputX;
	@FindBy(id="y")WebElement inputY;
	@FindBy(id="calc")WebElement sum;

	WebElement resultElement;
	private int X;
	private int Y;

	public void result(int firstValidNumber, int secondValidNumber){
		X = firstValidNumber; 
		Y = secondValidNumber;
		ajaxTestPage.click();
		inputX.clear();
		inputY.clear();
		inputX.sendKeys(Integer.toString(X));
		inputY.sendKeys(Integer.toString(Y));
		sum.click();
		resultElement = Utils.waitForElementPresent("//*[@id='result']");
	}

	public boolean correctResult(){
		String correctResultText = resultElement.getText();
		int colon = correctResultText.indexOf(":") + 2;
		String i = correctResultText.substring(colon);
		String stringResult = i.substring(0, i.indexOf("."));
		int readyResult = Integer.parseInt(stringResult); 

		if((X+Y) == readyResult){
			return true;
		}
		else return false;
	}

	public void result(int validNumber, String word){
		X = validNumber;
		ajaxTestPage.click();
		inputX.clear();
		inputY.clear();
		inputX.sendKeys(Integer.toString(X));
		inputY.sendKeys(word);
		sum.click();
		resultElement = Utils.waitForElementPresent("//*[@id='result']");
	}

	public boolean incorrectResult(){		
		if(resultElement.getText().equals("Result is: Incorrect data")){
			return true;
		}
		else return false;
	}

}
