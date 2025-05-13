package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testbase.BaseClass;

public class AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_account_registration() {

        logger.info("***** Starting AccountRegistrationTest *****");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("Clicked on MyAccount Link...");
            homePage.clickRegister();
            logger.info("Clicked on Register Link...");

            logger.info("Providing customer details...");
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            accountRegistrationPage.setFirstName(generateFirstAndLastName());
            accountRegistrationPage.setLastName(generateFirstAndLastName());
            //accountRegistrationPage.setEmailAddress("julieBrown123$@gmail.com");
            accountRegistrationPage.setEmailAddress(generateRandomEmail()); //randomly generated email
            accountRegistrationPage.setTelephone(generatePhoneNumber());

            String password = generatePassword();
            accountRegistrationPage.setPassword(password);
            accountRegistrationPage.setConfirmPassword(password);

            accountRegistrationPage.setPrivacyPolicy();
            accountRegistrationPage.clickContinueButton();

            logger.info("Validating expected message...");
            String confirmMessage = accountRegistrationPage.getConfirmationMessage();
            Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
        } catch (Exception e) {
            logger.error("Test failed...", e);
            logger.debug("Debug logs...");
            Assert.fail("\"Account registration test failed due to exception.\"");
        }

        logger.info("***** Finished AccountRegistrationTest *****");
    }


}
