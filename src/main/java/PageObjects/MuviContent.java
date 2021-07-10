package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseTest.TestBase;

public class MuviContent extends TestBase {
	
	@FindBy(xpath="//button[@class='btn btn-primary my-2 my-sm-0 ']")
	private WebElement freeTrial;
	
	@FindBy(xpath="//div[@class='form-group'][1]/input")
	private WebElement name;
	
	@FindBy(xpath="//div[@class='form-group'][2]/input")
	private WebElement companyName;
	
	@FindBy(xpath="//div[@class='form-group'][3]/input")
	private WebElement phoneNo;
	
	@FindBy(xpath="//div[@class='form-group'][4]/input")
	private WebElement email;
	
	@FindBy(xpath="//div[@class='form-group'][5]/input")
	private WebElement password;
	
	@FindBy(xpath="//*[contains(text(),'I agree')]")
	private WebElement termsCondition;
	
	//###################################################
	
	@FindBy(xpath="//button[@id='nextbtn']")
	private WebElement signupNext;
	
	//###################################################
	
	@FindBy(xpath="//a[@href='https://cms.muvi.com/cmscontent/managecontent']/i[@class='fa fa-arrow-right']")
	private WebElement content;
	
	@FindBy(xpath="//a[@href='https://cms.muvi.com/template']/i[@class='fa fa-arrow-right']")
	private WebElement template;
	
	@FindBy(xpath="//a[@href='https://cms.muvi.com/monetization/settings']/i[@class='fa fa-arrow-right']")
	private WebElement setting;
	
	@FindBy(xpath="//a[@href='javascript:void(0)']/i[@class='fa fa-arrow-right']")
	private WebElement gotIt;
	
	//###################################################
	
	@FindBy(xpath="//em[@class='icon-film left-icon']")
	private WebElement manageContent;
	
	@FindBy(xpath="//ul[@class='Sub-Menu-Level--1 quicktip1']/li/a[contains(text(),'Content')]")
	private WebElement contentLibrary;
	
	@FindBy(xpath="//button[contains(text(),'Add Content')]")
	private WebElement addContent;
	
	@FindBy(xpath="//input[@name='movie[name]']")
	private WebElement inputName;
	
	@FindBy(xpath="//select[@id='content_category_value']/option[1]")
	private WebElement catagory1;
	
	
	@FindBy(xpath="//select[@id='content_category_value']/option[2]")
	private WebElement catagory2;
	
	@FindBy(xpath="//button[@id='save-btn']")
	private WebElement saveContent;
	
	public MuviContent(){
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void signUp() throws InterruptedException {
		freeTrial.click();
		name.sendKeys("myname");
		companyName.sendKeys("mycompany");
		phoneNo.sendKeys("123344");
		email.sendKeys("montealbanabc63@gmail.com");
		password.sendKeys("Mypassword@123");
		Thread.sleep(5000);
		termsCondition.click();
		signupNext.click();
		Thread.sleep(10000);
		signupNext.click();
		Thread.sleep(15000);
		
	}
	
	public void navigation() {
		content.click();
		template.click();
		setting.click();
		gotIt.click();
	}

	public void createContent() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(manageContent).perform();
		contentLibrary.click();
		addContent.click();
		inputName.sendKeys("newMovieName");
		catagory2.click();
		Thread.sleep(5000);
		catagory1.click();
		//driver.findElement(By.xpath("//span[@class='help-block with-errors']")).click();
		Thread.sleep(10000);
		//catagory.sendKeys(Keys.TAB);
		saveContent.click();
		Thread.sleep(20000);
		
	}
	
	public void searchContent() {
		Actions action=new Actions(driver);
		action.moveToElement(manageContent).perform();
		contentLibrary.click();
		WebElement addedMovie=driver.findElement(By.xpath("//span[contains(text(),'newMovieName')]"));
		if(addedMovie.isDisplayed()==true) {
			Assert.assertTrue(true, "Movie name found");
		}
		
		
	}
}
