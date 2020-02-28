package com.company;

import java.util.Random;

public class hRandom {

    private static Random localRandom;
    // the following would work too (and is the preferred way!),
    // but for easier understanding / demonstration I put the instantiation into the method
    // private static Random localRandom = new Random();

    /**
     * returns a random value between min (inclusive) and max (inclusive)
     *
     * @param min minimum value
     * @param max maximum value
     * @return random integer
     */
    public static int getRandomNumberInRange(int min, int max) {
        // only create one instance!
        if (localRandom == null) {
            localRandom = new Random();
        }

        if (min >= max) {
            throw new IllegalArgumentException("max (" + max + ") must be greater than min (" + min + ")");
        }

        return localRandom.nextInt((max - min) + 1) + min;
    }
}
