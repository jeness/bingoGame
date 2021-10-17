package com.project.bingo.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void isValidInput_GeneratedNumbersAreNotSufficient() {
        assertFalse(Validator.isValidInput(40, 6, 10, 7));
    }

    @Test
    public void isValidInput_NumbersPerRowIsLargerThanColNumber() {
        assertFalse(Validator.isValidInput(40, 6, 6, 7));
    }

    @Test
    public void isValidInput_NumbersInBoardIsLessThanFive() {
        assertFalse(Validator.isValidInput(40, 3, 10, 1));
    }

    @Test
    public void isValidInput_InputIsValid(){
        assertTrue(Validator.isValidInput(40, 3, 5, 4));
    }

    @Test
    public void validateInputIsPositiveNumber_StringWithLetters() {
        assertFalse(Validator.validateInputIsPositiveNumber("something", "A String with letters"));
    }

    @Test
    public void validateInputIsPositiveNumber_NegativeNumber() {
        assertFalse(Validator.validateInputIsPositiveNumber("-10", "Negative Number"));
    }

    @Test
    public void validateInputIsPositiveNumber_InputIsValid() {
        assertTrue(Validator.validateInputIsPositiveNumber("10", "valid"));
    }
}