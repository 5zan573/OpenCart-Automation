package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	WebElement alert;

	public void setemail(String email) {
		emailtxt.sendKeys(email);
	}

	public void setpassword(String password) {
		passwordtxt.sendKeys(password);
	}

	public void clickonbtn() {
		loginbtn.click();
	}

	public void clickonNewCustomer() {
		newcustomer.click();
	}

	public void clickonRegister() {
		clickonRegister.click();
	}

	public boolean InvalidAlert() {
		try {
			alert.getText();
		} catch (Exception e) {
		}
		return false;
	}

}
