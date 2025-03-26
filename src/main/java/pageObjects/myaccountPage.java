package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountPage extends BasePage {

	public myaccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//body//main//h2[1]")
	WebElement myAccount;

	@FindBy(xpath = "//body//main//a[13]")
	WebElement logoutbtn;

	public String MyaccountPageExists() {
		return myAccount.getText();
	}

	public void logoutbtn() {
		logoutbtn.click();
	}

}
