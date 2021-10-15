package co.com.sofka.runner.reset_research;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/reset_search/reset_search.feature"},
        glue = {"co.com.sofka.stepdefinition.reset_search"},
        tags = "not @ignore"
)
public class ResetResearchCucumberTest {
}
