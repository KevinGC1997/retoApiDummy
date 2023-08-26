package dummyApiRest.stepDefinitions;

import dummyApiRest.questions.user.ResponsePost;
import dummyApiRest.questions.user.StatusCode;
import dummyApiRest.tasks.user.DeleteUser;
import dummyApiRest.tasks.user.GetUser;
import dummyApiRest.tasks.user.PostUser;
import dummyApiRest.tasks.user.PutUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static dummyApiRest.utils.Global.idUserGlobal;

public class PostUserStepDefinition {
    private EnvironmentVariables enviromentVariables;
    Actor user= Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = enviromentVariables.optionalProperty("restApi.baseurl")
                .orElse("https://dummy.restapiexample.com/api/v1");
        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the endpoint {string} and I send the user information name {string}, salary {string} age {string}")
    public void setUser(String endpoint, String name, String salary, String age) {
        user.attemptsTo(
                PostUser.Post(endpoint, name, salary, age)
        );
    }
    @Then("I can validate the response service {int} and message {string}")
    public void iCanValidateTheResponseServiceAndMessage(Integer response, String message) {
        user.should(
                seeThat(
                        "The response was", StatusCode.was(), equalTo(response)
                ),
                seeThat(
                        "The message is successfully",
                        res -> ResponsePost.was().answeredBy(user).getMessage(),
                        equalTo(message)
                )
        );
    }

}
