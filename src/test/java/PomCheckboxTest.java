import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckPage;

import java.time.Duration;

public class PomCheckboxTest {

    WebDriver driver;
    WebDriverWait wait;
    CheckPage page;

    @BeforeMethod
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        page = new CheckPage(driver, wait);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
        driver = null;
        wait = null;
        page = null;
    }

    @Test
    void firstCheckboxTest_positiveCase_haveIsSelectedState() {
        page.goToPage();
        page.selectChechbox(page.inputCheckbox1);
        Assert.assertTrue(page.verifyIsChecked(page.inputCheckbox1));
    }

    @Test
    void secondCheckboxTest_positiveCase_haveIsSelectedState() {
        page.goToPage();
        Assert.assertTrue(page.verifyIsChecked(page.inputCheckbox2));
    }

    @Test
    void firstCheckboxTest_positiveCase_isNotSelected() {
        page.goToPage();
        Assert.assertFalse(page.verifyIsChecked(page.inputCheckbox1));
    }

    @Test
    void secondtCheckboxTest_positiveCase_isNotSelected() {
        page.goToPage();
        page.selectChechbox(page.inputCheckbox2);
        Assert.assertFalse(page.verifyIsChecked(page.inputCheckbox2));
    }
}
