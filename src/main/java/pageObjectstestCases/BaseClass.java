package pageObjectstestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	Properties p;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void SetUp(String os, String brow) throws IOException {

		switch (brow.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser driver");
			return;
		}

		FileInputStream file = new FileInputStream(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Cookie cfcookie = new Cookie("cf_clearance",
				"lyWzOyU.ZTr_RXk0Y5C.v7z2yDOax6gXaIeFwbbt9XM-1744641606-1.2.1.1-yAPuwp4v1T5yJI7b.PFP0IthnoizuFWGvguMDjXiMwGevyGDDnY.au9AjY86pp188Jo2ERhyCA76NiE96IJf47PoMLg6uQuYdN2CvjpIYGmJlh9HkAJrSz.YHsOGCm3chWo1tMsof7w9VCcy9wbNMr65gNTHrThVHGfNFU_n915WJcOCDX3Bd3AnhpRjHCotutk283eExDYG_Ze5_Ruwa6Y6sFLsXKgOiluXiqdHHid8stKx8Cn9SmUBd9CWNb4eK2DYAxv_aWV.XpjzX_upFs5JMROC83n8CEPg4hHfTiuBTllTyoPit2Lto_IyXRtjNQn508cFyEaDg15WwUnDat29sYurqJrMDg2c.F.udTSI5dH1FP25Grs8.IM9ZsFC");
		driver.manage().addCookie(cfcookie);
		driver.navigate().refresh();
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}

	public String randomAlphaNum() {
		String generated = RandomStringUtils.randomAlphanumeric(5);
		return generated;
	}

	public String randomString() {
		String generated = RandomStringUtils.randomAlphabetic(5);
		return generated;
	}

}
