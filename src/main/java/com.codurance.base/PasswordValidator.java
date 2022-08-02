package com.codurance.base;

public class PasswordValidator {
    public boolean validate(String password) {
        if(!isLongerThanEightCharacters(password)){
            return false;
        }

        if(!isContainUppercase(password)){
            return false;
        }

        if(!isContainLowercase(password)){
            return false;
        }

        if(!isContainsDigit(password)){
            return false;
        }

        if(!isContainsUnderscore(password)){
            return false;
        }

        return true;
    }

    private boolean isLongerThanEightCharacters(String password){
        return password.length()>8;
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
