package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    public Hooks() {
        driver = WebDriverManager.getDriver();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println(scenario.getStatus());
    }

}

