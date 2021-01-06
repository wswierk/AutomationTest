package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    @FindBy(className = "checkout_info")
    private WebElement checkoutInfo;

    @FindBy(css = ".form_input#first-name")
    private WebElement inputFirstName;

    @FindBy(css = ".form_input#last-name")
    private WebElement inputLastName;

    @FindBy(css = ".form_input#postal-code")
    private WebElement inputPostalCode;

    @FindBy(css = "[type=submit]")
    private WebElement buttonSubmit;

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPage(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url + "/checkout-step-one.html"));
        wait.until(ExpectedConditions.visibilityOf(checkoutInfo));
    }

    public void inputFirstName(String firstName) {
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        inputPostalCode.clear();
        inputPostalCode.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        buttonSubmit.click();
    }

}
