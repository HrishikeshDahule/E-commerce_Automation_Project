package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SearchPage;

public class InvalidSearchTest extends BaseTest {

    @Test
    public void testInvalidSearch() {
        test = extent.createTest("Invalid Search Test - Search for non-existent product");

        try {
            HomePage home = new HomePage(driver);
            home.clickProducts();
            test.info("Clicked on Products page.");

            SearchPage searchpage = new SearchPage(driver);
            searchpage.enterSearchTerm("Shoes");
            searchpage.submitSearch();
            test.info("Entered invalid search term 'Shoes' and submitted.");

            boolean noProductMessageDisplayed = searchpage.isNoProductFoundVisible();
            Assert.assertTrue(noProductMessageDisplayed, "No products found message was not displayed!");
            test.pass("No products found message displayed as expected for invalid search.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
