package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {
    WebDriver driver = null;
    public P03_homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "select[name=\"customerCurrency\"]")
    public WebElement currencyList;

    @FindBy(tagName = "option")
    public List<WebElement> currencyItems;

    @FindBy(css = "span.price")
    public List<WebElement> GetEuroValue;
//    Search

    public By SearchFiled() {

        return By.id("small-searchterms");
    }
    public By SearchBtn() {

        return By.xpath("//*[@id=\"small-search-box-form\"]/button");
    }
    @FindBy(css = "button.search-box-button[type=\"submit\"]")
    public WebElement searchButtonPom;
    @FindBy(css = "h2.product-title")
    public List<WebElement> productsLabels;

    @FindBy(css = "div.item-box")
    public List<WebElement> products;

    @FindBy(css = "div.sku")
    public WebElement productsSku;


    @FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]/li")
    public List<WebElement> main;

    @FindBy(xpath = "//div[@class='page-title']//h1")
    public WebElement catTitle;

    @FindBy(css = "div.nivoSlider")
    public WebElement slider;

    @FindBy(css = "a.nivo-control")
    public List<WebElement> Selector;

    @FindBy(css = "a[href=\"http://www.facebook.com/nopCommerce\"]")
    public WebElement facebook;

    @FindBy(css = "a[href=\"https://twitter.com/nopCommerce\"]")
    public WebElement twitter;

    @FindBy(css = "a[href=\"/news/rss/1\"]")
    public WebElement rss;

    @FindBy(css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    public WebElement youtube;

    @FindBy(css = "button.add-to-wishlist-button[title=\"Add to wishlist\"]")
    public List<WebElement> WishlistBtn;

    @FindBy(css = "a.ico-wishlist[href=\"/wishlist\"]")
    public WebElement HyperLink;
    @FindBy(css = "div.bar-notification")
    public WebElement notification;

    @FindBy(xpath = "//tr//td[@class=\"quantity\"]//input")
    public List<WebElement> Quantity;

}
