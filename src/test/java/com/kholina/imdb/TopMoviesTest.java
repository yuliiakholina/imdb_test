package com.kholina.imdb;

import com.kholina.imdb.page_object.MoviePage;
import com.kholina.imdb.page_object.SignInPage;
import com.kholina.imdb.page_object.TopMoviesPage;
import org.junit.jupiter.api.Test;

import static com.kholina.imdb.constant.DataUtil.getRandomMovieIndex;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopMoviesTest extends BaseTest {
    private TopMoviesPage topMoviesPage = new TopMoviesPage();
    private MoviePage moviePage = new MoviePage();
    private SignInPage signInPage = new SignInPage();

    @Test
    void verifyClickingMovieTitleRedirectsToMoviePage() {
        String movie = topMoviesPage.clickMovieTitle(getRandomMovieIndex());
        assertTrue(moviePage.verifyUserIsOnMoviePage(movie));
    }

    @Test
    void verifyClickingAddToWatchListRedirectsToSignIn() {
        topMoviesPage.clickAddToWatchListButton(getRandomMovieIndex());
        signInPage.verifyUserIsOnSignInPage();
    }

    @Test
    void verifyReverseOrderSorting() {
        assertTrue(topMoviesPage.verifySortingMoviesReverseOrder());
    }

    @Test
    void verifySortingByReleasedDate() {
        assertTrue(topMoviesPage.verifySortingMoviesByReleasedDate());
    }
}
