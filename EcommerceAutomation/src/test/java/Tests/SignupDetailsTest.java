package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SignupDetailsPage;
import Pages.SignupPage;

public class SignupDetailsTest extends BaseTest {

    @Test
    public void testFullSignupFlow() {
        test = extent.createTest("Full Signup Flow Test");

        try {
            // Step 1: Navigate to Signup/Login page
            HomePage home = new HomePage(driver);
            home.clickSignupLogin();
            test.info("Navigated to Signup/Login page.");

            // Fill initial signup form
            SignupPage signup = new SignupPage(driver);
            signup.fillSignUpForm("Rushi Dahule", "Dahule1234@gmail.com");
            test.info("Filled signup form with name and email.");

            signup.clickSignupButton();
            test.info("Clicked Signup button to proceed to details form.");

            // Step 2: Fill signup details form
            SignupDetailsPage detailsPage = new SignupDetailsPage(driver);
            detailsPage.fillDetailsForm(
                    "Rushi@123",        // password
                    "Rushi",            // first name
                    "Dahule",           // last name
                    "123 Auto Street",  // address
                    "Maharashtra",      // state
                    "Nagpur",           // city
                    "440001",           // zip
                    "9876543210"        // mobile
            );
            test.info("Filled signup details form.");

            detailsPage.ClickCreateAccount();
            test.info("Clicked Create Account button.");

            Assert.assertTrue(detailsPage.isAccountCreated(), "Account creation failed!");
            test.pass("Account created successfully.");
        } catch (Exception e) {
            test.fail("Signup test failed due to exception: " + e.getMessage());
            Assert.fail("Exception during signup flow: " + e.getMessage());
        }
    }
}
