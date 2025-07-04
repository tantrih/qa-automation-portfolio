package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.baseclass;
import library.utilityclass;
import pages.AddToCartPage;
import pages.LoginPage;

public class AddToCartTest extends baseclass {

    LoginPage login;
    AddToCartPage cartPage;
    String TCID;

    @BeforeMethod
    public void setUp() {
        login = new LoginPage(driver);
        cartPage = new AddToCartPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            utilityclass.captureSS(TCID, driver);
        }
        driver.quit();
    }

    @Test
    public void addToCart_PositiveTest() {
        TCID = "TC_ADD_01";

        login.enterCredentials("standard_user", "secret_sauce");
        cartPage.clickAddToCart();

        Assert.assertTrue(cartPage.isItemAdded(), "Cart badge should be displayed");
        Assert.assertEquals(cartPage.getCartItemCount(), "1", "Cart should show 1 item");
    }

    @Test
    public void addToCart_WithoutLogin_NegativeTest() {
        TCID = "TC_ADD_02";

        driver.get("https://www.saucedemo.com/inventory.html");

        login = new LoginPage(driver);

        String actualError = login.getErrorMSG();
        String expectedError = "Epic sadface: You can only access '/inventory.html' when you are logged in.";

        Assert.assertEquals(actualError, expectedError, "Error message should match when accessing inventory directly without login.");
    }
}
