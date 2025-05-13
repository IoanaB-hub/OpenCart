package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "(//input[@id='input-confirm'])[1]")
    WebElement confirmPassword;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement radioButton_yes;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement confirmationMessage;


    public void setFirstName(String fn) {
        firstName.sendKeys(fn);
    }

    public void setLastName(String ln) {
        lastName.sendKeys(ln);
    }

    public void setEmailAddress(String em) {
        email.sendKeys(em);
    }

    public void setTelephone(String tel) {
        telephone.sendKeys(tel);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
        confirmPassword.sendKeys(pwd);
    }

    public void radioButton() {
        radioButton_yes.click();
    }

    public void setPrivacyPolicy() {
        privacyPolicy.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getConfirmationMessage() {
        try {
            return (confirmationMessage.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }

    }


}
