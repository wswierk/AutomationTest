package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    @FindBy(className = "inventory_container")
    private WebElement inventoryContainer;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemName;

    @FindBy(className = "btn_inventory")
    private List<WebElement> itemButton;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrice;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "product_sort_container")
    private WebElement sortBySelect;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPage(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url + "/inventory.html"));
        wait.until(ExpectedConditions.visibilityOf(inventoryContainer));
    }

    public String getProductName(int itemNumber) {
        return itemName.get(itemNumber).getText();
    }

    public void addToShopingCardByName(String itemName) {
        for (int i = 0; i < this.itemName.size(); i++) {

            if (getProductName(i).equals(itemName)) {
                itemButton.get(i).click();
                return;
            }
        }
    }

    public String getButtonTextByName(String itemName) {
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

    public void clickBasketShop() {
        shoppingCartBadge.click();
    }

    public void navigate(String url) {
        driver.get(url + "/inventory.html");
    }

    public void setSortBy(String sortBy) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sortBySelect));
        Select select = new Select(sortBySelect);
        select.selectByVisibleText(sortBy);
    }

    public String checkSortBy() {
        Select select = new Select(sortBySelect);
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getItemNameList() {
        List<String> itemNameList = new ArrayList<String>();
        for (int i = 0; i < itemName.size(); i++) {
            itemNameList.add(i, itemName.get(i).getText());
        }
        return itemNameList;
    }

    public List<Float> getItemPriceList() {
        List<Float> itemPriceList = new ArrayList<Float>();
        for (int i = 0; i < itemPrice.size(); i++) {
            itemPriceList.add(i, Float.valueOf(itemPrice.get(i).getText().replace("$", "")));
        }
        return itemPriceList;
    }

}
