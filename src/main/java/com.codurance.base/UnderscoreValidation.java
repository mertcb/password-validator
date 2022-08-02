package com.codurance.base;

import java.util.List;

public class UnderscoreValidation implements ValidationStrategy {

    @Override
    public void validate(String password, List<String> errors, PasswordValidator validator) {
        if(validator.shouldContainsUnderscore() && !isContainUnderscore(password)){
            errors.add("Password must contain underscore.");
        }
    }

    private boolean isContainUnderscore(String password){
        return password.matches(".*[_].*");
    }
}
