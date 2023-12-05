package com.nopcommerce.demo.testsuite.Electronics;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ElectronicsTest extends BaseTest {
    ElectronicsPage electronicsPage = new ElectronicsPage();
    HomePage homePage = new HomePage();
    CellPhonesPage cellPhonesPage = new CellPhonesPage();
    CellPhoneProductPage cellPhoneProductPage = new CellPhoneProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    HeaderPage headerPage = new HeaderPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //1.1 Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronics();
        //1.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhone();
        //1.3 Verify the text “Cell phones”
        String expectedPageTitleCellPhones = "Cell phones";
        String actualPageTitleCellPhones = cellPhonesPage.getWelcomePageText();
        Assert.assertEquals(actualPageTitleCellPhones, expectedPageTitleCellPhones);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //2.1 Mouse Hover on “Electronics” Tab
        homePage.mouseHoverOnElectronics();
        //2.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhone();
        //2.3 Verify the text “Cell phones”
        String expectedPageTitleCellPhones = "Cell phones";
        String actualPageTitleCellPhones = cellPhonesPage.getWelcomePageText();
        Assert.assertEquals(actualPageTitleCellPhones, expectedPageTitleCellPhones);

        //2.4 Click on List View Tab
        cellPhonesPage.clickOnListViewTab();
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        cellPhonesPage.clickOnNokiaLumia1020ProductName();
        Thread.sleep(2000);
        //2.6 Verify the text “Nokia Lumia 1020”
        String actualProductTitle = cellPhoneProductPage.getWelcomeProductName();
        String expectedProductTitle = "Nokia Lumia 1020";
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
        //2.7 Verify the price “$349.00”
        String actualProductPrice = cellPhoneProductPage.getProductPrice();
        String expectedProductPrice = "$349.00";
        Assert.assertEquals(actualProductPrice, expectedProductPrice);
        //2.8 Change quantity to 2
        cellPhoneProductPage.changeProductQuantity("2");
        //2.9 Click on “ADD TO CART” tab
        cellPhoneProductPage.clickOnAddToCartBtn();
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualSuccessMsgForAddToCart = cellPhoneProductPage.getAddToCartSuccessfulMessage();
        String expectedSuccessMsgForAddToCart = "The product has been added to your shopping cart";
        Assert.assertEquals(actualSuccessMsgForAddToCart, expectedSuccessMsgForAddToCart);
        //After that close the bar clicking on the cross button
        cellPhoneProductPage.closeSuccessAddToCartMsg();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        headerPage.mouseHoverOnShoppingCart();
        Thread.sleep(2000);
        headerPage.clickOnGoToCartBtn();
        Thread.sleep(2000);
        //2.12 Verify the message "Shopping cart"
        String actualTitleShoppingCart = shoppingCartPage.getWelcomePageText();
        String expectedTitleShoppingCart = "Shopping cart";
        Assert.assertEquals(actualTitleShoppingCart, expectedTitleShoppingCart);
        //2.13 Verify the quantity is 2
        String actualQuantity = shoppingCartPage.getDataFromQuantityField();
        String expectedQuantity = "2";
        Assert.assertEquals(actualQuantity, expectedQuantity);
        //2.14 Verify the Total $698.00
        String actualTotalPrice = shoppingCartPage.getTextFromTotalPriceField();
        String expectedTotalPrice = "$698.00";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfServiceAgreementCheckBox();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutBtn();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String actualCheckOutPageMessage = checkOutPage.getWelcomeText();
        String expectedCheckOutPageMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(actualCheckOutPageMessage, expectedCheckOutPageMessage);
        //2.18 Click on “REGISTER” tab
        checkOutPage.clickOnRegisterBtn();
        //2.19 Verify the text “Register”
        String actualRegisterPageText = registerPage.getWelcomeText();
        String expectedRegisterPageText = "Register";
        Assert.assertEquals(actualRegisterPageText, expectedRegisterPageText);
        //2.20 Fill the mandatory fields
        registerPage.sendDataToFirstNameField("James");
        registerPage.sendDataToLastNameField("Bond");
        Random random = new Random();
        String tempEmail = "jamesbond" + random.nextInt() + "@gmail.com";
        registerPage.sendDataToEmailField(tempEmail);
        registerPage.sendDataToPasswordField("abcd123");
        registerPage.sendDataToConfirmPasswordField("abcd123");
        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        //2.22 Verify the message “Your registration completed”
        String actualConfirmationRegistrationMessage = registerPage.getDataFromConfirmationMessage();
        String expectedCConfirmationRegistrationMessage = "Your registration completed";
        Assert.assertEquals(actualConfirmationRegistrationMessage, expectedCConfirmationRegistrationMessage);
        //2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueButton();
        //2.24 Verify the text “Shopping card”
        String actualTitleShoppingCart1 = shoppingCartPage.getWelcomePageText();
        Assert.assertEquals(actualTitleShoppingCart1, expectedTitleShoppingCart);

        headerPage.clickOnLoginBtn();
        System.out.println(tempEmail);
        loginPage.sendDataToEmailField(tempEmail);
        loginPage.sendDataToPasswordField("abcd123");
        loginPage.clickOnLoginButton();

        //2.25 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfServiceAgreementCheckBox();
        //2.26 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutBtn();
        //2.27 Fill the Mandatory fields
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        checkOutPage.sendDataToCityField("Harrow");
        checkOutPage.sendDataToAddressField("17, Cad Road");
        checkOutPage.sendDataToPostCodeField("HA3 7CD");
        checkOutPage.sendDataToContactField("01234567890");
        checkOutPage.clickOnContinue();

        checkOutPage.clickOnSecondDayAirOption();
        checkOutPage.clickOnShippingMethodContinueButton();

        checkOutPage.clickOnPayByCreditCardOption();
        checkOutPage.clickOnPaymentMethodContinueOption();

        checkOutPage.selectCreditCard("Visa");
        checkOutPage.sendDataToCardholderNameField("James Bond");
        checkOutPage.sendDataToCardNumberField("4001919257537193");
        checkOutPage.sendDataToExpiryDateField("09");
        checkOutPage.sendDataToExpiryYearField("2026");
        checkOutPage.sendDataToCardCodeField("123");
        checkOutPage.clickOnPaymentInformationContinueButton();

        String actualPaymentMethod = checkOutPage.getDataOfPaymentMethod();
        String expectedPaymentMethod = "Credit Card";
        Assert.assertEquals(actualPaymentMethod, expectedPaymentMethod);

        String actualShippingMethod = checkOutPage.getDataOfShippingMethod();
        String expectedShippingMethod = "2nd Day Air";
        Assert.assertEquals(actualShippingMethod, expectedShippingMethod);

        String actualConfirmOrderPrice = checkOutPage.getConfirmOrderPrice();
        String expectedConfirmationPrice = "$698.00";
        Assert.assertEquals(actualConfirmOrderPrice, expectedConfirmationPrice);

        checkOutPage.clickOnConfirmOrderContinueButton();
        checkOutPage.orderConfirmationMessage();

        String actualOrderConfirmationMessage = checkOutPage.orderConfirmationMessage();
        String expectedOrderConfirmationMessage = "Your order has been successfully processed!";
        Assert.assertEquals(actualOrderConfirmationMessage, expectedOrderConfirmationMessage);

        checkOutPage.clickOnOrderConfirmationContinue();
        //2.42 Verify the text “Welcome to our store”

        String actualWelcomeHomePageText = homePage.getWelcomeText();
        String expectedWelcomeHomePageText = "Welcome to our store";
        Assert.assertEquals(actualWelcomeHomePageText, expectedWelcomeHomePageText);

        headerPage.clickOnLogOutBtn();
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”

        String currentUrl = getCurrentURL();
        String actualUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl, currentUrl);
    }
}
