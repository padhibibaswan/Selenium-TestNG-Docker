package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Academy.Listeners;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.ExcelUtility;
import resources.ExtentReporterNG;
import resources.TestDataProvider;
import resources.base;

public class validateTitle extends base{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private ThreadLocal<ExtentTest> et1 =ExtentReporterNG.getExtentTestObject();
	public Listeners l=new Listeners();
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		System.out.println("m in before test");
		// driver =initializeDriver();
		log.info("Test started");

		//driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}




	//@Test(dataProvider = "Authentication", dataProviderClass=TestDataProvider.class)
	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void TC2(String sUserName, String sPassword) throws InterruptedException, IOException {
		driver =createDriver();
		driver.get("https://www.google.com/");
		log.info("Driver is initialized");
		System.out.println("m in tc2");
		//l.writetoReport("driver launched");
		et1.get().log(Status.PASS, "TC2 driver started");
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		System.out.println(sUserName);
		Thread.sleep(3000);
		System.out.println(sPassword);
		et1.get().log(Status.PASS, "TC2 credential entered in console");    
		et1.get().log(Status.PASS, "Credentials entered are "+sUserName + " and "+ sPassword);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void TC1(String sUserName, String sPassword) throws InterruptedException, IOException {
		System.out.println("m in tc1");
		driver =createDriver();
		driver.get("https://www.google.com/");
		log.info("Driver is initialized");
		et1.get().log(Status.PASS, "TC1 driver started");   
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		System.out.println(sUserName);
		Thread.sleep(3000);
		System.out.println(sPassword);
		et1.get().log(Status.PASS, "TC1 credential entered in console");
		et1.get().log(Status.PASS, "Credentials entered are "+sUserName + " and "+ sPassword);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void TC3(String sUserName, String sPassword) throws InterruptedException, IOException {
		System.out.println("m in tc3");
		driver =createDriver();
		driver.get("https://www.google.com/");
		log.info("Driver is initialized");
		et1.get().log(Status.PASS, "TC3 driver started");   
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		System.out.println(sUserName);
		Thread.sleep(3000);
		System.out.println(sPassword);
		et1.get().log(Status.PASS, "TC3 credential entered in console");
		et1.get().log(Status.PASS, "Credentials entered are "+sUserName + " and "+ sPassword);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void TC4(String sUserName, String sPassword) throws InterruptedException, IOException {
		System.out.println("m in tc4");
		driver =createDriver();
		driver.get("https://www.google.com/");
		log.info("Driver is initialized");
		et1.get().log(Status.PASS, "TC4 driver started");   
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		System.out.println(sUserName);
		Thread.sleep(5000);
		System.out.println(sPassword);
		et1.get().log(Status.PASS, "TC4 credential entered in console");
		et1.get().log(Status.PASS, "Credentials entered are "+sUserName + " and "+ sPassword);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void TC5(String sUserName, String sPassword) throws InterruptedException, IOException {
		System.out.println("m in TC5");
		driver =createDriver();
		driver.get("https://www.google.com/");
		log.info("Driver is initialized");
		et1.get().log(Status.PASS, "TC5 driver started");   
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		System.out.println(sUserName);
		Thread.sleep(3000);
		System.out.println(sPassword);
		et1.get().log(Status.PASS, "TC5 credential entered in console");
		et1.get().log(Status.PASS, "Credentials entered are "+sUserName + " and "+ sPassword);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void TC6(String sUserName, String sPassword) throws InterruptedException, IOException {
		System.out.println("m in TC6");
		driver =createDriver();
		driver.get("https://www.google.com/");
		log.info("Driver is initialized");
		et1.get().log(Status.PASS, "TC6 driver started");   
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
		System.out.println(sUserName);
		Thread.sleep(3000);
		System.out.println(sPassword);
		et1.get().log(Status.PASS, "TC6 credential entered in console");
		et1.get().log(Status.PASS, "Credentials entered are "+sUserName + " and "+ sPassword);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}
	@AfterTest
	public void teardown()
	{
		System.out.println("m in after test");
		//driver.close();


	}

	@BeforeMethod
	public void beforeMethod(Method currmethod) throws Exception {
		System.out.println("m in the before method for the testcase "+ currmethod.getModifiers());
		
	}

	@AfterMethod
	public void afterMethod(ITestResult result,Method currmethod) throws IOException {
		System.out.println("m in after method");
		System.out.println(result.toString());
		driver.quit();
		String testCaseName=result.getTestName();
		et1.get().log(Status.PASS, "Driver closed successfully for the testcase case : "+currmethod.getName());
		System.out.println("-------------------------------------------------------------------------------------");

	}
//	@DataProvider
//
//	public Object[][] Authentication(Method testMethod) throws Exception{
//		System.out.println("m in dtaa provider");
//		ExcelUtility.setExcelFile("C:\\Users\\m81084\\Desktop\\TestData.xlsx","Sheet1");
//		sTestCaseName = this.toString();
//		System.out.println("Before Testmethod: " + testMethod.getName()); 
//		sTestCaseName = testMethod.getName();
//		iTestCaseRow = ExcelUtility.getRowContains(sTestCaseName,0);
//		Object[][] testObjArray = ExcelUtility.getTableArray("C:\\Users\\m81084\\Desktop\\TestData.xlsx","Sheet1",iTestCaseRow);
//		return (testObjArray);
//
//	}

}
