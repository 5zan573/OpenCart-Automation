package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.myaccountPage;

public class LoginTest extends BaseClass {

	@Test
	public void LoggingInWithValidDetails() throws InterruptedException {
		homePage hp=new homePage(driver);
		hp.myaccount();
		hp.Clickonlogin();
		
		loginPage lp=new loginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickonlogin();
		
		myaccountPage ap=new myaccountPage(driver);
		Thread.sleep(1000);
		Assert.assertEquals(ap.MyaccountPageExists(), "My Account");
		ap.logoutbtn();
	}
	
}
