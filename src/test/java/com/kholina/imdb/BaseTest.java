package com.kholina.imdb;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.kholina.imdb.constant.Constant.BASE_URL;

public class BaseTest {
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = true;
        Configuration.pageLoadStrategy = "eager";
        open(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        getWebDriver().quit();
    }
}
