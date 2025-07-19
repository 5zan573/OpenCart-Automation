package pageObjectstestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;

public class SearchBoxTest extends BaseClass{
	
	@Test
	public void ValidatingSearchBoxResults() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.SearchProduct("mac");
		hp.ClickSearchButton();
		Thread.sleep(5000);
		String actual=hp.ValidateSearchProductsResults("mac");
		Assert.assertEquals(actual, "mac", actual);

		
		
		
	}

}
