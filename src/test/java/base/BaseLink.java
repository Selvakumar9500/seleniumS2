package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseLink {

	
public static WebDriver driver;
	
	public static void openBrowser()
	{
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
	}
	
	public void closebrowser()
	{
		driver.close();
	}
}
