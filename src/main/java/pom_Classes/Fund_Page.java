package pom_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util_Classes.Util_Class;

public class Fund_Page extends Util_Class {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[text() = 'Balance available']")
	private WebElement text;
	
	@FindBy(xpath="//input[@id='wrs445Amount']")
	private WebElement amountField;
	
	@FindBy(xpath="//div[text() = 'More Options']")
	private WebElement moreOption;
	
	
	@FindBy(xpath="//div[text() = 'Net Banking']")
	private WebElement netBanking;
	
	@FindBy(xpath="//span[text() = 'PAY VIA NETBANKING']")
	private WebElement netBankingBtn;
	
	
	
	
	
	public Fund_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean verifyFudPage() throws EncryptedDocumentException, IOException
	{
		WebElement text1 = explicitWait(driver, text);
		
		String textFromUI = text1.getText();
		
		String textFromExcel = getDataFromExcelSheet("Sheet1", 2, 0); 
		
		if(textFromUI.equals(textFromExcel))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void verifyUserEnterAmount()
	{
		explicitWait(driver, amountField);
		
		amountField.sendKeys("200");
		
		moreOption.click();
		
		explicitWait(driver, netBanking);
		
		netBanking.click();
		
		netBankingBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
