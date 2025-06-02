package Tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends BaseTest {

    @Test
    public void testContactFormSubmission() {
        test = extent.createTest("Contact Us Form Submission Test");

        try {
            driver.get("https://automationexercise.com");
            test.info("Navigated to https://automationexercise.com");

            HomePage home = new HomePage(driver);
            home.clickContactUs();
            test.info("Clicked Contact Us link.");

            ContactUsPage contact = new ContactUsPage(driver);
            contact.fillContactForm(
                "Hrishi",
                "hrishi@test.com",
                "Test Subject",
                "This is a test message."
            );
            test.info("Filled contact form with test data.");

            // Optional file upload
            contact.uploadFile("C:\\Users\\hp\\OneDrive\\Desktop\\Book1.xlsx");
            test.info("Uploaded file: Book1.xlsx");

            contact.clickSubmit();
            test.info("Clicked Submit button.");

            // submit success message to appear

            Assert.assertTrue(contact.isSuccessMessageDisplayed(), "Success message should be displayed after submission.");
            test.pass("Contact form submitted successfully and success message displayed.");

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
