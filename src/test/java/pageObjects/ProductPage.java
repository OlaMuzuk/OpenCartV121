package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    WebDriver driver;

    public ProductPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    WebElement successMsg;


    public void clickAddToCart(){
        btnAddToCart.click();
    }

    public String getSuccessMessage(){
        return successMsg.getText();
    }








}
