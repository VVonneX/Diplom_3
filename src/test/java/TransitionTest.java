import base.BaseTest;
import browser.Browser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import user.User;
import steps.UserStep;

public class TransitionTest extends BaseTest {

    @Test
    public void transitionAuthInPersonalAccountTest() {
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.clickPersonalAccount();
        profilePage.waitLoadProfilePage();
        boolean profileIsDisplay = profilePage.profileButtonIsDisplayed();
        Assert.assertTrue(profileIsDisplay);
    }

    @Test
    public void transitionAuthInPersonalAccountToConstructorTest() {
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.clickPersonalAccount();
        profilePage.clickConstructorButton();
        boolean buttonCreateOrderIsDisplay = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrderIsDisplay);
    }

    @Test
    public void transitionAuthInPersonalAccountToLogoTest() {
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.clickPersonalAccount();
        profilePage.clickLogoButton();
        boolean buttonCreateOrderIsDisplay = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrderIsDisplay);
    }
}
