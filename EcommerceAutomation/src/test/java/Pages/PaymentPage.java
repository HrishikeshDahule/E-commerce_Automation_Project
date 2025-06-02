package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
	
	WebDriver driver;
	
	
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
		
		By nameOnCard = By.name("name_on_card");
		By cardNumber = By.name("card_number");
		By cvc = By.name("cvc");
		By expiryMonth = By.name("expiry_month");
		By expiryYear = By.name("expiry_year");
		By payAndConfirmBtn = By.id("submit");
		By successMessage = By.xpath("//p[contains(text(),\"Congratulations! Your order has been confirmed!\")]");
				
		
		  public void enterPaymentDetails(String name, String number, String cvcCode, String month, String year) {
		        driver.findElement(nameOnCard).sendKeys(name);
		        driver.findElement(cardNumber).sendKeys(number);
		        driver.findElement(cvc).sendKeys(cvcCode);
		        driver.findElement(expiryMonth).sendKeys(month);
		        driver.findElement(expiryYear).sendKeys(year);			
		}
		  
		  public void clickPayAndConfirmOrder() {
			  driver.findElement(payAndConfirmBtn).click();

			
		  	}
		  public boolean isOrderSuccessMessageVisible() {
			  return driver.findElement(successMessage).isDisplayed();
			
		}
	}


