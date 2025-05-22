package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentSparkReporter sparkReporter; //UI of the report.
	public static ExtentReports extent; // populate common info on the report.
	public ExtentTest test; // creating test case entries in the report and update status of the test methods.

public static void ExtentReports() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Faizan");
    


}



}