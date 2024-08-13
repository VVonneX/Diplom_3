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

public class TransitionTest {
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
    public void transitionAuthInPersonalAccountTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.clickPersonalAccount();
        profilePage.waitLoadProfilePage();
        boolean profileIsDisplay = profilePage.profileButtonIsDisplayed();
        Assert.assertTrue(profileIsDisplay);
        deleteUser(user);
    }

    @Test
    public void transitionAuthInPersonalAccountToConstructorTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.clickPersonalAccount();
        profilePage.clickConstructorButton();
        boolean buttonCreateOrderIsDisplay = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrderIsDisplay);
        deleteUser(user);
    }

    @Test
    public void transitionAuthInPersonalAccountToLogoTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.clickPersonalAccount();
        profilePage.clickLogoButton();
        boolean buttonCreateOrderIsDisplay = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrderIsDisplay);
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
