
package test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.SalesLandPage;
import resources.initializeDriver;

public class SalesPageValidation3  extends initializeDriver{
	 
	@BeforeTest
	public void initialtrig() throws IOException
	{
		driver= base();
		driver.get(prop.getProperty("url"));  //url invoked from properties file through initializeDriver
	}
	 @Test
	public void FilterChck() throws InterruptedException, IOException
	{
	 
		 //creating objects to that class and invoke methods of it  
		 SalesLandPage t = new SalesLandPage(driver);
		 t.getSalesdrpDwn().click();//driver.findelement
		 
		 Thread.sleep(3000L);
		// t.getSalesLanding().click();
		  Thread.sleep(2000L);
		// Before applying the sales page available products for sales 
			System.out.println("<======================================>"); 
		     t.getListofproduct(); 
		     
		  //Navigates to filter page Filter with Price $100.00 - $199.99 
		  t.getProductFiltered().click();	  
	 //validates the filter
	Assert.assertTrue(t.getProductFiltered().isEnabled());
//	t.getListofproduct();	
	System.out.println("The filter with Price $100.00 - $199.99 is applied correctly");
	 t.getListofproduct(); 
	System.out.println("<======================================>"); 
	}
	 
	 @AfterTest
	 public void drop()
	 {
		 driver.manage().deleteAllCookies();
		 driver.close();
		 
	 }
}