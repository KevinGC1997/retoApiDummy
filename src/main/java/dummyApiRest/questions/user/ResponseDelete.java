package dummyApiRest.questions.user;

import dummyApiRest.models.user.responseDelete.ResponseUserDelete;
import dummyApiRest.models.user.responseUser.ResponseUserPost;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseDelete implements Question<ResponseUserDelete> {
    @Override
    public ResponseUserDelete answeredBy(Actor actor) {

        return SerenityRest.lastResponse().as(ResponseUserDelete.class);
    }
    public static ResponseDelete was(){
        return new ResponseDelete();
    }
}
