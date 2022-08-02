package com.codurance.base;

public class PasswordValidator {
    private int characterLimit;

    private boolean containsUppercase;
    private boolean containsLowercase;
    private boolean containsUnderscore;
    private boolean containsNumber;

    public PasswordValidator(int characterLimit, boolean containsUppercase, boolean containsLowercase, boolean containsUnderscore, boolean containsNumber) {
        this.characterLimit = characterLimit;
        this.containsUppercase = containsUppercase;
        this.containsLowercase = containsLowercase;
        this.containsUnderscore = containsUnderscore;
        this.containsNumber = containsNumber;
    }


    public boolean validate(String password) {
        if(!isLongerThanCharacterLimit(password)){
            return false;
        }

        if(containsUppercase && !isContainUppercase(password)){
            return false;
        }

        if(containsLowercase && !isContainLowercase(password)){
            return false;
        }

        if(containsNumber && !isContainsDigit(password)){
            return false;
        }

        if(containsUnderscore && !isContainsUnderscore(password)){
            return false;
        }

        return true;
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
