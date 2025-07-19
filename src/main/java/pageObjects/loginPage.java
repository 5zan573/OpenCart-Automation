
package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailtxt;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordtxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbtn;

	@FindBy(linkText = "Continue")
	WebElement newcustomer;

	@FindBy(linkText = "Register")
	WebElement clickonRegister;

	@FindBy(id = "alert")
	WebElement InValidDetailsError;
	
	@FindBy(xpath = "//div[@class='mb-3']//a")
	WebElement ForgottenPasswordLink;
	
	@FindBy(tagName = "h1")
	WebElement ForgotPasswordPageVerify;
	
	@FindBy(xpath = "//label[text()='E-Mail Address']")
	WebElement emailholdertxt;
	
	@FindBy(xpath = "//*[text()='Password']")
	WebElement passwordholdertxt;
	

	public void setemail(String email) {
		emailtxt.sendKeys(email);
	}

	public void setpassword(String password) {
		passwordtxt.sendKeys(password);
	}

	public void clickonlogin() {
		loginbtn.click();
	}

	public void clickonNewCustomer() {
		newcustomer.click();
	}

	public void clickonRegister() {
		clickonRegister.click();
	}

	public String InValidDetailsError() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.textToBePresentInElement(InValidDetailsError, "Warning: No match for E-Mail Address and/or Password."));

		return InValidDetailsError.getText();
	}
	
	public void ClickOnForgottenpassword() {
		ForgottenPasswordLink.click();
	}
	
	public String ForgetPasswordPageValidation() {
		
		return ForgotPasswordPageVerify.getText();			
	}
	
	public String EmailHolderTxt() {
		return emailholdertxt.getText();
	}
    
	public String PasswordHolderTxt() {
		return passwordholdertxt.getText();
	}
}
