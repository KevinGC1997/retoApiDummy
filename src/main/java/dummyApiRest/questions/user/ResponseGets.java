package dummyApiRest.questions.user;

import dummyApiRest.models.user.responseAllUser.ResponseAllUser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseGets implements Question<ResponseAllUser> {

    @Override
    public ResponseAllUser answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ResponseAllUser.class);
    }
    public static ResponseGets was(){
        return new ResponseGets();
    }
}
