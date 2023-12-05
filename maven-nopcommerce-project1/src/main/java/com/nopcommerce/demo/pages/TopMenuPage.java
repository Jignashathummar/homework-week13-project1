package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuPage extends Utility {
    By getListMenu = By.xpath("//ul[@class='top-menu notmobile']/li");
    By getClickedMenuTitle = By.tagName("h1");

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = getListOfElements(getListMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(getListMenu);
        }
    }

    public String getSelectedMenuTitle(){
        return getTextFromElement(getClickedMenuTitle);
    }
}
