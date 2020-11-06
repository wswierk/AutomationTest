package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(css = ".inventory_container") private WebElement inventoryContainer;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void waitForPage(WebDriver driver, String url){
        WebDriverWait wait =  new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(url+"/inventory"));
        wait.until(ExpectedConditions.visibilityOf(inventoryContainer));
    }
}
