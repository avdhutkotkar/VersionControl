import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.PropertyOperations;

public class TestClass {
	
	public static WebDriver driver=null;
	
	public void LaunchBrowserWithAppURL(){
		PropertyOperations prop= new PropertyOperations();
		String browserTouse = prop.getPropertyValue("browser");
		String appURL = prop.getPropertyValue("AppURL");
		
		System.out.println("BrowserType :"+browserTouse);
		System.out.println("URL :"+appURL);
		
		if (browserTouse.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Avdhut\\Radicle_Software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserTouse.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Avdhut\\Radicle_Software\\geckodriver_64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if(driver!=null){
			driver.get(appURL);
			Reporter.log("Browser "+browserTouse+" Launched Successfully with AppURL: "+appURL);
		}else{
			Reporter.log("Browser "+browserTouse+" Launch is not Successful with AppURL: "+appURL);
		}
	}
	
	@Test
	public void test(){
		TestClass obj1 = new TestClass();
		obj1.LaunchBrowserWithAppURL();
	}

}
