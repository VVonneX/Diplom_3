import base.BaseTest;
import browser.Browser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.HomePage;

public class ConstructorTest extends BaseTest {

    @Test
    public void constructorBreadTest() {
        homePage.clickToDisplay("Начинки");
        homePage.clickToDisplay("Булки");
        boolean checkBread = homePage.ingredientsIsDisplay("Краторная булка N-200i");
        Assert.assertTrue(checkBread);
    }

    @Test
    public void constructorSauceTest() {
        homePage.clickToDisplay("Соусы");
        boolean checksSauce = homePage.ingredientsIsDisplay("Соус фирменный Space Sauce");
        Assert.assertTrue(checksSauce);
    }

    @Test
    public void constructorFillingTest() {
        homePage.clickToDisplay("Начинки");
        boolean checkFilling = homePage.ingredientsIsDisplay("Хрустящие минеральные кольца");
        Assert.assertTrue(checkFilling);
    }
}
