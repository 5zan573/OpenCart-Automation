package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myaccountPage;
import pageObjects.registerPage;

//This class automates TC001,2,3,6
public class AccountRegistrationByProvidingAllFields extends BaseClass {

	@Test
	public void navigateToRegistration() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		rp.fname(randomString());
		rp.lname(randomString());
		rp.email(randomAlphaNum() + "@gmail.com");

		String pass = randomAlphaNum();

		rp.password(pass);
		rp.policy();
		rp.continuebtn();
		String confmsg = rp.getconfirmationmessage();

		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

	}
}

//TC005
class NewsletterOptionYes extends BaseClass {

	@Test
	public void AccountRegisterwithNewsletter() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		rp.fname(randomString());
		rp.lname(randomString());
		rp.email(randomAlphaNum() + "@gmail.com");

		String pass = randomAlphaNum();

		rp.password(pass);
		rp.clickonnewsletter();
		rp.policy();
		rp.continuebtn();
		String confmsg = rp.getconfirmationmessage();

		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}

}

//TC007
class DifferentWaysToNavigateToRegisterAccount extends BaseClass {
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

//TC009
class loginwithwithValidEmail extends BaseClass {
	@Test
	public void verifylogin() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickonlogin();

		Thread.sleep(3000);
		myaccountPage myacc = new myaccountPage(driver);
		String actualmsg = myacc.MyaccountPageExists();
		String expectedmsg = "My Account";

		Assert.assertEquals(actualmsg, expectedmsg, "My Account does not exist!");
		myacc.logoutbtn();
	}
}

class loginwithInvalidEmail extends BaseClass {
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
