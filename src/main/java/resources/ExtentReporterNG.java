package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	static ThreadLocal<ExtentTest> extentTest;

	public static ExtentReports getReportObject()
	{
		if (extent==null){
			System.out.println("m in the ExtentReporterNG");
			String path =System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Results");
			reporter.config().setDocumentTitle("Test Results");

			extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Bibaswan Padhi");
			return extent;
		}else {
			return extent;
		}


	}

	public static ThreadLocal<ExtentTest> getExtentTestObject()
	{
		if (extentTest==null){
			extentTest =new ThreadLocal<ExtentTest>();
			return extentTest;
		}else {
			return extentTest;
		}


	}
}
