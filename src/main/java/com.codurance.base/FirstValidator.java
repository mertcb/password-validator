package com.codurance.base;

public class FirstValidator extends PasswordValidator{
    static PasswordValidator generateValidator(){
        PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
        builder.setCharacterLimit(8);
        builder.setContainsUppercase();
        builder.setContainsLowercase();
        builder.setContainsUnderscore();
        builder.setContainsNumber();
        return builder.buildValidator();
    }

    public FirstValidator(int characterLimit, boolean containsUppercase, boolean containsLowercase, boolean containsUnderscore, boolean containsNumber, boolean allowFail) {
        super(characterLimit, containsUppercase, containsLowercase, containsUnderscore, containsNumber, allowFail);
    }
}
