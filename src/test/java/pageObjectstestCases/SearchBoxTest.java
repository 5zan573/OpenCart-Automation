package pageObjectstestCases;

import org.testng.annotations.Test;

import pageObjects.homePage;

public class SearchBoxTest extends BaseClass{
	
	@Test
	public void ValidatingSearchBoxResults() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.SearchProduct("imac");
		hp.ClickSearchButton();
		Thread.sleep(5000);
		hp.ValidateSearchProductsResults();
		

		
		
		
	}

}
