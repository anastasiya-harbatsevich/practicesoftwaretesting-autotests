package com.practicesoftwaretesting.asserts;

import com.practicesoftwaretesting.pages.CheckoutPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckOutPageAsserts extends CheckoutPage {

    public CheckOutPageAsserts successfulMessageIsDisplayed() {
        $(MESSAGE).shouldHave(text("Payment was successful"));
        return this;
    }
}
