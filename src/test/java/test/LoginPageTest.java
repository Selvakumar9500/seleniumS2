package test ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import page.LoginPage;

public class LoginPageTest  {
	
	public WebDriver driver ;
	LoginPage lp;
	
	@Test(priority='1')
	public void start_browser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\selva\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		lp = new LoginPage(driver);
	}
	
	@Test(priority='2')
	public void user_login() throws InterruptedException
	
	{
		Thread.sleep(2500);
		lp.user_login();
		
	}
	

	@AfterClass
	public void closebroser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
	
}
