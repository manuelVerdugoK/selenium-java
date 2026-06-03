package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTests {
    LoginPage page;

    @BeforeMethod(alwaysRun = true)
    void setupPage(){
        page = new LoginPage(driver, wait);
    }

    @Test(groups = "smoke")
    void verifyPageIsUp(){
        page.goToPage();
        Assert.assertEquals(page.getPageTitle(), "The Internet");
    }

    @Test
    void loginTest_positiveCase_redirectToNextPage(){
        page.goToPage();
        page.login("tomsmith","SuperSecretPassword!");
        Assert.assertTrue(page.getUrl().contains("secure"));
    }
    @Test
    void loginTest_negativeCase_keepSameSite(){
        page.goToPage();
        page.login("janeDoe","pass_doe");
        Assert.assertEquals(page.getUrl(), LoginPage.LOGIN_URL);
    }
}
