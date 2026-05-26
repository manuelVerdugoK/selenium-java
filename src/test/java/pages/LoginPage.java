package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public static final String LOGIN_URL = "https://the-internet.herokuapp.com/login";

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.className("radius");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void goToSite(){
        driver.get(LOGIN_URL);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void login(String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).submit();
    }

}
