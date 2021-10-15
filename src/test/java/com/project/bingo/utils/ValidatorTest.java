package com.project.bingo.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void isValidInput_InputIsNotValid() {
        assertFalse(Validator.isValidInput(40, 6, 10, 7));
        assertFalse(Validator.isValidInput(40, 6, 6, 7));
        assertFalse(Validator.isValidInput(40, 3, 10, 1));
    }

    @Test
    public void isValidInput_InputIsValid(){
        assertTrue(Validator.isValidInput(40, 3, 5, 4));
    }

    @Test
    public void validateInputIsPositiveNumberTest() {
        assertTrue(Validator.validateInputIsPositiveNumber("10", "valid"));
        assertFalse(Validator.validateInputIsPositiveNumber("-10", "not valid"));
        assertFalse(Validator.validateInputIsPositiveNumber("something", "not valid"));
    }
}