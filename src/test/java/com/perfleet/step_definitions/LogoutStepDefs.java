package com.perfleet.step_definitions;

import com.perfleet.pages.DashboardPage;
import com.perfleet.pages.HomePage;
import com.perfleet.pages.LoginPage;
import com.perfleet.utilities.BrowserUtils;
import com.perfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefs {

    public LoginPage loginPage = new LoginPage();

    public HomePage homePage = new HomePage();

    public DashboardPage dashboardPage = new DashboardPage();


    @When("User is on the login page")
    public void userIsOnTheLoginPage() {

        Driver.getDriver().get("https://qa.perfleet.com/user/login");
        BrowserUtils.sleep(2);
    }

    @When("User logins with {string} and {string}")
    public void userLoginsWithAnd(String username, String password) {
        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginBtn.click();
    }


    @Then("User should be backward to login page")
    public void userShouldBeBackwardToLoginPage() {

        String expectedTitle = "Login";
        Assert.assertEquals(expectedTitle,loginPage.getPageTitle());

    }


    @When("User clicks step back button")
    public void userClicksStepBackButton() {

        Driver.getDriver().navigate().back();
        BrowserUtils.sleep(2);
    }

    @Then("User shouldn't be able on the dashboard")
    public void userShouldnTBeAbleOnTheDashboard() {

        String expectedUrl = "https://qa.perfleet.com/user/login";
        Assert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl());

    }

    @When("User closes all tabs")
    public void userClosesAllTabs() {

        Driver.closeDriver();
        BrowserUtils.sleep(1);

    }

    @And("User opens browser and tries to go dashboard")
    public void userOpensBrowserAndTriesToGoDashboard() {

        Driver.getDriver().get("https://qa.perfleet.com");
        BrowserUtils.sleep(5);
    }

    @Then("User shouldn't go to dashboard")
    public void userShouldnTGoToDashboard() {

        String expectedUrl = "https://qa.perfleet.com/user/login";
        Assert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl());
    }

    @When("User don't use mouse or keyboard for {int} minutes")
    public void user_don_t_use_mouse_or_keyboard_for_minutes(Integer int1) {
        BrowserUtils.sleep(180);
    }
    @Then("User should be on to login page")
    public void user_should_be_on_to_login_page() {
        String expectedTitle = "Login";
        Assert.assertEquals(expectedTitle,loginPage.getPageTitle());
    }




}
