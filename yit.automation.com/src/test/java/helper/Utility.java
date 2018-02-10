package helper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileSystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.FileUtils;

public class Utility {
	
	public static String getCurrentDateTime()
	{
		
		DateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
				
		Date date=new Date();
		
		
	String fromatedDate=dateFormat.format(date);
	
	return fromatedDate;
	}

	
	public static String captureScreenshot(WebDriver driver)
	{
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+Utility.getCurrentDateTime()+".png";
		
		File dest=new File(screenshotPath);
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		try {
			
			
			org.apache.commons.io.FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			
			System.out.println("Error: Unable to capture the screen shot");
			
			System.out.println("Error "+e.getMessage());
		}
		
		return screenshotPath;
	}
}
