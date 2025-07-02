package pageObjectstestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Properties p;
	public Logger logger;
	

	@BeforeMethod
	@Parameters({ "os", "browser" })
	public void SetUp(String os, String brow) throws IOException {

		 logger=LogManager.getLogger(this.getClass());

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
				"HPBnXxelBgpiBAdthUuIsFDvyFkAqTfme36RBMxs1mI-1751459933-1.2.1.1-f4REpXcYVopNnde59x2RvTw9cQL8LHWDvUz5o3_dodb1n2jPaSJz3kIAq_I5ueDh9UExmuD2LVsuL__hGOObYOuXMJe4xIIrI2wEr9pzxxkH7swiMRs9R9xQaBs67iiwRGORnMnxMVqCsPCCCFYjb3wtjSLaZff311du6R2TD6a5Fxqv5UXNg_FGAkrjS2ko_Fqkl7sbnOcvuYewZm7CaAN3DLBdsyoI963dTxqQqxPIl2SIrZevfH5xXQHucd12");
		driver.manage().addCookie(cfcookie);
		driver.navigate().refresh();
	}

	@AfterMethod
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
