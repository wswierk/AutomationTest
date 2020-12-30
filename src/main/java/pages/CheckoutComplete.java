package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutComplete {
    @FindBy(className = "pony_express") private WebElement ponyExpress;
    private WebDriver driver;

    public CheckoutComplete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPage(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url + "/checkout-complete.html"));
        wait.until(ExpectedConditions.visibilityOf(ponyExpress));
    }
}
