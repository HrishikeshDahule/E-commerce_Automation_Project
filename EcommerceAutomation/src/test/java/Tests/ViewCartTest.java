package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.SearchPage;

public class ViewCartTest extends BaseTest {

    @Test
    public void testViewCart() {
        // Start test in report
        test = extent.createTest("View Cart Test");

        try {
            // Step 1: Navigate to Products and Search for "Tshirt"
            HomePage home = new HomePage(driver);
            home.clickProducts();
            test.info("Navigated to Products page");

            SearchPage search = new SearchPage(driver);
            search.enterSearchTerm("Tshirt");
            search.submitSearch();
            test.info("Searched for 'Tshirt'");

            // Step 2: Add first product to cart
            CartPage cart = new CartPage(driver);
            cart.ClickAddtoCartFirstProduct();
            test.info("Clicked Add to Cart on first product");

            // Step 3: Verify "Added to Cart" popup
            Assert.assertTrue(cart.isAddedToCartMessageDisplayed(), "Add to cart popup not shown.");
            test.pass("Add to cart popup is displayed");

            // Step 4: Click "View Cart"
            cart.clickViewCart();
            test.info("Clicked View Cart");

            // Step 5: Verify product visible in cart
            Assert.assertTrue(cart.isProductVisibleInCart(), "Product not visible in the cart!");
            test.pass("Product is visible in the cart");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
