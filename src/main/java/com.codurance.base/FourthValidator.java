package com.codurance.base;

public class FourthValidator extends PasswordValidator{
    static PasswordValidator generateValidator(){
        PasswordValidatorBuilder builder = new PasswordValidatorBuilder();
        builder.setCharacterLimit(16);
        builder.setContainsUppercase();
        builder.setContainsLowercase();
        builder.setContainsUnderscore();
        builder.setAllowFail();
        return builder.buildValidator();
    }

    public FourthValidator(int characterLimit, boolean containsUppercase, boolean containsLowercase, boolean containsUnderscore, boolean containsNumber, boolean allowFail) {
        super(characterLimit, containsUppercase, containsLowercase, containsUnderscore, containsNumber, allowFail);
    }
}
