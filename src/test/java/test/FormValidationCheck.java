 
package test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.FormPage;
import resources.initializeDriver;

public class FormValidationCheck  extends initializeDriver{
	 //Navigates to Login Page
	@BeforeTest
	public void initialtrig() throws IOException, InterruptedException
	{
		driver= base();
		driver.get(prop.getProperty("url"));  //url invoked from properties file through initializeDriver
		//creating objects to that class and invoke methods of it  
			  }
	 @Test (priority=1)
	public void ValidationCheckLogin() throws InterruptedException, IOException
	{	 
		 //Lands to the login page through the method 
		 FormPage l = new FormPage(driver);
		 //driver.findelement
		  FormPage lp= l.getLogin(); // method clicks the Account drop down  and then lands to Login Page (code imported from Landing page java)
		l.getEmail().sendKeys("test@test.com");
		l.getPassword().sendKeys("ThisIs@T3st");
		
		l.getLoginButton().click(); //login button clicked
	   String ExpectedResult="Invalid login or password.";
	   String  ActualResult=l.getValidationError().getText() ; 
	  Assert.assertEquals(ExpectedResult,ActualResult);
	  System.out.println("<======================================>"); 
	  System.out.println("1. Eror displayed for validation of Login Page  "+ActualResult );
	  System.out.println("<======================================>"); 
	}
	 
	 @Test (priority=2)
	 public void RequiredFieldCheck() throws InterruptedException
		{
			//Lands to the login page through the method 
			 FormPage l = new FormPage(driver);
			 //driver.findelement
			  FormPage lp= l.getLogin(); // method clicks the Account drop down  and then lands to Login Page (code imported from Landing page java)
			  	Thread.sleep(2000L);
			// This pass the email and password as provided from dataprovider

			l.getLoginButton().click(); //login button clicked	
			Thread.sleep(2000L);
			Assert.assertTrue(l.getEmailValidation().isDisplayed());
			Assert.assertTrue(l.getPassValidation().isDisplayed());
			 System.out.println("<======================================>"); 
			System.out.println("Appeared Validation for Email  " +l.getEmailValidation().getText());
			System.out.println("Appeared Validation for Password  " +l.getPassValidation().getText());
			System.out.println("<======================================>"); 
		}
	 
	 @AfterTest
	 public void drop()
	 {
		 driver.manage().deleteAllCookies();
		 driver.close();
	 }
}
	 
	 
	
