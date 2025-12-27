package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC004_Search extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_search_with_valid_product(){

        logger.info("***** Starting TC004_SearchPositiveTest*****");

        try{
            HomePage hp= new HomePage(driver);
            hp.enterSearchText("MacBook");
            hp.clickSearch();

            Assert.assertTrue(hp.getSearchResultCount() >0, "Search result are not displayed");


        }catch (Exception e){
            Assert.fail("Test failed due to exception: " + e.getMessage());

            }

        logger.info("***** Finished TC008_SearchPositiveTest");


    }





}
