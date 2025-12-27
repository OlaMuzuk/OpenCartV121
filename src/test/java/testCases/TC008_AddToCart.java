package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC008_AddToCart extends BaseClass {

    @Test(groups = {"Master"})
    public void verify_add_to_cart(){

        logger.info("****** Starting TC008_AddToCart*******");

        try {
            //Search product
            HomePage hp=new HomePage(driver);
            hp.enterSearchText("MacBook");
            hp.clickSearch();
            hp.clickOnMacBook();

            //Product page
            ProductPage pp=new ProductPage(driver);
            pp.clickAddToCart();

            //Validation
            String actualMessage = pp.getSuccessMessage();
            Assert.assertTrue(actualMessage.contains("Success: You have added MacBook to your shopping cart!"), "Add to cart success message not displayed");


        }catch (Exception e){
            Assert.fail("Test failed due exception: " + e.getMessage());
        }

        logger.info("**** Finished TC008_AddToCartTest****");






    }






}
