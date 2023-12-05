package com.nopcommerce.demo.testsuite.TopMenu;

import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    TopMenuPage topMenuPage = new TopMenuPage();

    @Test
    public void verifyPageNavigation(){
        // create method with name "selectMenu" it has one parameter name "menu" of type string
        topMenuPage.selectMenu("Electronics");
        String actualSelectedMenuTitle = topMenuPage.getSelectedMenuTitle();
        String expectedSelectedMenuTitle = "Electronics";
        Assert.assertEquals(actualSelectedMenuTitle, expectedSelectedMenuTitle);
    }
}
