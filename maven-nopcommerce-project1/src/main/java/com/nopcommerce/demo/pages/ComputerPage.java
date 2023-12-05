package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;

public class ComputerPage extends Utility {
    By clickOnDesktop = By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']");

    public void clickOnDesktop() {
        clickOnElement(clickOnDesktop);
    }
}
