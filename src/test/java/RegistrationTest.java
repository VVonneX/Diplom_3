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
import user.UserStep;

public class RegistrationTest {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;
    private UserStep step = new UserStep();

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
        homePage.clickPersonalAccount();
        loginPage.clickToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setFieldAndClickButtonRegistration(user.getName(), user.getEmail(), user.getPassword());
        loginPage.waitLoadLoginPage();
        boolean buttonAuth = loginPage.buttonAuthorizationIsDisplayed();
        Assert.assertTrue(buttonAuth);
        deleteUser(user);
    }

    @Test
    public void registrationNegativeTest() {
        User user = new User("MishaChurikov20@yandex.ru", "1234F", "Михаил");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickPersonalAccount();
        loginPage.clickToRegistration();
        registrationPage.setFieldAndClickButtonRegistration(user.getName(), user.getEmail(), user.getPassword());
        boolean errorMessage = registrationPage.errorMessageWithPasswordIsDisplayed();
        Assert.assertTrue(errorMessage);
    }

    public void deleteUser(User user) {
        step.deleteUser(user);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
