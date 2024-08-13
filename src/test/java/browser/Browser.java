package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class Browser {

    public WebDriver getWebDriver(String browserName) {
        switch (browserName.toLowerCase(Locale.ROOT)) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "D:\\Work_autotesting\\WebDriver\\bin\\yandexdriver.exe");
                return new ChromeDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "D:\\Work_autotesting\\WebDriver\\bin\\chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Нету драйвера под выбранный браузер: " + browserName);
        }
    }
}