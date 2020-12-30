package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.WebDriverManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith (Cucumber.class)
@CucumberOptions
        (
                features="src/test/resources/features/",
                glue={"stepdefs"},
                plugin = {"pretty"}
        )

public class TestRunner {

    @AfterClass
    public static void closeWebDriver() {
        WebDriverManager.closeDriver();
    }


}
