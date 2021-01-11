package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.collect.Ordering;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import pages.HomePage;

public class SortList {

    private WebDriver driver;
    private HomePage homePage;

    @Given("^Start web browser on home page, URL: \"(.*)\"$")
    public void startWebBrowser(String url) {
        driver = WebDriverManager.getDriver();
        homePage = new HomePage(driver);
        homePage.navigate(url);
        homePage.waitForPage(url);
    }

    @When("Set sort list by name \\(A to Z)")
    public void setSortByNameAscending() {
        homePage.setSortByNameAscending();
    }

    @When("Set sort list by name \\(Z to A)")
    public void setSortByNameDescending() {
        homePage.setSortByNameDescending();
    }

    @When("Set sort list by price \\(low to high)")
    public void setSortByPriceAscending() {
        homePage.setSortByPriceAscending();
    }

    @When("Set sort list by price \\(high to low)")
    public void setSortByPriceDescending() {
        homePage.setSortByPriceDescending();
    }

    @Then("Validate the sort")
    public void CheckCorrectSort() {
        switch (homePage.getSortMethod()) {
            case "Name (A to Z)":
                Assert.assertTrue(Ordering.natural().isOrdered(homePage.getItemNameList()));
                break;
            case "Name (Z to A)":
                Assert.assertTrue(Ordering.natural().reverse().isOrdered(homePage.getItemNameList()));
                break;
            case "Price (low to high)":
                Assert.assertTrue(Ordering.natural().isOrdered(homePage.getItemPriceList()));
                break;
            case "Price (high to low)":
                Assert.assertTrue(Ordering.natural().reverse().isOrdered(homePage.getItemPriceList()));
                break;
        }
    }

}
