package applicationTestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationFactory.DataProviderFactory;
import applicationPages.LoginPage;
import helper.BaseClass;
import helper.Utility;

public class LoginCRM extends BaseClass {
	

	@Test
	public void loginAdmin()
	{
		logger=report.startTest("Login, Admin");
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUsername(DataProviderFactory.getExcel().getStringData("Login", 0, 0));
		login.enterPassword(DataProviderFactory.getExcel().getStringData("Login", 0, 1));
		login.clickOnLoginButton();
	
	}
	
	
	
}
