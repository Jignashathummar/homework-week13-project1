package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {
    By welcomePageText = By.tagName("h1");
    By quantityField = By.xpath("//input[@class = 'qty-input']");
    By totlePriceField = By.xpath("//span[@class='product-subtotal']");
    By termsOfServiceAgreementCheckBox = By.xpath("//input[@id='termsofservice']");
    By checkOutBtn = By.xpath("//button[@id='checkout']");
    By clearText = By.className("qty-input");
    By clickOnUpdateCart = By.id("updatecart");
    By checkOutButton = By.xpath("//button[@id='checkout']");

    public String getWelcomePageText() {
        return getTextFromElement(welcomePageText);
    }

    public String getDataFromQuantityField() {
        return getAttributeFromElement(quantityField, "value");
    }

    public String getTextFromTotalPriceField() {
        return getTextFromElement(totlePriceField);
    }

    public void clickOnTermsOfServiceAgreementCheckBox() {
        clickOnElement(termsOfServiceAgreementCheckBox);
    }

    public void clickOnCheckOutBtn() {
        clickOnElement(checkOutBtn);
    }

    public void clearText() {
        clearElement(clearText);
    }

    public void sendTextChangeQuantity(String text) {
        sendTextToElement(clearText, text);
    }

    public void clickOnUpdateCart() {
        clickOnElement(clickOnUpdateCart);
    }

    public void clickOnCheckOut() {
        clickOnElement(checkOutButton);
    }

}
