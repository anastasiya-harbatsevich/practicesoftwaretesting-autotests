package com.practicesoftwaretesting.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.practicesoftwaretesting.utils.SelectorUtils.byDataTest;
import static org.openqa.selenium.By.className;

public class HomePage {

    private static final By BANNER = className("img-fluid");
    public static final By PRODUCT_CARDS = byDataTest("product-name");

    public HomePage isLoaded() {
        $(BANNER).shouldBe(visible);
        return this;
    }

    public HomePage open() {
        Selenide.open("/");
        return this;
    }

    public void clickOnTheFirstProduct() {
        $$(PRODUCT_CARDS).first().click();
    }
}