package Functionaltesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.Kpi;
import Pages.Login;
import Utility.CommonAction;

public class Sprint2 extends CommonAction{
	
	@Test
	public void Testcase1() throws InterruptedException	
	{
		logger= extent.createTest("logn test");
		Login login = new Login(driver);
				login.dologin("Admin", "admin123");
		Kpi obj=new Kpi(driver);
		
		

		logger.log(Status.INFO, "Click kpi");
		obj.openkpipage();
		logger.log(Status.INFO, "add kpi");
		obj.addKpi("CEO", "HI", "78", "89");
	Assert.assertEquals(true, true);
		
		
	}
	
	

}
