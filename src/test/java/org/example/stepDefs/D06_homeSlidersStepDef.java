package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {
    P03_homePage Slider = new P03_homePage(Hooks.webDriver);
    SoftAssert softAssert = new SoftAssert();;

    @Given("user select Nokia Lumia slider")
    public void userClicksOnNokiaLumiaSlider() throws InterruptedException {
        Slider.Selector.get(0).click();
        Slider.slider.click();
        Hooks.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Then("Nokia Lumia page will be opened")
    public void userShouldBeDirectedToNokiaLumiaPage() {
        String RightUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        softAssert.assertEquals(RightUrl,
                Hooks.webDriver.getCurrentUrl(),
                "Directed to wrong url it is supposed be: ".concat(RightUrl).concat(" but directed to: ").concat(Hooks.webDriver.getCurrentUrl()));
        softAssert.assertTrue(Hooks.webDriver.findElement(By.linkText("My account")).isDisplayed(), "Item with \"My account\" didn't appears");
        softAssert.assertAll();
    }

    @Given("user Select on iphone slider")
    public void userClicksOnIphoneSlider() throws InterruptedException {
        Slider.Selector.get(1).click();
        Hooks.webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Slider.slider.click();

    }

    @Then("iphone page will be opened")
    public void userShouldBeDirectedToIphonePage() {
        String RightUrl = "https://demo.nopcommerce.com/iphone-6";

        softAssert.assertEquals(RightUrl,
                Hooks.webDriver.getCurrentUrl(),
                "Directed to wrong url it is supposed be: ".concat(RightUrl).concat(" but directed to: ").concat(Hooks.webDriver.getCurrentUrl()));
        softAssert.assertTrue(Hooks.webDriver.findElement(By.linkText("My account")).isDisplayed(), "items with \"My account\" didn't appears");
        softAssert.assertAll();
    }
}
