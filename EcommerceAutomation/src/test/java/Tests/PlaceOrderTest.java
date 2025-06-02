package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentPage;
import Pages.SearchPage;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void testPlaceOrderSuccessfully() {
        // Start test in report for this test method iteration
        test = extent.createTest("Place Order Test");

        try {
            // Navigate to login page
            HomePage home = new HomePage(driver);
            home.clickSignupLogin();
            test.info("Navigated to Signup/Login page.");

            // Login Page
            LoginPage login = new LoginPage(driver);
            login.fillLoginForm("hrishitest@email.com", "123456");
            login.clickLoginButton();
            test.info("Logged in with valid credentials.");

            // Go to product and search
            home.clickProducts();
            test.info("Navigated to Products page.");

            SearchPage search = new SearchPage(driver);
            search.enterSearchTerm("tshirt");
            search.submitSearch();
            test.info("Searched for product: tshirt");

            CartPage cart = new CartPage(driver);
            cart.ClickAddtoCartFirstProduct();
            Assert.assertTrue(cart.isAddedToCartMessageDisplayed(), "Product not added to cart.");
            test.pass("Product added to cart successfully.");

            cart.clickViewCart();
            Assert.assertTrue(cart.isProductVisibleInCart(), "Product not visible in cart.");
            test.pass("Product visible in cart.");

            // Proceed to Checkout
            CheckoutPage checkout = new CheckoutPage(driver);
            checkout.clickProceedToCheckout();
            Assert.assertTrue(checkout.isDeliveryAddressVisible(), "Delivery Address is Not Visible");
            test.pass("Delivery address visible on checkout.");

            Assert.assertTrue(checkout.isBillingAddressVisible(), "Billing Address is not Visible");
            test.pass("Billing address visible on checkout.");

            checkout.enterComment("Please deliver between 9am to 6pm.");
            test.info("Entered comment for delivery.");

            checkout.clickPlaceOrder();
            test.info("Clicked place order.");

            // Enter Payment Details & Confirm
            PaymentPage payment = new PaymentPage(driver);
            payment.enterPaymentDetails("Hrishi Dahule", "412367858945", "311", "12", "2040");
            payment.clickPayAndConfirmOrder();
            Assert.assertTrue(payment.isOrderSuccessMessageVisible(), "Order Confirmation Message not Displayed");
            test.pass("Order placed and confirmation message displayed successfully.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
