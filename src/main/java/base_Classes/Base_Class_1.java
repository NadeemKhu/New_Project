package base_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class_1 {
	
	public static WebDriver getDriver(String browser)
	{
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			//System.setProperty("webdriver.chrome.driver", "G:\\selenium\\driver\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
		}
		
		driver.get("https://groww.in/");
		
		driver.manage().window().maximize();
		
		return driver;
	}

}
