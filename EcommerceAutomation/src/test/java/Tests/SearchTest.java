package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SearchPage;

public class SearchTest extends BaseTest {
    
    @Test(priority = 1)
    public void testProductSearch() {
        test = extent.createTest("Valid Product Search Test");
        
        HomePage home = new HomePage(driver);
        home.clickProducts();
        test.info("Navigated to Products page.");
        
        SearchPage search = new SearchPage(driver);
        search.enterSearchTerm("T Shirt");
        test.info("Entered search term: T Shirt");
        
        search.submitSearch();
        test.info("Submitted the search form.");
        
        Assert.assertTrue(search.isResultsDisplayed(), "Search result header not displayed");
        test.pass("Search result header is displayed.");
        
        Assert.assertTrue(search.anyProductContains("shirt"), "No product title contains 'shirt'");
        test.pass("At least one product title contains 'shirt'.");
    }
    
    @Test(priority = 2)
    public void testInvalidSearch() {
        test = extent.createTest("Invalid Product Search Test");
        
        HomePage home = new HomePage(driver);
        home.clickProducts();
        test.info("Navigated to Products page.");
        
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchTerm("InvalidProduct123");
        test.info("Entered invalid search term: InvalidProduct123");
        
        searchPage.submitSearch();
        test.info("Submitted the search form.");
        
        Assert.assertTrue(searchPage.isNoProductFoundVisible(), "Product list is not empty for invalid search.");
        test.pass("No product found message is displayed for invalid search.");
    }
}
