package com.nopcommerce.demo.testsuite.computer;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputerTest extends BaseTest {
    HomePage homepage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu
        homepage.clickOnComputer();
        //1.2 Click on Desktop
        computerPage.clickOnDesktop();
        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectPositionZtoA("Name: Z to A");
        Thread.sleep(2000);
        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> list = desktopPage.getAllProductTitleOnPage();
        ArrayList originalList = new ArrayList();
        for (WebElement l : list) {
            originalList.add(l.getText());
        }
        Collections.reverse(originalList);
        desktopPage.sortByFilter("Name: Z to A");
        Thread.sleep(2000);
        ArrayList sortedList = new ArrayList();
        list = desktopPage.getAllProductTitleOnPage();
        for (WebElement l : list) {
            sortedList.add(l.getText());
        }
        //System.out.println(sortedList);
        Assert.assertEquals(originalList, sortedList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu
        homepage.clickOnComputer();
        //2.2 Click on Desktop
        computerPage.clickOnDesktop();
        //2.3 Select Sort By position "Name: A to Z"
        List<WebElement> list = desktopPage.getAllProductTitleOnPage();
        ArrayList originalList = new ArrayList();
        for (WebElement l : list) {
            originalList.add(l.getText());
        }
        Collections.sort(originalList);
        System.out.println(originalList);

        desktopPage.sortByFilter("Name: A to Z");
        Thread.sleep(2000);
        ArrayList sortedList = new ArrayList();
        list = desktopPage.getAllProductTitleOnPage();
        for (WebElement l : list) {
            sortedList.add(l.getText());
        }
        System.out.println(sortedList);
        Assert.assertEquals(originalList, sortedList);

        Thread.sleep(2000);
        //2.4 Click on "Add To Cart"
        desktopPage.clickOnAddToCart();
        //2.5 Verify the Text "Build your own computer"
        String expectedTextBuildComputer = "Build your own computer";
        String actualTextBuildComputer = buildYourOwnComputerPage.getTextBuildOwnComputer();
        Assert.assertEquals(expectedTextBuildComputer, actualTextBuildComputer);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildYourOwnComputerPage.selectDualCore("2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        buildYourOwnComputerPage.select8GB("8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        buildYourOwnComputerPage.selectRadioButton();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        buildYourOwnComputerPage.selectRadioVistaPremium();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        buildYourOwnComputerPage.clickOnCheckbox();
        Thread.sleep(2000);
        //2.11 Verify the price "$1,475.00"
        String expectedTotal = "$1,475.00";
        String actualTotal = buildYourOwnComputerPage.getTextTotal();
        Assert.assertEquals(expectedTotal, actualTotal);
        //2.12 Click on "ADD TO CARD" Button.
        buildYourOwnComputerPage.clickOnAddToCart();
        //2.13 Verify the Message "The product has been added to your shopping cart" on To green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = buildYourOwnComputerPage.getTextFromMessage();
        //After that close the bar clicking on the cross button
        buildYourOwnComputerPage.clickOnCloseButton();
        Thread.sleep(2000);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        buildYourOwnComputerPage.mouseHoverOnAddToCart();
        buildYourOwnComputerPage.clikOnAddToCart();
        //2.15 Verify the message "Shopping cart"
        String expectedShoppingCart = "Shopping cart";
        String actualShoppingCart = shoppingCartPage.getWelcomePageText();
        Assert.assertEquals(expectedShoppingCart, actualShoppingCart);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.clearText();
        shoppingCartPage.sendTextChangeQuantity("2");
        shoppingCartPage.clickOnUpdateCart();
        //2.17 Verify the Total"$2,950.00"
        String actualTotalPrice = shoppingCartPage.getTextFromTotalPriceField();
        String expectedTotalPrice = "$2,950.00";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
        //2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfServiceAgreementCheckBox();
        //2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOut();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String actualCheckOutPageMessage = checkOutPage.getWelcomeText();
        String expectedCheckOutPageMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(actualCheckOutPageMessage, expectedCheckOutPageMessage);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        checkOutPage.clickOnCheckOutAsGuest();
        //2.22 Fill the all mandatory field
        checkOutPage.sendDataToFirstNameField("Abcd");
        checkOutPage.sendDataToLastNameField("Xyz");
        Random random = new Random();
        checkOutPage.sendDataToEmailField("abcd" + random.nextInt() + "@gmail.com");
        System.out.println(random);
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        checkOutPage.sendDataToCityField("Harrow");
        checkOutPage.sendDataToAddressField("17, Abc Road");
        checkOutPage.sendDataToPostCodeField("HA3 7CD");
        checkOutPage.sendDataToContactField("012458222274");
        //2.23 Click on “CONTINUE”
        checkOutPage.clickOnContinue();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkOutPage.clickOnNextDayAirOption();
        //2.25 Click on “CONTINUE”
        checkOutPage.clickOnShippingMethodContinueButton();
        //2.26 Select Radio Button “Credit Card”
        checkOutPage.clickOnPayByCreditCardOption();
        checkOutPage.clickOnPaymentMethodContinueOption();
        //2.27 Select “Master card” From Select credit card dropdown
        checkOutPage.selectCreditCard("Master card");
        //2.28 Fill all the details
        checkOutPage.sendDataToCardholderNameField("Abcdxyz");
        checkOutPage.sendDataToCardNumberField("5425233430109903");
        checkOutPage.sendDataToExpiryDateField("04");
        checkOutPage.sendDataToExpiryYearField("2026");
        checkOutPage.sendDataToCardCodeField("456");
        //2.29 Click on “CONTINUE”
        checkOutPage.clickOnPaymentInformationContinueButton();
        //2.30 Verify “Payment Method” is “Credit Card”
        String actualPaymentMethod = checkOutPage.getDataOfPaymentMethod();
        String expectedPaymentMethod = "Credit Card";
        Assert.assertEquals(actualPaymentMethod, expectedPaymentMethod);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String actualShippingMethod = checkOutPage.getDataOfShippingMethod();
        String expectedShippingMethod = "Next Day Air";
        Assert.assertEquals(actualShippingMethod, expectedShippingMethod);
        //2.34 Click on “CONFIRM”
        checkOutPage.clickOnConfirmOrderContinueButton();
        checkOutPage.orderConfirmationMessage();
        //2.35 Verify the Text “Thank You”
        String actualOrderConfirmationMessage = checkOutPage.orderConfirmationMessage();
        String expectedOrderConfirmationMessage = "Your order has been successfully processed!";
        Assert.assertEquals(actualOrderConfirmationMessage, expectedOrderConfirmationMessage);
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedsuccessfullyMessage = "Verify the message “Your order has been successfully processed!”";
        String actualsuccessfullyMessage = checkOutPage.getTextsuccessfullMessage();
        Assert.assertEquals(expectedsuccessfullyMessage, actualsuccessfullyMessage);
        //2.37 Click on “CONTINUE”
        checkOutPage.clickOnOrderConfirmationContinue();
        //2.38 Verify the text “Welcome to our store”
        homepage.getWelcomeText();
    }
}

