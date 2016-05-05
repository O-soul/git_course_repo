package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = USER_NAME_TEXT_FIELD_XPATH)
    WebElement userNameTextField;
    @FindBy(xpath = UPASSWORD_TEXT_FIELD_XPATH)
    WebElement passwordTextField;
    @FindBy(xpath = ULOGIN_BUTTON_XPATH)
    WebElement loginButton;

    public ApplicationPage loginAs(User user) {
        userNameTextField.clear();
        passwordTextField.clear();
        //userNameTextField.sendKeys(user.getUsername()); // закоменчено специально для фейла(listener)(раскоменть)
        //passwordTextField.sendKeys(user.getPassword()); // закоменчено специально для фейла(listener)(раскоменть)
        loginButton.click();
        return initPage(ApplicationPage.class);
    }

    public static final String USER_NAME_TEXT_FIELD_XPATH = "//input[@id='j_username']";
    public static final String UPASSWORD_TEXT_FIELD_XPATH = "//input[@id='j_password']";
    public static final String ULOGIN_BUTTON_XPATH = "//div[@class='form']/form/input";
}
