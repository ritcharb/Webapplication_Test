package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesLandPage {

	public WebDriver driver;
	By SalesDrDwn= By.cssSelector("a[href*='sale']");
	By SalesPage = By.cssSelector("a[text*='Sale']");
	//By ProductPric = By.cssSelector("span[class*='price']");
	By FilterPrice= By.cssSelector("a[href*='100-200']");
	
	public SalesLandPage (WebDriver driver) {
		this.driver= driver;
	}
	public WebElement getSalesdrpDwn() {
		// TODO Auto-generated method stub
		return driver.findElement(SalesDrDwn);
	}
   public WebElement getSalesLanding() {
	return driver.findElement(SalesPage);
}
   //public WebElement getProductPric() {
	//	return driver.findElement(ProductPric);
	//}
   
   public void getListofproduct() //prints all the available products on sale page based on filter
   {
	   List<WebElement> products=driver.findElements(By.cssSelector("h2[class*='product-name']")); 
		 System.out.println("<======================================>"); 
		 System.out.println("Products are  ;"); 
		 for (WebElement name : products) 
		 {
			 System.out.println(name.getText());
		 }
		 
		 System.out.println("<======================================>"); 
   }
   
   public WebElement getProductFiltered()
   {
	   return driver.findElement(FilterPrice);
   }
   
}