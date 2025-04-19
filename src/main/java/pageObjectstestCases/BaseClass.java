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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	Properties p;

	@BeforeMethod
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
				"JyzIJ6kzZIzXWObP986ioXjOVGWUFll.BBfSAB5e8cs-1744880752-1.2.1.1-0Y7f8pcJneFHqhfimWOfYb7.NyzDL5pjALgmqnqApwAZCxnDIiN0yfgyH3QDBlFDGFhcHWWMZCFax7jGG6DGZpFQb1yl7lM.i8yT8MOqZ4Wx47qH3M_UmUfFCg_c_gTBQRpPLqaoN9B56e_LYuvyfY_jy66JuvC4fOMj4eDLSQjGUhFA3LSrNtvNKfZmj5VUVuDlMxRXArx3lG9SlsfctZT8PhYf77Dl76D4P.GZ43OLoeFTpjsudcRQFfOBhOfrCCPlc8Bc3YrAIeRMFzpmz9aGp7NJsYWuq_60Kd58zsXEQcQJOp5tnt5iR8qEuaOPh2QMzPK6h0FKFBfg8eDluFyhjc8Dvin7iMzV3KKc11w2iW0.JQpgpMDKOVrWf1Gt");
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
