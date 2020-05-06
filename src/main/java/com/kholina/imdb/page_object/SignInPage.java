package com.kholina.imdb.page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private SelenideElement signInOptions = $(By.id("signin-options"));
    private static Logger log = LoggerFactory.getLogger(SignInPage.class);

    public boolean verifyUserIsOnSignInPage() {
        log.info("Verify user is on Sign In page");
        return signInOptions.isDisplayed();
    }
}
