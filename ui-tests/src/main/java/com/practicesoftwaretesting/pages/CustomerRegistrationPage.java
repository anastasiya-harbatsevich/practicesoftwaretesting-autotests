package com.practicesoftwaretesting.pages;

import com.practicesoftwaretesting.asserts.RegisterPageAsserts;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CustomerRegistrationPage {

    public CustomerRegistrationPage isLoaded() {
        $("h3").shouldHave(text("Customer registration"));
        return this;
    }

    public RegisterPageAsserts assertThat() {
        return new RegisterPageAsserts();
    }
}
