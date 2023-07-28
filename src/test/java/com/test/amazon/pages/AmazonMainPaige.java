package com.test.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AmazonMainPaige {

    public AmazonMainPaige(WebDriver driver){
        PageFactory.initElements(driver, this);


    }
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    // use css selector

    @FindBy(xpath = "//span[contains(text(),'results for')]")
    WebElement result;

    @FindBy(xpath = "//h2//a")
    List<WebElement> allHeader;


    public void searchItem(String word) {
        searchBar.sendKeys(word, Keys.ENTER);
    }

    public boolean resultNumber(int number) {
        return BrowserUtils.getText(result).replace(",", "").contains(String.valueOf(number));//about......20000 results
    }

    public void validateAllHeaders(String expectedWord) {
        for (WebElement header : allHeader) {
            if (!BrowserUtils.getText(header).equals("")) {
                Assert.assertTrue(BrowserUtils.getText(header).toLowerCase().contains(expectedWord));
            }
        }
    }

}
