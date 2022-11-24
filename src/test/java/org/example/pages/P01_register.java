package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {

    public By RegisterBtn(){
     return By.className("ico-register");
    }

    public By GenderMaleBtn(){
        return By.id("gender-male");
    }

    public By firstName ()
    {
        return By.name("FirstName");
    }

    public By lastName ()
    {
        return By.name("LastName");
    }

    public By  date (String name,String value)
    {
        return By.cssSelector("select[name=\""+name+"\"] > option[value=\""+value+"\"]");
    }

    public By Email ()
    {
        return By.name("Email");
    }
    public By comp ()
    {
        return By.name("Company");
    }
    public By password ()
    {
        return By.name("Password");
    }
    public By confPass ()
    {
        return By.name("ConfirmPassword");
    }
    public By registerButton ()
    {
        return By.name("register-button");
    }

}
