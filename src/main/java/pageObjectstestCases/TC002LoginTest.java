package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myaccountPage;

public class TC002LoginTest extends BaseClass {

	@Test
	public void verifylogin() {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));

		myaccountPage myacc = new myaccountPage(driver);
		boolean targetpage = myacc.MyaccountPageExists();

		Assert.assertTrue(targetpage);
		myacc.logoutbtn();
	}
}
