package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D08_WishlistStepDef {
    P03_homePage wishlist = new P03_homePage(Hooks.webDriver);
    SoftAssert softAssert = new SoftAssert();


    @Given("Select HTC and click on wishlist button")
    public void SelectAndClick() {
        wishlist.WishlistBtn.get(2).click();
    }

    @Then("green background and success msg will be displayed")
    public void GreenAndSuccess() {
        String ExpectedMessage = "The product has been added to your wishlist";
        String ExpectedColor = "#4bb07a";
        softAssert.assertTrue(wishlist.notification.getText().contains(ExpectedMessage), "error message did not show up");
        String actualColor = Color.fromString(wishlist.notification.getCssValue("background-color")).asHex();
        softAssert.assertEquals(ExpectedColor, actualColor, "Expected message color is different");
        softAssert.assertAll();
    }

    @And("Check the product quantity")
    public void userGoToWishlistPage() throws InterruptedException {
        Hooks.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wishlist.HyperLink.click();
    }

    @Then("Verify that the quantity is grater than zero")
    public void theProductQuantityShouldBeGraterThan() {
        int actualQuantity = Integer.parseInt(wishlist.Quantity.get(0).getAttribute("value"));
        softAssert.assertTrue(actualQuantity > 0, "quantity is: " + actualQuantity + "and should be grater than 0");
        softAssert.assertAll();
    }
}
