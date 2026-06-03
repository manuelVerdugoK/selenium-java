package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckPage;

public class CheckboxTest extends BaseTests{
    CheckPage page;
    @BeforeMethod
    void setupPage() { page = new CheckPage(driver, wait);}

    @Test
    void firstCheckboxTest_positiveCase_haveIsSelectedState() {
        page.goToPage();
        page.selectFirstCheckbox();
        Assert.assertTrue(page.verifyFirstCheckbox());
    }

    @Test
    void secondCheckboxTest_positiveCase_haveIsSelectedState() {
        page.goToPage();
        Assert.assertTrue(page.verifySecondCheckbox());
    }

    @Test
    void firstCheckboxTest_positiveCase_isNotSelected() {
        page.goToPage();
        Assert.assertFalse(page.verifyFirstCheckbox());
    }

    @Test
    void secondtCheckboxTest_positiveCase_isNotSelected() {
        page.goToPage();
        page.selectSecondCheckbox();
        Assert.assertFalse(page.verifySecondCheckbox());
    }
}
