package org.example.stepDefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
public class D07_followUsStepDef {
    P03_homePage followUs = new P03_homePage(Hooks.webDriver);

    @Given("user opens facebook link")
    public void userOpensFacebookLink() {
        followUs.facebook.click();
        Hooks.openAnotherTap(1, 2);
    }

    @Given("user opens twitter link")
    public void userOpensTwitterLink() {
        followUs.twitter.click();
        Hooks.openAnotherTap(1, 2);
    }

    @Given("user opens rss link")
    public void userOpensRssLink() {
        followUs.rss.click();
        Hooks.openAnotherTap(0, 1);
    }

    @Given("user opens youtube link")
    public void userOpensYoutubeLink() {
        followUs.youtube.click();
        Hooks.openAnotherTap(1, 2);
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String url) {
        Assert.assertEquals(Hooks.webDriver.getCurrentUrl(), url);
    }
}
