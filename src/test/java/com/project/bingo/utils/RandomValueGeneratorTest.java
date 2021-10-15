package com.project.bingo.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RandomValueGeneratorTest {
    private static final int testLimit = 5;
    RandomValueGenerator underTest = new RandomValueGenerator(testLimit);

    @Test
    public void setLimitTest() {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        for(int i = 0; i < testLimit; i++) {
            int newNumber = underTest.generateValue();
            assertTrue(set.contains(newNumber));
            set.remove(newNumber);
        }
        assertTrue(set.isEmpty());
    }
}