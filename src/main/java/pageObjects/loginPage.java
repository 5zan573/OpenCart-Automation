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

	@FindBy(xpath = "//body//div//dirv")
	WebElement warning;

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

	public String InvalidAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(warning));

		return warning.getText();
	}
}
