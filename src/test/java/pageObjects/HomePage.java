package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(linkText = "Login" )          //Login link added in steps 5
    WebElement linkLogin;


    @FindBy(xpath = "//input[@placeholder = 'Search']")
    WebElement txtSearch;

    @FindBy(xpath = "//button[@class = 'btn btn-default btn-lg']")
    WebElement btnSearch;

    @FindBy(xpath = "//p[contains(text(), 'There is no product that matches the search criteria.')]")
    WebElement noProductMessage;

    @FindBy(xpath = "//div[@class='product-thumb']")
    List<WebElement> searchResult;

    @FindBy(linkText = "MacBook")
    WebElement productMacBook;


    public void clickMyAccount(){
        lnkMyaccount.click();
    }

    public void clickRegister(){
        lnkRegister.click();
    }

    public void clickLogin(){
        linkLogin.click();
    }


    public void enterSearchText(String text){
        txtSearch.clear();
        txtSearch.sendKeys(text);
    }

    public void clickSearch(){
        btnSearch.click();
    }

    public boolean isNotProductMessageDisplayed(){
        return noProductMessage.isDisplayed();
    }

    public int getSearchResultCount(){
        return searchResult.size();
    }
    public void clickOnMacBook(){
        productMacBook.click();
    }














}
