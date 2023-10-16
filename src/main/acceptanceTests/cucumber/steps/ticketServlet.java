package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ticketServlet {

    private Response response;
    @Test
    @Given("the Ticket Details API is available")
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9090;
    }
    @Test
    @When("I send a GET request to the API")
    public void sendGETRequest() {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/ticketDetails");
    }
    @Test
    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int expectedStatusCode) {
        response.then()
                .statusCode(expectedStatusCode);
    }
    @Test
    @Then("the response should contain JSON data")
    public void verifyResponseContainsJsonData() {
        response.then()
                .contentType(ContentType.JSON)
                .body(
                        "$", hasSize(greaterThan(0))
                );
    }
}
