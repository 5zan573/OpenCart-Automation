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
				"An7SrpEZ3FZZY3OF2YHYORvdKZ7_7XRKZ6TiCgKfeG0-1747126758-1.2.1.1-7w0gbjWMLBKF959.Aeg5HiD_VmL7tGUphndnp86GOtN__XDEu.a4PgkOJqYOElxN3.J1wgTd7YXqLa4dOo2ZjRXGw9rGqDefwZ2DGKfYeNOpSfPYREvBRfX7SK3Yb_sANBOgf.nL5NeZTfa.Pf0Th.kCS9hS2h2Udx9.83tgL7W5hBLDJTo1SNrqsVlBlX_qScuPSewZwrbonPCq1ZjadGsii_rLgUk5UGaXdgQ6dVKyxKb97Wvglher87s9C0duRHNqXXIJExabVqiqlV8jgQc6AxyYPxl30vyusvHU1Z4ggalf.Fv683ieSekWIvDs6tVIVvnA056p2Xk123BUGGxc81VtX11HW3FeCW.fSOPOPy3AFEl5pHKG8wb6A1Yb");
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
