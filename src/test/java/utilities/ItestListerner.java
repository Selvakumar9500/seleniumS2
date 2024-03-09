package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListerner implements ITestListener{

	/*
	 * @Override public void onTestStart(ITestResult result) {
	 * System.out.println("Test has Started"); }
	 */

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Test has Started");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String Testmethod = result.getName();
				
		System.out.println("Test has failed");
		
		WebDriver driver = null;
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			String destFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+Testmethod+".png";
			
			try {
				FileUtils.copyFile(srcFile, new File(destFilePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	@Override 
	public void onFinish(ITestContext context) {
		 System.out.println("The test  Completed");
		 
	}
	
}


	

