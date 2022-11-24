package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P01_register register=new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
     Hooks.webDriver.findElement(register.RegisterBtn()).click();
    }

    @When("user select gender type")
    public void SelectGender(){
    Hooks.webDriver.findElement(register.GenderMaleBtn()).click();
    }

    @And("user enter first name \"Mahmoud\" and last name \"Salah\"")
    public void EnterName(){
    Hooks.webDriver.findElement(register.firstName()).sendKeys("Mahmoud");
    Hooks.webDriver.findElement(register.lastName()).sendKeys("Salah");
    }
    @And("user enter date of birth")
    public void DateOfBirth(){
        Hooks.webDriver.findElement(register.date("DateOfBirthDay","25")).click();
        Hooks.webDriver.findElement(register.date("DateOfBirthMonth","5")).click();
        Hooks.webDriver.findElement(register.date("DateOfBirthYear","1997")).click();
    }
    @And("user enter email \"test@example.com\" field")
    public void EnterEmail(){
        Hooks.webDriver.findElement(register.Email()).sendKeys("mbadreldin01@gmail.com");
    }

    @And("user fills company field")
    public void company(){
        Hooks.webDriver.findElement(register.comp()).sendKeys("ISchool");

    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void Pass(){
        Hooks.webDriver.findElement(register.password()).sendKeys("Msh2812@");
        Hooks.webDriver.findElement(register.confPass()).sendKeys("Msh2812@");
    }

    @And("user clicks on register button")
    public void ClickRegisterBtn(){
        Hooks.webDriver.findElement(register.registerButton()).click();
    }
    @Then("success message is displayed")
    public void SucessMsg(){
        SoftAssert soft=new SoftAssert();
        String color = Hooks.webDriver. findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");

        soft.assertTrue(Hooks.webDriver. findElement(By.cssSelector("div[class=\"result\"]")).isDisplayed());
        soft.assertTrue(Hooks.webDriver.getCurrentUrl().contains("https://demo.nopcommerce.com/registerresult/1?returnUrl=/"));
        soft.assertTrue(Hooks.webDriver.findElement(By.cssSelector("a[href=\"/customer/info\"][class=\"ico-account\"]")).isDisplayed());
        soft.assertEquals(color,"rgba(76, 177, 124, 1)");
        soft.assertAll();
    }
}
