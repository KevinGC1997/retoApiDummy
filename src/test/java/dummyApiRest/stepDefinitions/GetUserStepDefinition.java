package dummyApiRest.stepDefinitions;

import dummyApiRest.tasks.user.GetUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class GetUserStepDefinition {
    private EnvironmentVariables enviromentVariables;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = enviromentVariables.optionalProperty("restApi.baseurl")
                .orElse("https://dummy.restapiexample.com/api/v1");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint {string}")
    public void iConsumeTheEndpoint(String endpoint) {
        user.attemptsTo(
                GetUser.on(endpoint)
        );
    }
}
