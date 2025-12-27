package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC007_Search  extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void veriry_search(){
        logger.info("***** Starting TC_007_SearchTest ******");

       try{
           //Home Page
           HomePage hp = new HomePage(driver);
           hp.enterSearchText("&&&&&&");
           hp.clickSearch();

           Assert.assertTrue(hp.isNotProductMessageDisplayed(),"No product warning message is not displayed");


       }catch (Exception e){
           Assert.fail("Test failed dueto exception: " + e.getMessage());
       }


logger.info("****** Finished TC007_SearchNoResultTest ******");




    }


}
