package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPage {
    WebDriver driver;
    WebDriverWait wait;

    public static final String PAGE_URL = "https://the-internet.herokuapp.com/checkboxes";
    private final By inputCheckbox1 = By.xpath("//*[@id='checkboxes']/input[1]");
    private final By inputCheckbox2 = By.xpath("//*[@id='checkboxes']/input[2]");

    public CheckPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToPage(){
        driver.get(PAGE_URL);
    }
    private boolean verifyIsChecked(By input){
        return driver.findElement(input).isSelected();
    }
    public boolean verifyFirstCheckbox(){
        return verifyIsChecked(inputCheckbox1);
    }
    public boolean verifySecondCheckbox(){
        return verifyIsChecked(inputCheckbox2);
    }

    private void selectChechbox(By input){
        driver.findElement(input).click();
    }
    public void selectFirstCheckbox(){
        selectChechbox(inputCheckbox1);
    }
    public void selectSecondCheckbox(){
        selectChechbox(inputCheckbox2);
    }

}
