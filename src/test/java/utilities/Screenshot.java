package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	WebDriver driver;
	public static  void getScreenshot(WebDriver driver, String testname) {
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("C:\\Users\\user\\eclipse-workspace\\OpenCart\\screenshots\\" +testname + "_" + timestamp +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

}
