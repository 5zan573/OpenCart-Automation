package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.registerPage;

public class RegistrationTest extends BaseClass {
//This class automates TC_RF_001,2,3,6
	// @Test
	public void RegistaringAccountWithValidData() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		rp.fname(randomString());
		rp.lname(randomString());
		rp.email(randomAlphaNum() + "@gmail.com");
		rp.password(randomAlphaNum());
		rp.policy();
		rp.continuebtn();

		Assert.assertEquals(rp.getconfirmationmessage(), "Your Account Has Been Created!");
	}

//TC_RF_005
	// @Test
	public void RegistaringAccountWithNewsLetterEnabled() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		rp.fname(randomString());
		rp.lname(randomString());
		rp.email(randomAlphaNum() + "@gmail.com");
		rp.password(randomAlphaNum());
		rp.clickonnewsletter();
		rp.policy();
		rp.continuebtn();

		Assert.assertEquals(rp.getconfirmationmessage(), "Your Account Has Been Created!");
	}

	// TC_RF_009
	// @Test
	public void ValidatingByRegisteringExistingAccount() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		rp.fname("Faizan");
		rp.lname("Hussain");
		rp.email(p.getProperty("email"));
		rp.password(p.getProperty("password"));
		rp.policy();
		rp.continuebtn();

		Assert.assertEquals(rp.EmailExistAlert(), "Warning: E-Mail Address is already registered!");

	}

	// TC_RF_010
	// @Test
	public void ShouldNotRegisterWithInValidEmail() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);
		rp.fname("Faizan");
		rp.lname("Hussain");
		rp.email("faizanhussain573gmail.com");
		rp.password(p.getProperty("password"));
		rp.policy();
		rp.continuebtn();

		Assert.assertEquals(rp.GetInvalidEmailMsg(),
				"Please include an '@' in the email address. 'faizanhussain573gmail.com' is missing an '@'.");
	}

//TC_RF_012
	@Test
	public void ShouldNotRegisterWithKeyboardKeys() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.registeraccount();

		registerPage rp = new registerPage(driver);

		String fnameError = rp.FnameErrorMessage();

		System.out.println(fnameError);

		Assert.assertEquals(fnameError, "First Name must be between 1 and 32 characters!");

		// Assert.assertEquals(lnameError, "Last Name must be between 1 and 32
		// characters!");

		// Assert.assertEquals(emailError, "E-Mail Address does not appear to be
		// valid!");

		// Assert.assertEquals(passerror, "Password must be between 4 and 20
		// characters!");

	}

//TC_RF_013
	// @Test
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
