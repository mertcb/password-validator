package com.codurance.base;

public class PasswordValidatorBuilder implements Builder{
    private int characterLimit;
    private boolean containsUppercase = false;
    private boolean containsLowercase = false;
    private boolean containsUnderscore = false;
    private boolean containsNumber = false;

    @Override
    public void setCharacterLimit(int limit) {
        this.characterLimit = limit;
    }

    @Override
    public void setContainsUnderscore() {
        this.containsUnderscore = true;
    }

    @Override
    public void setContainsLowercase() {
        this.containsLowercase = true;
    }

    @Override
    public void setContainsUppercase() {
        this.containsUppercase = true;
    }

    @Override
    public void setContainsNumber() {
        this.containsNumber = true;
    }

    public PasswordValidator buildValidator(){
        return new PasswordValidator(this.characterLimit, this.containsUppercase, this.containsLowercase, this.containsUnderscore, this.containsNumber);
    }
}
