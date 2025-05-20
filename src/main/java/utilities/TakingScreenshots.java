package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakingScreenshots {
	WebDriver driver;
	public void getScreenshot() throws IOException {
		
		//FullPage Screenshot
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\user\\git\\Automation\\Practice\\screenshots\\fullpage.png"));

	}	

}
