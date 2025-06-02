package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By contactUsLink = By.xpath("//a[contains(text(),'Contact us')]");
    private By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private By testCasesLink = By.xpath("//a[contains(text(),'Test Cases')]");
    private By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    private By logoutLink = By.xpath("//a[contains(text(),\"Logout\")]");
    // Actions
    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }

    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }

    public void clickProducts() {
        driver.findElement(productsLink).click();
    }

    public void clickCart() {
        driver.findElement(cartLink).click();
    }

    public void clickTestCases() {
        driver.findElement(testCasesLink).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(loggedInText).isDisplayed();
    }
    
    public void clcikLogout() {
    	
    	driver.findElement(logoutLink).click();
		
	}
}
