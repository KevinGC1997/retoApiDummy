package dummyApiRest.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/dummyFeatures/",
        glue = "dummyApiRest.stepDefinitions",
        tags = "@PostUser or @GetUser or @PutUser or @DeleteUser or @GetAllUser",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class dummyApiRunner {
}
