package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {

    WebDriver driver;
    WebDriverWait wait;
    Select select;

    public static final String URL = "https://the-internet.herokuapp.com/dropdown";
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;

    }
    public void goToPage(){
        driver.get(URL);
    }

    public void selectByValue(int value){
        select = new Select(driver.findElement(dropdown));;
        select.selectByIndex(value);
    }

    public String verifyIsSelected(){
        return select.getFirstSelectedOption().getText();
    }
}
