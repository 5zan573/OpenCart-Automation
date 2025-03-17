package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountPage extends BasePage {

	public myaccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//body//main//h2[1]")
	WebElement Myaccount;

	public boolean MyaccountPageExists() {
		try {
			return (Myaccount.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
}
