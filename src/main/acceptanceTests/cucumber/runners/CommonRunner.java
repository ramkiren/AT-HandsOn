package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty:target/cucumber/cucumber.txt"
        },
        features = "src/main/acceptanceTests/cucumber/features",
        glue = {"steps"},monochrome = true
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CommonRunner {
}
