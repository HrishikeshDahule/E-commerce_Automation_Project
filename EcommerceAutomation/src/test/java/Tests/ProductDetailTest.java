package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchPage;

public class ProductDetailTest extends BaseTest {

    @Test
    public void testProductDetailsDisplayedCorrectly() {
        test = extent.createTest("Product Detail Display Test");

        try {
            driver.get("https://automationexercise.com");
            test.info("Navigated to homepage.");

            HomePage home = new HomePage(driver);
            home.clickProducts();
            test.info("Clicked on Products.");

            SearchPage search = new SearchPage(driver);
            search.enterSearchTerm("tshirt");
            search.submitSearch();
            Assert.assertTrue(search.isResultsDisplayed(), "Search results not displayed.");
            test.info("Search results displayed for 'tshirt'.");

            ProductDetailPage detail = new ProductDetailPage(driver);
            Assert.assertTrue(detail.firstimagedisplayed(), "First product image not displayed.");
            test.info("First product image is displayed.");

            detail.clickfirstviewproduct();
            test.info("Clicked on first product to view details.");

            Assert.assertFalse(detail.getProductName().isEmpty(), "Product name not displayed.");
            Assert.assertFalse(detail.getCategory().isEmpty(), "Product category not displayed.");
            Assert.assertFalse(detail.getPrice().isEmpty(), "Product price not displayed.");
            Assert.assertFalse(detail.getAvailability().isEmpty(), "Availability not displayed.");
            Assert.assertFalse(detail.getCondition().isEmpty(), "Condition not displayed.");
            Assert.assertFalse(detail.getBrand().isEmpty(), "Brand not displayed.");
            test.pass("All product details are displayed correctly.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
