package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

    WebDriver driver;
    WebDriverWait wait;
    public static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    public static final By simpleAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    public static final By confirmAlertButton = By.xpath("//button[text()='Click for JS Confirm']");
    public static final By textRequestedAlertButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By textDisplayed = By.id("result");

    public AlertsPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void goToPage(){
        driver.get(URL);
    }
    public void clickButton(By button) {
        // For example: pass public simpleAlertButton like arg.
        wait.until(ExpectedConditions.visibilityOfElementLocated(button)).click();
    }
    public String getTextDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textDisplayed)).getText();
    }

    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    public void  dismisslAlert(){
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }
    public void typeInPrompt(String text){
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys(text);
    }
}
