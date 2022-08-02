package com.codurance.base;

import java.util.List;

public class NumberValidation implements ValidationStrategy {

    @Override
    public void validate(String password, List<String> errors, PasswordValidator validator) {
        if(validator.shouldContainsNumber() && !isContainNumber(password)){
            errors.add("Password must contain number.");
        }
    }

    private boolean isContainNumber(String password){
        return password.matches(".*[0-9].*");
    }
}
