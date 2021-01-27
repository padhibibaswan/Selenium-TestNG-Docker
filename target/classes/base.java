package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.EnvironmentType;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.core.util.Loader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public static  WebDriver driver;
	public Properties prop = new Properties();
	public static Logger log = null;
	public static FileInputStream fis;
	
	public static String testCong = System.getProperty("user.dir")+File.separator+"Config"+File.separator+"testConfig.properties";
	
	
	public WebDriver getDriver() throws IOException {
		 if(driver == null) driver = createDriver();
		 return driver;
		}
	
	
	public WebDriver createDriver() throws IOException { 
		fis=new FileInputStream(testCong);
		prop.load(fis);
		String environmentType=prop.getProperty("environment");
	    switch (environmentType) {     
	         case "local" : driver = initializeDriver_Local();
	          break;
	         case "remote" : driver = initializeDriver_Remote();
	          break;
	    }
	    return driver;
	  }
	
	
	
	private WebDriver initializeDriver_Remote() throws IOException {
		// TODO Auto-generated method stub
		//DesiredCapabilities cap = new DesiredCapabilities();
		fis=new FileInputStream(testCong);
		prop.load(fis);
		DesiredCapabilities cap =  DesiredCapabilities.chrome();
		if (prop.getProperty("browser").equals("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver.exe");
			cap.setBrowserName(BrowserType.CHROME);
			//cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			
			
		}else if (prop.getProperty("browser").equals("firefox")) {
			cap.setBrowserName(BrowserType.FIREFOX);
		}
		
		
		String dockerurl="http://localhost:4545/wd/hub";
		String localurl="http://localhost:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(dockerurl),cap);
		return driver;
	}


	public WebDriver initializeDriver_Local() throws IOException
	{

		//prop= new Properties();
		//FileInputStream fis=new FileInputStream(testCong);
		fis=new FileInputStream(testCong);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver.exe");
			driver= new ChromeDriver();
			//execute in chrome driver

		}
		else if (browserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
			//firefox code
		}
		else if (browserName.equals("IE"))
		{
			//	IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}


	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}


	private static void initLogs(){
		if (log == null){
			// Initialize Log4j logs

			DOMConfigurator.configure(System.getProperty("user.dir")+File.separator+"config"+File.separator+"log4j.xml");
			log = Logger.getLogger("MyLogger");
			log.info("Logger is initialized..");
		}
	}

	protected static String getPropertyValue(String PropertyKey){
		Properties props=null;
		FileInputStream fin =null;
		String PropertyValue = null;

		try {
			File f = new File(testCong);
			fin = new FileInputStream(f);
			props = new Properties();
			props.load(fin);
			PropertyValue = props.getProperty(PropertyKey);
		} catch(Exception e){
			System.out.println(e.getMessage());
		} 

		return PropertyValue;
	}

	public static void quitDriver() {

		driver.quit();
		driver = null;
		log.info("Closing Browser.");

	}

}
