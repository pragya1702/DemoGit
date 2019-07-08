package Functionaltesting;




import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Login;
import Utility.Base;
import Utility.CommonAction;


public class Sprint1 extends Base{
	
	@Test
	public void Testcase12() throws IOException
	
	{
		
		CommonAction obj=new CommonAction();
		Properties pro=obj.readProperty();

		Login lg = new Login(driver);
		lg.dologin(pro.getProperty("UN"),pro.getProperty("Pwd"));
		
		
		
		
	Assert.assertEquals(true, true);
		
		
	}
	
	

}
