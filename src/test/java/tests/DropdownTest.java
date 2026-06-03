package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;


public class DropdownTest extends BaseTests{

    DropdownPage page;

    @BeforeMethod
    void setupPage () { page = new DropdownPage(driver, wait );}

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
