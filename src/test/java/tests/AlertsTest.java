package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;


public class AlertsTest extends BaseTests {
    AlertsPage page;

    @BeforeMethod
    void setupPage(){ page = new AlertsPage(driver, wait);}

    @Test
    void simpleAlert_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickSimpleAlert();
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You successfully clicked an alert");
    }

    @Test
    void confirmAlert_pressingAccept_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickConfirmAlert();
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You clicked: Ok");
    }
    @Test
    void confirmAlert_pressingCancel_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickConfirmAlert();
        page.dismisslAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You clicked: Cancel");
    }
    @Test
    void textRequestAlert_withoutText_pressAccept_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickTextRequestAlert();
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You entered:");
    }
    @Test
    void textRequestAlert_withoutText_pressCancel_positiveCase_textChangedCorrectly(){
        page.goToPage();
        page.clickTextRequestAlert();
        page.dismisslAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You entered: null");
    }
    @Test
    void textRequestAlert_havingText_pressAccept_positiveCase_textChangedCorrectly(){
        String textToSend = "Test";
        page.goToPage();
        page.clickTextRequestAlert();
        page.typeInPrompt(textToSend);
        page.acceptAlert();
        Assert.assertEquals(page.getTextDisplayed(),"You entered: "+ textToSend);
    }
}
