package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.SearchPage;

public class CartRemoveTest extends BaseTest {

    @Test
    public void verifyCartRemoveFunctionality() {
        test = extent.createTest("Verify Cart Remove Functionality");

        try {
            HomePage home = new HomePage(driver);
            home.clickProducts();
            test.info("Navigated to Products page.");

            SearchPage search = new SearchPage(driver);
            search.enterSearchTerm("tshirt");
            search.submitSearch();
            test.info("Searched for product: tshirt");

            CartPage cart = new CartPage(driver);
            cart.ClickAddtoCartFirstProduct();
            Assert.assertTrue(cart.isAddedToCartMessageDisplayed(), "Add to Cart popup not shown");
            test.pass("Product added to cart successfully.");

            cart.clickViewCart();
            Assert.assertTrue(cart.isProductVisibleInCart(), "Product is not visible in the Cart.");
            test.pass("Product is visible in the cart.");

            cart.clickDeleteProduct();
            Assert.assertTrue(cart.isCartEmpty(), "Cart is not empty after product removal.");
            test.pass("Product removed and cart is empty.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
