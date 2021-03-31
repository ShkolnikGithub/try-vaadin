package ru.mshkolniy.vaadin.model;

import java.util.Arrays;
import java.util.List;

public enum SelectedValues {
    YES("Да"),
    NO("Нет"),
    DONT_KNOW("Не знаю");

    private final String answer;

    SelectedValues(String answer) {
        this.answer = answer;
    }

    public static List<SelectedValues> getAllAnswers() {
        return Arrays.asList(YES, NO, DONT_KNOW);
    }
}
