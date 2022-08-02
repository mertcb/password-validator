package com.codurance.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorShould {

    private PasswordValidator validator;

    @ParameterizedTest
    @MethodSource(value = "inputsForFirstValidator")
    void validateFirstValidator(String password, boolean expected) {
        // given
        PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
        builder.setCharacterLimit(8);
        builder.setContainsUppercase();
        builder.setContainsLowercase();
        builder.setContainsUnderscore();
        builder.setContainsNumber();
        validator = builder.buildValidator();

        // when
        ValidationResult result = validator.validate(password);

        // then
        assertEquals(expected, result.isValid());
    }

    private static Stream<Arguments> inputsForFirstValidator() {
        return Stream.of(
            Arguments.of("1234567", false),
            Arguments.of("123456789g", false),
            Arguments.of("123456789G", false),
            Arguments.of("ASDqweRTe", false),
            Arguments.of("ASDqweRTe1", false),
            Arguments.of("_23ASDq_weRTe1", true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputsForSecondValidator")
    void validateSecondValidator(String password, boolean expected) {
        // given
        PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
        builder.setCharacterLimit(6);
        builder.setContainsUppercase();
        builder.setContainsLowercase();
        builder.setContainsNumber();
        validator = builder.buildValidator();

        // when
        ValidationResult result = validator.validate(password);

        // then
        assertEquals(expected, result.isValid());
    }

    private static Stream<Arguments> inputsForSecondValidator() {
        return Stream.of(
            Arguments.of("12345", false),
            Arguments.of("123456789g", false),
            Arguments.of("123456789G", false),
            Arguments.of("ASDqweRTe1", true),
            Arguments.of("_23ASDq_weRTe1", true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputsForThirdValidator")
    void validateThirdValidator(String password, boolean expected) {
        // given
        PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
        builder.setCharacterLimit(16);
        builder.setContainsUppercase();
        builder.setContainsLowercase();
        builder.setContainsUnderscore();
        validator = builder.buildValidator();

        // when
        ValidationResult result = validator.validate(password);

        // then
        assertEquals(expected, result.isValid());
    }

    private static Stream<Arguments> inputsForThirdValidator() {
        return Stream.of(
            Arguments.of("1234567891234", false),
            Arguments.of("123456789ggggggggg", false),
            Arguments.of("123456789GGGGGGGGG", false),
            Arguments.of("ASDqweRTe______GDFSFS__", true),
            Arguments.of("_23ASDq_weRTe1+___SDSADasdasd", true)
        );
    }
}
