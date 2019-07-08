package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login  {
	
	
	public WebDriver driver;
	
	
	
	
	
	
	

	@FindBy(id="txtUsername")
	WebElement txtUserName;
	
	@FindBy(id="txtPassword")
	WebElement txtPwd;

	@FindBy(id="btnLogin")
	WebElement btnClick;
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/h1")
	WebElement dashBoard;
	public  Login (WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
//pageMethod
	
	public void dologin(String Username,String pwd)
	{
		txtUserName.sendKeys(Username);
		txtPwd.sendKeys(pwd);
		btnClick.click();
	}
	


}
