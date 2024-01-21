package co.com.booking.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(publish = true,
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "co.com.booking.steps",
        tags = "@Regression",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {
}
