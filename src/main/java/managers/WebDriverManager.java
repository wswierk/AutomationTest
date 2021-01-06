package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    private static WebDriver driver;
    private static final String chromeDriverProperty = "webdriver.chrome.driver";
    private static final String chromeDriverPath = "driver/chromedriver.exe";

    public static WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private static WebDriver createDriver() {
        System.setProperty(chromeDriverProperty, chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
    }

}
