package com.codurance.base;

public class ThirdValidator extends PasswordValidator{
    static PasswordValidator generateValidator(){
        PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
        builder.setCharacterLimit(16);
        builder.setContainsUppercase();
        builder.setContainsLowercase();
        builder.setContainsUnderscore();
        return builder.buildValidator();
    }

    public ThirdValidator(int characterLimit, boolean containsUppercase, boolean containsLowercase, boolean containsUnderscore, boolean containsNumber, boolean allowFail) {
        super(characterLimit, containsUppercase, containsLowercase, containsUnderscore, containsNumber, allowFail);
    }
}
