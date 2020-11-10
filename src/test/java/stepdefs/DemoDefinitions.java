package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BasketPage;
import pages.HomePage;
import pages.LoginPage;


public class DemoDefinitions {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage ;
    private BasketPage basketPage;
    private String url;


    @Given("^Start Web Browser, URL: \"(.*)\"$")
    public void startWebBrowser(String url) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        basketPage = new BasketPage(driver);
        this.url = url;
        loginPage.navigate(driver, this.url);
        loginPage.waitForPage(driver);


    }
    @When("^Enter Login \"(.*)\"$")
    public void enterLogin(String login) {
        loginPage.inputUserName(driver, login);

    }
    @When("^Enter Password \"(.*)\"$")
    public void enterPassword(String password) {
        loginPage.inputPassword(driver, password);

    }
    @When("Click Login Button")
    public void clickLoginButton() {
        loginPage.clickButtonLogin(driver);

    }

    @When ("^Add product \"(.*)\" to basket shop$")
    public void addProductToBasketShopByName(String itemName) {
        homePage.addToShopingCardByName(itemName);
    }

    @When("Click basket shop")
    public void clickBasketShop() {
        homePage.clickBasketShop();
    }

    @Then("Check Correct Login")
    public void checkCorrectLogin() {
        homePage.waitForPage(driver, url);
        System.out.println(url);
    }
    @Then("^Product \"(.*)\" has Remove Button$")
    public void productRemoveButton (String itemName) {
        Assert.assertEquals(homePage.getButtonTextByName(itemName), "REMOVE");
    }
    @Then("Basket Shop has Products")
    public void basketProduct() {
        Assert.assertTrue(homePage.isShoppingCartBadge());
    }
    @Then("Basket page is Displayed")
    public void basketPageIsDisplayed() {
        basketPage.waitForPage(driver, url);
    }
    @Then("^Product \"(.*)\" is in Basket$")
    public void productIsInBasket(String itemName) {
        Assert.assertEquals(basketPage.getBasketItemName(),itemName);
    }

    @Before
    public void beforeScenario(){
    }

    @After
    public void afterScenario(){
        try{
            Thread.sleep(1000);
        } catch (Exception exception){

        }
        driver.quit();
    }
}
