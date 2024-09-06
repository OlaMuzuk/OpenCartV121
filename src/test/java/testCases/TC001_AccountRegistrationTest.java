package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void verify_account_registration() {

        logger.info("******* Starting TC001_AccountRegistrationTest******");  //LOg4J2

        try {

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount Link");
            hp.clickRegister();
            logger.info("Clicked on TRegister Link");


            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("Providing customer details...");
            regpage.setFirstName(randomeString().toUpperCase());
            regpage.setLastName(randomeString().toUpperCase());
            regpage.setEmail(randomeString() + "@gmail.com");
            regpage.setTxtTelephone(randomeNumber());

            String password = randomAlphaNumeric();

            regpage.setPassword(password);
            regpage.setTxtConfirmPwd(password);


            regpage.setPrivacyPolicy();
            regpage.clickContinue();

            logger.info("Validating expected message...");
            String confmsg = regpage.getConfirmationMsg();
            if (confmsg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test failed....");
                logger.debug("Debug logs....");
                Assert.assertTrue(false);
            }

           // Assert.assertEquals(confmsg, "Your Account Has Been Created!??");

        } catch (Exception e) {

            Assert.fail();
        }
        logger.info("****Finished TC001_AccountRegistrationTest******");
    }
}





























