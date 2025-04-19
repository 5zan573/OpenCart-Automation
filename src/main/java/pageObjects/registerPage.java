package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//body//div//dirv")
	WebElement warning;

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

	@FindBy(css = "body div dirv")
	WebElement emailexistalert;

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

	public String InvalidAlert() {
		FluentWait wait = new FluentWait(driver);
		wait.until(ExpectedConditions.visibilityOf(warning));

		return warning.getText();
	}

	public String FnameErrorMessage() {
		fname.sendKeys(" ");
		policybtn.click();
		continuebtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(driver -> !fnameerrormessage.getText().trim().isEmpty());
		return fnameerrormessage.getText();
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

	public String GetInvalidEmailMsg() {
		return txtemail.getAttribute("validationMessage");
	}

	public String EmailExistAlert() {
		FluentWait wait = new FluentWait(driver);
		wait.until(ExpectedConditions.visibilityOf(emailexistalert));
		return emailexistalert.getText();

	}

}
