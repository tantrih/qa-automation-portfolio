package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.baseclass;
import library.utilityclass;
import pages.LoginPage;

public class LoginPageTest extends baseclass {

	LoginPage login;
	String TCID; // untuk simpan ID test case saat screenshot

	@BeforeMethod
	public void setUp() {
		// Inisialisasi LoginPage dengan WebDriver dari baseclass
		login = new LoginPage(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// Ambil screenshot kalau gagal
			utilityclass.captureSS(TCID, driver);
		}
		driver.quit();
	}

	@Test
	public void verifyURL() throws IOException {
		TCID = "TC01";
		String actURL = login.verifyURL();
		String expURL = utilityclass.readPFData("URL");
		Assert.assertEquals(actURL, expURL);
	}

	@Test
	public void verifyLogo() {
		TCID = "TC02";
		boolean actLogo = login.verifyLogo();
		boolean expLogo = true;
		Assert.assertEquals(actLogo, expLogo);
	}

	@Test
	public void verifyPageTitle() {
		TCID = "TC03";
		String actTitle = login.verifyPageTitle();
		String expTitle = "Swag Labs";
		Assert.assertEquals(actTitle, expTitle);
	}

	@DataProvider(name = "credential")
	public Object[][] getData() {
		return new Object[][] {
			{"valid", "standard_user", "secret_sauce"},
			{"invalid", "abcd", "1234"},
			{"blank", "", ""},
			{"invalidUN", "abcd", "secret_sauce"},
			{"invalidPWD", "standard_user", "1234"}
		};
	}

	@Test(dataProvider = "credential")
	public void verifyLoginFunctionality(String scenario, String username, String password) throws IOException {
		TCID = "TC04_" + scenario;

		login.enterCredentials(username, password);

		if (scenario.equals("valid")) {
			String actResult = login.verifyURL();
			String expResult = utilityclass.readPFData("productPageURL");
			Assert.assertEquals(actResult, expResult);
		} else if (scenario.equals("invalid") || scenario.equals("invalidUN") || scenario.equals("invalidPWD")) {
			String actResult = login.getErrorMSG();
			String expResult = "Epic sadface: Username and password do not match any user in this service";
			Assert.assertEquals(actResult, expResult);
		} else if (scenario.equals("blank")) {
			String actResult = login.getErrorMSG();
			String expResult = "Epic sadface: Username is required";
			Assert.assertEquals(actResult, expResult);
		}
	}
}
