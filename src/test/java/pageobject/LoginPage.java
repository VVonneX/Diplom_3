package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    private By locatorToRegister = By.xpath("//a[@href='/register' and text()='Зарегистрироваться']");
    private By locatorToAuthorizationButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx " +
            "button_button_size_medium__3zxIa' and text()='Войти']");
    private String fieldLoginInSystem = "//label[text()='%s']/following-sibling::input";
    private By locatorInputSystemButton = By.xpath("//*[text()='Войти']");
    private By locatorInPasswordRecoveryButton = By.xpath("//*[@href='/forgot-password']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Filling in the registration fields with data and clicking on the authorization button")
    public void setFieldAndClickButtonInputInSystem(String email, String password) {
        driver.findElement(By.xpath(String.format(fieldLoginInSystem, "Email"))).sendKeys(email);
        driver.findElement(By.xpath(String.format(fieldLoginInSystem, "Пароль"))).sendKeys(password);
        driver.findElement(locatorInputSystemButton).click();
    }

    @Step("Clicking on the button to go to the registration page")
    public void clickToRegistration() {
        driver.findElement(locatorToRegister).click();
    }

    @Step("Clicking on the button to go to the password recovery page")
    public void clickButtonPasswordRecovery() {
        driver.findElement(locatorInPasswordRecoveryButton).click();
    }

    @Step("Checking that the login button is displayed")
    public boolean buttonAuthorizationIsDisplayed() {
        WebElement element = driver.findElement(locatorToAuthorizationButton);
        return element.isDisplayed();
    }

    @Step("Waiting for the login page to load")
    public void waitLoadLoginPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
