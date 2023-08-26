package dummyApiRest.tasks.user;

import dummyApiRest.models.user.UserModel;
import dummyApiRest.questions.user.BuildDataUser;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static dummyApiRest.utils.Global.idUserGlobal;

public class PutUser implements Task {
    private final String endpoint;
    private final String name;
    private final String salary;
    private final String age;

    public PutUser(String endpoint, String name, String salary, String age) {
        this.endpoint = endpoint;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(endpoint+"/"+idUserGlobal);

        UserModel userModel =actor.asksFor(BuildDataUser.was(name, salary, age));

        int status = 0;
        while (status != 200){
            actor.attemptsTo(
                    Put.to(endpoint+"/"+idUserGlobal).with(
                            requestSpecification -> requestSpecification
                                    .contentType(ContentType.JSON)
                                    .body(userModel)
                    )
            );
            status = SerenityRest.lastResponse().getStatusCode();
            System.out.println(status);
        }

    }
    public static PutUser on(String endpoint, String name, String salary, String age){
        return Instrumented.instanceOf(PutUser.class).withProperties(endpoint, name, salary, age);
    }
}
