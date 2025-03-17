package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends BasePage {

	public homePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myaccount;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
	WebElement registeraccount;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;

	public void myaccount() {
		myaccount.click();
	}

	public void registeraccount() throws InterruptedException {
		registeraccount.click();
	}

	public void Clickonlogin() {
		login.click();
	}

}
