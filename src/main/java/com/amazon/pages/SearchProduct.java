package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;


public class SearchProduct extends Utility {

    public SearchProduct() {
        PageFactory.initElements(driver, this);
    }



    @FindBy (xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> searchList;

    @CacheLookup
    @FindBy (linkText = "Next")
    WebElement nextButton;


    public boolean findSelection(String item) throws InterruptedException {
        boolean myBreak = true;
        boolean selection = false;
        while (myBreak) {
            for (WebElement e : searchList) {
                if (e.getText().equalsIgnoreCase(item)) {
                    System.out.println(e.getText());
                    pmClickOnElement(e);
                    selection = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak) {
                if (!driver.getCurrentUrl().contains("page=20")) {
                    pmWaitUntilVisibilityOfElementLocated(By.linkText("Next"), 100).click();
                } else {
                    selection = false;
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
                Thread.sleep(5000);
            }
        }
        return selection;
    }






}







