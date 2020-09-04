package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {

	public WebDriver driver;
	
		By account= By.cssSelector("a[href*='account']"); 
		By login= By.cssSelector("a[href*='login']");
		By email=By.cssSelector("input[name*='login[username]']");
		By password= By.id("pass");
		By LoginButton =By.id("send2");	
		By ValidationError= By.xpath("//li[@class='error-msg']");
		By InputValidationEmail=By.id ("advice-required-entry-email");
		By InputValidationPass= By.id("advice-required-entry-pass");
	
		
		public FormPage (WebDriver driver) 
	{
		this.driver= driver;
	}
	
		public FormPage getLogin() {
			// TODO Auto-generated method stub
			 driver.findElement(account).click();
			 driver.findElement(login).click();
			 FormPage lp= new FormPage(driver);
			 return lp;
		}

		public WebElement getEmail() {
		// TODO Auto-generated method stub
		
			return driver.findElement(email);
	}

		public WebElement getPassword() {
	
			return driver.findElement(password);
}

		public WebElement getLoginButton()
{
	return driver.findElement(LoginButton);
	}
		public WebElement getValidationError()
		{
			return driver.findElement(ValidationError);
		}
		public WebElement getEmailValidation()
		{
			return driver.findElement(InputValidationEmail);
		}
		public WebElement getPassValidation()
		{
			return driver.findElement(InputValidationPass);
		}

}