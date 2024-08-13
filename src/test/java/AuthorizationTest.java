import browser.Browser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.PasswordRecoveryPage;
import pageobject.RegistrationPage;
import user.User;
import user.UserStep;

public class AuthorizationTest {
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
    public void authInButtonInputInAccountTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickButtonInputInAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
        step.deleteUser(user);
    }

    @Test
    public void authInButtonPersonalAccountTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickPersonalAccount();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
        step.deleteUser(user);
    }

    @Test
    public void authButtonInputInRegistrationPageTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickPersonalAccount();
        loginPage.clickToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickButtonAuthorization();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
        step.deleteUser(user);
    }

    @Test
    public void authButtonInputInPasswordRecoveryPageTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        homePage.clickPersonalAccount();
        loginPage.clickButtonPasswordRecovery();
        passwordRecoveryPage.clickButtonAuthorization();
        loginPage.setFieldAndClickButtonInputInSystem(user.getEmail(), user.getPassword());
        homePage.waitLoadHomePage();
        boolean buttonCreateOrder = homePage.buttonCreateOrderIsDisplayed();
        Assert.assertTrue(buttonCreateOrder);
        step.deleteUser(user);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
