package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	 WebDriver driver;
	    WebDriverWait wait;
	    
	    // Locators

	    
	    By InputName = By.xpath("//input[@data-qa=\"signup-name\"]");
	    By emailInput = By.xpath("//input[@data-qa=\"signup-email\"]");
	    By signupButton = By.xpath("//button[@data-qa='signup-button']");
	    By AccountInText = By.xpath("//b[contains(text(),\"Enter Account Information\")]");
	    By errorMessage = By.xpath("//p[contains(text(),'Email Address already exist!')]");

	    // constructor
	    
	    public SignupPage(WebDriver driver) {
	    	
	    	this.driver = driver;
	    	this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    	
}
	    
	    // Actions 
	    
	   
	    public void fillSignUpForm(String name, String email) {
	    	
	    	driver.findElement(InputName).sendKeys(name);
	    	driver.findElement(emailInput).sendKeys(email);
	    }
	    
	    public void clickSignupButton() {
	        driver.findElement(signupButton).click();
	    }

	    public boolean isSignupSuccessful() {
	        try {
	            return wait.until(ExpectedConditions.visibilityOfElementLocated(AccountInText)).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    public boolean isSignupErrorDisplayed() {
	        try {
	            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	
}
