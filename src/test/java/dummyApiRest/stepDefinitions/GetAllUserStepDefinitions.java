package dummyApiRest.stepDefinitions;

import dummyApiRest.questions.user.ResponseGets;
import dummyApiRest.questions.user.StatusCode;
import dummyApiRest.tasks.user.GetAllUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllUserStepDefinitions {

    private EnvironmentVariables enviromentVariables;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = enviromentVariables.optionalProperty("restApi.baseurl")
                .orElse("https://dummy.restapiexample.com/api/v1");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint all users {string}")
    public void iConsumeTheEndpointAllUsers(String endpoint) {
        user.attemptsTo(
                GetAllUser.on(endpoint)
        );
    }
    @Then("I can validate the response service {int} and message all user {string}")
    public void iCanValidateTheResponseServiceAndMessageAllUser(Integer statuscode, String message) {
        user.should(
                seeThat(
                        "The response was", StatusCode.was(), equalTo(statuscode)
                ),
                seeThat(
                        "The message is successfully",
                        res -> ResponseGets.was().answeredBy(user).getMessage(),
                        equalTo(message)
                )
        );
    }
}
