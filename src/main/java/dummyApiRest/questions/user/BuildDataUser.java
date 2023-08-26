package dummyApiRest.questions.user;

import dummyApiRest.models.user.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BuildDataUser implements Question<UserModel> {

    private final String name;
    private final String salary;
    private final String age;

    public BuildDataUser(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }


    @Override
    public UserModel answeredBy(Actor actor) {

        return UserModel.builder()
                .name(name)
                .salary(salary)
                .age(age)
                .build();
    }

    public static BuildDataUser was(String name, String salary, String age){
        return new BuildDataUser(name, salary, age);
    }
}
