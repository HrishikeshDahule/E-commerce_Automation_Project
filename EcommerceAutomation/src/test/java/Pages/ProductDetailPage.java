package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    
    By imageview = By.xpath("//div[@class=\"productinfo text-center\"]//img");
    By firstViewProduct = By.xpath("(//a[text()='View Product'])[1]");
    By productName = By.xpath("//div[@class='product-information']//h2");
    By category = By.xpath("//div[@class=\"product-information\"]//p");
    By price = By.xpath("(//div[@class=\"product-information\"]//span)[2]");
    By Availability = By.xpath("//div[@class='product-information']/p[2]");
    By condition = By.xpath("//div[@class='product-information']/p[3]");
    By brand = By.xpath("//div[@class='product-information']/p[4]");
    
    
    
    public boolean firstimagedisplayed() {
    	WebElement element = driver.findElement(imageview); 
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	 return element.isDisplayed();
	}
    
    public void clickfirstviewproduct() {
    	driver.findElement(firstViewProduct)
    	.click();
	}
    public String getProductName() {
        return driver.findElement(productName)
                     .getText();
    }
   
    public String getCategory() {
    	return driver.findElement(category).getText();
    }

    public String getPrice() {
        return driver.findElement(price)
                     .getText();
    }

    public String getAvailability() {
        return driver.findElement(Availability)
                     .getText();
    }

    public String getCondition() {
        return driver.findElement(condition)
                     .getText();
    }

    public String getBrand() {
        return driver.findElement(brand)
                     .getText();
    }
}
