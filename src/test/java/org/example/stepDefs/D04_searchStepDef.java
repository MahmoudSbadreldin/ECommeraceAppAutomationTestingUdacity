package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class D04_searchStepDef {
    P03_homePage search = new P03_homePage(Hooks.webDriver);
    SoftAssert softassert = new SoftAssert();


    @Given("user type the search word on search field {string}")
    public void typingSearchWord(String kewWord) {
        Hooks.webDriver.findElement(search.SearchFiled()).clear();
        Hooks.webDriver.findElement(search.SearchFiled()).sendKeys(kewWord);
    }

    @When("user click on search button")
    public void clickSearchButton() throws InterruptedException {
        Hooks.webDriver.findElement(search.SearchBtn()).click();
        Thread.sleep(3000);
        softassert.assertTrue(Hooks.webDriver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }

    @And("There are {string} should be displayed")
    public void NoOfProductDisplayed(String Number){
        int count=search.productsLabels.size();
        softassert.assertEquals(count, Integer.parseInt(Number), "Expected: ".concat(Number).concat("but found: ").concat(String.valueOf(count)));

    }

    @Then("user find each result contains the search word by keyword {string}")
    public void findResult(String searchWord) {

        List<WebElement> searchkeyword = search.productsLabels;
        for (WebElement element : searchkeyword) {
            softassert.assertTrue(element.getText().toLowerCase().contains(searchWord.toLowerCase()), element.getText().concat(" doesn't contain the word").concat(searchWord));
        }
        softassert.assertAll();
    }

    @And("user Click on the product")
    public void ClickOnProduct(){
        search.products.get(0).click();
    }

    @Then("The product should contains {string} for each product")
    public void ProductSku(String sku){
        String actual_sku= search.productsSku.getText();
        softassert.assertEquals(actual_sku,sku);


    }
}
