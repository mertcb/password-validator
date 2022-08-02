package com.codurance.base;

import java.util.List;

public interface ValidationStrategy {
    void validate(String password, List<String> errors, PasswordValidator validator);
}
