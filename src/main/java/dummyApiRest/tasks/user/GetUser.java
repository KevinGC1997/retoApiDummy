package dummyApiRest.tasks.user;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static dummyApiRest.utils.Global.idUserGlobal;

public class GetUser implements Task {
    private final String endpoint;

    public GetUser(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(endpoint+"/"+idUserGlobal);
        int status = 0;
        while (status != 200){
            actor.attemptsTo(
                    Get.resource(endpoint+"/"+idUserGlobal).with(
                            requestSpecification -> requestSpecification
                                    .contentType(ContentType.JSON)
                    )
            );
            status = SerenityRest.lastResponse().getStatusCode();
            System.out.println(status);

        }
    }
    public static GetUser on(String endpoint){
        return Instrumented.instanceOf(GetUser.class).withProperties(endpoint);
    }
}
