package com.amazon.testsuite;

import com.amazon.pages.AddToCart;
import com.amazon.pages.selectedProPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SearchProduct;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LaptopTest extends TestBase {
    HomePage homePage;
    SearchProduct searchProduct;
    selectedProPage selectedProPage;
    AddToCart addToCart;


    @BeforeMethod
    public void init() {
        homePage = new HomePage();
        searchProduct = new SearchProduct();
        selectedProPage = new selectedProPage();
        addToCart = new AddToCart();
    }


    @Test
    @Parameters({"search1", "description1", "quantity1", "message1" })
    public void userShouldBeAbleToPurchaseLaptopSuccessfully(String lSearch, String lDescription, String lQuantity, String lMessage) throws InterruptedException {
        homePage.enterDataInTheSearchBox(lSearch);
        homePage.clickOnTheSearchButton();
        searchProduct.findSelection(lDescription);
        selectedProPage.selectQuantity(lQuantity);
        selectedProPage.addItemToCart();
        addToCart.verifyTheAddToCartMessage(lMessage);
    }

}

