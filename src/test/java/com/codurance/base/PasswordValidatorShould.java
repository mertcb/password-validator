package com.codurance.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorShould {

    @Test
    void notValidateWhenLessThan8Characters() {
        PasswordValidator validator = new PasswordValidator();
        String password = "1234567";
        boolean result = validator.validate(password);
        assertFalse(result);
    }

    @Test
    void notValidateWhenPasswordHasCapitalCharacter() {
        PasswordValidator validator = new PasswordValidator();
        String password = "123456789g";
        boolean result = validator.validate(password);
        assertFalse(result);
    }

    @Test
    void notValidateWhenPasswordHasNotAnyLowercaseLetter() {
        PasswordValidator validator = new PasswordValidator();
        String password = "123456789Gg";
        boolean result = validator.validate(password);
        assertFalse(result);
    }
}
