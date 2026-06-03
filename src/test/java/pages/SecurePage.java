package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurePage extends BasePage {
    private static final String URL = "https://the-internet.herokuapp.com/secure";
    private By logoutButton = By.className("icon-signout");

    public SecurePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getBaseUrl() {
        return URL;
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }

}
