package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PrimerTest {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }


    @Test
    void creteTestDriver(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        var barraBusqueda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        if (barraBusqueda.isDisplayed()){
            barraBusqueda.sendKeys("Selenium");
            barraBusqueda.submit();
        }
    }

    /*
    @Test
    void verificarTitulPaginaBusqueda(){
        driver.get("https://www.google.com");
        var buscar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        if (buscar.isDisplayed()){
            buscar.sendKeys("Selenium");
            buscar.submit();
        }
        assert "Selenium - Buscar con Google".equals(driver.getTitle());
    }
    esto no corre por el detector de bots de google.
     */
}
