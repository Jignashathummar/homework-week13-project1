package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class CellPhonesPage extends Utility {
    By welcomeText = By.tagName("h1");
    By listViewTab = By.xpath("//a[normalize-space()='List']");
   By nokiaLumia1020ProductName =By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]");
    public String getWelcomePageText() {
        return getTextFromElement(welcomeText);
    }

    public void clickOnListViewTab() {
        clickOnElement(listViewTab);
    }

    public void clickOnNokiaLumia1020ProductName(){
        clickOnElement(nokiaLumia1020ProductName);
    }

}
