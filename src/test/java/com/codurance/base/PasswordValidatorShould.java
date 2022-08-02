package com.codurance.base;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorShould {

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void validate(PasswordValidator validator, String password, boolean expected, List<String> expectedErrorMessages) {
        // given

        // when
        ValidationResult result = validator.validate(password);

        // then
        assertEquals(expected, result.isValid());
        assertEquals(expectedErrorMessages, result.getErrorMessages());
    }

    private static Stream<Arguments> inputs() {
        PasswordValidator firstValidator = FirstValidator.generateValidator();
        PasswordValidator secondValidator = SecondValidator.generateValidator();
        PasswordValidator thirdValidator = ThirdValidator.generateValidator();
        PasswordValidator fourthValidator = FourthValidator.generateValidator();

        return Stream.of(
            Arguments.of(firstValidator, "1234567", false, List.of("Password is shorter than expected limit.", "Password must contain uppercase character.", "Password must contain lowercase character.", "Password must contain underscore.")),
            Arguments.of(firstValidator, "123456789g", false, List.of("Password must contain uppercase character.", "Password must contain underscore.")),
            Arguments.of(firstValidator, "123456789G", false, List.of("Password must contain lowercase character.", "Password must contain underscore.")),
            Arguments.of(firstValidator, "ASDqweRTe", false, List.of("Password must contain number.", "Password must contain underscore.")),
            Arguments.of(firstValidator, "ASDqweRTe1", false, List.of("Password must contain underscore.")),
            Arguments.of(firstValidator, "_23ASDq_weRTe1", true, List.of()),
            Arguments.of(secondValidator, "12345", false, List.of("Password is shorter than expected limit.", "Password must contain uppercase character.", "Password must contain lowercase character.")),
            Arguments.of(secondValidator, "123456789g", false, List.of("Password must contain uppercase character.")),
            Arguments.of(secondValidator, "123456789G", false, List.of("Password must contain lowercase character.")),
            Arguments.of(secondValidator, "ASDqweRTe1", true, List.of()),
            Arguments.of(secondValidator, "_23ASDq_weRTe1", true, List.of()),
            Arguments.of(thirdValidator, "1234567891234", false, List.of("Password is shorter than expected limit.", "Password must contain uppercase character.", "Password must contain lowercase character.", "Password must contain underscore.")),
            Arguments.of(thirdValidator, "123456789ggggggggg", false, List.of("Password must contain uppercase character.", "Password must contain underscore.")),
            Arguments.of(thirdValidator, "123456789GGGGGGGGG", false, List.of("Password must contain lowercase character.", "Password must contain underscore.")),
            Arguments.of(thirdValidator, "ASDqweRTe______GDFSFS__", true, List.of()),
            Arguments.of(thirdValidator, "_23ASDq_weRTe1+___SDSADasdasd", true, List.of()),
            Arguments.of(fourthValidator, "ASDqweRTe____", true, List.of("Password is shorter than expected limit.")),
            Arguments.of(fourthValidator, "ASDRT____", false, List.of("Password is shorter than expected limit.","Password must contain lowercase character."))
        );
    }
}
