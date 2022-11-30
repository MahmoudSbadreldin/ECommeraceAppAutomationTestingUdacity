package org.example.stepDefs;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import org.example.pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    P03_homePage Hover = new P03_homePage(Hooks.webDriver);
    SoftAssert softAssert = new SoftAssert();
    List<WebElement> subCat;
    List<WebElement> mainCat;
    int selectedCat;
    String selectdCatTxt;
    String selectSubCatTitle;
    Actions actions = new Actions(Hooks.webDriver);

    @Given("user select main category and ascertain that the sub categories are displayed")
    public void MainCategory() throws InterruptedException {
        mainCat = Hover.main;
        selectedCat = (int) Math.floor(Math.random() * mainCat.size());
        actions.moveToElement(mainCat.get(selectedCat)).perform();
        selectdCatTxt = mainCat.get(selectedCat).getText();
        Thread.sleep(2000);

    }
    @And("Subcategories displayed")
    public void Subcategoriesdisplayed(){
        String dir = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCat + 1 + "]/li";
        subCat = Hooks.webDriver.findElements(By.xpath(dir));
        Hooks.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @When("user select sub category or select the main category")
    public void SubCategory() {
        if (!subCat.isEmpty()) {
            int selectedSubCategory = (int) Math.floor(Math.random() * subCat.size());
            selectSubCatTitle = subCat.get(selectedSubCategory).getText();
            subCat.get(selectedSubCategory).click();
        } else {
            selectSubCatTitle = mainCat.get(selectedCat).getText();
            mainCat.get(selectedCat).click();
        }
        Hooks.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("Check the Name")
    public void CheckName() {
        String actualTitle = Hover.catTitle.getText().toLowerCase().trim();
        softAssert.assertEquals(actualTitle, selectSubCatTitle.toLowerCase().trim(), "Expected: ".concat(selectdCatTxt).concat(" but found: ").concat(actualTitle));
        softAssert.assertAll();
    }
}
