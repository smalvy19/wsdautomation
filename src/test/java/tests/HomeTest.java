package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class HomeTest extends BaseTest {

    @Test(priority = 0)
    public void testProductFilteringByCategoryAndBrand() {
        HomePage homePage = new HomePage(driver);

        homePage.applyCategoryFilter();
        homePage.applyBrandFilter();
        homePage.scrollToTop();


        Assert.assertTrue(homePage.isClawHammerDisplayed(), "'Claw Hammer' product not found after applying filters.");

    }
}
