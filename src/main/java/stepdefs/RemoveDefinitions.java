package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import pages.BasketPage;
import org.junit.Assert;

public class RemoveDefinitions {

    private WebDriver driver;
    private BasketPage basketPage;
    private String url;

    @Given("^Remove product from basket shop \"(.*)\"$")
    public void removeProductFromBasketShop(String url) {
        driver = WebDriverManager.getDriver();
        basketPage = new BasketPage(driver);
        this.url = url;
        basketPage.navigate(url);
        SessionStorage sessionStorage = ((WebStorage) driver).getSessionStorage();
        sessionStorage.setItem("cart-contents", "[4]");
        driver.navigate().refresh();
        basketPage.waitForPage(url);
    }

    @When("Click remove button")
    public void clickRemoveButton() {
        basketPage.clickRemoveButton();
    }

    @Then("Check if the basket is empty")
    public void checkIfTheBasketIsEmpty() {
        Assert.assertEquals(basketPage.isItemNameDisplayed(), 0);
    }

}
