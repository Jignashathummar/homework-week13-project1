package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By welcomeText = By.xpath("//h2[normalize-space()='Welcome to our store']");
    By mouseHoverOnElectronics = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']");
    By mouseHoverAndClickOnCellPhone = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");
    By clickOnComputer = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
    public void mouseHoverOnElectronics(){
        mouseHoverToElement(mouseHoverOnElectronics);
    }
    public void mouseHoverAndClickOnCellPhone(){
        mouseHoverToElementAndClick(mouseHoverAndClickOnCellPhone);
    }
    public String getWelcomeText(){
        return getTextFromElement(welcomeText);
    }
    public void clickOnComputer(){
        clickOnElement(clickOnComputer);
    }
}
