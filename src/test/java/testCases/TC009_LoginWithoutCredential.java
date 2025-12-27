package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC009_LoginWithoutCredential extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_login_without_credential(){

        logger.info("***** Starting TC009_LoginTestWithoutCredential");

        try {
            //Home Page
            HomePage hp= new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //Login Page
            LoginPage lp= new LoginPage(driver);
            lp.clickLogin();

            //Assertion - verify warning message
            String actualWarning= lp.getWarningMessage();
            String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";

            Assert.assertEquals(actualWarning, expectedWarning, "Warning is not displayed or incorrect");



            }catch (Exception e){
            Assert.fail("Test failed due to exception: " + e.getMessage());


        }


        logger.info("***** Finished TC009_LoginWithoutCredential");



    }







}
