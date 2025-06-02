package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By addToCartButton = By.xpath("(//a[text()='Add to cart'])[1]");
    By addedToCartPopup = By.xpath("//h4[contains(text(),\"Added!\")]");
    By viewCartBtn = By.xpath("//u[text()=\"View Cart\"]");
    By cartProductName = By.xpath("//a[contains(text(),\"Men Tshirt\")]");
    By deleteButton = By.xpath("//a[@class=\"cart_quantity_delete\"]");
    By emptyCartTxt =  By.xpath("//span[@id=\"empty_cart\"]//b");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds wait
    }

    public void ClickAddtoCartFirstProduct() {
       driver.findElement(addToCartButton).click();
    }

    public boolean isAddedToCartMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addedToCartPopup)).isDisplayed();
    }
    public void clickViewCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
		
	}
    
    public boolean isProductVisibleInCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductName)).isDisplayed();

	}
    
    public void clickDeleteProduct() {
    	wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
		
	}
    
    public boolean isCartEmpty() {
    	
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartTxt)).isDisplayed();
	}
}
