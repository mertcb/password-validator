package com.codurance.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorShould {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void validate(String password, boolean expected) {
        // given

        // when
        boolean result = validator.validate(password);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputs() {
        return Stream.of(
            Arguments.of("1234567", false),
            Arguments.of("123456789g", false),
            Arguments.of("123456789G", false),
            Arguments.of("ASDqweRTe", false),
            Arguments.of("ASDqweRTe1", false),
            Arguments.of("_23ASDq_weRTe1", true)
        );
    }
}
