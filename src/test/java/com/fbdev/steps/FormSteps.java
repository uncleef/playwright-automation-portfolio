package com.fbdev.steps;

import com.fbdev.pages.FormPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class FormSteps {

    private final FormPage formPage = new FormPage(ScenarioContext.getPage());

    @Given("I navigate to the forgot password page")
    public void navigateToFormPage() {
        formPage.navigate();
    }

    @When("I submit the email {string}")
    public void submitEmail(String email) {
        formPage.submitEmail(email);
    }

    @Then("I should see a confirmation message")
    public void verifyConfirmation() {
        String message = formPage.getConfirmationMessage();
        assertNotNull(message);
        assertFalse(message.isEmpty());
    }

}
