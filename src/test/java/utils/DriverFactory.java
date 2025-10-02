package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
