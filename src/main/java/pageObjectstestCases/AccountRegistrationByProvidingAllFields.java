package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.registerPage;

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

@Test
class NewletterOptionYes extends BaseClass {
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
