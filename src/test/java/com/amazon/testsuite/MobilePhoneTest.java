package com.amazon.testsuite;


import com.amazon.pages.AddToCart;
import com.amazon.pages.SearchProduct;
import com.amazon.pages.HomePage;
import com.amazon.pages.selectedProPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;;

public class MobilePhoneTest extends TestBase {
    HomePage homePage;
    SearchProduct searchProduct;
    selectedProPage selectedProPage;
    AddToCart addToCart;


    @BeforeMethod
    public void init1() {
        homePage = new HomePage();
        searchProduct = new SearchProduct();
        selectedProPage = new selectedProPage();
        addToCart = new AddToCart();
    }

    @Test
    @Parameters({"search2", "description2", "quantity2", "message2" })
    public void userShouldBeAbleToPurchaseMobilePhoneSuccessfully(String mSearch, String mDescription, String mQuantity, String mMessage) throws InterruptedException {
        homePage.enterDataInTheSearchBox(mSearch);
        homePage.clickOnTheSearchButton();
        searchProduct.findSelection(mDescription);
        selectedProPage.selectQuantity(mQuantity);
        selectedProPage.addItemToCart();
        addToCart.verifyTheAddToCartMessage(mMessage);
    }
}