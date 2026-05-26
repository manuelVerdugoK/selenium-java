
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class InitialLoginTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }
    @Test
    void loginPage_casoPositivo_credencialesCorrectas(){
        driver.get("https://the-internet.herokuapp.com/login");

        var userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        var userPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        var loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".radius")));
        if (userInput.isDisplayed() && userPassword.isDisplayed() && loginButton.isDisplayed()){
            userInput.sendKeys("tomsmith");
            userPassword.sendKeys("SuperSecretPassword!");
            loginButton.submit();
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }
    @Test
    void loginPage_casoNegativo_loginCredencialesIncorrectas() {
        driver.get("https://the-internet.herokuapp.com/login");
        String oldUrl;
        var userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        var userPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        var loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".radius")));

        oldUrl = driver.getCurrentUrl();
        if (userInput.isDisplayed() && userPassword.isDisplayed() && loginButton.isDisplayed()) {
            userInput.sendKeys("janeDoe");
            userPassword.sendKeys("JaneDoe");
            loginButton.submit();
        }
        var flashFlag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        Assert.assertEquals(driver.getCurrentUrl(), oldUrl);

    }
}
