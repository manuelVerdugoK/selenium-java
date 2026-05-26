import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
public class PomLoginTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @BeforeMethod
    void setuo(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver, wait);
    }
    @AfterMethod
    void tearDown(){
        driver.quit();
        driver = null;
        wait = null;
        loginPage = null;
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
