package dummyApiRest.stepDefinitions;

import dummyApiRest.questions.user.ResponseDelete;
import dummyApiRest.questions.user.StatusCode;
import dummyApiRest.tasks.user.DeleteUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteUserStepDefinition {
    private EnvironmentVariables enviromentVariables;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = enviromentVariables.optionalProperty("restApi.baseurl")
                .orElse("https://dummy.restapiexample.com/api/v1");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint delete {string}")
    public void iConsumeTheEndpointDelete(String endpoint) {
        user.attemptsTo(
                DeleteUser.on(endpoint)
        );
    }
    @Then("I can validate the response service {int} and message deleted {string}")
    public void iCanValidateTheResponseServiceAndMessageDeleted(Integer statuscode, String message) {
        user.should(
                seeThat(
                        "The response was", StatusCode.was(), equalTo(statuscode)
                ),
                seeThat(
                        "The message is successfully",
                        res -> ResponseDelete.was().answeredBy(user).getMessage(),
                        equalTo(message)
                )
        );
    }
}
