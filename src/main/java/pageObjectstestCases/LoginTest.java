package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myaccountPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoggingInWithValidDetails() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickonlogin();

		myaccountPage ap = new myaccountPage(driver);
		Thread.sleep(1000);
		Assert.assertEquals(ap.MyaccountPageExists(), "My Account");
		ap.logoutbtn();
	}

	@Test
	public void LoggingInWithInValidDetails() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();

		loginPage lp = new loginPage(driver);
		lp.setemail(randomAlphaNum() + "@gmail.com");
		lp.setpassword(randomAlphaNum());
		lp.clickonlogin();

		Assert.assertEquals(lp.InValidDetailsError(), "Warning: No match for E-Mail Address and/or Password.");

	}
	
	@Test
	public void LoginingInWithInvalidEmail() throws InterruptedException {
		homePage hp=new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();
		
		loginPage lp=new loginPage(driver);
		lp.setemail(randomString()+"@gmail.com");
		lp.setpassword(p.getProperty("password"));
		lp.clickonlogin();
		
		Assert.assertEquals(lp.InValidDetailsError(), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	
	@Test
	public void LogingInWithInvalidPassword() {
		homePage hp=new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();
		
		loginPage lp=new loginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(randomString());
		lp.clickonlogin();
		
		Assert.assertEquals(lp.InValidDetailsError(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test
	public void LoggingInWithoutCreds() {
		homePage hp=new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();
		
		loginPage lp=new loginPage(driver);
		lp.clickonlogin();
		
		Assert.assertEquals(lp.InValidDetailsError(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@Test
	public void ForgotPageValidation() throws InterruptedException {
		homePage hp=new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();
		
		loginPage lp=new loginPage(driver);
		Thread.sleep(5000);
		lp.ClickOnForgottenpassword();
		
		Assert.assertEquals(lp.ForgetPasswordPageValidation(),"Forgot Your Password?");
	}
	
	@Test
	public void ValidatingEmailPlaceHolderTxt() {
		logger.info("ValidatingEmailPlaceHolderTxt");
		homePage hp=new homePage(driver);
		hp.myaccount();
		logger.trace("clicked on myaccount");
		hp.Clickonlogin();
		logger.info("clicked on login");
		loginPage lp=new loginPage(driver);
		Assert.assertEquals(lp.EmailHolderTxt(), "E-Mail Address");
		Assert.assertEquals(lp.PasswordHolderTxt(), "Password");
	}
	
	
}
