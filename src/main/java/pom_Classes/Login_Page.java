package pom_Classes;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util_Classes.Util_Class;

public class Login_Page extends Util_Class {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='absolute-center']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='login_email1']")
	private WebElement emailInput;

	@FindBy(xpath="//div[@class='lils382ContinueBtn']")
	private WebElement continueButton;

	@FindBy(xpath="//input[@id='login_password1']")
	private WebElement passwordInput;

	@FindBy(xpath="//div[@class='col l12 leps592LoginButton']")
	private WebElement submitButton;

	@FindBy(xpath="(//input[@type='number'])[1]")
	private WebElement pinInput; 
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void putEmail() throws IOException
	{
		explicitWait(driver, emailInput);
		emailInput.sendKeys(getDataFromPropertyFile("email"));
	}
	
	public void clickContinue()
	{
		continueButton.click();
	}
	
	public void putPassword() throws IOException
	{
		explicitWait(driver, passwordInput);
		passwordInput.sendKeys(getDataFromPropertyFile("password"));
	}
	
	public void clickSubmit()
	{
		submitButton.click();
	}
	
	public void putPin() throws IOException
	{
		String pin = getDataFromPropertyFile("pin");   //  1234
		
		char digits[] = pin.toCharArray();  //  ['1', 2, 3, 4]
		
		explicitWait(driver, pinInput);
		
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='number']"));
		
		for(int i=0; i<digits.length; ++i)
		{
			list.get(i).sendKeys(String.valueOf(digits[i]));
		}
	}
	
	
	
	
	
	
	
	
	
	
	


}
