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
		boolean targetpage = rp.RegisterAccountisDisplayed();
		Assert.assertTrue(targetpage);

		hp.myaccount();
		hp.Clickonlogin();
		lp.clickonRegister();
		boolean targetpage1 = rp.RegisterAccountisDisplayed();
		Assert.assertTrue(targetpage1);
	}
}

//TC009
class loginwithwithValidEmail extends BaseClass {
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

@Test
class loginwithInvalidEmail extends BaseClass {

	public void inValidEmail() {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.setemail(randomAlphaNum() + "@gmail.com");
		lp.setpassword(p.getProperty("password"));
		lp.clickonbtn();
		boolean actual = lp.InvalidAlert();
		Assert.assertTrue(actual, "No match for E-Mail Address and/or Password");

	}
}
