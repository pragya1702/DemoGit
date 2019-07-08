package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestMethodWithDataProviderMethodWorker;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class CommonAction {
	public WebDriver driver=null;
	public  ExtentHtmlReporter htmlReporter;
    public  ExtentReports extent;
    public  ExtentTest logger;
    public Properties pro;

	
	
	
	     
	     
public Properties readProperty() throws IOException
{
	FileInputStream file =new FileInputStream(new File("data.properties"));
	
	
	pro = new Properties();
	pro.load(file);
	
	return pro;
	
	
	
}

@AfterMethod
public void getResult(ITestResult result){
	 
	 if(result.getStatus() == ITestResult.SUCCESS) {
		 
		 logger.log(Status.PASS, "Test Case Passed " + result.getName());
	 }
	   
  if(result.getStatus() == ITestResult.FAILURE){
 	 
            logger.log(Status.FAIL, "Test Case Failed is "+result.getName() + result.getThrowable());
            
            
            //logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
}
  else if(result.getStatus() == ITestResult.SKIP){
 	 
            logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
}
  
	//extent.endTest(logger);
	
	
}

public static void captureScreenShot(WebDriver ldriver){
	// Take screenshot and store as a file format             
	 File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
	try {
	// now copy the  screenshot to desired location using copyFile method
	 
	FileUtils.copyFile(src, new File("C:/selenium/"+System.currentTimeMillis()+".png"));                              }
	catch (IOException e)
	 
	{
	  System.out.println(e.getMessage()) ;
	 }
	  }
	 
}

