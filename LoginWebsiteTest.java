package com.example.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginWebsiteTest
{
	public WebDriver driver = null;
	
	 //initialise ExtentReports with a file path 
//	boolean replaceExisting = true;
//	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Will Peters\\Reporting\\dualreporting.html", replaceExisting);
	static ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public static void initial()
	{
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\WillPeters\\Reporting\\dualreporting.html", true);
	}
	
	//initialise / start the test
	@Before
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver();
	
	}
	
	@Test
	public void TestyK()
	{
	test = extent.startTest("Verify application Title");
	driver.get("http://thedemosite.co.uk/");
	
	//add a note to the test
	test.log(LogStatus.INFO, "Browser started");
	driver.findElement(By.linkText("3. Add a User")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("test1");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test2");
    driver.findElement(By.name("FormsButton2")).click();
    driver.findElement(By.linkText("4. Login")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("test1");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test2");
    driver.findElement(By.name("FormsButton2")).click();
    
    WebElement text = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
    
    //report the test as a pass
  	if(text.getText().equals("**Successful Login**"))
  	{
  		test.log(LogStatus.PASS, "verify: Title of the page");
  	}
  	else
  	{
  		test.log(LogStatus.FAIL, "invalid verification: Title of the page");
  	}
  	
  	extent.endTest(test);
  	
  	
//  	assertEquals("**Successful Login**", text.getText());
  	
    }
	
	@After
	public void teardown()
	{
		driver.quit();	
	}
	
	@AfterClass
	public static void end() {
		extent.flush();
	}
	
	@Test
	public void TestyP()
	{
	test = extent.startTest("Failed login simulation");
	driver.get("http://thedemosite.co.uk/");
	
	//add a note to the test
	test.log(LogStatus.INFO, "Browser started");
	driver.findElement(By.linkText("3. Add a User")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("9876");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("9876");
    driver.findElement(By.name("FormsButton2")).click();
    driver.findElement(By.linkText("4. Login")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("4764");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("9876");
    driver.findElement(By.name("FormsButton2")).click();
    
    WebElement text = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
    
    //report the test as a pass
  	if(text.getText().equals("**Failed Login**"))
  	{
  		test.log(LogStatus.PASS, "incorrect username - failed login");
  	}
  	else
  	{
  		test.log(LogStatus.FAIL, "correct username - successful login");
  	}
  	
  	extent.endTest(test);
  	
//  	assertEquals("**Failed Login**", text.getText());
    }
}