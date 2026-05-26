package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPage {
    WebDriver driver;
    WebDriverWait wait;

    public static final String PAGE_URL = "https://the-internet.herokuapp.com/checkboxes";
    public final By inputCheckbox1 = By.xpath("//*[@id='checkboxes']/input[1]");
    public final By inputCheckbox2 = By.xpath("//*[@id='checkboxes']/input[2]");
    public CheckPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToPage(){
        driver.get(PAGE_URL);
    }

    public boolean verifyIsChecked(By input){
        return driver.findElement(input).isSelected();
    }
    public void selectChechbox(By input){
        driver.findElement(input).click();
    }

}
