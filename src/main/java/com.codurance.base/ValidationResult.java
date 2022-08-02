package com.codurance.base;

import java.util.List;

public class ValidationResult {

    private boolean isValid = true;
    private List<String> errorMessages;

    public ValidationResult(List<String> errorMessages, boolean allowFail) {
        if(!allowFail && errorMessages.size()>0){
            this.isValid = false;
        }

        if(allowFail && errorMessages.size()>1){
            this.isValid = false;
        }

        this.errorMessages = errorMessages;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
