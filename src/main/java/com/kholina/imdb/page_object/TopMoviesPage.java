package com.kholina.imdb.page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.kholina.imdb.constant.Constant.RELEASE_DATE;

public class TopMoviesPage {
    private List<SelenideElement> titles = $$(".titleColumn >a");
    private List<SelenideElement> moviesRows = $$(".lister-list >tr");
    private SelenideElement sortReverseButton = $(".lister-sort-reverse");
    private SelenideElement dropdownList = $(By.id("lister-sort-by-options"));
    private By moviesLocator = By.cssSelector(".wl-ribbon");
    private By releasedLocator = By.cssSelector(".secondaryInfo");
    private static Logger log = LoggerFactory.getLogger(TopMoviesPage.class);

    public String clickMovieTitle(int movieIndex) {
        log.info("Click movie title for movie with index", movieIndex);
        SelenideElement movie = titles.get(movieIndex);
        String movieName = movie.getText();
        movie.click();
        return movieName;
    }

    public void clickAddToWatchListButton(int movieIndex) {
        log.info("Click add to watch list button for movie with index", movieIndex);
        moviesRows.get(movieIndex).findElement(moviesLocator).click();
    }

    public boolean verifySortingMoviesByReleasedDate() {
        log.info("Verify movies could be sorted by release date");
        dropdownList.selectOptionContainingText(RELEASE_DATE);
        List<String> imdBRatingsActual = moviesRows.stream()
                .map(element -> element.findElement(releasedLocator).getText()).collect(Collectors.toList());
        List<String> imdBRatingsExpected = moviesRows.stream()
                .map(element -> element.find(releasedLocator).getText()).sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return imdBRatingsActual.equals(imdBRatingsExpected);
    }

    public boolean verifySortingMoviesReverseOrder() {
        log.info("Verify movies could be sorted in reverse order");
        List<String> expectedMovies = titles.stream().map(SelenideElement::getText).collect(Collectors.toList());
        Collections.reverse(expectedMovies);
        sortReverseButton.click();
        List<String> actualMovies = titles.stream().map(SelenideElement::getText).collect(Collectors.toList());
        return expectedMovies.equals(actualMovies);
    }
}
