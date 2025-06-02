package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	
	
	public  CheckoutPage(WebDriver driver) {
		this.driver  = driver;
		
	}
		By proceedToCheckoutBtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");
		By deliveryAddress = By.xpath("//ul[@id=\"address_delivery\"]");
		By billingAddress = By.xpath("//ul[@id=\"address_invoice\"]");
		By commentTextArea = By.name("message");
		By placeOrderBtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");
		
		
		public void clickProceedToCheckout() {
			driver.findElement(placeOrderBtn).click();
		}
		
		public boolean isDeliveryAddressVisible() {
			return driver.findElement(deliveryAddress).isDisplayed();
			
		}
		
		public boolean isBillingAddressVisible() {
			return driver.findElement(billingAddress).isDisplayed();
			
		}
		
		
		public void enterComment(String comment) {
			driver.findElement(commentTextArea).sendKeys(comment);
			
		}
		
		public void clickPlaceOrder(){
			
			driver.findElement(placeOrderBtn).click();
			
		}
	
	
	}


