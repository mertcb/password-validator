package com.codurance.base;

public class SecondValidator extends PasswordValidator{
    static PasswordValidator generateValidator(){
        PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
        builder.setCharacterLimit(6);
        builder.setContainsUppercase();
        builder.setContainsLowercase();
        builder.setContainsNumber();
        return builder.buildValidator();
    }

    public SecondValidator(int characterLimit, boolean containsUppercase, boolean containsLowercase, boolean containsUnderscore, boolean containsNumber, boolean allowFail) {
        super(characterLimit, containsUppercase, containsLowercase, containsUnderscore, containsNumber, allowFail);
    }
}
