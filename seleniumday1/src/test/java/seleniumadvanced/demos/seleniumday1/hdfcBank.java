package seleniumadvanced.demos.seleniumday1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class hdfcBank {WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\Subhashree\\chromedriver\\chromedriver.exe");
	  driver=new ChromeDriver();
	
	  driver.manage().window().maximize();
	  driver.get("https://www.hdfcbank.com/");
	  
	  Actions act1=new Actions(driver);
	  act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']")));
	  act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
	  act1.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[2]/div[3]/div/ul/li[1]/a")));
	  act1.click(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[2]/div[3]/div/ul/li[1]/a")));
	  act1.perform();
	  
  }
}
