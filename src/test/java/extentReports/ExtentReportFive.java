package extentReports;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportFive {
	ExtentTest test;

	@Test
	public void extentTest() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");  //html file will be generated
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		spark.config().setReportName("Extent Report");
		extent.attachReporter(spark);
		test = extent.createTest("Login Test").assignAuthor("Sonam").assignCategory("Sanity").assignDevice("Chrome");
		test.pass("Login test pass successfully");
		
		extent.flush();
}
}