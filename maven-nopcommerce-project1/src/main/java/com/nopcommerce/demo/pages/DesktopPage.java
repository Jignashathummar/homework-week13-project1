package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopPage extends Utility {
    By selectPositionZtoA = By.id("products-orderby");
    By allProductTitle = By.xpath("//h2[@class = 'product-title']");
    By sortByFilterPath = By.xpath("//select[@id='products-orderby']");
    By clickOnAddToCart = By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']");

    public void selectPositionZtoA(String text) {
        selectByVisibleTextFromDropDown(selectPositionZtoA, text);
    }

    public List<WebElement> getAllProductTitleOnPage() {
        List<WebElement> products = driver.findElements(allProductTitle);
        return products;
    }

    public void sortByFilter(String sortByOption) {
        selectByVisibleTextFromDropDown(sortByFilterPath, sortByOption);
    }

    public void clickOnAddToCart() {
        clickOnElement(clickOnAddToCart);
    }
}
