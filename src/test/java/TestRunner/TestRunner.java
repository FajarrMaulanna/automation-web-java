package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue= {"StepDef"},
        plugin ={"pretty","json:target/cucumber.json","html:target/HTML_report.html"})
public class TestRunner {
}
