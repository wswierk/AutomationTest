package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(css = "form input#user-name") private WebElement userNameInput;
    @FindBy(css = "form input#password") private WebElement passwordInput;
    @FindBy(id = "login-button") private WebElement loginButton;
    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);


    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void waitForPage() {
       WebDriverWait wait =  new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
       wait.until(ExpectedConditions.visibilityOf(userNameInput));

    }
    public void inputUserName(String login) {
        userNameInput.clear();
        userNameInput.sendKeys(login);
    }
    public void inputPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void clickButtonLogin() {
        loginButton.click();
    }

}
