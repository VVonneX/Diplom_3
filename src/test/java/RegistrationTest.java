import base.BaseTest;
import browser.Browser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import user.User;
import steps.UserStep;

public class RegistrationTest {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;
    private UserStep step = new UserStep();
    private boolean isTearDownCalled = true;

    @Before
    public void setup() {
        Browser browser = new Browser();
        driver = browser.getWebDriver("chrome");
        driver.get(URL);
    }

    @Test()
    public void registrationPositiveTest() {
        User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickPersonalAccount();
        loginPage.clickToRegistration();
        registrationPage.setFieldAndClickButtonRegistration(user.getName(), user.getEmail(), user.getPassword());
        loginPage.waitLoadLoginPage();
        boolean buttonAuth = loginPage.buttonAuthorizationIsDisplayed();
        Assert.assertTrue(buttonAuth);
    }

    @Test
    public void registrationNegativeTest() {
        User user = new User("MishaChurikov20@yandex.ru", "1234F", "Михаил");
        isTearDownCalled = false;
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickPersonalAccount();
        loginPage.clickToRegistration();
        registrationPage.setFieldAndClickButtonRegistration(user.getName(), user.getEmail(), user.getPassword());
        boolean errorMessage = registrationPage.errorMessageWithPasswordIsDisplayed();
        Assert.assertTrue(errorMessage);
    }

    @After
    public void tearDown() {
        if(!isTearDownCalled) {
            User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
            step.deleteUser(user);
        }
        driver.quit();
    }
}
