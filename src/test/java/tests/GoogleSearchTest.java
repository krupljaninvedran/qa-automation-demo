package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;

import java.time.Duration;

public class GoogleSearchTest extends BaseTest {

    @Test(enabled = false)
    public void testGoogleSearch() {
        GooglePage google = new GooglePage(driver);
        google.open();
        google.search("UpWork");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                        By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
                )
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("div.recaptcha-checkbox-border")
                )
        ).click();


        Assert.assertTrue(google.isResultDisplayed("Upwork"), "Results not displayed!");
    }
}
