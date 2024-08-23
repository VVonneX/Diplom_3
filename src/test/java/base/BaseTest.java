package base;

import browser.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobject.*;
import steps.UserStep;
import user.User;

public class BaseTest {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public PasswordRecoveryPage passwordRecoveryPage;
    public ProfilePage profilePage;
    public RegistrationPage registrationPage;
    public User user;
    public UserStep step;

    @Before
    public void setup() {
        Browser browser = new Browser();
        driver = browser.getWebDriver("yandex");
        driver.get(URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        profilePage = new ProfilePage(driver);
        registrationPage = new RegistrationPage(driver);
        step = new UserStep();
        user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        step.postCreateUser(user);
    }

    @After
    public void tearDown() {
        step.deleteUser(user);
        driver.quit();
    }
}
