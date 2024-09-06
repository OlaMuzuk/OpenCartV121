package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }
     @FindBy(xpath = "//h2[normalize-space()='My Account']")    //MyAccount Page heading
    WebElement msgHeading;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")    //added in step 6
    WebElement lnkLogout;

    public boolean isMyAccountPageExist(){
        try{
            return(msgHeading.isDisplayed());
        } catch (Exception e){
            return false;
        }
    }

    public void clickLogout(){
        lnkLogout.click();
    }








}
