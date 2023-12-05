package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CellPhoneProductPage extends Utility {
    By welcomePeoductName = By.tagName("h1");
    By productPrice = By.id("price-value-20");
    By productQuantity = By.id("product_enteredQuantity_20");
    By addToCartBtn = By.id("add-to-cart-button-20");
    By successMsgAddToCart = By.xpath("(//p[@class='content'])[1]");
    By successAddToCartMsgCloseButton = By.xpath("//span[@title='Close']");
    public String getWelcomeProductName(){
        return getTextFromElement(welcomePeoductName);
    }

    public String getProductPrice(){
        return getTextFromElement(productPrice);
    }

    public void changeProductQuantity(String quantity){
        clearElement(productQuantity);
        sendTextToElement(productQuantity, quantity);
    }
    public void clickOnAddToCartBtn(){
        clickOnElement(addToCartBtn);
    }

    public String getAddToCartSuccessfulMessage() {
        return getTextFromElement(successMsgAddToCart);
    }

    public void closeSuccessAddToCartMsg(){
        clickOnElement(successAddToCartMsgCloseButton);
    }
}
