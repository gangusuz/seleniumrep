package seleniumadvanced.demos.seleniumday1;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class NewTest {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String username, String password) {
	  	driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
  
  @DataProvider
  public Object[][] dp() {
	  return testExcel.testreadExcel();
    };
    
	@BeforeTest
	@Parameters("browser")
	public void beforetest(String value,ITestContext result)
	{		
		System.out.println(result.getCurrentXmlTest().getName()+"test is started");
		if(value.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Subhashree\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(value.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Subhashree\\IEdriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		}
	@AfterTest
	public void aftertest(ITestContext result)
	
	{System.out.println(result.getCurrentXmlTest().getName()+"test is stopped");}
	}
	
  

