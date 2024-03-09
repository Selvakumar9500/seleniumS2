package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.BaseLink;
import page.LoginPage;

public class LoginPageTest extends BaseLink {
	LoginPage lp;
	
	@Test(priority='1')
	public void start_browser() throws InterruptedException
	{
		openBrowser();
		lp = new LoginPage(driver);
		Thread.sleep(1000);
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
