package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class initializeDriver {

	//access for entire testcase
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver base () throws IOException {
		// TODO Auto-generated method stub
		
		prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Ar_Richya\\eclipse-workspaceNew\\Testing Project\\data.properties");
		prop.load(fis); //load takes fis as argument 
	 	
		//for browser 
		String browserName=prop.getProperty("browser");
	    System.out.println(browserName) ;
	   
	   if (browserName.equals("chrome"))
	{
		//execute in chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ar_Richya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver= new ChromeDriver (); 
	}
	else if (browserName.equals("firefox"))
	{
		System.setProperty("","");
	     driver = new FirefoxDriver();
	}
	else if (browserName.equals("IE"))
	{
		System.setProperty("","");
	     driver = new InternetExplorerDriver();//IE code
	}
	//waits before the scriptfail
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
	return driver; //sending driver object back 
	}
}
