package org.example.stepDefs;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {

    P03_homePage homePage = new P03_homePage(Hooks.webDriver);
    @Given("user Navigate to Home and Select “Euro” from currency dropdown list")
    public void select() {
      homePage.currencyList.click();
      homePage.currencyItems.get(1).click();

    }

    @Then("Find all Elements with Euro currency")
    public void findAllElementsWithEuroCurrency() {
        List<WebElement> euroValues = homePage.GetEuroValue;
        for (WebElement eurovalue : euroValues) {
            Assert.assertTrue(eurovalue.getText().contains("€"));

        }
    }
}
