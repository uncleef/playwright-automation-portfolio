package com.fbdev.steps;

import com.fbdev.pages.UploadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class UploadSteps {

    private final UploadPage uploadPage = new UploadPage(ScenarioContext.getPage());

    @Given("I navigate to the upload page")
    public void navigateToUploadPage() {
        uploadPage.navigate();
    }

    @When("I select from file system the file {string}")
    public void selectFile(String fileName) {
        uploadPage.selectFile(fileName);
    }

    @Then("the selected expected file name is {string}")
    public void checkIfTheSelectedFileIsCorrect(String expectedFileName) {
        String actualFileName = uploadPage.getFileName();
        Assertions.assertEquals(expectedFileName, actualFileName,
                "Assertion Failed - File name expected: " + expectedFileName
                        + ", but it is: " + actualFileName);
    }

    @When("I click the upload button")
    public void uploadFile() {
        uploadPage.uploadFile();
    }

    @Then("file is uploaded")
    public void checkFileUploaded() {
        Assertions.assertTrue(uploadPage.isUploadSuccessful(),
                "Assertion failed - File is not uploaded");
    }

}
