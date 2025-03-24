package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage extends BasePage {

	public registerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement fname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pass;

	@FindBy(xpath = "//body//main//input[2]")
	WebElement newsletterbtn;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement policybtn;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement continuebtn;

	@FindBy(xpath = "//h1[text() = 'Your Account Has Been Created!']")
	WebElement getmesage;

	@FindBy(xpath = "//body//main//div//div//div//h1")
	WebElement registerAccountHeading;

	public void fname(String firstname) {
		fname.sendKeys(firstname);
	}

	public void lname(String lastname) {
		lname.sendKeys(lastname);
	}

	public void email(String email) {
		txtemail.sendKeys(email);
	}

	public void password(String password) {
		pass.sendKeys(password);
	}

	public void continuebtn() {
		continuebtn.click();
	}

	public void policy() {
		policybtn.click();

	}

	public String getconfirmationmessage() {
		return getmesage.getText();
	}

	public void clickonnewsletter() {
		newsletterbtn.click();
	}

	public boolean RegisterAccountisDisplayed() {

		if (registerAccountHeading.isDisplayed()) {
			registerAccountHeading.getText();
		}
		return true;
	}

}
