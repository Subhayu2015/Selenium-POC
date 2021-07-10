package BaseTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utils.WebEventListener;

import PageObjects.AddRemoveElements;
import PageObjects.Dashboard;
import PageObjects.MuviContent;


public abstract class TestBase {
	static protected WebDriver driver;
	static protected JavascriptExecutor js;
	protected Dashboard dashboardPage;
	protected AddRemoveElements addRemoveElement;
	protected MuviContent muviContent;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public static void initialization(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		driver = new ChromeDriver(); 
		e_driver= new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//driver.get("http://the-internet.herokuapp.com");
		driver.get("https://www.muvi.com");
		
	}
	public void initializePOM(){
		//dashboardPage= new Dashboard();
		//addRemoveElement= new AddRemoveElements();
		muviContent=new MuviContent();
	}

}
