package seleniumadvanced.demos.seleniumday1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testAjax1 {WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\Subhashree\\chromedriver\\chromedriver.exe");
	  driver=new ChromeDriver();
	
	  driver.manage().window().maximize();
	  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  
	  
	  WebElement from=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[2]/div/div/span"));
      WebElement to=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_Label1\"]"));
      
      Actions act1=new Actions(driver);
      act1.dragAndDrop(from, to).perform();
      act1.clickAndHold(from).release(to).perform();
      WebDriverWait wait=new WebDriverWait(driver,100);
      wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id=\\\"ctl00_ContentPlaceholder1_Label1\\"),"Drop a package here to check price"));
      String result=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_Label1\"]")).getText();
      System.out.println("Result:" +result);
      Assert.assertTrue(result.contains("$4999"));

  
  }
  
}
