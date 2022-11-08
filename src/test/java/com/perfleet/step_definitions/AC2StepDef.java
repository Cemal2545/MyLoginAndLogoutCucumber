package com.perfleet.step_definitions;

import com.perfleet.pages.DashboardPage;
import com.perfleet.pages.HomePage;
import com.perfleet.pages.LoginPage;
import com.perfleet.utilities.ConfigurationReader;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class AC2StepDef {

  public LoginPage loginPage = new LoginPage();
  public HomePage homePage = new HomePage();

  public DashboardPage dashboardPage = new DashboardPage();

    @When("The user tries to login with {string} and {string}")
    public void the_user_tries_to_login_with_and(String username, String password) {
      loginPage.loginWithCredentials(username,password);

    }
    @Then("{string} message should be displayed for invalid credentials")
    public void message_should_be_displayed_for_invalid_credentials(String expectedMessage) {
        String actualMessage = loginPage.getinvalidMessage();
      Assert.assertEquals(expectedMessage,actualMessage);
    }

  @When("The field of {string} or {string} is empty")
  public void the_field_of_or_is_empty(String username, String password) {
    loginPage.usernameField.sendKeys(username);
    loginPage.passwordField.sendKeys(password);
    loginPage.loginBtn.click();

  }
  @Then("{string} message should be displayed from any empty field")
  public void message_should_be_displayed_from_any_empty_field(String expectedMessage) {
    String actualMessage = loginPage.usernameField.getAttribute("validationMessage");
    Assert.assertEquals(expectedMessage,actualMessage);
  }

  @Then("{string} message should be displayed from password field")
  public void messageShouldBeDisplayedFromPasswordField(String expectedMessage) {
    String actualMessage = loginPage.passwordField.getAttribute("validationMessage");
    Assert.assertEquals(expectedMessage,actualMessage);

  }

  @When("{string} and {string} fields are empty")
  public void and_fields_are_empty(String username, String password) {
    loginPage.usernameField.sendKeys(username);
    loginPage.passwordField.sendKeys(password);
    loginPage.loginBtn.click();
  }
  @Then("{string} message should be displayed from username field")
  public void message_should_be_displayed_from_username_field(String expectedMessage) {
    String actualMessage = loginPage.usernameField.getAttribute("validationMessage");
    Assert.assertEquals(expectedMessage,actualMessage);
  }


  @When("user enters a {string}")
  public void userEntersA(String password) {
    loginPage.passwordField.sendKeys(password);
  }

  @Then("Then password credentials are shown as bullet points")
  public void thenPasswordCredentialsAreShownAsBulletPoints() {
      Assert.assertEquals("password", loginPage.passwordField.getAttribute("type"));
  }

  @When("User clicks on forgotPassword button")
  public void user_clicks_on_forgot_password_button() {
    loginPage.forgotPasswordBtn.click();
  }
  @Then("User should go to Forgot Password page")
  public void user_should_go_to_forgot_password_page() {
    Assert.assertEquals("Forgot Password", Driver.getDriver().getTitle());
  }

  @When("User is on the Forgot Password Page")
  public void userIsOnTheForgotPasswordPage() {
      Driver.getDriver().navigate().to("https://qa.perfleet.com/user/reset-request");
  }

  @When("User enters  valid username and email")
  public void userEntersValidUsernameAndEmail() {
      loginPage.usernameOrEmail.sendKeys(ConfigurationReader.getProperty("driver_username"));
    loginPage.requestBtn.click();
  }


  @Then("User should change his\\/her password")
  public void userShouldChangeHisHerPassword() throws InterruptedException {

    Assert.assertTrue("Test Failed",loginPage.warningMessage2.getText().contains("Succes"));
  }
  @When("User enters  invalid username and email")
  public void userEntersInvalidUsernameAndEmail() {
    loginPage.usernameOrEmail.sendKeys(ConfigurationReader.getProperty("invalid_username"));
    loginPage.requestBtn.click();
  }

  @Then("User should see There is no active user with username or email address message .")
  public void userShouldSeeThereIsNoActiveUserWithUsernameOrEmailAddressMessage() {
      String wrongUsername = ConfigurationReader.getProperty("invalid_username");
      String expectedResult = "There is no active user with username or email address "+"\""+wrongUsername+"\".";
      String actualResult = loginPage.errorMessage.getText();
      Assert.assertEquals(expectedResult,actualResult);
  }

  @When("User enters nothing")
  public void userEntersNothing() {
      loginPage.usernameOrEmail.sendKeys("");
    loginPage.requestBtn.click();

  }

  @Then("Lütfen bu alanı doldurun. message should be displayed")
  public void lütfenBuAlanıDoldurunMessageShouldBeDisplayed() {

    Assert.assertEquals("Lütfen bu alanı doldurun.",loginPage.usernameOrEmail.getAttribute("validationMessage"));
  }




  @When("User enters his\\/her username and hits enter")
  public void userEntersHisHerUsernameAndHitsEnter() throws InterruptedException {

      loginPage.usernameField.sendKeys(ConfigurationReader.getProperty("driver_username"));
      Thread.sleep(6000);
      loginPage.usernameField.sendKeys(Keys.ENTER);

  }

  @Then("User should be on password field")
  public void userShouldBeOnPasswordField() {
      Assert.assertTrue(loginPage.passwordField.isEnabled());
  }

  @When("User enters credentials and hits enter")
  public void userEntersCredentialsAndHitsEnter() {

    loginPage.usernameField.sendKeys(ConfigurationReader.getProperty("driver_username"));
    loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("driver_password"));
    loginPage.loginBtn.sendKeys(Keys.ENTER);
  }


  @Then("User should be on Dashboard page")
  public void userShouldBeOnDashboardPage() {
    String actualTitle = homePage.getSubtitle();
    String expectedTitle = "Quick Launchpad";
    Assert.assertEquals(expectedTitle,actualTitle);
  }

 // @When("User logins with {string} and {string}")
 // public void userLoginsWithAnd(String username, String password) {
 //     loginPage.usernameField.sendKeys(username);
 //     loginPage.passwordField.sendKeys(password);
 //     loginPage.loginBtn.click();

 // }


 // @Then("User should see his\\/her {string} on right top of the the Dashboard")
 // public void userShouldSeeHisHerOnRightTopOfTheTheDashboard(String expectedName) {
 //   String actualName = dashboardPage.usernameDropdown.getText();
 //   Assert.assertEquals(expectedName,actualName);
 // }



  @When("User logins with {string} and {string} after User should see his\\/her username on right top of the the Dashboard")
  public void userLoginsWithAndAfterUserShouldSeeHisHerUsernameOnRightTopOfTheTheDashboard(String username, String password) throws InterruptedException {
    loginPage.usernameField.sendKeys(username);
    loginPage.passwordField.sendKeys(password);
    loginPage.loginBtn.click();
    Thread.sleep(5000);

    String actualName = dashboardPage.usernameDropdown.getText();
    Assert.assertEquals(username,actualName);
  }

  @When("User enters his\\/her  {string} and {string} on the fields")
  public void userEntersHisHerAndOnTheFields(String username, String password) {
      loginPage.usernameField.sendKeys(username);
      loginPage.passwordField.sendKeys(password);
  }

  @And("User clicks to the the RememberMe button")
  public void userClicksToTheTheRememberMeButton() throws InterruptedException {
      Thread.sleep(2000);
    loginPage.rememberMeBtn.click();
  }

  @And("User clicks the loginbutton")
  public void userClicksTheLoginbutton() throws InterruptedException {
      Thread.sleep(2000);
  loginPage.loginBtn.click();
  }

  @And("User clicks the logout button on the right corner of the page")
  public void userClicksTheLogoutButtonOnTheRightCornerOfThePage() throws InterruptedException {
      Thread.sleep(5000);
    dashboardPage.usernameDropdown.click();
    Thread.sleep(2000);
    dashboardPage.logoutBtn.click();

  }




  @Then("User should be able to see the his\\/her {string} and password typed in the boxes")
  public void userShouldBeAbleToSeeTheHisHerAndPasswordTypedInTheBoxes(String username) {

    Assert.assertEquals("Test failed",username,loginPage.usernameField.getText());
    Assert.assertEquals("Test failed","password", loginPage.passwordField.getAttribute("type"));
  }
}
