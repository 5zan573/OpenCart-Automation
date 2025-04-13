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

	@FindBy(id = "error-firstname")
	WebElement fnameerrormessage;

	@FindBy(id = "error-lastname")
	WebElement lnameerrormessage;

	@FindBy(id = "error-email")
	WebElement emailerrormessage;

	@FindBy(id = "error-password")
	WebElement passerrormessage;

	@FindBy(css = "label[for='input-firstname']")
	WebElement fnameholder;

	@FindBy(css = "label[for='input-lastname']")
	WebElement lnameholder;

	@FindBy(css = "label[for='input-email']")
	WebElement emailholder;

	@FindBy(css = "label[for='input-password']")
	WebElement passholder;

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

	public String RegisterAccountisDisplayed() {
		return registerAccountHeading.getText();
	}

	public String FnameErrorMessage() {
		return fnameerrormessage.getText();

	}

	public String LnameErrorMessage() {
		return lnameerrormessage.getText();
	}

	public String EmailErrorMessage() {
		return emailerrormessage.getText();
	}

	public String PasswordErrorMessage() {
		return passerrormessage.getText();
	}

	public String FnamePlaceHolder() {
		return fname.getAttribute("for");
	}

	public String lnamePlaceHolder() {
		return lname.getAttribute("for");
	}

	public String EmailPlaceHolder() {
		return emailholder.getAttribute("for");
	}

	public String PasswordPlaceHolder() {
		return passholder.getAttribute("for");
	}

}
