package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class updateTicket {
    private Response response;

    @BeforeAll
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9090;
    }

    @BeforeEach
    public void clearResponse() {
        response = null;
    }

    @Given("I am on the ticket update page")
    public void givenIAmOnTicketUpdatePage() {
        // This step is included for consistency with the Cucumber feature file
        // You can skip this step in your test class
    }


    @When("I fill in the following update details:")
    public void iFillInTheFollowingUpdateDetails() {
    }

    @And("I submit the update form")
    public void iSubmitTheUpdateForm() {
    }

    @Then("I should see the message for update message {string}")
    public void iShouldSeeTheMessageForUpdateMessage(String arg0) {
    }
}
