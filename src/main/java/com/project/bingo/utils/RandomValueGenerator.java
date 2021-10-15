package com.project.bingo.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.project.bingo.utils.Constants.DEFAULT_LIMIT_NUMBER;

/**
 * this class is intended to generate random number in range 1 ~ limit
 * and not appeared before
 */
public class RandomValueGenerator {
    private int limit;
    private Set<Integer> usedNumber;

    public RandomValueGenerator() {
        this.limit = DEFAULT_LIMIT_NUMBER;
        this.usedNumber = new HashSet<>();
    }


    public RandomValueGenerator(int limit) {
        this.limit = limit;
        this.usedNumber = new HashSet<>();
    }


    /**
     * this method is intended to generate a random value in the range [1, limit]
     * and the value not used
     * @return random value generated
     */
    public int generateValue() {
        Random random = new Random();
        int number = random.nextInt(limit) + 1;  // (0 ... limit - 1) + 1 -> 1 ... limit
        while(usedNumber.contains(number)) {
            number = random.nextInt(limit) + 1;
        }
        usedNumber.add(number);
        return number;
    }
}
