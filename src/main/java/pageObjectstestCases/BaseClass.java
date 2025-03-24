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
				"DR_wtXK_JFLm5IkioTgYgiy0kD10DqFmC6b7eQiEpSo-1742804888-1.2.1.1-iE1YBj9DWjM_wGa5M01cpioAhdODNjMBFUvs2s8PfN2XmN6jel.VM2O91JddnvO1ouP7BgmxMpc5LmMaBMQ37AvlL78.YXQ6hvEmNya6tKw9ccCG9.gcS4Rf8SV2ZGFt81XhSFDAe6nxHjgD7speArgwooSjcysMJjYVkApg8Q7.GOHeBfL67bscTJHV2.VVAHs49WdkyVzVoDXuJyBx3dferkW7W3pZC0HUxvUO8gxVRWr889uqBpbSTYPu5hLf4gdO8xJTl_hdZR7jY4GvqGr_eJ.XrxO.9eC_flfjRy6Vgyo5PuFXJu.lWTEtBIIvJVmU5G7zQ0nKGoczERmhmd4B2X38WfDhvpTHZKE7IEAr2..oPZaVedlp9ORbBNYBAzH_Gudwkh.KoqHokWGGqmxRawb7qE.f8BoYtG8vWdg");
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
