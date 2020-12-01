package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasketPage {

    @FindBy(className = "cart_contents_container") private WebElement waitForPage;
    @FindBy(className = "inventory_item_name") private List<WebElement> basketItemName;
    @FindBy(className = "checkout_button") private WebElement buttonCheckout;
    @FindBy(className = "cart_button") private WebElement removeButton;
    private WebDriver driver;


    public BasketPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForPage(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url + "/cart.html"));
        wait.until(ExpectedConditions.visibilityOf(waitForPage));
    }
    public String getBasketItemName() { return basketItemName.get(0).getText(); }
    public void clickCheckoutButton() {
        buttonCheckout.click();
    }
    public void navigate(String url) { driver.get(url + "/cart.html"); }
    public void clickRemoveButton() { removeButton.click(); }
    public int isItemNameDisplayed() { return basketItemName.size(); }
}
