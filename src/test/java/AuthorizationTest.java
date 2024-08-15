import base.BaseTest;
import browser.Browser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.*;
import user.User;
import steps.UserStep;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authInButtonInputInAccountTest() {
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
    }

    @Test
    public void authInButtonPersonalAccountTest() {
        homePage.clickPersonalAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
    }

    @Test
    public void authButtonInputInRegistrationPageTest() {
        homePage.clickPersonalAccount();
        loginPage.clickToRegistration();
        registrationPage.clickButtonAuthorization();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
    }

    @Test
    public void authButtonInputInPasswordRecoveryPageTest() {
        homePage.clickPersonalAccount();
        loginPage.clickButtonPasswordRecovery();
        passwordRecoveryPage.clickButtonAuthorization();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
    }
}
