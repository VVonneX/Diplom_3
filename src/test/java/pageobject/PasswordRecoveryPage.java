package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;

    private By locatorInputSystemButton = By.xpath("//*[@href='/login']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clicking on the login button to go to the authorization page")
    public void clickButtonAuthorization() {
        driver.findElement(locatorInputSystemButton).click();
    }
}
