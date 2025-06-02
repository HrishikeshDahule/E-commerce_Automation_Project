package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;

public class LogoutTest extends BaseTest {
    
    @Test
    public void testLogoutFunctionality() {
        test = extent.createTest("Logout Functionality Test");
        
        try {
            HomePage home = new HomePage(driver);
            home.clickSignupLogin();
            test.info("Navigated to Signup/Login page.");
            
            LoginPage login = new LoginPage(driver);
            login.fillLoginForm("hrishitest@email.com", "123456");
            login.clickLoginButton();
            test.info("Logged in with valid credentials.");
            
            LogoutPage logoutpage = new LogoutPage(driver);
            logoutpage.clickLogout();
            test.info("Clicked logout.");
            
            String currentUrl = driver.getCurrentUrl();
            test.info("Current URL after logout: " + currentUrl);
            
            Assert.assertTrue(logoutpage.isBackOnLoginPage(), "Logout failed, user not redirected to login page.");
            test.pass("User successfully logged out and redirected to login page.");
        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
