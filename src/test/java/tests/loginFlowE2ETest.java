    package tests;

    import org.testng.Assert;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;
    import pages.LoginPage;
    import pages.SecurePage;

    public class loginFlowE2ETest extends BaseTests {

        LoginPage lPage;
        SecurePage sPage;

        @BeforeMethod(alwaysRun = true)
        void setupPage() {
            lPage = new LoginPage(driver, wait);
            sPage = new SecurePage(driver, wait);
        }

        @Test(groups = "e2e")
        void LoginLogoutFlow() {
            lPage.goToPage();
            Assert.assertEquals(lPage.getPageTitle(), "The Internet");
            lPage.login("tomsmith", "SuperSecretPassword!");
            Assert.assertTrue(lPage.getCurrentUrl().contains("secure"));
            sPage.clickLogoutButton();
            Assert.assertTrue(sPage.getCurrentUrl().contains("login"));
        }
    }
