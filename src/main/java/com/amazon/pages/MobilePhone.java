package com.amazon.pages;

import com.amazon.utility.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePhone extends Utility {
    public MobilePhone() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchbtn;
    @CacheLookup
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchtab;
    @CacheLookup
    @FindBy(xpath = "(//span[normalize-space()='Nokia'])[1]")
    WebElement nokia;
    @CacheLookup
    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[14]")
    WebElement searchPhone;
    @CacheLookup
    @FindBy(xpath = "//span[@id='submit.add-to-cart']")
    WebElement addtocart;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
    WebElement verifytxt;

    public void clickOnSearchBtn(String search) {
        sendTextToElement(searchbtn, search);
    }

    public void clickOnSearchTab() {
        clickOnElement(searchtab);
    }
    public void clickOnNokiaTab(){
        clickOnElement(nokia);
    }
    public void clickOnPhone(){
        clickOnElement(searchPhone);
    }
    public void clickOnAddToCart(){
        clickOnElement(addtocart);
    }


    public String verifyAddToCartTxt(){
        return getTextFromElement(verifytxt);
    }
}
