package com.codurance.base;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    private int characterLimit;

    private boolean containsUppercase;
    private boolean containsLowercase;
    private boolean containsUnderscore;
    private boolean containsNumber;

    private boolean allowFail;

    public PasswordValidator(int characterLimit, boolean containsUppercase, boolean containsLowercase, boolean containsUnderscore, boolean containsNumber, boolean allowFail) {
        this.characterLimit = characterLimit;
        this.containsUppercase = containsUppercase;
        this.containsLowercase = containsLowercase;
        this.containsUnderscore = containsUnderscore;
        this.containsNumber = containsNumber;
        this.allowFail = allowFail;
    }

    public ValidationResult validate(String password) {
        List<String> errorMessages = new ArrayList<String>(List.of());
        if(!isLongerThanCharacterLimit(password)){
            errorMessages.add("Password is shorter than expected limit.");
        }

        if(containsUppercase && !isContainUppercase(password)){
            errorMessages.add("Password must contain uppercase character.");
        }

        if(containsLowercase && !isContainLowercase(password)){
            errorMessages.add("Password must contain lowercase character.");
        }

        if(containsNumber && !isContainsDigit(password)){
            errorMessages.add("Password must contain number.");
        }

        if(containsUnderscore && !isContainsUnderscore(password)){
            errorMessages.add("Password must contain underscore.");
        }

        return new ValidationResult(errorMessages, this.allowFail);
    }

    private boolean isLongerThanCharacterLimit(String password){
        return password.length()>this.characterLimit;
    }

    private boolean isContainUppercase(String password){
        return password.matches(".*[A-Z].*");
    }

    private boolean isContainLowercase(String password){
        return password.matches(".*[a-z].*");
    }

    private boolean isContainsDigit(String password){
        return password.matches(".*[0-9].*");
    }

    private boolean isContainsUnderscore(String password){
        return password.matches(".*[_].*");
    }
}
