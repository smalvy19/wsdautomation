package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[normalize-space()='Hammer']")
    WebElement hammerCategoryCheckbox;

    @FindBy(xpath = "//label[normalize-space()='MightyCraft Hardware']")
    WebElement mightyBrandCheckbox;

    @FindBy(xpath = "//h5[normalize-space()='Claw Hammer']")
    WebElement clawHammerProduct;


    public void applyCategoryFilter() {
        scrollToElement(hammerCategoryCheckbox);  // Scroll to the category checkbox
        if (!hammerCategoryCheckbox.isSelected()) {
            hammerCategoryCheckbox.click();
        }
    }

    public void applyBrandFilter() {
        scrollToElement(mightyBrandCheckbox);  // Scroll to the brand checkbox
        if (!mightyBrandCheckbox.isSelected()) {
            mightyBrandCheckbox.click();
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);"); // Scroll to top
    }

    public boolean isClawHammerDisplayed() {
        try {
            return clawHammerProduct.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
