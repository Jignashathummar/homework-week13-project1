package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class HeaderPage extends Utility {
    By shoppingCart = By.xpath("//a[@class='ico-cart']");
    By goToCartBtn = By.xpath("//button[normalize-space()='Go to cart']");
    By loginButton = By.xpath("//a[normalize-space()='Log in']");
    By logOutBtn = By.xpath("//a[normalize-space()='Log out']");
    public void mouseHoverOnShoppingCart(){
        mouseHoverToElement(shoppingCart);
    }
    public void clickOnGoToCartBtn(){
        clickOnElement(goToCartBtn);
    }
    public void clickOnLoginBtn(){
        clickOnElement(loginButton);
    }
    public void clickOnLogOutBtn(){
        clickOnElement(logOutBtn);
    }


}
