package testCases;

import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC005_LogoutTest  extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_logout_registration() {

       logger.info("***** Starting TC005_AccountLogoutTest******");

        try{
            //Home Page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();


            //Login Page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            //Logout
            MyAccountPage ap = new MyAccountPage(driver);
            ap.clickLogout();
            Assert.assertTrue(ap.isAccountLogoutPresent(),
                    "Logout failed; Account Logout page not displayed");


        }catch (Exception e){
            Assert.fail();

        }
        logger.info("*****Finished TC005_AccountLogoutTest*******");



    }
}
