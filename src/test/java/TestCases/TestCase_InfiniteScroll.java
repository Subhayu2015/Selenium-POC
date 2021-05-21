package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Allure examples")
@Feature("Practice Selenium")
public class TestCase_InfiniteScroll extends TestBase{
	@BeforeMethod
	public void setup(){
		TestBase.initialization();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(retryAnalyzer = Utils.RetryAnalyzer.class)
	@Link("http://the-internet.herokuapp.com/Scroll_Page/")
	@Story("Scroll_Page")
	@Severity(SeverityLevel.MINOR)
	public void ScrollPage() {
		initializePOM();
		dashboardPage.ClickOnInfiniteScroll();
		dashboardPage.PixelWiseScrollDown();
		dashboardPage.PixelWiseScrollDown();
		dashboardPage.PixelWiseScrollDown();
		dashboardPage.PixelWiseScrollDown();
		dashboardPage.PixelWiseScrollDown();
		dashboardPage.Sleep();
		dashboardPage.PixelWiseScrollUp();
		dashboardPage.Sleep();
		//dashboardPage.TextSearchWiseScroll();
	}
	
	@AfterMethod
	public void CloseSession() {
		driver.close();
		driver.quit();
	}

}
