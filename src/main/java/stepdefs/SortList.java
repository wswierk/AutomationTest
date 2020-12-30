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
    private String url;
    private String sortBy;

    @Given("^Start web browser on home page, URL: \"(.*)\"$")
    public void startWebBrowser(String url) {
        driver = WebDriverManager.getDriver();
        this.url = url;
        homePage = new HomePage(driver);
        homePage.navigate(url);
        homePage.waitForPage(url);

    }

    @When("^Set sort list by \"(.*)\"$")
    public void setSortListBy(String sortBy) {
        this.sortBy = sortBy;
        homePage.setSortBy(sortBy);
    }

    @Then("Check correct sort")
    public void CheckCorrectSort() {
        Assert.assertEquals(homePage.checkSortBy(), sortBy);
        switch (sortBy) {
            case "Name (A to Z)":
                Assert.assertEquals(Ordering.natural().isOrdered(homePage.getItemNameList()), true);
                break;
            case "Name (Z to A)":
                Assert.assertEquals(Ordering.natural().reverse().isOrdered(homePage.getItemNameList()), true);
                break;
            case "Price (low to high)":
                Assert.assertEquals(Ordering.natural().isOrdered(homePage.getItemPriceList()), true);
                break;
            case "Price (high to low)":
                Assert.assertEquals(Ordering.natural().reverse().isOrdered(homePage.getItemPriceList()), true);
                break;
        }
    }


}
