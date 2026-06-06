package com.fbdev.steps;

import com.fbdev.pages.DynamicControlsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DynamicControlsSteps {

    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(ScenarioContext.getPage());

    @Given("I navigate to the dynamic controls page")
    public void navigateToDynamicControlsPagePage() {
        dynamicControlsPage.navigate();
    }

    @When("I press the remove button")
    public void removeCheckbox() {
        dynamicControlsPage.removeCheckbox();
    }

    @When("I press the add button")
    public void addCheckbox() {
        dynamicControlsPage.addCheckbox();
    }

    @When("I click the checkbox")
    public void clickTheCheckbox() {
        dynamicControlsPage.clickCheckbox();
    }

    @Then("the checkbox should be {string}")
    public void checkIfCheckboxIsVisible(String expectedStatus) {
        if (expectedStatus.equals("visible")) {
            Assertions.assertTrue(dynamicControlsPage.isCheckboxPresent());
        } else if (expectedStatus.equals("not visible")) {
            Assertions.assertFalse(dynamicControlsPage.isCheckboxPresent());
        }
    }

    @Then("the checkbox expected status is {string}")
    public void checkCheckbox(String expectedStatus) {
        if (expectedStatus.equals("checked")) {
            Assertions.assertTrue(dynamicControlsPage.isCheckboxChecked());
        } else if (expectedStatus.equals("unchecked")) {
            Assertions.assertFalse(dynamicControlsPage.isCheckboxChecked());
        }
    }

    @When("I click the enable button")
    public void clickEnableButton() {
        dynamicControlsPage.enableText();
    }

    @When("I click the disable button")
    public void clickDisableButton() {
        dynamicControlsPage.disableText();
    }

    @Then("text is {string}")
    public void isTextEnabled(String expectedStatus) {
        if (expectedStatus.equals("enabled")) {
            Assertions.assertFalse(dynamicControlsPage.isEnableButtonVisible(),
                    "Assertion failed - Enable button is visible, but not expected when text is: " + expectedStatus);
            Assertions.assertTrue(dynamicControlsPage.isDisableButtonVisible(),
                    "Assertion failed - Disable button is not visible, but expected when text is: " + expectedStatus);
            Assertions.assertFalse(dynamicControlsPage.isTextDisabled(),
                    "Assertion failed - Text expected to be enabled");
        } else if (expectedStatus.equals("disabled")) {
            Assertions.assertTrue(dynamicControlsPage.isEnableButtonVisible(),
                    "Assertion failed - Enable button is not visible, but expected when text is: " + expectedStatus);
            Assertions.assertFalse(dynamicControlsPage.isDisableButtonVisible(),
                    "Assertion failed - Enable button is visible, but not expected when text is: " + expectedStatus);
            Assertions.assertTrue(dynamicControlsPage.isTextDisabled(),
                    "Assertion failed - Text expected to be disabled");
        }
    }

}
