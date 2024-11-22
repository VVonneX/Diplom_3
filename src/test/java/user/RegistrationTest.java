package user;

import browser.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import steps.UserStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationTest {
    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;
    private UserStep step = new UserStep();
    private boolean isTearDownCalled = true;

    @Given("Подготовка необходимых данных и зависимостей для тестирования")
    public void setup() {
        Browser browser = new Browser();
        driver = browser.getWebDriver("chrome");
        driver.get(URL);
    }


    @When("Успешная регистрация, а после проверка, что отобразилась кнопка Войти")
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

    @When("Негативная регистрация и появление сообщения, что пароль некорректный")
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

    @Then("Удаление юзера и закрытие браузера")
    public void tearDowns() {
        if(isTearDownCalled) {
            User user = new User("MishaChurikov20@yandex.ru", "password1234", "Михаил");
            step.deleteUser(user);
        }
       driver.quit();
    }
}