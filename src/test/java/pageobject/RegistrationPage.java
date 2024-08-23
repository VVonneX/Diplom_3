package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    private String fieldRegistration = "//label[text()='%s']/following-sibling::input";
    private By locatorRegistrationButton = By.xpath("//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']");
    private By locatorInputSystemButton = By.xpath("//*[@href='/login']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Filling in the registration fields with data and clicking on the registration button")
    public void setFieldAndClickButtonRegistration(String name, String email, String password) {
        driver.findElement(By.xpath(String.format(fieldRegistration, "Имя"))).sendKeys(name);
        driver.findElement(By.xpath(String.format(fieldRegistration, "Email"))).sendKeys(email);
        driver.findElement(By.xpath(String.format(fieldRegistration, "Пароль"))).sendKeys(password);
        driver.findElement(locatorRegistrationButton).click();
    }

    @Step("Checking that a password error message is displayed")
    public boolean errorMessageWithPasswordIsDisplayed() {
        WebElement element = driver.findElement(By.xpath("//p[text()='Некорректный пароль']"));
        return element.isDisplayed();
    }

    @Step("Clicking the transfer button to the authorization page")
    public void clickButtonAuthorization() {
        driver.findElement(locatorInputSystemButton).click();
    }

}