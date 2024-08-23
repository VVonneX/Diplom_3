package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    private By locatorToPersonalAccount = By.xpath("//a[@href='/account']");
    private String registrationOrCreateOrderButton = "//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text() = '%s']";
    private String locatorDisplayIngredients = "//span[text()='%s']";
    private String locatorIngredients = "//p[@class='BurgerIngredient_ingredient__text__yp3dH' and text()='%s']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the Personal Account in the header")
    public void clickPersonalAccount() {
        driver.findElement(locatorToPersonalAccount).click();
    }

    @Step("Click on the Personal Account in the body")
    public void clickButtonInputInAccount() {
        driver.findElement(By.xpath(String.format(registrationOrCreateOrderButton, "Войти в аккаунт"))).click();
    }

    @Step("Checking that the \"Create order\" button is displayed")
    public boolean buttonCreateOrderIsDisplayed() {
        WebElement element = driver.findElement(By.xpath(String.format(registrationOrCreateOrderButton, "Оформить заказ")));
        return element.isDisplayed();
    }

    @Step("Waiting for the home page to load")
    public void waitLoadHomePage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("Clicking on the ingredient selection button")
    public void clickToDisplay(String displayName) {
        driver.findElement(By.xpath(String.format(locatorDisplayIngredients, displayName))).click();
    }

    @Step("Checking that the ingredients are displayed in a certain tab")
    public boolean ingredientsIsDisplay(String ingredientsName) {
        WebElement element = driver.findElement(By.xpath(String.format(locatorIngredients, ingredientsName)));
        return element.isDisplayed();
    }

}