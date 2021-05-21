package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseTest.TestBase;

public class AddRemoveElements extends TestBase{
	@FindBy(xpath="//h3[text()='Add/Remove Elements']")
	private WebElement AddRemoveElementsPageTitle;
	//*[@id="content"]/h3
	
	@FindBy(xpath="//*[@onclick='addElement()']")
	private WebElement AddElementButton;	
	//*[@id="content"]/div/button
	//*[@onclick='addElement()']
	
	
	
	//<button class="added-manually" onclick="deleteElement()">Delete</button>
	
	
	
	
	public void ClickOnAddElementButton() {
		AddElementButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
