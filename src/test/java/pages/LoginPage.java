package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(flashMessage));
        String text = driver.findElement(flashMessage).getText();
        return text.toLowerCase().contains("secure area");
    }

    public boolean isLoginFailed() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(flashMessage));
        String text = driver.findElement(flashMessage).getText();
        return text.toLowerCase().contains("invalid");
    }
}
