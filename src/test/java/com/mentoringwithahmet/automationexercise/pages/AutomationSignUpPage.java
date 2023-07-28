package com.mentoringwithahmet.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AutomationSignUpPage {

    public AutomationSignUpPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath= "//div//ul//li//a[.=' Signup / Login']")
    WebElement clickSignUpLoginButton;

    @FindBy(xpath= "//h2[.='New User Signup!']") // just for Aida
    WebElement newSignUpHeader;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement username;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emaiL;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signButton;

  // sout  well look at it




/*

    @FindBy( "")
    WebElement sss;

    @FindBy( "")
    WebElement sss;



    */

    public boolean validateNewSignUpHeader(String expectedSignUpHeader){

        return BrowserUtils.getText(newSignUpHeader).equals(expectedSignUpHeader);
    }

    public void login (  String username, String email ) throws InterruptedException {

        this.username.sendKeys(username);
        this.emaiL.sendKeys(email);

        this.signButton.click();


    }

    public void clicksSignUp(){

        this.clickSignUpLoginButton.click();

//        return BrowserUtils.getText(titlePage).equals(expectedHeaderMainPage);  // String expectedHeaderMainPage
    }


}
