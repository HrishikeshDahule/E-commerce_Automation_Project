package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	// Locators
	By nameInput = By.name("name");
	By emailInput = By.name("email");	
	By subjectInput = By.name("subject");
	By messageTextarea  = By.id("message");
	By submitBtn = By.name("submit");
    By successMessage = By.xpath("//div[@class='status alert alert-success']");
    By uploadFileInput = By.xpath("//input[@name=\"upload_file\"]");
	
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Actions
    public void fillContactForm(String name, String email, String subject, String message) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(subjectInput).sendKeys(subject);
        driver.findElement(messageTextarea).sendKeys(message);
    }
    
    public void uploadFile(String filePath) {
		driver.findElement(uploadFileInput)
      .sendKeys(filePath);
    }
	
    public void clickSubmit() {
        driver.findElement(submitBtn).click();
        driver.switchTo().alert().accept(); // Accept alert popup
    }
	
	public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
