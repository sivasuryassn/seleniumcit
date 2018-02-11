package applicationFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	// This will be static method Since its return you webdriver instance
	// So webdriver will be the return type
	//Added one more commited by sivasurya

		public static WebDriver startApplication(String browser, String url) {
	
		System.out.println("INFO: Setting up the Browser");
		WebDriver driver=null;
		
		DesiredCapabilities cap=new DesiredCapabilities();
		//This is one way of writing=>cap.setAcceptInsecureCerts(true);
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		if (browser.equalsIgnoreCase("Chrome")) 
		{
			
			
			System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(cap);

		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("Webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver(cap);
		} else if (browser.equalsIgnoreCase("IE")) 
		{// Sometime movesovering mouse over will not put ie one 
			// they removed this way=>ap.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING,true);
			
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			System.setProperty("Webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(cap);

		} else {
			System.out.println("Error: Sorry this framework supports only chrome,ie,FF");
		}

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("INFO: Browser and application is set up");
		return driver;

	}
}
