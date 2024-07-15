package com.practicesoftwaretesting.pages;

import com.practicesoftwaretesting.asserts.HeaderAsserts;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.practicesoftwaretesting.utils.SelectorUtils.byDataTest;

public class Header {

    private static final By NAVIGATION_SIGN_IN = byDataTest("nav-sign-in");
    protected static final By NAVIGATION_PROFILE_MENU = byDataTest("nav-menu");
    private static final By NAVIGATION_CONTACT = byDataTest("nav-contact");
    private static final By NAVIGATION_CART = byDataTest("nav-cart");

    public void clickSignInMenuItem() {
        $(NAVIGATION_SIGN_IN).click();
    }

    public HeaderAsserts assertThat() {
        return new HeaderAsserts();
    }

    public void clickContactMenuItem() {
        $(NAVIGATION_CONTACT).click();
    }

    public void clickCartMenUItem() {
        $(NAVIGATION_CART).click();
    }
}