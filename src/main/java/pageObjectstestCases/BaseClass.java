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
				"ezCV1GKdrohPraLKNabscqQcER1rGpEIyProF_OK.xM-1741675088-1.2.1.1-f_CekHn2xB_BA4EQXKqGn.6RVkXv327BNv13b7Zb_Nl8aHd_Dn5xQanfAgzjmF8clATNvLQ9jB1P.MUieID97uWRe3mn7t8C4hYFaymYijSMTK5aXbhrT4WKdH6XfQMr22RgMGjrksD8uFaMljgSt3iaNRld3pE.VwB3wV5U45Q64CDL6ArvmlpyBn9dRnVlvqF_v6aMAs85F7TT.x5soPG0RJnnS34scuWdwdzDntvMfYP9P1QFcLqZscmjyUUG34IiBIljtJxbtjFi9XoJhCnOjlPedMu_785vFa4pOSeJv11YD8PWePpqnGfiys5IWadT17TCKky_YfjVsry6mqI1GZKgD1m3moPP9rT5QdtrOXSvl4bFjwsKmKnLBcIUEpYwGMpSeQSDFc9eGMHHSo5siwgbX1UcW2AHoVdctGk");
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
