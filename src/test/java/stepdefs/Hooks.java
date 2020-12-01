package stepdefs;

import io.cucumber.java.After;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;
    public Hooks () {
        driver = WebDriverManager.getDriver();
    }

    @After
    public void afterScenarioRemove() {
        try{
            Thread.sleep(1000);
        } catch (Exception exception){

        }
        WebDriverManager.closeDriver();

    }
}
