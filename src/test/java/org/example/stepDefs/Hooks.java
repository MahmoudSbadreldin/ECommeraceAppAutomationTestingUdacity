package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver webDriver = null;
    public static  String edgePath = System.getProperty("user.dir") + "\\src\\main\\resources\\msedgedriver.exe";

@Before
public static void openBrowser(){
    System.setProperty("webdriver.edge.driver",edgePath);
    webDriver=new EdgeDriver();
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.navigate().to("https://demo.nopcommerce.com");
}
@After
public static void quitBrowser() throws InterruptedException {
    Thread.sleep(3000);
    webDriver.quit();
}
    public static void openAnotherTap(int Index, int Tabs) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(Tabs));
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        System.out.println(tabs.size());

        webDriver.switchTo().window(tabs.get(Index));
    }
}
