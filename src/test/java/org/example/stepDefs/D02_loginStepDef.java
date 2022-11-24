package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P02_login login=new P02_login();
    @Given("user go to login page")
        public void loginPg(){
        Hooks.webDriver.findElement(login.login()).click();
        }
@When("^user login with \"(.*)\" and \"(.*)\"$")
    public void userLogin(String Email,String password){
    Hooks.webDriver.findElement(login.Email()).sendKeys(Email);
    Hooks.webDriver.findElement(login.pass()).sendKeys(password    );
}
@And("user press on login button")
public void pressLogin(){
    Hooks.webDriver.findElement(login.loginBtn()).click();
}
@Then("user login to the system successfully")
    public void logSuccess(){
    SoftAssert soft=new SoftAssert();
    soft.assertEquals(Hooks.webDriver.getCurrentUrl(),"https://demo.nopcommerce.com/");
    soft.assertTrue(Hooks.webDriver.findElement(login.myAccountTap()).isDisplayed());
    soft.assertAll();
    }

@Then("user could not login to the system")
    public void logFailed(){
    SoftAssert soft=new SoftAssert();
    String expectedResult="Login was unsuccessful. Please correct the errors and try again.";
    String actualResult=Hooks.webDriver.findElement(login.notLogged()).getText();
    soft.assertTrue(actualResult.contains(expectedResult),"Login was unsuccessful.");
    String color = Hooks.webDriver. findElement(login.notLogged()).getCssValue("color");
//    soft.assertEquals(color,"#e4434b");
    soft.assertAll();

}




}

