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
    private List<ValidationStrategy> strategies;
    public PasswordValidator(int characterLimit,  boolean containsUppercase, boolean containsLowercase, boolean containsUnderscore, boolean containsNumber, boolean allowFail) {
        this.characterLimit = characterLimit;
        this.containsUppercase = containsUppercase;
        this.containsLowercase = containsLowercase;
        this.containsUnderscore = containsUnderscore;
        this.containsNumber = containsNumber;
        this.allowFail = allowFail;
        strategies = List.of(new CharacterLimitValidation(),  new UppercaseValidation(), new LowercaseValidation(), new NumberValidation(), new UnderscoreValidation());
    }

    public ValidationResult validate(String password) {
        List<String> errorMessages = new ArrayList<String>(List.of());

        for (ValidationStrategy strategy:strategies) {
            strategy.validate(password, errorMessages, this);
        }

        return new ValidationResult(errorMessages, this.allowFail);
    }
    public int getCharacterLimit() {
        return characterLimit;
    }

    public boolean shouldContainsUppercase() {
        return containsUppercase;
    }
    public boolean shouldContainsLowercase() {
        return containsLowercase;
    }
    public boolean shouldContainsUnderscore() {
        return containsUnderscore;
    }

    public boolean shouldContainsNumber() {
        return containsNumber;
    }
}
