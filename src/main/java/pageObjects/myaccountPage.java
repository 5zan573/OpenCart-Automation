package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountPage extends BasePage {

	public myaccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//body//main//h2[1]")
	WebElement myaccount;

	@FindBy(xpath = "//body//main//a[13]")
	WebElement logoutbtn;

	public boolean MyaccountPageExists() {

		if (myaccount.isDisplayed()) {
			myaccount.getText();
		}
		return false;
	}

	public void logoutbtn() {
		logoutbtn.click();
	}

}
