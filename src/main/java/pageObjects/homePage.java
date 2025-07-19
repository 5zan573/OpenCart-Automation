package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	@FindBy(css = ".product-thumb h4 a")
	List<WebElement> SearchResult;

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
	
	public String ValidateSearchProductsResults(String keyword) {
		
		keyword = keyword.toLowerCase();
		for(WebElement result : SearchResult) {
			String productName = result.getText().toLowerCase();
			if(!productName.contains(keyword)) {
				return "Validation failed "+productName+ " does not contain "+keyword;
			}
		}
		return keyword;
	}

}
