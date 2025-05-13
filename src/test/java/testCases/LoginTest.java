package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;

public class LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_login() {

        logger.info("***** Starting TC_002_LoginTest *****");


        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(p.getProperty("email"));
        loginPage.setPassword(p.getProperty("password"));
        loginPage.clickLogin();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Boolean targetPage = myAccountPage.isMyAccountPageIsDisplayed();

        Assert.assertEquals(targetPage, true, "Login failed"); //Assert.assertTrue(targetPage);


        logger.info("***** Finished TC_002_LoginTest *****");

    }


}
