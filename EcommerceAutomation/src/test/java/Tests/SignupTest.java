package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SignupPage;

public class SignupTest extends BaseTest {

    @Test(dataProvider = "signupData")
    public void testSignup(String name, String email, boolean expectedSuccess) {
        test = extent.createTest("Signup Test with email: " + email);

        try {
            // Navigate to signup/login page
            HomePage home = new HomePage(driver);
            home.clickSignupLogin();
            test.info("Navigated to Signup/Login page.");

            SignupPage signup = new SignupPage(driver);
            signup.fillSignUpForm(name, email);
            test.info("Filled signup form with Name: " + (name.isEmpty() ? "[empty]" : name) + ", Email: " + (email.isEmpty() ? "[empty]" : email));

            // HTML5 validation check (empty fields)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isNameValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", driver.findElement(By.xpath("//input[@data-qa='signup-name']")));
            boolean isEmailValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", driver.findElement(By.xpath("//input[@data-qa='signup-email']")));

            if (!isNameValid || !isEmailValid) {
                test.warning("Validation blocked submission: Required field is empty.");
                Assert.assertFalse(expectedSuccess, "Expected failure due to empty fields, but test expected success.");
                test.pass("Test passed due to expected validation block.");
                return;
            }

            // Click signup button
            signup.clickSignupButton();
            test.info("Clicked Signup button.");

            if (expectedSuccess) {
                Assert.assertTrue(signup.isSignupSuccessful(), "Expected signup to succeed, but it failed.");
                test.pass("Signup succeeded as expected.");
            } else {
                Assert.assertTrue(signup.isSignupErrorDisplayed(), "Expected signup to fail with error, but no error message shown.");
                test.pass("Signup failed as expected and error message displayed.");
            }
        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @DataProvider(name = "signupData")
    public Object[][] getData() {
        return new Object[][] {
            {"Hrishi Dahule", "rushi4112@email.com", true},  // Valid - use unique email each run
            {"Hrishi Dahule", "hrishitest@email.com", false}, // Existing email
            {"", "uniqueemail@email.com", false},             // Empty name
            {"Valid Name", "", false}                          // Empty email
        };
    }
}
