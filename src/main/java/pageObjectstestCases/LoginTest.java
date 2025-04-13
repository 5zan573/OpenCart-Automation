package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myaccountPage;

public class LoginTest extends BaseClass {

//TC009
	@Test
	public void verifylogin() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickonlogin();

		myaccountPage myacc = new myaccountPage(driver);
		Assert.assertEquals(myacc.MyaccountPageExists(), "My Account does not exist!");
		myacc.logoutbtn();
	}

//TC0010
	@Test
	public void inValidEmail() {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.setemail(randomAlphaNum() + "@gmail.com");
		lp.setpassword(p.getProperty("password"));
		lp.clickonlogin();
		String actualmsg = lp.InvalidAlert();
		String expectedmsg = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualmsg, expectedmsg, "Warning does not exist!");

	}

}
