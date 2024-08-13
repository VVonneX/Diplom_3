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
import user.UserStep;

public class LogoutTest {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;
    private UserStep step = new UserStep();

    @Before
    public void setup() {
        Browser browser = new Browser();
        driver = browser.getWebDriver("yandex");
        driver.get(URL);
    }

    @Test
    public void LogoutOfAccount() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonInputInAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        ProfilePage profilePage = new ProfilePage(driver);
        homePage.clickPersonalAccount();
        profilePage.waitLoadProfilePage();
        profilePage.clickLogoutButton();
        boolean inputButtonIsDisplay = loginPage.buttonAuthorizationIsDisplayed();
        Assert.assertTrue(inputButtonIsDisplay);
        deleteUser(user);
    }

    public void deleteUser(User user) {
        step.deleteUser(user);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
