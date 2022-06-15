package test_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base_Classes.Base_Class_1;
import pom_Classes.Fund_Page;
import pom_Classes.Home_Page;
import pom_Classes.Login_Page;

public class VerifyUserCanAddFundInAccount {
	
	WebDriver driver;
	Login_Page lp;
	Home_Page hp;
	Fund_Page fp;
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest test;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String k)
	{
		reporter = new ExtentHtmlReporter("ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(reporter);
		test = report.createTest("VerifyUserCanAddFundInAccount");
		
		driver = Base_Class_1.getDriver(k);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp = new Login_Page(driver);
		hp = new Home_Page(driver);
		fp = new Fund_Page(driver);
	}
	
	
	@Test
	public void verifyUserCanLogin() throws IOException, InterruptedException
	{
		lp.clickLogin();
		lp.putEmail();
		lp.clickContinue();
		lp.putPassword();
		lp.clickSubmit();
		lp.putPin();
		
		Thread.sleep(5000);
		
		hp.clickIcon();
		
		boolean k = hp.verifyUser();
		
		Assert.assertTrue(k);  // assert for every test methods
		
	}
	
	@Test
	public void verifyUserCanOpenFundPage() throws EncryptedDocumentException, IOException
	{
		hp.clickFund();
		
		Assert.assertTrue(fp.verifyFudPage());
	}
	
	@Test
	public void verifyUserCanAddAmount()
	{
		fp.verifyUserEnterAmount();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is passed" + result.getName());
		}
		else
		{
			String path = lp.getScreenshot(driver, result.getName());
			test.log(Status.FAIL, "Test is Failed" + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		report.flush();
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
