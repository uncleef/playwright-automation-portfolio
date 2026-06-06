package com.fbdev.steps;

import com.fbdev.pages.CheckboxPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckboxSteps {

    private final CheckboxPage checkboxPage = new CheckboxPage(ScenarioContext.getPage());

    @Given("I navigate to the checkbox page")
    public void navigateToCheckboxPage() {
        checkboxPage.navigate();
    }

    @Then("the default status should be Checkbox1:unchecked, Checkbox2: checked")
    public void defaultStatus() {
        Assertions.assertFalse(checkboxPage.isFirstCheckboxChecked());
        Assertions.assertTrue(checkboxPage.isSecondCheckboxChecked());
    }

    @When("I click the first checkbox")
    public void clickFirstCheckBox() {
        checkboxPage.clickCheckbox1();
    }

    @When("I click the second checkbox")
    public void clickSecondCheckBox() {
        checkboxPage.clickCheckbox2();
    }

    @Then("the first checkbox expected status is {string}")
    public void checkFirstCheckbox(String expectedStatus) {
        if(expectedStatus.equals("checked")) {
            Assertions.assertTrue(checkboxPage.isFirstCheckboxChecked());
        } else if(expectedStatus.equals("unchecked")) {
            Assertions.assertFalse(checkboxPage.isFirstCheckboxChecked());
        }
    }

    @Then("the second checkbox expected status is {string}")
    public void checkSecondCheckbox(String expectedStatus) {
        if(expectedStatus.equals("checked")) {
            Assertions.assertTrue(checkboxPage.isSecondCheckboxChecked());
        } else if(expectedStatus.equals("unchecked")) {
            Assertions.assertFalse(checkboxPage.isSecondCheckboxChecked());
        }
    }

}
