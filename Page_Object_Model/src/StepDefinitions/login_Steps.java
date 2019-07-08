package StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Pages.Login;
import Utility.Base;
import Utility.CommonAction;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login_Steps {

WebDriver driver;
	@Given("^I am on OragangeHrm$")
	public void i_am_on_OragangeHrm() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Base obj= new Base();
		CommonAction objo=new CommonAction();
		Properties pro=objo.readProperty();

		//Login lg = new Login(driver);
		//lg.dologin(pro.getProperty("Browser"),pro.getProperty("url"));
		
	driver=	obj.launchbrowser(pro.getProperty("Browser"), pro.getProperty("url"));
	    
	}

	@When("^I enter the Username \"([^\"]*)\" & Password \"([^\"]*)\"$")
	public void i_enter_the_Username_Password(String arg1, String arg2) throws Throwable {
		
		Login objj = new Login(driver);
		objj.dologin(arg1, arg2);
		
		
	
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^I click onn login button$")
	public void i_click_onn_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
