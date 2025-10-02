package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {
    private WebDriver driver;

    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void search(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchBox).submit();
    }

    public boolean isResultDisplayed(String keyword) {
        return driver.getPageSource().contains(keyword);
    }
}
