package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;


public class LoginDataDrivenTestCase extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")
    //getting the data provider from different class
    public void verify_login_dataDrivenTesting(String email, String pass, String expected_result) {

        logger.info("***** Starting TC_003_LogInDataDrivenTesting *****");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(email);
            loginPage.setPassword(pass);
            loginPage.clickLogin();

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageIsDisplayed();

        /*
        Data is valid - login success - test pass - logout
                      -  login failed - test fail

        Data is invalid - login success - test fail - logout
                        - login failed - test pass
         */


            if (expected_result.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    macc.clickLogoutButton();
                    Assert.assertTrue(true); // login success, as expected
                } else {
                    Assert.fail("Login failed for valid data"); // login should've succeeded

                }
            } else if (expected_result.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    macc.clickLogoutButton();
                    Assert.fail("Login succeeded for invalid data"); // login should've failed
                } else {
                    Assert.assertTrue(true); // login failed, as expected
                }
            }

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("***** Finished TC_003_LogInDataDrivenTesting *****");
    }
}
