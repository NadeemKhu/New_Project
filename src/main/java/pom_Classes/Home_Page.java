package pom_Classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util_Classes.Util_Class;

public class Home_Page extends Util_Class {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='valign-wrapper']/div")
	private WebElement profileIcon;
	
	@FindBy(xpath="//p[@class='truncate headerDggnd']")
	private WebElement userEmail;
	
	@FindBy(xpath="//div[@class='valign-wrapper balance-wrap']")
	private WebElement fundButton;
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickIcon()
	{
		explicitWait(driver, profileIcon);
		profileIcon.click();
	}
	
	public boolean verifyUser() throws IOException
	{
		WebElement element = explicitWait(driver, userEmail);
		
		String emailFromUi = element.getText();
		
		String emailFromFile = getDataFromPropertyFile("email");
		
		if(emailFromUi.equals(emailFromFile))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickFund()
	{
		fundButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
