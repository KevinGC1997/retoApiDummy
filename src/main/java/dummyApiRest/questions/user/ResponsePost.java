package dummyApiRest.questions.user;

import dummyApiRest.models.user.responseUser.ResponseUserPost;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponsePost implements Question<ResponseUserPost> {

    @Override
    public ResponseUserPost answeredBy(Actor actor) {

        return SerenityRest.lastResponse().as(ResponseUserPost.class);
    }
    public static ResponsePost was(){
        return new ResponsePost();
    }
}
