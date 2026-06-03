package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;


public class DropdownTest extends BaseTests{

    DropdownPage page;

    @BeforeMethod(alwaysRun = true)
    void setupPage () { page = new DropdownPage(driver, wait );}

    @Test(groups = "smoke")
    void verifyPageIsUp(){
        page.goToPage();
        Assert.assertEquals(page.getPageTitle(), "The Internet");
    }

    @Test
    void selectOption_positiveCase_firstOptionEsSelected(){
        page.goToPage();
        page.selectByValue(1);
        Assert.assertEquals(
                page.verifyIsSelected(),
                "Option 1"
                );
    }
}
