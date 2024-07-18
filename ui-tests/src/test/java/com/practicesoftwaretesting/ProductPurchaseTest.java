package com.practicesoftwaretesting;

import com.practicesoftwaretesting.pages.*;
import org.junit.Test;

import static com.practicesoftwaretesting.user.UserSteps.getUserEmail;

public class ProductPurchaseTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    Header header = new Header();
    CheckoutPage checkoutPage = new CheckoutPage();

    private String userId;

    @Test
    public void addProductToCartAndPurchaseIt() {
        var email = getUserEmail();
        userId = registerUser(email);
        loginUser(email, defaultPassword);

        homePage.clickOnTheFirstProduct();

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

        deleteUser(userId);
    }
}
