package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {

    public static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final By simpleAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private static final By confirmAlertButton = By.xpath("//button[text()='Click for JS Confirm']");
    private static final By textRequestedAlertButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By textDisplayed = By.id("result");

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToPage() {
        driver.get(URL);
    }

    private void clickButton(By button) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(button)).click();
    }

    public String getTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textDisplayed)).getText();
    }

    public void clickSimpleAlert() {
        clickButton(simpleAlertButton);
    }

    public void clickConfirmAlert() {
        clickButton(confirmAlertButton);
    }

    public void clickTextRequestAlert() {
        clickButton(textRequestedAlertButton);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void dismisslAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    public void typeInPrompt(String text) {
        wait.until(ExpectedConditions.alertIsPresent()).sendKeys(text);
    }
}
