package com.fbdev.steps;

import com.fbdev.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(ScenarioContext.getPage());

    @Given("I navigate to the login page")
    public void navigateToLoginPage() {
        loginPage.navigate();
    }

    @When("I login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see the success message")
    public void verifySuccess() {
        assertTrue(loginPage.isLoginSuccessful());
    }

    @Then("I should see an error message")
    public void verifyError() {
        assertTrue(loginPage.isErrorDisplayed());
    }
}
