package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
	
	@FindBy (xpath = "//input[@name='search' and @placeholder='Search']")
	WebElement searchbox;
	
	@FindBy (xpath = "//input[@name='search']//following-sibling::button[@type='button']")
	WebElement SearchButton;
	
	@FindBy(css = ".product-thumb")
	String SearchResult;

	public void myaccount() {
		myaccount.click();
	}

	public void registeraccount() throws InterruptedException {
		registeraccount.click();
	}

	public void Clickonlogin() {
		login.click();
	}
	
	public void SearchProduct(String ProductName) {
		searchbox.sendKeys(ProductName);
	}
	
	public void ClickSearchButton() {
		SearchButton.click();
	}
	
	public void ValidateSearchProductsResults() {
		List<WebElement>allresults=driver.findElements(By.cssSelector(SearchResult));
		for(WebElement result : allresults) {
			String productname=result.getText();
			if(productname != null && productname.toLowerCase().contains("imac")) {
				continue;
			}
			String text=result.getText().toLowerCase();
			Assert.assertTrue(text.contains("imac"),"unexpected result"+text);
		}
	}

}
