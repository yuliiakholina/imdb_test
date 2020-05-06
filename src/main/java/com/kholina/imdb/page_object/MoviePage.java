package com.kholina.imdb.page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.kholina.imdb.constant.Constant.DEFAULT_WAIT_TIME;

public class MoviePage {
    private SelenideElement movieTitle = $(".title_wrapper > h1");
    private static Logger log = LoggerFactory.getLogger(MoviePage.class);

    public boolean verifyUserIsOnMoviePage(String movieName) {
        log.info("Verify user is on Sign In page");
        return movieTitle.waitUntil(Condition.visible,DEFAULT_WAIT_TIME).getText().contains(movieName);
    }
}
