package com.kholina.imdb.page_object;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class MoviePage {
    private SelenideElement movieTitle = $(".title_wrapper > h1");
    private static Logger log = LoggerFactory.getLogger(MoviePage.class);

    public boolean verifyUserIsOnMoviePage(String movieName) {
        log.info("Verify user is on Sign In page");
        return movieTitle.getText().contains(movieName);
    }
}
