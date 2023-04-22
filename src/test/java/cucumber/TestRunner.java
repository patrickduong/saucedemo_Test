package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/"
        , glue = {"steps","cucumber"}
        ,
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber_report.json",
                "junit:target/cucumber-reports/Cucumber_report.xml",
                "html:target/cucumber-reports/cucumber-report.html"},
        monochrome = true

)
public class TestRunner {

}
