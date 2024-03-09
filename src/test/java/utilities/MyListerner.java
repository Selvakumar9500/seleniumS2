package utilities;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Listeners(ItestListerner.class)
public class MyListerner  implements ITestListener {
	
			
	public static WebDriver driver;
			
	@BeforeTest
	
	public void OpenBrowser()
	
	{
		driver = new ChromeDriver();	
	}
				
	//this test will fail due to assertion

	@Test(priority='1')
	
	public void Testmethod() throws IOException
	
	{
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		System.out.println(driver.getTitle());
		Assert.assertTrue(false);
	} 
		
	public void Extentreport()
	
	{		
		ExtentReports Ereport = new ExtentReports();
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("C:\\Users\\selva\\OneDrive\\Desktop\\SeleniumS2\\SeleniumS2\\extentreports\\newreport.html");
		Ereport.attachReporter(sparkreporter); // report gets created
		Ereport.setSystemInfo("OS", System.getProperty("os.name"));
		Ereport.setSystemInfo("JAVA", System.getProperty("java.version"));
		Ereport.setSystemInfo("Browser","Chrome");
		Ereport.setSystemInfo("Host Name","1234567");		
		Ereport.flush();
			
	}

	@AfterTest
	
	public void Closebrowser() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
}
	}
