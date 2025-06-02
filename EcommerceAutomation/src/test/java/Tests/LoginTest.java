package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password, boolean expectedSuccess) {
        // Start test in report for this test method iteration
        test = extent.createTest("Login Test with email: " + email);

        try {
            // Navigate to login page
            HomePage home = new HomePage(driver);
            home.clickSignupLogin();
            test.info("Navigated to Signup/Login page.");

            LoginPage login = new LoginPage(driver);
            login.fillLoginForm(email, password);
            test.info("Filled login form with email: " + email + ", password: " + (password.isEmpty() ? "[empty]" : "[provided]"));

            // HTML5 field validation (empty email/password)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isEmailValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", driver.findElement(By.name("email")));
            boolean isPasswordValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", driver.findElement(By.name("password")));

            if (!isEmailValid || !isPasswordValid) {
                test.warning("Validation blocked submission: One or more required fields are empty.");

                System.out.println("Validation blocked submission: Required field is empty.");
                Assert.assertFalse(expectedSuccess, "Expected failure due to empty fields, but test expected success.");
                test.pass("Test passed due to expected validation block.");

                return;
            }

            // Click login button
            login.clickLoginButton();

            // Success and failure handling
            if (expectedSuccess) {
                Assert.assertTrue(login.isLoginSuccessful(), "Expected login to succeed, but it failed.");
                test.pass("Login successful as expected.");
            } else {
                Assert.assertTrue(login.isLoginErrorDisplayed(), "Expected login to fail with error, but no error message shown.");
                test.pass("Login failed as expected and error message displayed.");
            }
        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"hrishitest@email.com", "123456", true},       // Valid
            {"invaliduser@example.com", "invalidpass", false},  // Invalid
            {"", "somepassword", false},                     // Empty email
            {"validuser@example.com", "", false},            // Empty password
        };
    }
}
