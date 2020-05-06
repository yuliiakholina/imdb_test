package com.kholina.imdb.constant;

import java.util.concurrent.ThreadLocalRandom;

public class DataUtil {

    private DataUtil(){

    }

    public static int getRandomMovieIndex() {
        return ThreadLocalRandom.current().nextInt(0, 249);
    }
}
