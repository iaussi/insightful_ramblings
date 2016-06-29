package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	public WebDriver driver;
		
	public WebDriver getDriver(String Browser) {
	
		File file;

		switch (Browser)
		{
		case "FF":
			driver = new FirefoxDriver();
			break;
			
		case "IE":

			file = new File("F:/downloads/eclipse/eclipse/selenium/IEDriverServer.exe");
	    	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	    	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	    	ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	    	
			driver = new InternetExplorerDriver();
			
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			break;
		default:
			driver = new InternetExplorerDriver();
			break;
		}	
		
		return driver;
	
	}
	

}
