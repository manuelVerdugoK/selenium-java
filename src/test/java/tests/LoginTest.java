package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTests {
    LoginPage loginPage;

    @BeforeMethod
    void setupPage(){
        loginPage = new LoginPage(driver, wait);
    }

    @Test
    void loginTest_positiveCase_redirectToNextPage(){
        loginPage.goToSite();
        loginPage.login("tomsmith","SuperSecretPassword!");
        Assert.assertTrue(loginPage.getUrl().contains("secure"));
    }
    @Test
    void loginTest_negativeCase_keepSameSite(){
        loginPage.goToSite();
        loginPage.login("janeDoe","pass_doe");
        Assert.assertEquals(loginPage.getUrl(), LoginPage.LOGIN_URL);
    }
}
