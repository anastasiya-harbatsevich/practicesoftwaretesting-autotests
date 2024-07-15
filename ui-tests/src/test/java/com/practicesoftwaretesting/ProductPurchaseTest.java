package com.practicesoftwaretesting;

import com.practicesoftwaretesting.pages.*;
import com.practicesoftwaretesting.user.UserSteps;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.practicesoftwaretesting.user.UserSteps.DEFAULT_PASSWORD;

public class ProductPurchaseTest {

    UserSteps userSteps = new UserSteps();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    Header header = new Header();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void addProductToCartAndPurchaseIt() {
        var email = userSteps.getUserEmail();
        userSteps.registerUser(email, DEFAULT_PASSWORD);

        open("https://practicesoftwaretesting.com/auth/login");
        loginPage.login(email, DEFAULT_PASSWORD);
        accountPage.isLoaded();

        open("https://practicesoftwaretesting.com/#/");

        homePage.isLoaded()
                .clickOnTheFirstProduct();

        productPage.isLoaded()
                .addToCart();

        header.clickCartMenUItem();
        checkoutPage.isLoaded()
                .proceedToCheckOut()
                .proceedToCheckOutSignedIn()
                .proceedToCheckOutBillingAddress()
                .chooseCashPaymentMethodAndConfirm()
                .assertThat()
                .successfulMessageIsDisplayed();
    }
}
