package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTests {
    LoginPage page;

    @DataProvider(name = "loginData")
    Object[][] loginData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", true},
                {"janeDoe", "pass_doe", false},
                {"tomsmith", "", false},
                {"", "SuperSecretPassword!", false},
                {"tomsmith", "supersecretpassword!", false},
                {"TOMSMITH", "SUPERSECRETPASSWORD!", false},
        };
    }

    @BeforeMethod(alwaysRun = true)
    void setupPage() {
        page = new LoginPage(driver, wait);
    }

    @Test(groups = "smoke")
    void verifyPageIsUp() {
        page.goToPage();
        Assert.assertEquals(page.getPageTitle(), "The Internet");
    }

    @Test(dataProvider = "loginData", groups = "functional")
    void loginTest(String user, String password, Boolean result) {
        page.goToPage();
        page.login(user, password);
        if (result) {
            Assert.assertTrue(page.getUrl().contains("secure"));
        } else {
            Assert.assertEquals(page.getUrl(), LoginPage.LOGIN_URL);
        }
    }
}
