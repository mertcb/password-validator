package com.codurance.base;

public interface Builder {
    void setCharacterLimit(int limit);
    void setContainsUnderscore();
    void setContainsLowercase();
    void setContainsUppercase();
    void setContainsNumber();
}
