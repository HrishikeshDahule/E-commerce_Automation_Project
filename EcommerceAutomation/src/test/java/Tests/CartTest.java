package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.SearchPage;

public class CartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        test = extent.createTest("Add To Cart Test");

        try {
            // Navigate to Products page
            HomePage home = new HomePage(driver);
            home.clickProducts();
            test.info("Navigated to Products page.");

            // Search for a product
            SearchPage search = new SearchPage(driver);
            search.enterSearchTerm("Tshirt");
            search.submitSearch();
            test.info("Searched for product: Tshirt.");

            // Add first product to cart
            CartPage cart = new CartPage(driver);
            cart.ClickAddtoCartFirstProduct();
            test.info("Clicked Add to Cart on first product.");

            // Verify add to cart confirmation
            Assert.assertTrue(cart.isAddedToCartMessageDisplayed(), "Add to cart confirmation not visible.");
            test.pass("Add to cart confirmation message is displayed successfully.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
