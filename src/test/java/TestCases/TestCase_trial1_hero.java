package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.TestBase;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TestCase_trial1_hero extends TestBase {
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
	@Story("Frames_Page")
	@Severity(SeverityLevel.MINOR)
	public void ScrollPage() {
		initializePOM();
		dashboardPage.ClickFrameLink();
		dashboardPage.NestedFramesButton();
		dashboardPage.FetchFrameContent();
		dashboardPage.Sleep();
		//dashboardPage.TextSearchWiseScroll();
	}
	
	@AfterMethod
	public void CloseSession() {
		driver.close();
		driver.quit();
	}
}
