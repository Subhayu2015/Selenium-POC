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
@Feature("Practice Selenium Allure")
public class TestCase_AddDeleteElement extends TestBase {
	
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
	
	@Test
	@Link("http://the-internet.herokuapp.com/add_remove_elements/")
	@Story("Check add and Delete element")
	@Severity(SeverityLevel.CRITICAL)
	public void AddThenDeleteButton() {
		initializePOM();
		dashboardPage.ClickOnAddRemove_Elements();
		dashboardPage.ClickOnAddElement(5);
		dashboardPage.ClickOnDeleteElement();
	}
	@AfterMethod
	public void CloseSession() {
		driver.close();
		driver.quit();
	}

}
