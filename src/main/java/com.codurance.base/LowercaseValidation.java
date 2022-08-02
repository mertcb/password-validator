package com.codurance.base;

import java.util.List;

public class LowercaseValidation implements ValidationStrategy {

    @Override
    public void validate(String password, List<String> errors, PasswordValidator validator) {
        if(validator.shouldContainsLowercase() && !isContainLowercase(password)){
            errors.add("Password must contain lowercase character.");
        }
    }

    private boolean isContainLowercase(String password){
        return password.matches(".*[a-z].*");
    }
}
