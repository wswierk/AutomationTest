package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkoutsteptwo {

    @FindBy(className = "summary_info")
    private WebElement summaryInfo;

    @FindBy(className = "inventory_item_name")
    private WebElement inventoryItemName;

    @FindBy(css = ".summary_value_label:nth-child(2)")
    private WebElement paymentInformation;

    @FindBy(css = ".summary_value_label:nth-child(4)")
    private WebElement shippingInformation;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotalCost;

    @FindBy(className = "summary_tax_label")
    private WebElement taxCost;

    @FindBy(className = "summary_total_label")
    private WebElement totalCost;

    @FindBy(className = "cart_button")
    private WebElement buttonFinish;

    private WebDriver driver;

    public Checkoutsteptwo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPage(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.urlToBe(url + "/checkout-step-two.html"));
        wait.until(ExpectedConditions.visibilityOf(summaryInfo));
    }

    public String getProductName() {
        return inventoryItemName.getText();
    }

    public String getPaymentInformation() {
        return paymentInformation.getText();
    }

    public boolean isPaymentInformationDisplayed() {
        return paymentInformation.isDisplayed();
    }

    public String getShippingInformation() {
        return shippingInformation.getText();
    }

    public boolean isShippingInformationDisplayed() {
        return shippingInformation.isDisplayed();
    }

    public String getItemTotalCost() {
        return itemTotalCost.getText();
    }

    public boolean isItemTotalCostDisplayed() {
        return itemTotalCost.isDisplayed();
    }

    public String getTaxCost() {
        return taxCost.getText();
    }

    public boolean istTaxCostDisplayed() {
        return taxCost.isDisplayed();
    }

    public String getTotalCost() {
        return totalCost.getText();
    }

    public boolean isTotalCostDisplayed() {
        return totalCost.isDisplayed();
    }

    public void clickFinishButton() {
        buttonFinish.click();
    }

}
