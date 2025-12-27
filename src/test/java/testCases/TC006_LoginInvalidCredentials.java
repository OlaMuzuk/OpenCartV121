package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC006_LoginInvalidCredentials extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_login_registration(){

        logger.info("***** Starting TC006_LoginTestInvalidCredential *****");

        try{
            //Home page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //Login Page
            LoginPage lp =new LoginPage(driver);
            lp.setEmail("invalidemail@test.com");
            lp.setPassword("InvalidPassword123");
            lp.clickLogin();

            //Assertion - verify warning message
            String actualWarning = lp.getWarningMessage();
            String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";

            Assert.assertEquals(actualWarning, expectedWarning, "Warning message is not displayed or incorrect");


        }catch (Exception e){
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("****** Finished TC006_LoginTestInvalidCredentials");





    }








}
