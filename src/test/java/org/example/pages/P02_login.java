package org.example.pages;

import org.openqa.selenium.By;

public class P02_login {
    public By login(){
        return By.className("ico-login");
    }

    public By Email(){
        return By.name("Email");
    }
    public By pass(){
        return By.name("Password");
    }
public By loginBtn(){
        return By.cssSelector("div[class=\"buttons\"] > button[type=\"submit\"]");
}
public By myAccountTap(){
        return By.className("ico-account");
}
public By notLogged(){
        return By.cssSelector("form[novalidate=\"novalidate\"]");
}
}
