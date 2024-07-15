package com.practicesoftwaretesting.pages;

import com.codeborne.selenide.Selenide;
import com.practicesoftwaretesting.asserts.ContactPageAsserts;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.practicesoftwaretesting.utils.SelectorUtils.byFor;

public class ContactPage {

    public static final By FIRST_NAME_LABEL = byFor("first_name");
    public static final By FIRST_NAME_INPUT = byId("first_name");
    public static final By LAST_NAME_LABEL = byFor("last_name");
    public static final By LAST_NAME_INPUT = byId("last_name");
    public static final By EMAIL_LABEL = byFor("email");
    public static final By EMAIL_INPUT = byId("email");
    public static final By SUBJECT_LABEL = byFor("subject");
    public static final By SUBJECT_INPUT = byId("subject");
    public static final By MESSAGE_LABEL = byFor("message");
    public static final By MESSAGE_INPUT = byId("message");
    public static final By ATTACHMENT_LABEL = byFor("attachment");
    public static final By ATTACHMENT_INPUT = byId("attachment");

    public ContactPage isLoaded() {
        $("h3").shouldHave(text("Contact"));
        return this;
    }

    public ContactPageAsserts assertThat() {
        return new ContactPageAsserts();
    }

    public ContactPage open() {
        Selenide.open("/contact");
        return this;
    }
}
