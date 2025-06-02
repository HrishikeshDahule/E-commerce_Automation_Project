package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
    // Locators
    private By searchInput = By.xpath("//input[@id='search_product']");
    private By submitSearch = By.xpath("//button[@id='submit_search']");
    private By resultsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By productTitles = By.xpath("//div[@class='productinfo text-center']/p");
    private By noProductMessage = By.xpath("//*[contains(text(),'No products found')]");
    private By viewCartbutton  = By.xpath("//u[normalize-space()='View Cart']");

 // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
 // Actions
    

    public void enterSearchTerm(String term) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys(term);
    }

    public void submitSearch() {
        driver.findElement(submitSearch).click();
    }
    public boolean isResultsDisplayed() {
        return driver.findElement(resultsHeader).isDisplayed();
    }
    public boolean anyProductContains(String keyword) {
        return driver.findElements(productTitles)
                     .stream()
                     .peek(e -> System.out.println("Found product: " + e.getText()))
                     .anyMatch(e -> e.getText().toLowerCase().contains(keyword.toLowerCase()));
    }
    
    public boolean isNoProductFoundVisible() {
        By noProductText = By.xpath("(//div[@class=\"row\"])[2]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noProductText)).isDisplayed();
    }

    public void clickViewCart() {
        driver.findElement(viewCartbutton).click();
    }

}
