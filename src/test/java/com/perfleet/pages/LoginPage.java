package com.perfleet.pages;
import com.perfleet.utilities.ConfigurationReader;
import com.perfleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id= "prependedInput")
    public WebElement usernameField;

    @FindBy(id= "prependedInput2")
    public WebElement passwordField;

    @FindBy(id ="_submit")
    public WebElement loginBtn;

    @FindBy(xpath ="//div[.='Invalid user name or password.']")
    public WebElement invalidMessage;

    @FindBy(xpath = "//p[normalize-space(text())='Wrong username or password.']")
    public WebElement errorMessageText;

    @FindBy(xpath = "//p[@class='warning throttledMsg']")
    public WebElement warningMessage;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotPasswordBtn;

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameOrEmail;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestBtn;

    @FindBy(xpath = "//div[@class='alert alert-warn']")
    public WebElement warningMessage2;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[@class='custom-checkbox__text']")
    public WebElement rememberMeBtn;

    

    public void loginAsUserType(String userType){

        String password = "";
        String username = "";

        if (userType.equalsIgnoreCase("driver")) {
            username = ConfigurationReader.getProperty("driver_username");
            password = ConfigurationReader.getProperty("driver_password");
        }
        else if (userType.equalsIgnoreCase("sales manager")) {
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        }
        else if (userType.equalsIgnoreCase("store manager")) {
            username = ConfigurationReader.getProperty("store_manager_username");
            password = ConfigurationReader.getProperty("store_manager_password");
        }

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    public void loginWithCredentials(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }


    public String getPageTitle(){
        return Driver.getDriver().getTitle();
    }

    public String getinvalidMessage(){
        return invalidMessage.getText();
    }

    public void gotoLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
}


