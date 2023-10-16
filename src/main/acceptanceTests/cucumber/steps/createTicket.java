package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class createTicket {
    private Response response;

    @Given("I am on the ticket creation page")
    public void iAmOnTheTicketCreationPage() {
        // You can implement navigation to the ticket creation page here if applicable.
        // In a real application, this step may depend on your web application structure.
        // You can use a headless browser like Selenium for UI testing or simply make a GET request.
    }

    @When("I fill in the following details:")
    public void iFillInTheFollowingDetails(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> ticketData = dataTable.asMaps();

        String subject = ticketData.get(0).get("Subject");
        String description = ticketData.get(0).get("Description");
        String priority = ticketData.get(0).get("Priority");


        response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParams("subject", subject, "description", description, "priority", priority)
                .when()
                .post("http://localhost:9090/createticket"); // Replace with your actual URL

    }

//    @And("I submit the form")
//    public void iSubmitTheForm() {
//        // The form submission is handled in the "When" step.
//    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {
        // Validate the response message
        String responseBody = response.getBody().asString();
        Assert.assertEquals(expectedMessage, responseBody);
        response=null;
    }
//    @Given("I am on the ticket creation page")
//    public void iAmOnTheTicketCreationPage() {
//        // Implement navigation to the ticket creation page if applicable.
//        // In a real application, this step may depend on your web application structure.
//    }

    @When("I fill in the following details with missing or invalid information:")
    public void iFillInTheFollowingDetailsWithMissingOrInvalidInformation(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> ticketData = dataTable.asMaps();

        String subject = ticketData.get(0).get("Subject");
        String description = ticketData.get(0).get("Description");
        String priority = ticketData.get(0).get("Priority");


            response = RestAssured.given()
                    .contentType(ContentType.URLENC)
                    .formParams("subject", subject, "description", description, "priority", priority)
                    .when()
                    .post("http://localhost:9090/createticket"); // Replace with your actual URL
    }
    @And("I submit the form")
    public void iSubmitTheForm() {
        // The form submission is handled in the "When" step.
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        // Validate the response for an error message
        String responseBody = response.getBody().asString();
        Assert.assertEquals(expectedErrorMessage, responseBody);
    }
}
