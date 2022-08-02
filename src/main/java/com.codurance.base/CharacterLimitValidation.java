package com.codurance.base;

import java.util.List;

public class CharacterLimitValidation implements ValidationStrategy {

    @Override
    public void validate(String password, List<String> errors, PasswordValidator validator) {
        if(!isLongerThanCharacterLimit(password, validator.getCharacterLimit())){
            errors.add("Password is shorter than expected limit.");
        }
    }

    private boolean isLongerThanCharacterLimit(String password, int characterLimit){
        return password.length()> characterLimit;
    }
}
