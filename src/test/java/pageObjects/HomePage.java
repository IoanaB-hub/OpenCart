package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount_link;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register_link;

    @FindBy(linkText = "Login")
    WebElement login_link;

    public void clickMyAccount() {
        myAccount_link.click();
    }

    public void clickRegister() {
        register_link.click();
    }

    public void clickLogin() {
        login_link.click();
    }

}
