package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {

    @FindBy(className = "cart_contents_container") private WebElement waitForPage;
    @FindBy(className = "inventory_item_name") private WebElement basketItemName;
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
    public String getBasketItemName() {
        return basketItemName.getText();
    }
}
