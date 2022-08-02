package com.codurance.base;

import java.util.List;

public class UppercaseValidation implements ValidationStrategy {

    @Override
    public void validate(String password, List<String> errors, PasswordValidator validator) {
        if(validator.shouldContainsUppercase() && !isContainUppercase(password)){
            errors.add("Password must contain uppercase character.");
        }
    }

    private boolean isContainUppercase(String password){
        return password.matches(".*[A-Z].*");
    }
}
