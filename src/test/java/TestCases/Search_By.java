package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Academy.Listeners;
import ObjectRepository.CIP_Aplication_OR;
import resources.ExtentReporterNG;
import resources.base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Search_By extends base{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	private ThreadLocal<ExtentTest> et1 =ExtentReporterNG.getExtentTestObject();
	public Listeners l=new Listeners();
	CIP_Aplication_OR cip_or = new CIP_Aplication_OR(); 
	public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		System.out.println("m in before test");
		log.info("Test started");
		log.info("Navigated to Home page");
	}


	//@Test(dataProvider = "Authentication", dataProviderClass=TestDataProvider.class)
	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void Search_LID_Copper(String Lid) {
		System.out.println("Search_LID");
		driver.get(prop.getProperty("url"));
		driver.findElement(cip_or.txt_LIDSearchField).sendKeys(Lid);
		driver.findElement(cip_or.btn_search).click();
		//l.writetoReport("driver launched");
		et1.get().log(Status.PASS, "TC2 driver started");
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());

		et1.get().log(Status.PASS, "TC2 credential entered in console");    
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	//@Test(dataProvider = "Authentication", dataProviderClass=TestDataProvider.class)
	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void Search_LID_Coax(String Lid) {
		System.out.println("Search_LID");
		driver.get(prop.getProperty("url"));
		driver.findElement(cip_or.txt_LIDSearchField).sendKeys(Lid);
		driver.findElement(cip_or.btn_search).click();
		//l.writetoReport("driver launched");
		et1.get().log(Status.PASS, "TC2 driver started");
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());

		et1.get().log(Status.PASS, "TC2 credential entered in console");    
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}
	//@Test(dataProvider = "Authentication", dataProviderClass=TestDataProvider.class)
	@Test(dataProvider = "Authentication" ,dataProviderClass = resources.TestDataProvider.class)
	public void Search_LID_Fiber(String Lid) {
		System.out.println("Search_LID");
		driver.get(prop.getProperty("url"));
		driver.findElement(cip_or.txt_LIDSearchField).sendKeys(Lid);
		driver.findElement(cip_or.btn_search).click();
		//l.writetoReport("driver launched");
		et1.get().log(Status.PASS, "TC2 driver started");
		System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());

		et1.get().log(Status.PASS, "TC2 credential entered in console");    
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	@BeforeMethod
	public void beforeMethod(Method currmethod) throws Exception {
		System.out.println("m in the before method");
		driver =getDriver();
		log.info("Driver is initialized");


	}

}
