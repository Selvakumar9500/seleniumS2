package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseLink;

public class LoginPage extends BaseLink {

	@FindBy(xpath="//*[@id=\"pt-login-2\"]/a/span")
	WebElement clicklogin;

	@FindBy(xpath="//input[@id='wpName1']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='wpPassword1']")
	WebElement Password;
	
	@FindBy(xpath="//button[@id='wpLoginAttempt']")
	WebElement loginclick;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void user_login()
	{
		clicklogin.click();
		Username.sendKeys("Aselva@gmail.com");
		Password.sendKeys("Aselva@123");
		loginclick.click();
		
	}
	
	
}
