package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupDetailsPage {
	 WebDriver driver;
	    WebDriverWait wait;
	    
	    
	    
	    // Locators
	    By titleMr = By.id("id_gender1");
	    By password = By.id("password");
	    By days = By.id("days");
	    By months = By.id("months");
	    By years = By.id("years");
	    By newsletter = By.id("newsletter");
	    By offers = By.id("optin");
	    By firstName = By.id("first_name");
	    By lastName = By.id("last_name");
	    By address = By.id("address1");
	    By country = By.id("country");
	    By state = By.id("state");
	    By city = By.id("city");
	    By zip = By.id("zipcode");
	    By mobile = By.id("mobile_number");
	    By createAccountBtn = By.xpath("//button[text()='Create Account']");

	    By successMessage = By.xpath("//b[text()='Account Created!']");
	    
	 // Constructor
	    public SignupDetailsPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    // Actions
	    
	    public void fillDetailsForm(String pass, String fname, String lname, String addr, String stateVal,
                String cityVal, String zipCode, String phone) {
	    	
	    	driver.findElement(titleMr).click();
	    	driver.findElement(password).sendKeys(pass);
	    	
	    	
	    	new Select(driver.findElement(days)).selectByValue("4");
	    	new Select(driver.findElement(months)).selectByValue("11");
	    	new Select(driver.findElement(years)).selectByValue("2002");
	    	
	    	
	    	driver.findElement(newsletter).click();
	    	driver.findElement(offers).click();
	    	
	    	 driver.findElement(firstName).sendKeys(fname);
	         driver.findElement(lastName).sendKeys(lname);
	         driver.findElement(address).sendKeys(addr);
	         new Select(driver.findElement(country)).selectByVisibleText("India");
	         driver.findElement(state).sendKeys(stateVal);
	         driver.findElement(city).sendKeys(cityVal);
	         driver.findElement(zip).sendKeys(zipCode);
	         driver.findElement(mobile).sendKeys(phone);
	
	    }
	    
	    
	    public void ClickCreateAccount() {
	    	driver.findElement(createAccountBtn).click();
	    }
	    
	    public boolean isAccountCreated() {
	    	return driver.findElement(successMessage).isDisplayed();
	    }
}
