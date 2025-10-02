package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        // demo kredencijali za the-internet.herokuapp.com
        login.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(login.isLoginSuccessful(), "Login should be successful but wasn't.");
    }

    @Test
    public void testFailedLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("wronguser", "wrongpass");
        Assert.assertTrue(login.isLoginFailed(), "Login should fail for wrong credentials.");
    }
}

