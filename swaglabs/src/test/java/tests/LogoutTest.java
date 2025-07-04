package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.baseclass;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends baseclass {
	@Test
    public void logout_PositiveTest() {
        LoginPage login = new LoginPage(driver);
        login.enterCredentials("standard_user", "secret_sauce");

        LogoutPage logout = new LogoutPage(driver);
        logout.performLogout();

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("saucedemo.com"), "User should be redirected after logout");
    }
}
