package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
    private By loginForm = By.xpath("//form[@id='login-form']"); // Update selector as per actual login form
    private By loginButton = By.xpath("//button[contains(text(),'Login')]"); // Alternative login button

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    public boolean isBackOnLoginPage() {
        // Check for URL or presence of a login page element instead of URL only
        String url = driver.getCurrentUrl();
        if(url.contains("/login")) {
            return true;
        }
        // Alternatively check for login form visibility
        return driver.findElements(By.id("login-form")).size() > 0;  // replace with actual login form locator
    }

}
