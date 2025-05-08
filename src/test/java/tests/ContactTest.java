package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactPage;
import utils.CustomMethods;

public class ContactTest extends BaseTest {

    ContactPage contactPage;

    @BeforeClass
    public void setupContactPage() {contactPage = new ContactPage(driver);}

    @Test (priority = 0)
    public void navigateToContactPage(){
        contactPage.navigateToContact();
    }

    @Test (priority = 1)
        public void verifyAllRequiredFieldErrorMessages() {
            contactPage.submitForm();

            Assert.assertEquals(contactPage.getFirstNameError(), "First name is required");
            Assert.assertEquals(contactPage.getLastNameError(), "Last name is required");
            Assert.assertEquals(contactPage.getEmailError(), "Email is required");
            Assert.assertEquals(contactPage.getSubjectError(), "Subject is required");
            Assert.assertEquals(contactPage.getMessageError(), "Message is required");
        }

        @Test (priority = 2)
        public void fillContactFormWithRandomData() {
            String firstName = CustomMethods.getRandomFirstName();
            String lastName = CustomMethods.getRandomLastName();
            String email = CustomMethods.getRandomEmail();
            String message = CustomMethods.getRandomMessage();

            contactPage.fillContactForm(firstName, lastName, email, message);
            contactPage.submitForm();

            String actualSuccessMsg = contactPage.getSuccessMessage();
            String expectedMsg = "Thanks for your message! We will contact you shortly.";

            Assert.assertEquals(actualSuccessMsg.trim(), expectedMsg, "Success message did not match.");


        }

        @Test (priority = 3)
        public void goHome() {
            contactPage.navigateToHome();
        }
}

