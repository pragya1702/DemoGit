package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Kpi {
	
	
	public WebDriver driver;
	

	@FindBy(xpath="//*[@id=\"menu__Performance\"]/b")
	WebElement Perform;
	
	@FindBy(id="menu_performance_Configure")
	WebElement Config;
	
	@FindBy(xpath="//*[@id=\"menu_performance_searchKpi\"]")
	WebElement kpi;
	
	@FindBy(id="btnAdd")
	WebElement btnadd;
	
	@FindBy(xpath="//*[@id=\"defineKpi360_jobTitleCode\"]")
	WebElement JobTitle;
	@FindBy(xpath="//*[@id=\"defineKpi360_keyPerformanceIndicators\"]")
	WebElement key;
	
	@FindBy(xpath="//*[@id=\"defineKpi360_minRating\"]")
	WebElement mim;

	
@FindBy(xpath="//*[@id=\"defineKpi360_maxRating\"]")
WebElement max;

@FindBy(id="saveBtn")
WebElement savebtn;




public Kpi (WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
//page Method

public void openkpipage() throws InterruptedException
{
	
	Actions action = new Actions(driver);
	 
    action.moveToElement(Perform).build().perform();
    Thread.sleep(3000);
	Select sel= new Select(Config);
	sel.selectByVisibleText("KPIs");
	
			
			
}

public void addKpi(String Title,String ky,String min,String mx)
{
	btnadd.click();
	Select sel= new Select(JobTitle);
	sel.selectByVisibleText("Title");
	key.sendKeys(ky);
	mim.sendKeys(min);
	max.sendKeys(mx);
	
	savebtn.click();
	
}

}