import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;

import java.time.Duration;

public class PomAlertsTest {
    WebDriver driver;
    WebDriverWait wait;
    AlertsPage page;

    @BeforeMethod
    void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        page = new AlertsPage(driver, wait);
    }
    @AfterMethod
    void tearDown(){
        driver.quit();
        driver = null;
        wait = null;
        page = null;
    }

    @Test
    void simpleAlert_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickButton(page.simpleAlertButton);
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You successfully clicked an alert");
    }

    @Test
    void confirmAlert_pressingAccept_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickButton(page.confirmAlertButton);
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You clicked: Ok");
    }
    @Test
    void confirmAlert_pressingCancel_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickButton(page.confirmAlertButton);
        page.dismisslAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You clicked: Cancel");
    }
    @Test
    void textRequestAlert_withoutText_pressAccept_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickButton(page.textRequestedAlertButton);
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You entered:");
    }
    @Test
    void textRequestAlert_withoutText_pressCancel_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickButton(page.textRequestedAlertButton);
        page.dismisslAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You entered: null");
    }
    @Test
    void textRequestAlert_havingText_pressAccept_positiveCase_textChangedCorrectly(){
        String textToSend = "Test";
        page.goToPage();
        page.clickButton(page.textRequestedAlertButton);
        page.typeInPrompt(textToSend);
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You entered: "+ textToSend);
    }
}
