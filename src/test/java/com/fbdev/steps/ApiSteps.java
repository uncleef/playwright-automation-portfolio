package com.fbdev.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

public class ApiSteps {

    private Response response;

    @When("I send a GET request to {string}")
    public void getApiCall(String api) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get(api);
    }

    @When("I send a POST request to {string}")
    public void postApiCall(String api) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType("application/json")
                .body("{\"title\": \"test\", \"body\": \"test body\", \"userId\": 1}")
                .when()
                .post(api);
    }

    @Then("the status is {int}")
    public void checkStatus(int status) {
        response.then()
                .statusCode(status);
    }

    @Then("the body is not null")
    public void checkBody() {
        response.then()
                .body("size()", greaterThan(0));
    }

    @Then("the title is not null")
    public void checkTitle() {
        response.then()
                .body("title", notNullValue());
    }
}
