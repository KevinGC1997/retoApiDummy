package dummyApiRest.tasks.user;

import dummyApiRest.models.user.UserModel;
import dummyApiRest.questions.user.BuildDataUser;
import dummyApiRest.questions.user.ResponsePost;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static dummyApiRest.utils.Global.idUserGlobal;

public class PostUser implements Task {

    private final String endpoint;
    private final String name;
    private final String salary;
    private final String age;

    public PostUser(String endpoint, String name, String salary, String age) {
        this.endpoint = endpoint;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        UserModel userModel =actor.asksFor(BuildDataUser.was(name, salary, age));

        int status = 0;
        while (status != 200){
            actor.attemptsTo(
                    Post.to(endpoint).with(
                            requestSpecification -> requestSpecification
                                    .contentType(ContentType.JSON)
                                    .body(userModel)
                    )
            );
            status = SerenityRest.lastResponse().getStatusCode();
            System.out.println(status);
        }
        idUserGlobal = ResponsePost.was().answeredBy(actor).getData().id;
        System.out.println("varibale creada "+idUserGlobal);
    }
    public static PostUser Post(String endpoint, String name, String salary, String age){
        return Instrumented.instanceOf(PostUser.class).withProperties(endpoint, name, salary, age);
    }
}
