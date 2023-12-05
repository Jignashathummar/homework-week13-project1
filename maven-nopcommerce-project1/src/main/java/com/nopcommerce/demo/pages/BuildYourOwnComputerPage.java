package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class BuildYourOwnComputerPage extends Utility {
    By getTextBuildOwnComputer = By.xpath("//h1[normalize-space()='Build your own computer']");
    By selectDualCoreE2200 = By.id("product_attribute_1");
    By select8GB = By.id("product_attribute_2");
    By selectRadioButton400GB = By.id("product_attribute_3_7");
    By selectRadioVistaPremium = By.id("product_attribute_4_9");
    By clickOnCheckbox = By.id("product_attribute_5_12");
    By getTextTotal = By.id("price-value-1");
    By clickOnAddToCart = By.xpath("//button[@id='add-to-cart-button-1']");
    By getTextFromMessage = By.xpath("//p[@class='content']");
    By clickOnCloseButton = By.xpath("//span[@title='Close']");
    By mouseHoverOnAddToCart = By.xpath("//span[@class='cart-label']");
    By clikOnAddToCart = By.xpath("//button[normalize-space()='Go to cart']");

    public String getTextBuildOwnComputer() {
        return getTextFromElement(getTextBuildOwnComputer);
    }

    public void selectDualCore(String text) {
        selectByVisibleTextFromDropDown(selectDualCoreE2200, text);
    }

    public void select8GB(String text) {
        selectByVisibleTextFromDropDown(select8GB, text);
    }

    public void selectRadioButton() {
        clickOnElement(selectRadioButton400GB);
    }

    public void selectRadioVistaPremium() {
        clickOnElement(selectRadioVistaPremium);
    }

    public void clickOnCheckbox() {
        clickOnElement(clickOnCheckbox);
    }

    public String getTextTotal() {
        return getTextFromElement(getTextTotal);
    }

    public void clickOnAddToCart() {
        clickOnElement(clickOnAddToCart);
    }

    public String getTextFromMessage() {
        return getTextFromElement(getTextFromMessage);
    }

    public void clickOnCloseButton() {
        clickOnElement(clickOnCloseButton);
    }

    public void mouseHoverOnAddToCart() {
        mouseHoverToElement(mouseHoverOnAddToCart);
    }

    public void clikOnAddToCart() {
        clickOnElement(clikOnAddToCart);
    }
}
