package ru.mshkolniy.vaadin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("fieldA")
    private String fieldA;
    @JsonProperty("fieldB")
    private String fieldB;
    @JsonProperty("Select")
    private SelectedValues selectedValue;
    @JsonProperty("SAVE")
    private String save;

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    public void setFieldB(String fieldB) {
        this.fieldB = fieldB;
    }

    public void setSelectedValue(SelectedValues selectedValue) {
        this.selectedValue = selectedValue;
    }

    public void setSave(String save) {
        this.save = save;
    }
}
