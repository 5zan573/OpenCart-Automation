package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.registerPage;

public class RegistrationTest extends BaseClass {
//This class automates TC001,2,3,6
	@Test
	public void RegistaringAccountWithValidData() throws InterruptedException {
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

		Assert.assertEquals(rp.getconfirmationmessage(), "Your Account Has Been Created!");
	}

//TC005
	@Test
	public void RegistaringAccountWithNewLetterEnabled() throws InterruptedException {
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

		Assert.assertEquals(rp.getconfirmationmessage(), "Your Account Has Been Created!");
	}

//TC012
	@Test
	public void ShouldNotRegisterWithKeyboardKeys() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		rp.fname(" ");
		Assert.assertEquals(rp.FnameErrorMessage(), "First Name must be between 1 and 32 characters!");

		rp.lname(" ");
		Assert.assertEquals(rp.LnameErrorMessage(), "Last Name must be between 1 and 32 characters!");

		rp.email(" ");
		Assert.assertEquals(rp.EmailErrorMessage(), "E-Mail Address does not appear to be valid!");

		rp.password(" ");
		Assert.assertEquals(rp.PasswordErrorMessage(), "Password must be between 4 and 20 characters!");

		rp.policy();
		rp.continuebtn();
	}

//TC013
	@Test
	public void PlaceHoldersVerification() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		Assert.assertEquals(rp.FnamePlaceHolder(), "input-firstname");
		Assert.assertEquals(rp.lnamePlaceHolder(), "input-lastname");
		Assert.assertEquals(rp.EmailPlaceHolder(), "input-email");
		Assert.assertEquals(rp.PasswordPlaceHolder(), "input-password");
	}

}
