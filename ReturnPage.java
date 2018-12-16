package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReturnPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ReturnPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}

//WebElement for link System
		@FindBy(xpath="//a[contains(text(),'System')]")
		WebElement systemEle;
	
//WebElement for link Returns
		@FindBy(xpath="(//a[contains(text(),'Returns')])[2]")
		WebElement returnEle;
		
//WebElement for link Return Actions
		@FindBy(xpath="//a[contains(text(),'Return Actions')]")
		WebElement retactionEle;
	
//WebElement for button Action
		@FindBy(xpath="(//button[contains(text(), 'Action')])[1]")
		WebElement actionEle;
		
//WebElement for Edit
		@FindBy(xpath="//a[@title='Edit']")
		WebElement editEle;
	
//WebElement for field Return Action Name
		@FindBy(xpath="//input[@name='name']")
		WebElement retactnameEle;
		
//WebElement for icon Save
		@FindBy(xpath="//button[@title='Save']")
		WebElement saveEle;
		
		public void clickOnLinkSystem()
		{
			systemEle.click();
		}
		
		public void clickOnLinkReturns()
		{
			returnEle.click();
		}
		
		public void clickOnLinkRetActions()
		{
			retactionEle.click();
		}
		
		public void clickOnAction()
		{
			actionEle.click();
		}
		
		public void clickOnEdit()
		{
			editEle.click();
		}
		
		public void enterReturnActionName(String returnactionname)
		{
			retactnameEle.clear();
			retactnameEle.sendKeys(returnactionname);
		}
		
		public void clickOnIconSave()
		{
			saveEle.click();
		}
					
		public void validationOnRecord() throws FileNotFoundException, IOException
		{
			Properties p = new Properties();
			p.load(new FileInputStream("./TestData/magentodata.properties"));
		
			String pagesource = driver.getPageSource();
			//System.out.println(pagesource);
			
			if(pagesource.contains(p.getProperty("returnactionname"))) {
				System.out.println("The presence of edited action name is confirmed!");
			}
			else {
				System.out.println("The action is not added to the Return Actions List");
			}
		}

}
