package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.BasicPage;
import com.dataart.selenium.pages.HeaderPage;
import com.dataart.selenium.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.Utils.isElementPresent;
import static com.dataart.selenium.models.UserBuilder.admin;
import static org.fest.assertions.Assertions.assertThat;
import static com.dataart.selenium.framework.BasePage.initPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private BasicPage basicPage;
    private HeaderPage headerPage;
    private User user;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class); // finding BasicPage's elements and BasicPage init
        loginPage = basicPage.forceLogout(); // load LoginPage before each method
        headerPage = initPage(HeaderPage.class); // finding elements and HeaderPage init
        user = admin(); // I set my firstname and lastname here
    }

    @Test
    public void correctLoginTest() {
        loginPage.loginAs(user);  
        assertHeader(user);
       
        System.out.println("Oleg, correctLoginTest is finished!");
    }

    @Test
    public void incorrectLoginTest() {
        user.setPassword(user.getPassword() + user.getPassword()); // incorrect password
        loginPage.loginAs(user);                                   // entering incorrect password and correct username to inputs
        assertThat(isElementPresent(BasicPage.flash)).isTrue();
        assertThat(basicPage.getFlashMessage()).isEqualTo("You have entered an invalid username or password!");
        
        System.out.println("Oleg, incorrectLoginTest is finished!");
    }

    @Test
    public void incorrectThenCorrectTest() {
        user.setPassword(user.getPassword() + user.getPassword()); // incorrect password
        loginPage.loginAs(user);                                   // entering incorrect password and correct username to inputs
        user.setPassword(admin().getPassword());                   // correct password
        loginPage.loginAs(user);                                   // entering correct password and correct username to inputs
        assertHeader(user);
        
        System.out.println("Oleg, incorrectThenCorrectTest is finished!");
    }

    private void assertHeader(User user){
        assertThat(headerPage.getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }
}
