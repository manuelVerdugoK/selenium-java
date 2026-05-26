import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.time.Duration;

public class PomDropdownTest {

    WebDriver driver;
    WebDriverWait wait;
    DropdownPage page;

    @BeforeMethod
    void setup() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        driver = new ChromeDriver(option);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        page = new DropdownPage(driver, wait);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
        driver = null;
        wait = null;
        page = null;
    }

    @Test
    void selectOption_positiveCase_firstOptionEsSelected(){
        page.goToPage();
        page.selectByValue(1);
        Assert.assertEquals(
                page.verifyIsSelected(),
                "Option 1"
                );
    }
}
