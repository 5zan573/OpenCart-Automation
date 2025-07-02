package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentSparkReporter sparkReporter; //UI of the report.
	public static ExtentReports extent; // populate common info on the report.
	public static ExtentTest test; // creating test case entries in the report and update status of the test methods.

	public static String reportname;
	
public static void ExtentReports() {
	
	SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss");
	Date dt=new Date();
	String currentdate = df.format(dt);
	reportname = "Test=Report" + currentdate + ".html";
	
	String reportPath = "C:\\Users\\user\\eclipse-workspace\\OpenCart\\reports\\" + reportname;
	    sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        


}



}