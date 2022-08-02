package com.codurance.base;

public class PasswordValidatorBuilder {

    private int characterLimit;
    private boolean containsUppercase = false;
    private boolean containsLowercase = false;
    private boolean containsUnderscore = false;
    private boolean containsNumber = false;

    public void setCharacterLimit(int limit) {
        this.characterLimit = limit;
    }

    public void setContainsUnderscore() {
        this.containsUnderscore = true;
    }

    public void setContainsLowercase() {
        this.containsLowercase = true;
    }

    public void setContainsUppercase() {
        this.containsUppercase = true;
    }

    public void setContainsNumber() {
        this.containsNumber = true;
    }

    public PasswordValidator buildValidator(){
        return new PasswordValidator(this.characterLimit, this.containsUppercase, this.containsLowercase, this.containsUnderscore, this.containsNumber);
    }
}
