package utilities;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelutilites {
	
	public static WebDriver driver;
	
	@BeforeClass public void OpenBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/w/index.php?returnto=Main+Page&title=Special:UserLogin&centralAuthAutologinTried=1&centralAuthError=Not+centrally+logged+in");
		
	}
	@Test(dataProvider = "testdata")
	public void register_user(String Username, String Password ) throws InterruptedException
	{
		// Username input
	
		driver.findElement(By.xpath("//input[@id='wpName1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='wpName1']")).sendKeys(Username);
		
		//password input
		
		driver.findElement(By.xpath("//input[@id='wpPassword1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='wpPassword1']")).sendKeys(Password);
		
		//login
		
		driver.findElement(By.xpath("//button[@id='wpLoginAttempt']")).click();
		
		Thread.sleep(1500);
		
	}
	@DataProvider(name="testdata")
	public   Object[][] datasupply() throws FileNotFoundException
	{
		// get the data from excel sheet
		
		Object[][] inputdata = Xls_dataprovider.getTestData("TestData");
		
		return inputdata;
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
}

	

