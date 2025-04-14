package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.registerPage;

public class NavigationTest extends BaseClass {

//TC_RF_007
	@Test
	public void DifferentWayToNavigateRegisterAccount() {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.clickonNewCustomer();

		registerPage rp = new registerPage(driver);
		String actualmsg = rp.RegisterAccountisDisplayed();
		String expectedmsg = "Register Account";
		Assert.assertEquals(actualmsg, expectedmsg, "Register Account does not exist!");
	}

}
