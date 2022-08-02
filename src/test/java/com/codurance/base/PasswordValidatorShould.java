package com.codurance.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorShould {

    @Test
    void validateWhenMoreThan8Characters() {
        PasswordValidator validator = new PasswordValidator();
        String password = "123456789";
        boolean result = validator.validate(password);
        assertTrue(result);
    }
}
