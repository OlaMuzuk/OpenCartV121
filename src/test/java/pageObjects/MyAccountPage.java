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

    @FindBy(xpath = "//h1[normalize-space()= 'Account Logout']") //added it 2 year after
    WebElement msgAcauntLogaut;

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

    public boolean isAccountLogoutPresent() {
        try {
            return msgAcauntLogaut.isDisplayed();
        }catch (Exception e){
            return false;
        }


    }

}
