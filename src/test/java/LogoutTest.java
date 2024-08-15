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

public class LogoutTest extends BaseTest {

    @Test
    public void LogoutOfAccount() {
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.clickPersonalAccount();
        profilePage.waitLoadProfilePage();
        profilePage.clickLogoutButton();
        boolean inputButtonIsDisplay = loginPage.buttonAuthorizationIsDisplayed();
        Assert.assertTrue(inputButtonIsDisplay);
    }
}
