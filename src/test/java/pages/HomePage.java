package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    @FindBy(className = "inventory_container") private WebElement inventoryContainer;
    @FindBy(className = "inventory_item_name") private List<WebElement> itemName;
    @FindBy(className = "btn_inventory") private List<WebElement> itemButton;
    @FindBy(className = "shopping_cart_badge") private WebElement shoppingCartBadge;



    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void waitForPage(WebDriver driver, String url) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url + "/inventory.html"));
        wait.until(ExpectedConditions.visibilityOf(inventoryContainer));
    }
    public String getProductName(int itemNumber) {
        return itemName.get(itemNumber).getText();
    }
    public void addToShopingCardByName(String itemName) {
        int index = -1;

        try {
            for (int i = 0; i < this.itemName.size(); i++)
                if (getProductName(i).equals(itemName))
                    index = i;

            itemButton.get(index).click();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Nie znaleziono elemnetu o nazwie" + itemName);
            exception.printStackTrace();
        }
    }
    public String getButtonTextByName (String itemName) {
        int index = -1;

        try {
            for (int i = 0; i < this.itemName.size(); i++)
                if (getProductName(i).equals(itemName))
                    index = i;

        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Nie znaleziono elemnetu o nazwie" + itemName);
            exception.printStackTrace();
        }
        return itemButton.get(index).getText();
    }
    public boolean isShoppingCartBadge() {
        return shoppingCartBadge.isDisplayed();
    }
    public void clickBasketShop() { shoppingCartBadge.click(); }
}
