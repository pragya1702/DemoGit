package Utility;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {

	public WebDriver driver;
	public  ExtentHtmlReporter htmlReporter;
    public  ExtentReports extent;
    public  ExtentTest logger;
    public Properties pro;

	@Parameters({"Browser","url"})
	@BeforeMethod
	public WebDriver launchbrowser(String browser, String url) {
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Technogeeks\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.get(url);
			 driver.manage().window().maximize();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Technogeeks\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.get(url);
		}
			


		return driver;
			}
	
	@BeforeSuite
	 public void startReport(){
	 
		htmlReporter = new ExtentHtmlReporter("D:\\Report1.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", "Mac ");
        extent.setSystemInfo("Host Name", "test");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Pragya");
	 }
	
	
	@AfterSuite
	   public void endReport(){
	   
	                  extent.flush();
	                 
	     }

}
