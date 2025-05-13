package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountHeaderMessage;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") //step6 added
    WebElement logoutButton;

    public boolean isMyAccountPageIsDisplayed() {
        try {
            return (myAccountHeaderMessage.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }


}
