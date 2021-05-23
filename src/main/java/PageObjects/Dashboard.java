package PageObjects;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseTest.TestBase;

public class Dashboard extends TestBase{
	@FindBy(xpath="//*[@id='/abtest']/ul/li[1]/a")
	private WebElement AB_Testing;

	
	@FindBy(xpath="//a[text()='Add/Remove Elements']")
	private WebElement AddRemove_Elements;
	
	@FindBy(xpath="//a[text()='Broken Images']")
	private WebElement BrokenImages;
	
	
	@FindBy(xpath="//*[@id='/checkboxes']/ul/li[6]/a")
	private WebElement Checkboxes;
	
	
	@FindBy(xpath="//a[text()='Context Menu']")
	private WebElement ContextMenu;
	
	@FindBy(xpath="//a[text()='JavaScript Alerts']")
	private WebElement JavaScriptAlerts;
	
	@FindBy(xpath="//a[text()='Infinite Scroll']")
	private WebElement InfiniteScroll;
	
	@FindBy(xpath="//*[contains(text(),'eleniti amet architecto')]")
	private WebElement ScrollByText;
	
	
	@FindBy(xpath="//*[@id='/disappearing_elements']/ul/li[9]/a")
	private WebElement DisappearingElements;
	
	@FindBy(xpath="//a[text()='Drag and Drop']")
	private WebElement Drag_Drop;
	
	//######################    Frames     ###################
	@FindBy(xpath="//*[@id=\"content\"]/ul/li[22]/a")
	private WebElement FramesPageTitle;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/ul/li[1]/a")
	private WebElement NestedFrameLink;
	
	
	
	//###################### AddRemove Elements ########################
	@FindBy(xpath="//h3[text()='Add/Remove Elements']")
	private WebElement AddRemoveElementsPageTitle;
	
	@FindBy(xpath="//*[@onclick='addElement()']")
	private WebElement AddElementButton;
	
	@FindBy(xpath="//button[@onclick='deleteElement()']")
	private List<WebElement> DeleteElementButton;
	
	//#################################################################
	
	//###################### Broken Images ############################
	
	@FindBy (tagName="img")
	private List<WebElement> images;
	
	//#################################################################
	

	//###################### Context Menu #############################
	
	@FindBy(xpath="//div[@id='hot-spot']")
	private WebElement ContextMenuArea;
	
	//##################################################################
	
	//###################### JavaScripts Alert #############################
	
	@FindBy(xpath="//button[@onclick='jsAlert()']")
	private WebElement JsAlert;
	
	@FindBy(xpath="//button[@onclick='jsConfirm()']")
	private WebElement JsConfirm;
	
	@FindBy(xpath="//button[@onclick='jsPrompt()']")
	private WebElement JsPrompt;
	
	@FindBy(xpath="//p[@id='result']")
	private WebElement Result;
	
	//##################################################################
	
	//###################### Drag drop ################################
	
	@FindBy(xpath="//*[@id='column-a']")
	private WebElement DragPoint;
	
	@FindBy(xpath="//*[@id='column-b']")
	private WebElement DropPoint;
	
	//##################################################################
	//---------------------------------------------------------
	public Dashboard(){
		PageFactory.initElements(driver, this);
		
	}
	//########################  Frames Methods    #####################
	public void ClickFrameLink() {
		
		FramesPageTitle.click();
		try {
			Thread.sleep(2000);
		}  catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void NestedFramesButton() {
		
		NestedFrameLink.click();
		try {
			Thread.sleep(2000);
		}  catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public void FetchFrameContent() {
	driver.switchTo().frame("frame-bottom");
	String frametext= driver.findElement(By.tagName("body")).getText();
	System.out.println(frametext);
	
}
	
	
	
	//###################### AddRemove Elements ########################
	
	public void ClickOnAddElement(int iterator) {
		for (int i=0;i<iterator;i++) {
		AddElementButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	public void ClickOnDeleteElement() {
		int deleteButtonCount=DeleteElementButton.size();
		System.out.println(deleteButtonCount);
		for (int j=0;j<deleteButtonCount;j++) {
			DeleteElementButton.get(0).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//#################################################################
	
	//###################### Broken Images ############################
	
	public void FindBrokenImages() {
		
		for (WebElement imgElement : images) {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			try {
				org.apache.http.HttpResponse response = client.execute(request);
				int statusCode=response.getStatusLine().getStatusCode();
				System.out.println("......"+statusCode);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//#################################################################
	
	//###################### Context Menu #############################
	
	public void RightClickOnContextMenu() {
		Actions actions = new Actions(driver);
		
		actions.contextClick(ContextMenuArea).perform();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ContextMenuArea.click();
	}
	
	//#################################################################
	
	
	//###################### JavaScript Alerts #############################
	
	
	
	//Clicking on Alert
	public void ClickOnJsAlert() {
		JsAlert.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(".......1st Alert......"+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println(Result.getText());
	}
	
	
	
	//Clicking on Confirm
	public void ClickOnJsConfirm() {
		JsConfirm.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(".......2nd Alert......"+driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println(Result.getText());
	}
	
	
	//Clicking on Prompt
	public void ClickOnJsPrompt() {
		JsPrompt.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(".......3rd Alert......"+driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("qwerty");
		driver.switchTo().alert().accept();
		System.out.println(Result.getText());
	}
	
	//#################################################################
	
	//###################### Infinite Scroll #############################
	
	public void PixelWiseScrollDown() {
		
		js.executeScript("window.scrollBy(0,50000)");
	}
	
	public void TextSearchWiseScroll() {
		
		js.executeScript("arguments[0].scrollIntoView();",ScrollByText);
	}
	
	public void PixelWiseScrollUp() {
		
		js.executeScript("window.scrollBy(0,20000)");
	}
	
	//#################################################################
	
	//###################### Drag drop ################################
	
	public void DragAndDrop() {
		Actions actions = new Actions(driver);
		DropPoint.click();
		//actions.dragAndDrop(DragPoint, DropPoint).build().perform();
		//actions.clickAndHold(DragPoint).build().perform();
		//actions.moveToElement(DropPoint).build().perform();
		//actions.release(DropPoint).build().perform();
		actions.dragAndDropBy(DragPoint, 50, 0).perform();
		
	}
	
	
	//##################################################################
	public void ClickOnAB_Testing() {
		AB_Testing.click();
	}
	
	public void ClickOnAddRemove_Elements() {
		AddRemove_Elements.click();
	}	
	
	public void ClickOnBrokenImages() {
		BrokenImages.click();
	}
	
	public void ClickOnJavaScriptAlert() {
		JavaScriptAlerts.click();
	}
	
	public void ClickOnCheckboxes() {
		Checkboxes.click();
	}
	
	public void ClickOnInfiniteScroll() {
		InfiniteScroll.click();
	}
	
	public void ClickOnContextMenu() {
		ContextMenu.click();
	}
	
	public void ClickOnDisappearingElements() {
		DisappearingElements.click();
	}
	
	public void ClickOnDragDrop() {
		Drag_Drop.click();
	}
	
	public void Sleep() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
