package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ProfilePage {
    private WebDriver driver;
    private By locatorToPersonalAccount = By.xpath("//a[@href='/account/profile' and text()='Профиль']");
    private By locatorToConstructor = By.xpath("//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    private By locatorToLogout = By.xpath("//*[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");
    private By locatorToLogo = By.xpath("//*[@xmlns='http://www.w3.org/2000/svg' and @viewBox='0 0 290 50']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Checking that the Profile button is displayed")
    public boolean profileButtonIsDisplayed() {
        WebElement element = driver.findElement(locatorToPersonalAccount);
        return element.isDisplayed();
    }

    @Step("Clicking on the Constructor button in the header")
    public void clickConstructorButton() {
        driver.findElement(locatorToConstructor).click();
    }

    @Step("Clicking on the logo button in the header")
    public void clickLogoButton() {
        driver.findElement(locatorToLogo).click();
    }

    @Step("Clicking on the Log Out button to log out of your account")
    public void clickLogoutButton() {
        driver.findElement(locatorToLogout).click();
    }

    @Step("Waiting for the profile page to load")
    public void waitLoadProfilePage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}