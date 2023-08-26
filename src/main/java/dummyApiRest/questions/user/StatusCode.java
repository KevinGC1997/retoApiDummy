package dummyApiRest.questions.user;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StatusCode implements Question<Object> {
    @Override
    public Object answeredBy(Actor actor) {

        return SerenityRest.lastResponse().statusCode();
    }
    public static StatusCode was(){
        return new StatusCode();
    }
}
