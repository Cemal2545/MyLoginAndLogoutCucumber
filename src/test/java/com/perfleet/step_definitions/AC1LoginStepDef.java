package com.perfleet.step_definitions;

import com.perfleet.pages.HomePage;
import com.perfleet.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AC1LoginStepDef {

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.gotoLoginPage();
    }
    @When("The user logs in as a {string}")
    public void the_user_logs_in_as_a(String userType) {

        loginPage.loginAsUserType(userType);
        homePage.waitUntilLoaderScreenDisappear();

    }
    @Then("The user is on the {string} page")
    public void the_user_is_on_the_page(String expectedTitle) {
        String actualTitle = homePage.getSubtitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }



}
