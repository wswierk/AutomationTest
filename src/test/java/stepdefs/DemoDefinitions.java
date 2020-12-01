package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;


public class DemoDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage ;
    private BasketPage basketPage;
    private OrderPage orderPage;
    private Checkoutsteptwo checkoutsteptwo;
    private CheckoutComplete checkoutComplete;
    private String url;



    @Given("^Start web browser, URL: \"(.*)\"$")
    public void startWebBrowser(String url) {
        driver = WebDriverManager.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        basketPage = new BasketPage(driver);
        orderPage = new OrderPage(driver);
        checkoutsteptwo = new Checkoutsteptwo(driver);
        checkoutComplete = new CheckoutComplete(driver);
        this.url = url;
        loginPage.navigate(this.url);
        loginPage.waitForPage();
    }
    @When("^Enter login \"(.*)\"$")
    public void enterLogin(String login) {
        loginPage.inputUserName(login);

    }
    @When("^Enter password \"(.*)\"$")
    public void enterPassword(String password) {
        loginPage.inputPassword(password);

    }
    @When("Click login button")
    public void clickLoginButton() {
        loginPage.clickButtonLogin();
    }

    @When ("^Add product \"(.*)\" to basket shop$")
    public void addProductToBasketShopByName(String itemName) {
        homePage.addToShopingCardByName(itemName);
    }

    @When("Click basket shop")
    public void clickBasketShop() {
        homePage.clickBasketShop();
    }

    @When("Click checkout button")
    public void clickCheckoutButton() { basketPage.clickCheckoutButton();}

    @When("^Input first name \"(.*)\"$")
    public void inputFirstName(String firstName) { orderPage.inputFirstName(firstName);}

    @When("^Input last name \"(.*)\"$")
    public void inputLastName(String lastName) { orderPage.inputLastName(lastName);}

    @When("^Input postal code \"(.*)\"$")
    public void inputPostalCode (String postalCode) { orderPage.inputPostalCode(postalCode);}

    @When("Click finish button")
    public void clickFinishButton() { checkoutsteptwo.clickFinishButton(); }

    @Then("Check correct login")
    public void checkCorrectLogin() {
        homePage.waitForPage(url);
        System.out.println(url);
    }
    @Then("^Product \"(.*)\" has remove button$")
    public void productRemoveButton (String itemName) {
        Assert.assertEquals(homePage.getButtonTextByName(itemName), "REMOVE");
    }
    @Then("Basket shop has products")
    public void basketProduct() {
        Assert.assertTrue(homePage.isShoppingCartBadge());
    }
    @Then("Basket page is displayed")
    public void basketPageIsDisplayed() {
        basketPage.waitForPage(url);
    }
    @Then("^Product \"(.*)\" is in basket$")
    public void productIsInBasket(String itemName) {
        Assert.assertEquals(basketPage.getBasketItemName(),itemName);
    }

    @Then("Order page is displayed")
    public void orderPageIsDisplayed() { orderPage.waitForPage(url);}

    @Then("Click continue button")
    public void clickContinueButton() { orderPage.clickContinueButton();}

    @Then("Checkout order page is displayed")
    public void checkoutOrderPageIsDisplayed() { checkoutsteptwo.waitForPage(url);}

    @Then("^Product \"(.*)\" is on order list$")
    public void productOrderIsOnList(String productName) { Assert.assertEquals(checkoutsteptwo.getProductName(),productName);}

    @Then("^Payment information is \"(.*)\"$")
    public void paymentInformation(String paymentInformation) {
        Assert.assertEquals(checkoutsteptwo.getPaymentInformation(),paymentInformation);
        Assert.assertTrue(checkoutsteptwo.isPaymentInformationDisplayed());
    }

    @Then("^Shipping information is \"(.*)\"$")
    public void shippingInformation(String shoppingInformation) {
        Assert.assertEquals(checkoutsteptwo.getShippingInformation(),shoppingInformation);
        Assert.assertTrue(checkoutsteptwo.isShippingInformationDisplayed());
    }

    @Then("^Item total cost is \"(.*)\"$")
    public void itemTotalCost(String itemTotalCost) {
        Assert.assertTrue(checkoutsteptwo.isItemTotalCostDisplayed());
        Assert.assertEquals(checkoutsteptwo.getItemTotalCost(), "Item total: " + itemTotalCost);
    }

    @Then("^Tax cost is \"(.*)\"$")
    public void taxCost(String itemTaxCost) {
        Assert.assertTrue(checkoutsteptwo.istTaxCostDisplayed());
        Assert.assertEquals(checkoutsteptwo.getTaxCost(), "Tax: " + itemTaxCost);
    }

    @Then("^Total cost is \"(.*)\"$")
    public void totalCost(String itemTotalCost) {
        Assert.assertTrue(checkoutsteptwo.isItemTotalCostDisplayed());
        Assert.assertEquals(checkoutsteptwo.getTotalCost(), "Total: " + itemTotalCost);
    }

    @Then("Checkout complete page is displayed")
    public void checkoutcompletePageIsDisplayed() { checkoutComplete.waitForPage(url); }

}
