package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;


    public void setEmail(String email) {
        emailAddressField.sendKeys(email);
    }

    public void setPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }


}
