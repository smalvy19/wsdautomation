package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Contact']")
    WebElement contactButton;

    @FindBy(xpath = "//input[@value='Send']")
    WebElement sendButton;

    @FindBy(xpath = "//div[contains(text(),'First name is required')]")
    WebElement firstNameErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Last name is required')]")
    WebElement lastNameErrorMessage;

    @FindBy (xpath = "//div[contains(text(),'Email is required')]")
    WebElement emailErrorMessage;

    @FindBy (xpath = "//div[contains(text(),'Subject is required')]")
    WebElement subjectErrorMessage;

    @FindBy (xpath = "//div[@id='message_alert']")
    WebElement messageErrormessage;

    @FindBy (id= "first_name")
    WebElement firstNameField;

    @FindBy (id= "last_name")
    WebElement lastNameField;

    @FindBy (id= "email")
    WebElement emailField;

    @FindBy (id = "subject")
    WebElement subjectField;

    @FindBy (xpath = "//textarea[@id='message']")
    WebElement messageField;

    @FindBy (xpath = "//div[@role='alert']" )
    WebElement successMessage;

    @FindBy (xpath = "//a[normalize-space()='Home']")
    WebElement homeButton;

    public void navigateToContact() {
        contactButton.click();

    }

    public void navigateToHome() {
        homeButton.click();

    }

    public void submitForm() {
        sendButton.click();
    }

    public String getFirstNameError() {
        return firstNameErrorMessage.getText();
    }

    public String getLastNameError() {
        return lastNameErrorMessage.getText();
    }

    public String getEmailError() {
        return emailErrorMessage.getText();
    }

    public String getSubjectError() {
        return subjectErrorMessage.getText();
    }

    public String getMessageError() {
        return messageErrormessage.getText();
    }

    public void enterFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void selectRandomSubject() {
        Select subjectDropdown = new Select(subjectField);
        List<WebElement> options = subjectDropdown.getOptions();


        int startIndex = options.get(0).getText().toLowerCase().contains("select") ? 1 : 0;
        int randomIndex = new Random().nextInt(options.size() - startIndex) + startIndex;

        subjectDropdown.selectByIndex(randomIndex);
    }

    public void enterMessage(String message) {
        messageField.clear();
        messageField.sendKeys(message);
    }

    public void fillContactForm(String firstName, String lastName, String email, String message) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        selectRandomSubject();
        enterMessage(message);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

}
